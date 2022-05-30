package com.example.dailyeconomicflow.pojo;

import java.math.BigDecimal;

/**
 * @Title:
 * @Description:
 * @Param:
 * @Return:
 * @Author: ZengJT
 * @Updatedate: 2021/12/22 14:09
 */
public class Content {
    private String _id;
    private String icon;
    private String title;
    private BigDecimal price;
    private Integer recordType;

    public Content(String _id, String icon, String title , BigDecimal price ,
                   Integer recordType) {
        this._id = _id;
        this.icon = icon;
        this.title = title;
        this.price = price;
        this.recordType = recordType;
    }

    public Content() {
    }

    public String get_id() {

        return _id;
    }

    public void set_id(String _id) {

        this._id = _id;
    }

    public String getIcon() {

        return icon;
    }

    public void setIcon(String icon) {

        this.icon = icon;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }
    public Integer getRecordType() {

        return recordType;
    }

    public void setRecordType(Integer recordType) {

        this.recordType = recordType;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + _id +
                ", icon='" + icon +
                ", title='" + title +
                ", price='" + price +
                ", recordType='" + recordType +

                '}';
    }
}
