package com.ifast.customer.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * 
 * <pre>
 * 客户信息
 * </pre>
 * <small> 2018-08-07 14:36:07 | Aron</small>
 */
 @TableName("tb_customer_info")
public class CustomerInfoDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /** 客户编号 */
    @TableId
    private Long id;
    /** 客户名称 */
    private String name;
    /** 联系人姓名 */
    private String personName;
    /** 联系人手机电话 */
    private String personTel;
    /** 联系人职位 */
    private String personPosition;
    /** 地区 */
    private String country;
    /** 通讯地址 */
    private String relationArea;
    /** 邮箱 */
    private String email;
    /** 传真 */
    private String facsimile;
    /** 录入日期 */
    private Date indate;

    /**
     * 设置：客户编号
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：客户编号
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：客户名称
     */
    public void setCustomerName(String customerName) {
        this.name = customerName;
    }
    /**
     * 获取：客户名称
     */
    public String getCustomerName() {
        return name;
    }
    /**
     * 设置：联系人姓名
     */
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    /**
     * 获取：联系人姓名
     */
    public String getPersonName() {
        return personName;
    }
    /**
     * 设置：联系人手机电话
     */
    public void setPersonTel(String personTel) {
        this.personTel = personTel;
    }
    /**
     * 获取：联系人手机电话
     */
    public String getPersonTel() {
        return personTel;
    }
    /**
     * 设置：联系人职位
     */
    public void setPersonPosition(String personPosition) {
        this.personPosition = personPosition;
    }
    /**
     * 获取：联系人职位
     */
    public String getPersonPosition() {
        return personPosition;
    }
    /**
     * 设置：地区
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * 获取：地区
     */
    public String getCountry() {
        return country;
    }
    /**
     * 设置：通讯地址
     */
    public void setRelationArea(String relationArea) {
        this.relationArea = relationArea;
    }
    /**
     * 获取：通讯地址
     */
    public String getRelationArea() {
        return relationArea;
    }
    /**
     * 设置：邮箱
     */
    public String getEmail() {
        return email;
    }
    /**
     * 获取：邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 设置：传真
     */
    public void setFacsimile(String facsimile) {
        this.facsimile = facsimile;
    }
    /**
     * 获取：传真
     */
    public String getFacsimile() {
        return facsimile;
    }

    /**
     * 设置：录入日期
     */
    public void setIndate(Date indate) {
        this.indate = indate;
    }
    /**
     * 获取：录入日期
     */
    public Date getIndate() {
        return indate;
    }
}
