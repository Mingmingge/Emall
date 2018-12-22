package com.emall.spring.controller;

import com.emall.spring.entity.Product;
import com.emall.spring.entity.Productclass;
import com.emall.spring.services.ProdisService;
import com.emall.spring.services.ProductclassService;
import com.emall.spring.services.Productservice;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
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
}
