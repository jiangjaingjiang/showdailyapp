package com.example.dailyeconomicflow.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    /**
     * id
     */
    @Column(name="id")
    private Integer id;

    /**
     * username
     */
    @Column(name="username")
    private String username;

    /**
     * password
     */
    @Column(name="password")
    private String password;

    /**
     * name
     */
    @Column(name="name")
    private String name;
    /**
     * name
     */
    @Column(name="time")
    private Date time;
    /**
     * name
     */
    @Column(name="money")
    private BigDecimal money;


    public User() {
    }
}

