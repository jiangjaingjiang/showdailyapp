package com.example.dailyeconomicflow.pojo;

public class ReturnInfo {

    private Integer retFlag;
    private String retMsg;
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
