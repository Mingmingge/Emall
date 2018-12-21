package com.emall.spring.utils;

import com.emall.spring.entity.Customer;
import net.sf.json.JSONObject;

import java.util.Map;

public class TokenAuth {

    public static boolean auth(Map map) {
        JSONObject customerJsonobject = JSONObject.fromObject(map.get("customer"));
        if (customerJsonobject.get("customerid") != null) {
           return true;
        } else {
            return false;
        }
    }
}
