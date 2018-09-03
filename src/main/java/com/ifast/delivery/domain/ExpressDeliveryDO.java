package com.ifast.delivery.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 *
 * <pre>
 * 揽收快件
 * </pre>
 * <small> 2018-07-09 11:10:23 | Aron</small>
 */
@TableName("tb_express_delivery")
public class ExpressDeliveryDO implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 主键 */
    @TableId("id")
    private Long id;
    /** 订单编号 */
    private String orderNo;
    /** 收件人地址 */
    private String receiverAddress;
    /** 收件人 */
    private String receiver;
    /** 收件人证件类型 */
    private String receiverCtype;
    /** 收件人身份证号码 */
    private String receiverIdcard;
    /** 发件人地址 */
    private String senderAddress;
    /** 发件人 */
    private String sender;
    /** 发件人证件类型 */
    private String senderCtype;
    /** 发件人身份证号码 */
    private String senderIdcard;
    /** 商品ID */
    private String productId;
    /** 数量 */
    private Integer data;
    /** 重量 */
    private BigDecimal weight;

    @TableField(exist = false)
    private String productName;


    @TableField(exist = false)
    private List<ProductDO> products;


    /**
     * 设置：主键
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：主键
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    /**
     * 获取：
     */
    public String getOrderNo() {
        return orderNo;
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
    /**
     * 设置：收件人证件类型
     */
    public void setReceiverCtype(String receiverCtype) {
        this.receiverCtype = receiverCtype;
    }
    /**
     * 获取：收件人证件类型
     */
    public String getReceiverCtype() {
        return receiverCtype;
    }
    /**
     * 设置：收件人身份证号码
     */
    public void setReceiverIdcard(String receiverIdcard) {
        this.receiverIdcard = receiverIdcard;
    }
    /**
     * 获取：收件人身份证号码
     */
    public String getReceiverIdcard() {
        return receiverIdcard;
    }
    /**
     * 设置：发件人地址
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
    /**
     * 获取：发件人地址
     */
    public String getSenderAddress() {
        return senderAddress;
    }
    /**
     * 设置：发件人
     */
    public void setSender(String sender) {
        this.sender = sender;
    }
    /**
     * 获取：发件人
     */
    public String getSender() {
        return sender;
    }
    /**
     * 设置：发件人证件类型
     */
    public void setSenderCtype(String senderCtype) {
        this.senderCtype = senderCtype;
    }
    /**
     * 获取：发件人证件类型
     */
    public String getSenderCtype() {
        return senderCtype;
    }
    /**
     * 设置：发件人身份证号码
     */
    public void setSenderIdcard(String senderIdcard) {
        this.senderIdcard = senderIdcard;
    }
    /**
     * 获取：发件人身份证号码
     */
    public String getSenderIdcard() {
        return senderIdcard;
    }


    /**
     * 设置：数据
     */
    public void setData(Integer data) {
        this.data = data;
    }
    /**
     * 获取：数据
     */
    public Integer getData() {
        return data;
    }
    /**
     * 设置：重量
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    /**
     * 获取：重量
     */
    public BigDecimal getWeight() {
        return weight;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "ExpressDeliveryDO{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiver='" + receiver + '\'' +
                ", receiverCtype='" + receiverCtype + '\'' +
                ", receiverIdcard='" + receiverIdcard + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", sender='" + sender + '\'' +
                ", senderCtype='" + senderCtype + '\'' +
                ", senderIdcard='" + senderIdcard + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", products=" + products +
                ", data='" + data + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
