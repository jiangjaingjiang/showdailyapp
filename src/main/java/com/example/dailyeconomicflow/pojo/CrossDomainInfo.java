package com.example.dailyeconomicflow.pojo;

import java.util.List;

public class CrossDomainInfo {
    private Integer status;
    private String errMsg;
    private Data data;

    public CrossDomainInfo(Integer status, String errMsg, Data data) {
        this.status = status;
        this.errMsg = errMsg;
        this.data = data;
    }

    public CrossDomainInfo() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CrossDomainInfo{" +
                "status=" + status +
                ", errMsg='" + errMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
