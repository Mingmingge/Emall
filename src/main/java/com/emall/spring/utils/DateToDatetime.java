package com.emall.spring.utils;

import java.sql.Timestamp;
import java.util.Date;

public class DateToDatetime {


    /**
     * 时间转化为mysql可以存储的类型
     * @return 当前时间的mysql datetime类型
     */
    public static Timestamp dateToDatetimeNow() {

        Date date = new Date();
        return  new Timestamp(date.getTime());
    }
}
