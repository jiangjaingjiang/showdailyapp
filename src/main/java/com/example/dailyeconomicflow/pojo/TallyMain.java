package com.example.dailyeconomicflow.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name ="tally_main")
public class TallyMain {
    /**
     * 记账主表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /**
     * 交易时间
     */
    @Column(name="trading_time")
    private Date tradingTime;

    /**
     * 来源
     */
    @Column(name="trading_source")
    private String tradingSource;

    /**
     * 收/支
     */
    @Column(name="collect_or_branch")
    private String collectOrBranch;

    /**
     * 支付状态
     */
    @Column(name="state_payment")
    private String statePayment;

    /**
     * 类型
     */
    @Column(name="trading_type")
    private String tradingType;

    /**
     * 交易对方
     */
    @Column(name="trading_other")
    private String tradingOther;

    /**
     * 商品
     */
    @Column(name="trading_commodity")
    private String tradingCommodity;

    /**
     * 金额
     */
    @Column(name="trading_money")
    private BigDecimal tradingMoney;

    /**
     * 收支标识
     */
    @Column(name="plus_or_minus")
    private Integer plusOrMinus;

    /**
     * 是否计算标识
     */
    @Column(name="is_need")
    private Integer isNeed;

    /**
     * 计算后金额
     */
    @Column(name="amount_after_money")
    private BigDecimal amountAfterMoney;

    /**
     * 交易行为类别
     */
    @Column(name="trading_detail_type")
    private String tradingDetailType;

    /**
     * 交易行为第二类别
     */
    @Column(name="trading_more_detail_type")
    private String tradingMoreDetailType;

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

//    public void setId(Integer id) {
//        this.id = id;
//    }
//    public Integer getId() {
//        return id;
//    }
//
//    public void settradingTime(Date tradingTime) {
//        this.tradingTime = tradingTime;
//    }
//    public Date gettradingTime() {
//        return tradingTime;
//    }
//
//    public void settradingSource(String tradingSource) {
//        this.tradingSource = tradingSource;
//    }
//    public String gettradingSource() {
//        return tradingSource;
//    }
//
//    public void setcollectOrBranch(String collectOrBranch) {
//        this.collectOrBranch = collectOrBranch;
//    }
//    public String getcollectOrBranch() {
//        return collectOrBranch;
//    }
//
//    public void setstatePayment(String statePayment) { this.statePayment = statePayment; }
//    public String getstatePayment() {
//        return statePayment;
//    }
//
//    public void settradingType(String tradingType) {
//        this.tradingType = tradingType;
//    }
//    public String gettradingType() {
//        return tradingType;
//    }
//
//    public void settradingOther(String tradingOther) {
//        this.tradingOther = tradingOther;
//    }
//    public String gettradingOther() {
//        return tradingOther;
//    }
//
//    public void settradingCommodity(String tradingCommodity) {
//        this.tradingCommodity = tradingCommodity;
//    }
//    public String gettradingCommodity() {
//        return tradingCommodity;
//    }
//
//    public void settradingMoney(BigDecimal tradingMoney) {
//        this.tradingMoney = tradingMoney;
//    }
//    public BigDecimal gettradingMoney() {
//        return tradingMoney;
//    }
//
//    public void setplusOrMinus(Integer plusOrMinus) {
//        this.plusOrMinus = plusOrMinus;
//    }
//    public Integer getplusOrMinus() {
//        return plusOrMinus;
//    }
//
//    public void setisNeed(Integer isNeed) {
//        this.isNeed = isNeed;
//    }
//    public Integer getisNeed() {
//        return isNeed;
//    }
//
//    public void setamountAfterMoney(BigDecimal amountAfterMoney) {
//        this.amountAfterMoney = amountAfterMoney;
//    }
//    public BigDecimal getamountAfterMoney() {
//        return amountAfterMoney;
//    }
//
//    public void settradingMoreDetailType(String tradingMoreDetailType) { this.tradingMoreDetailType = tradingMoreDetailType; }
//    public String gettradingMoreDetailType() {
//        return tradingMoreDetailType;
//    }
//
//    public void setcrtInst(String crtInst) {
//        this.crtInst = crtInst;
//    }
//    public String getcrtInst() {
//        return crtInst;
//    }
//
//    public void setcreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//    public Date getcreateTime() {
//        return createTime;
//    }
//
//    public void setcreateUser(String createUser) {
//        this.createUser = createUser;
//    }
//    public String getcreateUser() {
//        return createUser;
//    }
//
//    public void setupdateTime(Date updateTime) { this.updateTime = updateTime; }
//    public Date getupdateTime() {
//        return updateTime;
//    }
//
//    public void setupdateUser(String updateUser) {
//        this.updateUser = updateUser;
//    }
//    public String getupdateUser() {
//        return updateUser;
//    }
//
//    public void setdelInd(String delInd) {
//        this.delInd = delInd;
//    }
//    public String getdelInd() {
//        return delInd;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
//    public Integer getVersion() {
//        return version;
//    }

}
