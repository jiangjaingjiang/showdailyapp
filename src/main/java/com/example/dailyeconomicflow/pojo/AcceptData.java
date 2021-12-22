package com.example.dailyeconomicflow.pojo;

public class AcceptData {
    //getAllAmount 获取总数
    private Integer recordYear;
    private Integer recordMonth;
    //getCategoryList 获取类别列表
    private Integer recordType;

    public AcceptData(Integer recordYear, Integer recordMonth, Integer recordType) {
        this.recordYear = recordYear;
        this.recordMonth = recordMonth;
        this.recordType = recordType;
    }

    public AcceptData() {
    }

    public Integer getRecordYear() {
        return recordYear;
    }

    public void setRecordYear(Integer recordYear) {
        this.recordYear = recordYear;
    }

    public Integer getRecordMonth() {
        return recordMonth;
    }

    public void setRecordMonth(Integer recordMonth) {
        this.recordMonth = recordMonth;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    @Override
    public String toString() {
        return "AcceptData{" +
                "recordYear=" + recordYear +
                ", recordMonth='" + recordMonth + '\'' +
                ", recordType=" + recordType +
                '}';
    }


}
