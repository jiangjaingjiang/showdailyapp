package com.example.dailyeconomicflow.pojo;

public class ReturnInfo {
    //传递用的标识 正常的话都是 0 ,有问题就变成 1
    private Integer retFlag;
    //传递用的信息
    private String retMsg;
    //传递用的参数
    private Object retVal;

    public ReturnInfo(Integer retFlag, String retMsg, Object retVal) {
        this.retFlag = retFlag;
        this.retMsg = retMsg;
        this.retVal = retVal;
    }

    public ReturnInfo() {
    }

    public Integer getRetFlag() {
        return retFlag;
    }

    public void setRetFlag(Integer retFlag) {
        this.retFlag = retFlag;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Object getRetVal() {
        return retVal;
    }

    public void setRetVal(Object retVal) {
        this.retVal = retVal;
    }

    @Override
    public String toString() {
        return "ReturnInfo{" +
                "retFlag=" + retFlag +
                ", retMsg='" + retMsg + '\'' +
                ", retVal=" + retVal +
                '}';
    }

}
