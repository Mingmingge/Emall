package com.emall.spring.controller;

import com.emall.spring.entity.Order;
import com.emall.spring.entity.Orderproduct;
import com.emall.spring.services.OrderService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查看所有订单
     * @return 成功 失败 订单列表
     */
    @RequestMapping(value = "/order/selectall", method = RequestMethod.GET)
    public JSONObject orderSelectAll() {
        JSONObject jsonObject = new JSONObject();
        try {
            ArrayList list = orderService.selectAll();
            jsonObject.put("result", 1);
            jsonObject.put("orderlist", list);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }

    /**
     *
     * @param order
     * @param orderproduct
     * @return
     */
    @RequestMapping(value = "/order/insert", method = RequestMethod.POST)
    public JSONObject orderInser(@ModelAttribute Order order, @ModelAttribute Orderproduct orderproduct) {
        String orderid = UUID.randomUUID().toString().toLowerCase();
        String uuid = UUID.randomUUID().toString().toLowerCase();
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }

    /**
     * 根据某一个顾客ID查看所有订单
     * @param customerid 顾客的ID
     * @return 成功 失败 order列表
     */
    @RequestMapping(value = "/order/selectbycustomer")
    public JSONObject orderselectByCustomer(@RequestParam("customerid") String customerid) {
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }
}
