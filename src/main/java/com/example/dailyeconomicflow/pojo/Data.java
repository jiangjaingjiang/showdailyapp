package com.example.dailyeconomicflow.pojo;


import java.math.BigDecimal;
import java.util.List;

public class Data {
    //总数
    private Integer count;
    //详细数据
    private List<Categorys> Categorys;
    //总支出
    private BigDecimal payAmount;
    //总收入
    private BigDecimal incomeAmount;

    public Data(Integer count, List<Categorys> Categorys ,
                BigDecimal payAmount,BigDecimal incomeAmount) {
        this.count = count;
        this.Categorys = Categorys;
        this.payAmount = payAmount;
        this.incomeAmount = incomeAmount;

    }

    public Data() {
    }

    public Integer getCount() {

        return count;
    }

    public void setCount(Integer count) {

        this.count = count;
    }

    public List<Categorys> getCategorys() {

        return Categorys;
    }

    public void setCategorys(List<Categorys> Categorys) {

        this.Categorys = Categorys;
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

    @Override
    public String toString() {
        return "Data{" +
                "count=" + count +
                ", Category='" + Categorys +
                ", payAmount='" + payAmount +
                ", incomeAmount='" + incomeAmount +
                '}';
    }
}
