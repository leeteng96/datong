package com.ifast.expressOrder.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.hibernate.validator.constraints.NotBlank;


/**
 * 
 * <pre>
 * 数据对比
 * </pre>
 * <small> 2018-10-31 10:32:38 | Aron</small>
 */
 @TableName("tb_data_comparison")
public class DataComparisonDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /**  */
    @TableId
    private Integer id;
    /** 分运单号 */
    @Excel(name="分运单号",orderNum="0")
    private String waybill;
    /** 提单号 */
    @Excel(name="提单号",orderNum="1")
    private String ladingBillNo;
    /** 毛重 */
    @Excel(name="毛重(KG)",orderNum="2")
    private BigDecimal grossWeight;
    /** 收件人地址 */
    @Excel(name="收件人地址",orderNum="3")
    private String receiverAddress;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：分运单号
     */
    public void setWaybill(String waybill) {
        this.waybill = waybill;
    }
    /**
     * 获取：分运单号
     */
    public String getWaybill() {
        return waybill;
    }
    /**
     * 设置：提单号
     */
    public void setLadingBillNo(String ladingBillNo) {
        this.ladingBillNo = ladingBillNo;
    }
    /**
     * 获取：提单号
     */
    public String getLadingBillNo() {
        return ladingBillNo;
    }
    /**
     * 设置：毛重
     */
    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }
    /**
     * 获取：毛重
     */
    public BigDecimal getGrossWeight() {
        return grossWeight;
    }
    /**
     * 设置：收件人地址
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
    /**
     * 获取：收件人地址
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }
}
