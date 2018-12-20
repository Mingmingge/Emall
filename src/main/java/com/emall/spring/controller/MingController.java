package com.emall.spring.controller;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class MingController {

    @RequestMapping(value = "/recive", method = RequestMethod.GET)
    public JSONObject recive(@RequestParam("list") String list) {
        System.out.println(list);
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = JSONObject.fromObject(list);
        System.out.println(jsonObject1);
        try {
            List<JSONObject> jsonObjects = (List<JSONObject>) jsonObject1.get("list");
            System.out.println(jsonObjects);
            Iterator<JSONObject> iterator  = jsonObjects.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject2 = iterator.next();
                jsonObject.put(jsonObject2.get("imagedir"), "imagedir");
            }
        } catch (Exception e) {
            System.out.println("ssss");
        }
        return jsonObject;
    }


    @RequestMapping(value = "/re", method = RequestMethod.POST)
    public JSONObject re(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        String list = (String) map.get("list");
        System.out.println(list);
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
        try {
            for (int i=0;i<jsonArray.size();i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                jsonObject.put(jsonObject1.get("imagedir"), "imagedir");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ssss");
        }
        return jsonObject;
    }
}
