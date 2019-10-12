package com.hui.pojo;


import java.io.Serializable;

public class Address implements Serializable{
    private static final long serialVersionUID = -8351287878380801831L;
    private Integer id;
    private Integer uid;            //用户ID
    private String recvPerson;      //收获人
    private String recvProvince;    //省（编码）
    private String recvCity;        //市（编码）
    private String recvArea;        //区（编码）
    private String recvDistrict;    //省市区（名称）
    private String recvAddr;        //详细地址
    private String recvPhone;       //手机号
    private String recvTel;         //固定电话
    private String recvAddrCode;    //邮编
    private String recvName;        //地址名称（家，公司...）
    private int isDefault;          //是否为默认地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRecvPerson() {
        return recvPerson;
    }

    public void setRecvPerson(String recvPerson) {
        this.recvPerson = recvPerson;
    }

    public String getRecvProvince() {
        return recvProvince;
    }

    public void setRecvProvince(String recvProvince) {
        this.recvProvince = recvProvince;
    }

    public String getRecvCity() {
        return recvCity;
    }

    public void setRecvCity(String recvCity) {
        this.recvCity = recvCity;
    }

    public String getRecvArea() {
        return recvArea;
    }

    public void setRecvArea(String recvArea) {
        this.recvArea = recvArea;
    }

    public String getRecvDistrict() {
        return recvDistrict;
    }

    public void setRecvDistrict(String recvDistrict) {
        this.recvDistrict = recvDistrict;
    }

    public String getRecvAddr() {
        return recvAddr;
    }

    public void setRecvAddr(String recvAddr) {
        this.recvAddr = recvAddr;
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone;
    }

    public String getRecvTel() {
        return recvTel;
    }

    public void setRecvTel(String recvTel) {
        this.recvTel = recvTel;
    }

    public String getRecvAddrCode() {
        return recvAddrCode;
    }

    public void setRecvAddrCode(String recvAddrCode) {
        this.recvAddrCode = recvAddrCode;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }
}
