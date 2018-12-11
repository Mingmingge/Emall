package com.emall.spring.controller;

import com.emall.spring.services.ProductclassService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductclassController {

    @Autowired
    private ProductclassService productclassService;

    @RequestMapping(value = "/productclass/selectall", method = RequestMethod.POST)
    public JSONObject slectall() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("typeList", productclassService.selectAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
