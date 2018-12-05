package com.emall.spring.controller;

import com.emall.spring.dao.ProdisMapper;
import com.emall.spring.entity.Prodis;
import com.emall.spring.entity.Product;
import com.emall.spring.services.Productservice;
import com.emall.spring.utils.FileUplaod;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    private Productservice productservice;

    @Autowired
    private ProdisMapper prodisMapper;


    /**
     * 产品上传
     * @param productimg 产品图片
     * @param product 实体
     * @param productadmin 上传者的uuid，经销商或者是管理员
     * @return 返回插入结果；成功则还返回这个商品实体
     */
    @RequestMapping(value = "/product/insert", method = RequestMethod.POST)
    public JSONObject productAdd(@RequestParam(value = "productimg", required = false) MultipartFile productimg, @ModelAttribute Product product, String productadmin) {
        JSONObject jsonObject = new JSONObject();
        FileUplaod fileUplaod = new FileUplaod();
        Prodis prodis = new Prodis();
        StringBuilder stringBuilder = new StringBuilder();
        String parentpath = "src/main/resources/static/productimg/";
        String productuuid = UUID.randomUUID().toString().toLowerCase();
        String prodisuuid = UUID.randomUUID().toString().toLowerCase();
        String imgname = stringBuilder.append(productuuid).append(".png").toString();
        product.setProductid(productuuid);
        product.setImagedir(imgname);
        System.out.println(product);
        prodis.setProductid(productuuid);
        prodis.setDistributeid(productadmin);
        prodis.setUuid(prodisuuid);
        try {
            fileUplaod.fileUplaod(productimg, imgname, parentpath);
            productservice.insert(product);
            prodisMapper.insert(prodis);
            jsonObject.put("result", 1);
            jsonObject.put("product", product);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }


    /**
     * 修改产品信息
     * @param product 产品实体
     * @param multipartFile 图片可以传可以不传
     * @return 成功标志以及更新后的product
     */

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public JSONObject productUpdate(@ModelAttribute Product product, @RequestParam("productimg") MultipartFile multipartFile) {
        JSONObject jsonObject = new JSONObject();
        FileUplaod fileUplaod = new FileUplaod();
        StringBuilder stringBuilder = new StringBuilder();
        String parentpath = "src/main/resources/static/productimg/";
        String imgname = stringBuilder.append(product.getProductid()).append(".png").toString();
        try {
            if (multipartFile == null) {
                productservice.updateByPrimaryKeySelective(product);
                jsonObject.put("result", 1);
                jsonObject.put("product", productservice.selectByPrimaryKey(product.getProductid()));
            } else {
                fileUplaod.fileUplaod(multipartFile, imgname, parentpath);
                productservice.updateByPrimaryKeySelective(product);
                jsonObject.put("result", 1);
                jsonObject.put("product", productservice.selectByPrimaryKey(product.getProductid()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }


    /**
     * 跟新产品status
     * @param state 更新的状态
     * @param productid 产品ID
     * @return 成功 失败 实体
     */
    @RequestMapping(value = "/product/updatestate", method = RequestMethod.POST)
    public JSONObject productUpdatestate(@RequestParam("state") String state, @RequestParam("productid") String productid) {
        JSONObject jsonObject = new JSONObject();
        Product product = new Product();
        product.setProductid(productid);
        product.setStatus(Integer.parseInt(state));
        try {
            productservice.updateState(product);
            jsonObject.put("result", 1);
            jsonObject.put("product", product);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }

    /**
     * 查询所有产品信息
     * @return 成功 失败 实体列表
     */
    @RequestMapping(value = "/product/searchall", method = RequestMethod.GET)
    public JSONObject searchAll() {
        JSONObject jsonObject = new JSONObject();
        try {
            ArrayList list = productservice.selectAll();
            jsonObject.put("result", 1);
            jsonObject.put("productlist", list);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;
    }

    /**
     * 模糊查询productname
     * @param productname name
     * @return 成功 失败 实体列表
     */
    @RequestMapping(value = "/product/searchbyname", method = RequestMethod.POST)
    public JSONObject searchByName(@RequestParam("productname") String productname) {
        JSONObject jsonObject = new JSONObject();
        try {
            ArrayList list = productservice.selectByNameLike(productname.trim());
            jsonObject.put("result", 1);
            jsonObject.put("productlist", list);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", 0);
        }
        return jsonObject;

    }


}
