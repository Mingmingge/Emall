package com.emall.spring.controller;

import com.emall.spring.services.BannerService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BannnerController {

    @Autowired
    private BannerService bannerService;

    /**
     * 服务于轮播图
     * @return 返回{"imgList":[{},{}]}
     */
    @RequestMapping(value = "/banner/selectall", method = RequestMethod.GET)
    public JSONObject bannerSelectall() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imgList", bannerService.selectAll());
        return jsonObject;
    }
}
