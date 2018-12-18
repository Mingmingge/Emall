package com.emall.spring.controller;
import com.emall.spring.dao.ReciverMapper;
import com.emall.spring.entity.Customer;
import com.emall.spring.entity.Reciver;
import com.emall.spring.services.CustomerService;
import com.emall.spring.services.ReciverServices;
import com.emall.spring.utils.DateToDatetime;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ReciverServices reciverServices;

    /**
     * 查看所有顾客信息
     * @return 成功 失败 顾客列表
     * 测试通过
     */
    @RequestMapping(value = "/customer/selectall", method = RequestMethod.GET)
    public JSONObject selectCustomerAll() {
        JSONObject jsonObject = new JSONObject();
        try {
            ArrayList list = customerService.selectAll();
            if (list != null) {
                jsonObject.put("customerlist", list);
            }
            jsonObject.put("result", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }

    /**
     * 顾客注册；balance=0；必须填写nickname，password，tel，
     * @param customer 实体
     * @return 成功 失败
     * 测试通过
     */
    @RequestMapping(value = "/customer/registe", method = RequestMethod.POST)
    public JSONObject customerregiste(@ModelAttribute Customer customer) {
        JSONObject jsonObject = new JSONObject();
        String customeruuid = UUID.randomUUID().toString().toLowerCase();
        customer.setCustomerid(customeruuid);
        customer.setBlance(BigDecimal.valueOf(0));
        customer.setCredit("信用一般");
        customer.setRegistiontime(DateToDatetime.dateToDatetimeNow());
        try {
            customerService.insert(customer);
            jsonObject.put("result", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }

    /**
     * 修改顾客信息，
     * @param customer 实体，必须包含了ID属性
     * @return 成功 失败 实体
     */
    @RequestMapping(value = "/customer/update", method = RequestMethod.POST)
    public JSONObject customerUpdate(@ModelAttribute Customer customer) {
        JSONObject jsonObject = new JSONObject();
        try {
            customerService.updateByPrimaryKeySelective(customer);
            jsonObject.put("result", 1);
            jsonObject.put("customer", customer);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }

    /**
     *
     * @param session 用户登陆
     * @return list
     */
    @RequestMapping(value = "/customer/getallreciver", method = RequestMethod.GET)
    public JSONObject getAllRe(HttpSession session) {
        JSONObject jsonObject = new JSONObject();

        try {
            Customer customer = (Customer)session.getAttribute("customer");
            ArrayList<Reciver> list = reciverServices.selectAll(customer.getCustomerid());
            jsonObject.put("reciverlist", list);
            jsonObject.put("result", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }

    /**
     * 插入收货地址
     * @param session
     * @param reciver
     * @return
     */

    @RequestMapping(value = "/customer/insertreciver", method = RequestMethod.POST)
    public JSONObject insertreciver(HttpSession session, @ModelAttribute Reciver reciver) {
        JSONObject jsonObject = new JSONObject();
        String reciverid = UUID.randomUUID().toString().toLowerCase();
        reciver.setReciverid(reciverid);
        try {
            reciverServices.insert(reciver);
            jsonObject.put("result", 1);
            jsonObject.put("reciver", reciver);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }
}
