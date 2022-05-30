package com.example.dailyeconomicflow.pojo;

import java.math.BigDecimal;
import java.util.List;

public class Acc {
    private String _id;
    private List<Content> content;
    private Integer bookId;
    private String remark;
    private BigDecimal incomeAmount;
    private BigDecimal payAmount;



    public Acc(String _id, List<Content> content, Integer bookId , String remark , BigDecimal incomeAmount ,
                BigDecimal payAmount) {
        this._id = _id;
        this.content = content;
        this.bookId = bookId;
        this.remark = remark;
        this.incomeAmount = incomeAmount;
        this.payAmount = payAmount;
    }

    public Acc() {
    }

    public String get_id() {

        return _id;
    }

    public void set_id(String _id) {

        this._id = _id;
    }

    public List<Content> getContent(){

        return content;
    }

    public void setContent(List<Content> content){

        this.content = content;
    }

    public Integer getBookId() {

        return bookId;
    }

    public void setBookId(Integer bookId) {

        this.bookId = bookId;
    }
    public String getRemark() {

        return remark;
    }

    public void setRemark(String remark) {

        this.remark = remark;
    }

    public BigDecimal getIncomeAmount(){

        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount){

        this.incomeAmount = incomeAmount;
    }

    public BigDecimal getPayAmount(){

        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount){

        this.payAmount = payAmount;
    }

    @Override
    public String toString() {
        return "Acc{" +
                "id=" + _id +
                ", content=" + content +
                ", bookId='" + bookId +
                ", remark='" + remark +
                ", incomeAmount='" + incomeAmount +
                ", payAmount='" + payAmount +
                '}';
    }
}
