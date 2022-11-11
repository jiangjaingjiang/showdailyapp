package com.example.dailyeconomicflow.util;

import com.example.dailyeconomicflow.pojo.ReturnInfo;

public class ReturnUtil {
    private static final ReturnInfo returnInfo = new ReturnInfo();
    public static ReturnInfo error(String retMag){
        //放入 标识 1 代表错误信息
        returnInfo.setRetFlag(1);
        //放入错误提示信息
        returnInfo.setRetMsg(retMag);
        returnInfo.setRetVal("");
        return returnInfo;
    }
    public static ReturnInfo success(Object retVal){
        //放入 标识 0 代表成功信息
        returnInfo.setRetFlag(0);
        // 放入默认成功信息
        returnInfo.setRetMsg("操作成功");
        //成功之后传递的val值
        returnInfo.setRetVal(retVal);
        return returnInfo;
    }
}
