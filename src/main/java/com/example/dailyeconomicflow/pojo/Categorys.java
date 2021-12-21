package com.example.dailyeconomicflow.pojo;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="category_table")
public class  Categorys implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    /**
     * id
     */
    @Column(name="id")
    private Integer id;

    /**
     * 图标名称
     */
    @Column(name="category_name")
    private String categoryName;

    /**
     * 对应的图标名称
     */
    @Column(name="icon_class_name")
    private String iconClassName;

    /**
     * 收支标识
     */
    @Column(name="record_type")
    private Integer recordType;

    /**
     * 创建机构
     */
    @Column(name="crt_inst")
    private String crtInst;

    /**
     * 创建时间
     */
    @Column(name="create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name="create_user")
    private String createUser;

    /**
     * 更新时间
     */
    @Column(name="update_time")
    private Date updateTime;

    /**
     * 更新人
     */
    @Column(name="update_user")
    private String updateUser;

    /**
     * 删除标志（indicator）
     */
    @Column(name="del_ind")
    private String delInd;

    /**
     * 版本号
     */
    @Column(name="version")
    private Integer version;

    public Categorys() {
    }
}
