package com.example.dailyeconomicflow.pojo;


import java.math.BigDecimal;
import java.util.List;

public class Data {
    //总数
    private Integer count;
    //图标数据
    private List<Categorys> categoryList;
    //总支出
    private BigDecimal payAmount;
    //总收入
    private BigDecimal incomeAmount;
    //数据数据
    private List<Acc> accList;

    public Data(Integer count, List<Categorys> categoryList ,
                BigDecimal payAmount,BigDecimal incomeAmount,List<Acc> accList) {
        this.count = count;
        this.categoryList = categoryList;
        this.payAmount = payAmount;
        this.incomeAmount = incomeAmount;
        this.accList = accList;

    }

    public Data() {
    }

    public Integer getCount() {

        return count;
    }

    public void setCount(Integer count) {

        this.count = count;
    }

    public List<Categorys> getCategoryList() {

        return categoryList;
    }

    public void setCategoryList(List<Categorys> categoryList) {

        this.categoryList = categoryList;
    }

    public BigDecimal getPayAmount(){

        return payAmount;
    }
    public void setPayAmount(BigDecimal payAmount){

        this.payAmount = payAmount;
    }

    public BigDecimal getIncomeAmount(){

        return incomeAmount;
    }
    public void setIncomeAmount(BigDecimal incomeAmount){

        this.incomeAmount = incomeAmount;
    }

    public List<Acc> getAccList(){

        return accList;
    }

    public void setAccList(List<Acc> accList){
        this.accList = accList;
    }

    @Override
    public String toString() {
        return "Data{" +
                "count=" + count +
                ", Category='" + categoryList +
                ", payAmount='" + payAmount +
                ", incomeAmount='" + incomeAmount +
                ", accList='" + accList +
                '}';
    }
}
