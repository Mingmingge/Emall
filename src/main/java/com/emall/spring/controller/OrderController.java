package com.emall.spring.controller;

import com.emall.spring.entity.Order;
import com.emall.spring.entity.Reciver;
import com.emall.spring.services.OrderService;
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
    @RequestMapping(value = "/order/selectbycustomer")
    public JSONObject orderselectByCustomer(HttpSession httpSession) {
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }
}
