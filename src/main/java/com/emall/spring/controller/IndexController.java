package com.emall.spring.controller;

import com.emall.spring.entity.Admin;
import com.emall.spring.services.AdminService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
public class IndexController {

    @Autowired
    private AdminService adminService;


    /**
     * 测试数据库以及mybatis
     * @param name admin的name属性
     * @return 返回插入结果，json型
     */

    @RequestMapping(value = "/insertadmin", method = RequestMethod.GET)
    public JSONObject insertAdmin(@RequestParam("name") String name) {

        JSONObject jsonObject = new JSONObject();
        Admin admin = new Admin();
        String uuid = UUID.randomUUID().toString().toLowerCase();
        admin.setAdminname(name);
        admin.setAdminid(uuid);
        try {
            adminService.insert(admin);
            jsonObject.put("key", "插入成功！其ID为 "+uuid);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("key", "数据库错误，请重试！");
        }
        return jsonObject;
    }
}
