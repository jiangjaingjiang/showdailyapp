package com.example.dailyeconomicflow.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title:
 * @Description:
 * @Param:
 * @Return:
 * @Author: ZengJT
 * @Updatedate: 2022/11/10 16:20
 */
public class DateUtil {
    //注意******************-------------yyyyMMddHHmmssSSSSSS
    /*
     * @Title:获取当前时间 String类型
     * @Description:
     * @Param null:
     * @Return: null
     * @Author: Zengjt
     * @Date: 2022/11/10 16:27
     */
    public static String getNowDateForStringyMdHms(){
        String now = new String();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        now = sdf.format(date);
        return now;
    }


}
