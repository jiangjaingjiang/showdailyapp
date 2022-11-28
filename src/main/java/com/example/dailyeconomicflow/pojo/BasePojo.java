package com.example.dailyeconomicflow.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Title: 共用的 pojo
 * @Description:
 * @Param:
 * @Return:
 * @Author: ZengJT
 * @Updatedate: 2022/11/16 9:40
 */

@Data
@MappedSuperclass
public abstract class BasePojo implements Serializable {

    /**
     * 主表id
     */
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "id-generator",strategy = "increment")
    @GeneratedValue(generator = "id-generator")
    @Column(name="id")
    private Long id;

    /**
     * 创建机构
     */
    @Column(name="crt_inst")
    private String crtInst;

    /**
     * 创建时间
     */
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @Column(name="create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name="create_user")
    private String createUser;

    /**
     * 更新时间
     */
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @Column(name="update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**
     * 更新人
     */
    @Column(name="update_user")
    private String updateUser;

    /**
     * 删除标志（indicator）
     */
    @Column(name="del_ind",
            columnDefinition = "varchar default '0'")
    private String delInd;

    /**
     * 版本号
     */
    @Column(name="version")
    private Integer version;

}
