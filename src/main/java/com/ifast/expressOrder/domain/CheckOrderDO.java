package com.ifast.expressOrder.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 *
 * <pre>
 * 待检测清单
 * </pre>
 * <small> 2018-11-01 16:24:23 | Aron</small>
 */
@TableName("tb_check_order")
public class CheckOrderDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**  */
    @TableId
    private Long id;

    @TableField(exist = false)
    @Excel(name="提单号",orderNum="0")
    private String ladingBillNo;
    /** 收寄时间 */
    @Excel(name="收寄时间",orderNum="1")
    private String receiverDate;
    /** 邮件号 */
    @Excel(name="邮件号",orderNum="2")
    private String waybillNo;
    /** 寄达省名称 */
    @Excel(name="寄达省名称",orderNum="3")
    private String province;
    /** 寄达市名称 */
    @Excel(name="寄达市名称",orderNum="4")
    private String city;
    /** 寄达局 */
    @Excel(name="寄达局",orderNum="5")
    private String postOffice;
    /** 计泡重量（克） */
    @Excel(name="计泡重量（克）",orderNum="6")
    private BigDecimal bubbleWeight;
    /** 重量(克) */
    @Excel(name="重量(克)",orderNum="7")
    private BigDecimal weight;
    /** 结算邮费 */
    @Excel(name="结算邮费",orderNum="8")
    private BigDecimal billPostage;
    /** 收件人 */
    @Excel(name="收件人",orderNum="9")
    private String receiver;

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
     * 设置：收寄时间
     */
    public void setReceiverDate(String receiverDate) {
        this.receiverDate = receiverDate;
    }
    /**
     * 获取：收寄时间
     */
    public String getReceiverDate() {
        return receiverDate;
    }
    /**
     * 设置：邮件号
     */
    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }
    /**
     * 获取：邮件号
     */
    public String getWaybillNo() {
        return waybillNo;
    }
    /**
     * 设置：寄达省名称
     */
    public void setProvince(String province) {
        this.province = province;
    }
    /**
     * 获取：寄达省名称
     */
    public String getProvince() {
        return province;
    }
    /**
     * 设置：寄达市名称
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * 获取：寄达市名称
     */
    public String getCity() {
        return city;
    }
    /**
     * 设置：寄达局
     */
    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }
    /**
     * 获取：寄达局
     */
    public String getPostOffice() {
        return postOffice;
    }
    /**
     * 设置：计泡重量（克）
     */
    public void setBubbleWeight(BigDecimal bubbleWeight) {
        this.bubbleWeight = bubbleWeight;
    }
    /**
     * 获取：计泡重量（克）
     */
    public BigDecimal getBubbleWeight() {
        return bubbleWeight;
    }
    /**
     * 设置：重量(克)
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    /**
     * 获取：重量(克)
     */
    public BigDecimal getWeight() {
        return weight;
    }
    /**
     * 设置：结算邮费
     */
    public void setBillPostage(BigDecimal billPostage) {
        this.billPostage = billPostage;
    }
    /**
     * 获取：结算邮费
     */
    public BigDecimal getBillPostage() {
        return billPostage;
    }
    /**
     * 设置：收件人
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    /**
     * 获取：收件人
     */
    public String getReceiver() {
        return receiver;
    }

    public String getLadingBillNo() {
        return ladingBillNo;
    }

    public void setLadingBillNo(String ladingBillNo) {
        this.ladingBillNo = ladingBillNo;
    }
}
