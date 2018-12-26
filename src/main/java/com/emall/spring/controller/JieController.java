package com.emall.spring.controller;

import com.emall.spring.entity.*;
import com.emall.spring.services.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JieController {

    @Autowired
    private Productservice productservice;

    @Autowired
    private ProdisService prodisService;

    @Autowired
    private ProductclassService productclassService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderproductService orderproductService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DistributeService distributeService;

    /**
     * 产品下架, 产品表和经销商表
     *
     * @param id 产品id
     * @return 成功 失败
     */

    @RequestMapping(value = "/product/deletebyid", method = RequestMethod.POST)
    public JSONObject deleteByid(@RequestParam(value = "id") String id) {
        JSONObject jsonObject = new JSONObject();
        System.out.println("id = [" + id + "]");
        try {
            Product list = productservice.selectByPrimaryKey(id);
            if (list == null) {
                jsonObject.put("result", 0);
            } else {
                productservice.deleteByPrimaryKey(id);
                prodisService.deleteByProductID(id);
                jsonObject.put("result", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }

    /**
     * 产品类别
     *
     * @return 返回产品类别
     */
    @RequestMapping(value = "/product/searchclasses", method = RequestMethod.GET)
    public JSONObject searchClasses() {
        int count = 0;
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> classes = new ArrayList<>();
        ArrayList<Productclass> productclassArrayList = productclassService.selectAll();
        for (Productclass productclass : productclassArrayList) {
            JSONObject classesJsonObjest = new JSONObject();
            int id = productclass.getProclassid();
            String name = productclass.getProclassname();
            classesJsonObjest.put("id", id);
            classesJsonObjest.put("name", name);
            classes.add(classesJsonObjest);
            count++;
        }
        jsonObject.put("classes", classes);
        jsonObject.put("result", count);
        return jsonObject;
    }

    @RequestMapping(value = "/product/searchbyid", method = RequestMethod.GET)
    public JSONObject searchById(@RequestParam String id) {
        JSONObject jsonObject = new JSONObject();
        int state = 0;
        try {
            Product product = productservice.selectByPrimaryKey(id);
            if (product != null) {
                state = 1;
                jsonObject.put("data", product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsonObject.put("state", state);
        return jsonObject;
    }

    @RequestMapping(value = "/order/productid", method = RequestMethod.GET)
    public JSONObject productid(@RequestParam String id) {
        JSONObject jsonObject = new JSONObject();
        int result = 0;
        try {
            Orderproduct orderproduct = orderproductService.selectByPrimaryKey(id);
            if (orderproduct != null) {
                String pid = orderproduct.getProductid();
                String name = productservice.selectByPrimaryKey(pid).getProductname();
                if (name != null) {
                    jsonObject.put("id", pid);
                    jsonObject.put("name", name);
                    result = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsonObject.put("reult", result);
        return jsonObject;
    }

    /**
     * 根据admin id 获取 admin name
     * @param id
     * @return
     */
    @RequestMapping(value = "/order/getid", method = RequestMethod.GET)
    public JSONObject getid(@RequestParam String id) {
        JSONObject jsonObject = new JSONObject();
        int result = 0;
        try {
            Admin admin = adminService.selectByPrimaryKey(id);
            if (admin != null) {
                String name = admin.getAdminname();
                if (name != null) {
                    jsonObject.put("name", name);
                    result = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsonObject.put("reult", result);
        return jsonObject;
    }

    /**
     * userid 得到 username
     * @param id
     * @return
     */
    @RequestMapping(value = "/order/getuserid", method = RequestMethod.GET)
    public JSONObject getuserid(@RequestParam String id) {
        JSONObject jsonObject = new JSONObject();
        int result = 0;
        try {
            Customer customer = customerService.selectByPrimaryKey(id);
            if (customer != null) {
                String name = customer.getCustomername();
                if (name != null) {
                    jsonObject.put("name", name);
                    result = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsonObject.put("reult", result);
        return jsonObject;
    }

    /**
     *
     */
    @RequestMapping(value = "/dis/info", method = RequestMethod.GET)
    public JSONObject dis_info(@RequestParam String id) {
        JSONObject jsonObject = new JSONObject();
        int result = 0;
        try {
            Distribute distribute = distributeService.selectByPrimaryKey(id);
            if (distribute != null) {
                jsonObject.put("dislist", distribute);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsonObject.put("result", result);
        return jsonObject;
    }
}
