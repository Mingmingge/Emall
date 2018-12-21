package com.emall.spring.controller;

import com.emall.spring.entity.Customer;
import com.emall.spring.entity.Order;
import com.emall.spring.entity.Orderproduct;
import com.emall.spring.entity.Product;
import com.emall.spring.services.*;
import com.emall.spring.utils.DateToDatetime;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@RestController
public class MingController {

    @Autowired
    private ProdisService prodisService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Productservice productservice;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderproductService orderproductService;

    /**
     * 首页搜索
     * @param map
     * @return
     */

    @RequestMapping(value = "/searchbyname", method = RequestMethod.POST)
    public JSONObject searchByName(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        String searchname = map.get("searchname").toString().trim().replace(" ", "");
        ArrayList<JSONObject> list1 = new ArrayList<>();
        ArrayList<Product> list;
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        list = productservice.selectByNameLike(searchname);
        if (list.size() != 0) {
            jsonObject.put("result", 1);
            jsonObject1.put("list", list);
            jsonObject1.put("type", "搜索结果");
            jsonObject2.put("goods",jsonObject1);
            list1.add(jsonObject2);
            jsonObject.put("goodsList",list1);
        } else {
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }

    /**
     * 新增订单
     * @param map
     * @return 逻辑：遍历JSONArray 得到所购买的product distribute的ID的set，循环set循环JSONArray，如果distribute的ID相同，则其所有商品为一哥
     * 订单，但是每个商品要分别插入orderproduct数据库。完成后，将customer的balance进行计算
     */
    @RequestMapping(value = "/re", method = RequestMethod.POST)
    public JSONObject re(@RequestBody Map map) {
        int flag = 0;
        BigDecimal customerConsume = new BigDecimal(0);
        JSONObject jsonObject = new JSONObject();
        Order order = new Order();
        Set<String> sendSet = new HashSet<>();
        Map<JSONObject, String> disproMap = new HashMap<>();
        String list = (String) map.get("list");
        JSONObject customerJsonobject = JSONObject.fromObject(map.get("customer"));
        if (customerJsonobject.get("customerid") != null) {
            order.setReciveid(customerJsonobject.get("customerid").toString());//已经登陆则接收ID为登陆者
            order.setExpressaddr(customerJsonobject.get("addr").toString());
            System.out.println(customerJsonobject);
        } else {
            System.out.println("未登录");
            jsonObject.put("result", -1);
            return jsonObject;
        }
        System.out.println(list);
        System.out.println(customerJsonobject);
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
//        if (httpSession.getAttribute("customer") != null) {
//            order.setReciveid(((Customer)httpSession.getAttribute("customer")).getCustomerid());//已经登陆则接收ID为登陆者
//            order.setExpressaddr(((Customer)httpSession.getAttribute("customer")).getAddr());
//            System.out.println(((Customer)httpSession.getAttribute("customer")).getAddr());
//        } else {
//            System.out.println(httpSession.getAttribute("customer"));
//            order.setReciveid("1");//为登陆，手动设置ID
//            order.setExpressaddr("未登陆，手动地址");
//        }
        order.setOrderprice(BigDecimal.valueOf(0));
        for (int i=0;i<jsonArray.size();i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);// 得到每个产品
            String productid = jsonObject1.get("productid").toString();
            System.out.println(productid);
            String distributeid = prodisService.selectByproductid(productid).getDistributeid();
            sendSet.add(distributeid);//产品所对应的供应商id set
            disproMap.put(jsonObject1, distributeid);
        }
        System.out.println(sendSet);
        Iterator<String> sendSetIterator = sendSet.iterator();
        while (sendSetIterator.hasNext()) {
            String sendid = sendSetIterator.next();
            System.out.println(sendid);
            Set<Map.Entry<JSONObject, String>> entries = disproMap.entrySet();
            String orderuuid = UUID.randomUUID().toString().toLowerCase();
            for (Map.Entry<JSONObject, String> entry : entries) {
                JSONObject jsonObject1 = entry.getKey();// 得到每个产品
                String distributeid = entry.getValue();
                String productid = jsonObject1.get("productid").toString();
                if (sendid.equals(distributeid)) {
                    flag = 1;
                    String num = jsonObject1.get("num").toString();
                    Product product = productservice.selectByPrimaryKey(productid);//重新从数据库取得数据，防止前端攻击
                    Orderproduct orderproduct = new Orderproduct();
                    BigDecimal orderprice = product.getPrice().multiply(BigDecimal.valueOf(Integer.parseInt(num)));
                    customerConsume = customerConsume.add(orderprice);
                    order.setOrderid(orderuuid);
                    order.setSendid(sendid);
                    order.setExpresstel("暂时没有");
                    order.setOrderprice(orderprice.add(order.getOrderprice()));
                    order.setState(0);
                    order.setOrderdata(DateToDatetime.dateToDatetimeNow());
                    order.setEndtime(new Timestamp(0));
                    orderproduct.setUuid(UUID.randomUUID().toString().toLowerCase());
                    orderproduct.setOrderid(orderuuid);
                    orderproduct.setProductid(productid);
                    orderproduct.setCount(Integer.parseInt(num));
                    orderproduct.setCountprice(orderprice);
                    product.setNums(product.getNums()-Integer.parseInt(num));
                    try {
                        orderproductService.insert(orderproduct);
                        productservice.updateByPrimaryKeySelective(product);
                    } catch (Exception e) {
                        jsonObject.put("result", 0);
                        flag = 0;
                        System.out.println("insert orderproduct error");
                    }
                }

            }
            if (flag == 1) {
                    try {
                        orderService.insert(order);
                        flag =0;
                        order.setOrderprice(BigDecimal.valueOf(0));
                    } catch (Exception e) {
                        jsonObject.put("result", 0);
                        e.printStackTrace();
                        System.out.println("insert ordermain error");
                    }
                }

            }
            try {
                Customer customer = new Customer();
                customer.setBlance((new BigDecimal(customerJsonobject.get("blance").toString())).subtract(customerConsume));
                customerService.updateByPrimaryKeySelective(customer);
            } catch (Exception e) {
                System.out.println("insert customer error");
                e.printStackTrace();
            }
            jsonObject.put("result", 1);
            jsonObject.put("customerConsume", customerConsume);

//        try {
//            for (int i=0;i<jsonArray.size();i++) {
//                JSONObject jsonObject1 = jsonArray.getJSONObject(i);// 得到每个产品
//                String productid = jsonObject1.get("productid").toString();
//                System.out.println(productid);
//                sendSet.add(prodisService.selectByproductid(productid).getDistributeid());//产品所对应的供应商id
//            }
//            System.out.println(sendSet);
//            Iterator<String> sendSetIterator = sendSet.iterator();
//            while (sendSetIterator.hasNext()) {
//                String sendid = sendSetIterator.next();
//                System.out.println(sendid);
//                for (int i=0;i<jsonArray.size();i++) {
//                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);// 得到每个产品
//                    String productid = jsonObject1.get("productid").toString();
//                    String orderuuid = UUID.randomUUID().toString().toLowerCase();
//                    if (sendid.equals(prodisService.selectByproductid(productid).getDistributeid())) {
//                        flag = 1;
//                        String num = jsonObject1.get("num").toString();
//                        Product product = productservice.selectByPrimaryKey(productid);//重新从数据库取得数据，防止前端攻击
//                        Orderproduct orderproduct = new Orderproduct();
//                        BigDecimal orderprice = product.getPrice().multiply(BigDecimal.valueOf(Integer.parseInt(num)));
//                        customerConsume = customerConsume.add(orderprice);
//                        order.setOrderid(orderuuid);
//                        order.setSendid(sendid);
//                        order.setExpresstel("暂时没有");
//                        order.setOrderprice(orderprice.add(order.getOrderprice()));
//                        order.setState(0);
//                        order.setOrderdata(DateToDatetime.dateToDatetimeNow());
//                        order.setEndtime(new Timestamp(0));
//                        orderproduct.setUuid(UUID.randomUUID().toString().toLowerCase());
//                        orderproduct.setOrderid(orderuuid);
//                        orderproduct.setProductid(productid);
//                        orderproduct.setCount(Integer.parseInt(num));
//                        orderproduct.setCountprice(orderprice);
//                        try {
//                            orderproductService.insert(orderproduct);
//                        } catch (Exception e) {
//                            jsonObject.put("result", 0);
//                            flag = 0;
//                            System.out.println("insert orderproduct error");
//                        }
//                    }
//
//                }
//                if (flag == 1) {
//                    try {
//                        orderService.insert(order);
//                        flag =0;
//                    } catch (Exception e) {
//                        jsonObject.put("result", 0);
//                        e.printStackTrace();
//                        System.out.println("insert ordermain error");
//                    }
//                }
//
//            }
//            jsonObject.put("result", 1);
//            jsonObject.put("customerConsume", customerConsume);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("ssss");
//        }
        return jsonObject;
    }


    @RequestMapping(value = "/searchorder", method = RequestMethod.POST)
    public JSONObject searchOrder(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        JSONObject customerJsonobject = JSONObject.fromObject(map.get("customer"));
        if (customerJsonobject.get("customerid") != null) {
            System.out.println(customerJsonobject);
            Integer state = Integer.parseInt(map.get("state").toString());
            ArrayList<Orderproduct> orderproductArrayList;
            ArrayList<Order> orderArrayList;
            List<JSONObject> orderlist = new ArrayList<>();
            Order order = new Order();
            order.setState(state);
            order.setReciveid(customerJsonobject.get("customerid").toString());
            try {
                orderArrayList = orderService.selectByreciverandstate(order);
                if (orderArrayList!=null) {
                    System.out.println(orderArrayList);
                    Iterator<Order> orderIterator  = orderArrayList.iterator();
                    while (orderIterator.hasNext()) {
                        Order order1 = orderIterator.next();
                        JSONObject jsonObject1 = new JSONObject();
                        jsonObject1.put("ordermain", order1);
                        orderproductArrayList = orderproductService.selectByOrderid(order1.getOrderid());
                        if (orderproductArrayList != null) {
                            jsonObject1.put("orderlist", orderproductArrayList);
                        }
                        orderlist.add(jsonObject1);

                    }
                    jsonObject.put("result", 1);
                    jsonObject.put("order", orderlist);
                } else {
                    jsonObject.put("result", 0);//没有订单
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println();
            }
        } else {
            System.out.println("未登录");
            jsonObject.put("result", -1);
            return jsonObject;
        }

        return jsonObject;

    }
}
