package com.emall.spring.controller;

import com.emall.spring.entity.Admin;
import com.emall.spring.entity.Distribute;
import com.emall.spring.entity.Product;
import com.emall.spring.services.AdminService;
import com.emall.spring.services.DistributeService;
import com.emall.spring.services.Productservice;
import com.emall.spring.utils.DateToDatetime;
import com.emall.spring.utils.FileUplaod;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@RestController
public class IndexController {

    @Autowired
    private AdminService adminService;


    @Autowired
    private DistributeService distributeService;


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
        admin.setRegisttime(DateToDatetime.dateToDatetimeNow());
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


    /**
     * 经销商登陆
     * @param tel 电话
     * @param password 密码
     * @param httpSession 成功则添加session
     * @return 1：登陆成功；0：电话密码错误；-1：数据库异常
     */
    @RequestMapping(value = "/distributelogin", method = RequestMethod.POST)
    public JSONObject distributelogin(@RequestParam("distributetel") String tel, @RequestParam("distributepassword") String password, HttpSession httpSession) {

        Distribute distribute = new Distribute();
        JSONObject jsonObject = new JSONObject();
        distribute.setDistributepassword(password.trim().replace(" ", ""));
        distribute.setDistributetel(tel.trim().replace(" ", ""));
        Distribute record;
        try {
           record = distributeService.selectByTelPassword(distribute);
           if (record == null) {
               jsonObject.put("result", 0);
           } else {
               jsonObject.put("result", 1);
               httpSession.setAttribute("distribute", record);
           }
        } catch (Exception e) {
           jsonObject.put("result", -1);
        }
        return jsonObject;
    }

    /**
     * 经销商注册
     * @param distribute 经销商实体
     * @return 成功：1；
     */
    @RequestMapping(value = "/distributeregist", method = RequestMethod.POST)
    public JSONObject disre(@ModelAttribute Distribute distribute) {
        JSONObject jsonObject = new JSONObject();
        int end = 0;
        String uuid = UUID.randomUUID().toString().toLowerCase();
        distribute.setDistributeid(uuid);
        distribute.setRegisttime(DateToDatetime.dateToDatetimeNow());
        distribute.setType(1);
        try {
            end = distributeService.insert(distribute);
        } catch (Exception e) {

        }
        jsonObject.put("result", end);
        return jsonObject;
    }


    /**
     * admin登陆
     * @param admintel 电话
     * @param httpSession session
     * @return 1：登陆成功；0：电话密码错误；-1：数据库异常
     */
    @RequestMapping(value = "adminlogin", method = RequestMethod.POST)
    public JSONObject adminlogin(@RequestParam("admintel") String admintel, HttpSession httpSession) {
        JSONObject jsonObject = new JSONObject();
        try {
            Admin admin = adminService.selectByTel(admintel.trim().replace(" ", ""));
            if (admin == null) {
                jsonObject.put("result", 0);
            } else {
                jsonObject.put("result", 1);
                httpSession.setAttribute("admin", admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", -1);
        }
        return jsonObject;
    }

}
