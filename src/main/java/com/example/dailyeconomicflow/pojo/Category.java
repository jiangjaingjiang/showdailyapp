package com.example.dailyeconomicflow.pojo;

import java.math.BigDecimal;

public class Category {
    private Integer id;
    private String icon;
    private String title;
    private BigDecimal price;
    private String recordType;
    private Integer bookId;
    private String remark;



    public Category(Integer id, String icon, String title , BigDecimal price ,
                    String recordType, Integer bookId , String remark) {
        this.id = id;
        this.icon = icon;
        this.title = title;
        this.price = price;
        this.recordType = recordType;
        this.bookId = bookId;
        this.remark = remark;
    }

    public Category() {
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getIcon() {

        return icon;
    }

    public void setIcon(String icon) {

        this.icon = icon;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }
    public String getRecordType() {

        return recordType;
    }

    public void setRecordType(String recordType) {

        this.recordType = recordType;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", icon='" + icon +
                ", title='" + title +
                ", price='" + price +
                ", recordType='" + recordType +
                ", bookId='" + bookId +
                ", remark='" + remark +
                '}';
    }
}
