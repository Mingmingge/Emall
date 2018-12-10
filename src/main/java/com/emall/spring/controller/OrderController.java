package com.emall.spring.controller;

import com.emall.spring.entity.Customer;
import com.emall.spring.entity.Order;
import com.emall.spring.entity.Orderproduct;
import com.emall.spring.entity.Reciver;
import com.emall.spring.services.OrderService;
import com.emall.spring.services.OrderproductService;
import com.emall.spring.services.ProdisService;
import com.emall.spring.services.ReciverServices;
import com.emall.spring.utils.ProductTrans;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProdisService prodisService;

    @Autowired
    private ReciverServices reciverServices;

    @Autowired
    private OrderproductService orderproductService;

    /**
     * 查看所有订单
     * @return 成功 失败 订单列表
     */
    @RequestMapping(value = "/order/selectall", method = RequestMethod.GET)
    public JSONObject orderSelectAll() {
        JSONObject jsonObject = new JSONObject();
        List<Order> list;
        try {
            list = orderService.selectAll();
            if (list != null) {
                list = orderService.selectAll();
                jsonObject.put("orderlist", list);
            }
            jsonObject.put("result", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }

    /**
     * 新增订单
     * @param reciverid 收货人的id
     * @param list [{},{}]
     * @return
     */

    @RequestMapping(value = "/order/insert", method = RequestMethod.POST)
    public JSONObject orderInsert(@RequestParam("reciverid") String reciverid, @RequestParam("list") ArrayList<ProductTrans> list, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        Order order = new Order();
        List<String> sendidlist = new ArrayList<>();
        Iterator<ProductTrans> iterator = list.iterator();
        while (iterator.hasNext()) {
            ProductTrans productTrans = iterator.next();
            Reciver reciver = reciverServices.selectByPrimaryKey(reciverid);
            sendidlist.add((prodisService.selectByproductid(productTrans.getProductid())).getDistributeid());
            order.setSendid(sendidlist.toString());
            order.setReciveid(reciverid);
            order.setExpressaddr(reciver.getReciveraddr());
            order.setExpresstel(reciver.getRecivertel());



        }
        return jsonObject;
    }

    /**
     * 根据某一个顾客ID查看所有订单
     * @param httpSession 顾客的ID
     * @return 成功 失败 order列表
     */
    @RequestMapping(value = "/order/selectbycustomer", method = RequestMethod.POST)
    public JSONObject orderselectByCustomer(HttpSession httpSession) {
        JSONObject jsonObject = new JSONObject();
        Customer customer = (Customer) httpSession.getAttribute("customer");
        ArrayList<Reciver> list = reciverServices.selectAll(customer.getCustomerid());
        Iterator<Reciver> iterator = list.iterator();
        List<JSONObject> list1 = new  ArrayList<JSONObject>();
        while (iterator.hasNext()) {
            Reciver reciver = iterator.next();
            ArrayList<Order> orderArrayList = orderService.selectByreciver(reciver.getReciverid());
            Iterator<Order> orderIterator = orderArrayList.iterator();
            while (orderIterator.hasNext()) {
                Order order = orderIterator.next();
                ArrayList<Orderproduct> orderproductArrayList = orderproductService.selectByOrderid(order.getOrderid());
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("orderproduct", orderproductArrayList);
                jsonObject1.put("ordermain", order);
                list1.add(jsonObject1);
            }// {"orderlist":[{"ordermain":"{}","orderproduct":[{},{}]},{},{}]}
        }
        if (list1.size() != 0) {
            jsonObject.put("orderlist", list1);
        }
        return jsonObject;
    }
}
