package com.example.dailyeconomicflow.util;

import com.example.dailyeconomicflow.pojo.ReturnInfo;

public class ReturnUtil {
    private static ReturnInfo returnInfo = new ReturnInfo();
    public static ReturnInfo error(String retMag){
        returnInfo.setRetFlag(1);
        returnInfo.setRetMsg(retMag);
        returnInfo.setRetVal("");
        return returnInfo;
    }
    public static ReturnInfo success(Object retVal){
        returnInfo.setRetFlag(0);
        returnInfo.setRetMsg("导入成功");
        returnInfo.setRetVal(retVal);
        return returnInfo;
    }
}
