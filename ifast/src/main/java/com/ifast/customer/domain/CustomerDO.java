package com.ifast.customer.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * 
 * <pre>
 * 客户信息动态表
 * </pre>
 * <small> 2018-08-07 17:09:10 | Aron</small>
 */
 @TableName("tb_user_customer")
public class CustomerDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /**  */
    @TableId
    private Long id;
    /** 用户编号 */
    private Long userId;
    /** 客户编号 */
    private Long customerId;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：用户编号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    /**
     * 获取：用户编号
     */
    public Long getUserId() {
        return userId;
    }
    /**
     * 设置：客户编号
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    /**
     * 获取：客户编号
     */
    public Long getCustomerId() {
        return customerId;
    }
}
