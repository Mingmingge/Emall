package com.emall.spring.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUplaod {

    /**
     * 文件上传具体操作
     * @param multipartFile spring中的文件类，由前端传回包含file的formdata得到
     * @param filename 要转存成的文件名称
     * @param filepath 要保存的文件目录
     * @return 异常出现返回0
     */
    public int fileUplaod(MultipartFile multipartFile, String filename, String filepath) {

        String filepathab = this.getAbPath(filepath);
        try {
            multipartFile.transferTo(new File(filepathab, filename));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件上传类出错");
            return 0;
        }
        return 1;
    }

    /**
     * 文件绝对目录
     * @param filepath 文件的相对目录
     * @return 字符串形式返回
     */
    public String getAbPath(String filepath) {

        File filedir = new File(filepath);
        String filepathab = filedir.getAbsolutePath();
        if (!filedir.exists()) {
            filedir.mkdir();
        }
        return filepathab;
    }
}
