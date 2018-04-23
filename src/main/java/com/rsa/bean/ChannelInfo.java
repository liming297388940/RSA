package com.rsa.bean;

import java.io.Serializable;
import java.util.Date;

public class ChannelInfo implements Serializable{
   
	private static final long serialVersionUID = 6028608450449037322L;

	private Integer id;

    private String channelCode;

    private String channelName;

    private String channelInfo;

    private String publicKey;

    private String privateKey;

    private String ip;

    private String domainName;

    private String groupId;

    private String accountType;
    
    private String dbstr;

    private String isDel;

    private Date createDate;

    private Date updateDate;

    private String userTransactionRate;

    private String channelTransactionRate;

    private String userInterestRate;

    private String channelInterestRate;

    private String commissionRate;

    private String tradeRate;

    private String tradeFee;

    private String remark;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    private String remark6;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getChannelInfo() {
        return channelInfo;
    }

    public void setChannelInfo(String channelInfo) {
        this.channelInfo = channelInfo == null ? null : channelInfo.trim();
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey == null ? null : publicKey.trim();
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName == null ? null : domainName.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    public String getDbstr() {
        return dbstr;
    }

    public void setDbstr(String dbstr) {
        this.dbstr = dbstr == null ? null : dbstr.trim();
    }
    
    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUserTransactionRate() {
        return userTransactionRate;
    }

    public void setUserTransactionRate(String userTransactionRate) {
        this.userTransactionRate = userTransactionRate == null ? null : userTransactionRate.trim();
    }

    public String getChannelTransactionRate() {
        return channelTransactionRate;
    }

    public void setChannelTransactionRate(String channelTransactionRate) {
        this.channelTransactionRate = channelTransactionRate == null ? null : channelTransactionRate.trim();
    }

    public String getUserInterestRate() {
        return userInterestRate;
    }

    public void setUserInterestRate(String userInterestRate) {
        this.userInterestRate = userInterestRate == null ? null : userInterestRate.trim();
    }

    public String getChannelInterestRate() {
        return channelInterestRate;
    }

    public void setChannelInterestRate(String channelInterestRate) {
        this.channelInterestRate = channelInterestRate == null ? null : channelInterestRate.trim();
    }

    public String getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate == null ? null : commissionRate.trim();
    }

    public String getTradeRate() {
        return tradeRate;
    }

    public void setTradeRate(String tradeRate) {
        this.tradeRate = tradeRate == null ? null : tradeRate.trim();
    }

    public String getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(String tradeFee) {
        this.tradeFee = tradeFee == null ? null : tradeFee.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5 == null ? null : remark5.trim();
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6 == null ? null : remark6.trim();
    }
}