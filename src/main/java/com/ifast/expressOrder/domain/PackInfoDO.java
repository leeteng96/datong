package com.ifast.expressOrder.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;


/**
 * 
 * <pre>
 * 包裹信息
 * </pre>
 * <small> 2018-10-18 15:04:33 | Aron</small>
 */
 @TableName("tb_pack_info")
public class PackInfoDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /**  */
    @TableId
    private Long id;
    /** 关联单号 */
    @Excel(name="关联单号",orderNum="0")
    @NotBlank(message = "关联单号不能为空")
    private String relaNo;
    /** 提单号 */
    @Excel(name ="提单号" ,orderNum="1")
    @NotBlank(message = "提单号不能为空")
    private String ladingBillNo;
    /** 运单编号 */
    @Excel(name ="企业运单编号" ,orderNum="2")
    @NotBlank(message = "企业运单编号不能为空")
    private String waybillNo;
    /** 毛重(KG) */
    @Pattern(regexp="/(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)/", message = "毛重格式不正确")
    @Excel(name = "毛重(kg)",orderNum="3")
    private BigDecimal grossWeight;
    /** 包裹名称 */
    @NotBlank(message = "主要商品不能为空")
    @Excel(name="主要商品",orderNum="4")
    private String goodsName;
    /** 收件人姓名 */
    @Pattern(regexp = "[\\u4E00-\\u9FA5]{2,5}", message = "姓名中文2-5位")
    @Excel(name="收件人姓名",orderNum="5")
    private String receiver;
    /** 收件人地址 */
    @NotBlank(message = "收件人地址不能为空")
    @Excel(name="收件人地址",orderNum="6")
    private String receiverAddress;
    /** 收件人电话 */
    @Pattern(regexp="^((/(/d{3}/))|(/d{3}/-))?13[0-9]/d{8}|15[89]/d{8}", message = "电话格式不正确")
    @Excel(name="收货人电话",orderNum="7")
    private String receiverPhone;
    /** 收件人证件号码 */
    @NotBlank(message = "收货人证件号码不能为空")
    @Excel(name="收货人证件号码",orderNum="8")
    private String receiverIdcard;
    /** 发货人名称 */
    @NotBlank(message = "发货人名称不能为空")
    @Excel(name="发货人名称",orderNum="9")
    private String sender;
    /** 发货人地址 */
    @NotBlank(message = "发货人地址不能为空")
    @Excel(name="发货人地址",orderNum="10")
    private String senderAddress;
    /** 发货人电话 */
    @Pattern(regexp="^((/(/d{3}/))|(/d{3}/-))?13[0-9]/d{8}|15[89]/d{8}", message = "电话格式不正确")
    @Excel(name="发货人电话",orderNum="11")
    private String senderPhone;
    /** 商品数量 */
    @Pattern(regexp="^[0-9]*$", message = "商品数量格式不正确")
    @Excel(name="商品数量",orderNum="12")
    private Integer quantity;
    /** 商品总价 */
    @Pattern(regexp="/(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)/", message = "商品总价格式不正确")
    @Excel(name = "商品总价RMB（两位小数）",orderNum="13")
    private BigDecimal totalPrice;
    /** 商品单价 */
    @Pattern(regexp="/(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)/", message = "商品单价格式不正确")
    @Excel(name = "商品单价RMB（两位小数）",orderNum="14")
    private BigDecimal goodsValue;
    /** 上传时间 */
    private Date indate;
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
     * 设置：关联单号
     */
    public void setRelaNo(String relaNo) {
        this.relaNo = relaNo;
    }
    /**
     * 获取：关联单号
     */
    public String getRelaNo() {
        return relaNo;
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
     * 设置：运单编号
     */
    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }
    /**
     * 获取：运单编号
     */
    public String getWaybillNo() {
        return waybillNo;
    }
    /**
     * 设置：毛重(KG)
     */
    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }
    /**
     * 获取：毛重(KG)
     */
    public BigDecimal getGrossWeight() {
        return grossWeight;
    }
    /**
     * 设置：包裹名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
     * 获取：包裹名称
     */
    public String getGoodsName() {
        return goodsName;
    }
    /**
     * 设置：收件人姓名
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    /**
     * 获取：收件人姓名
     */
    public String getReceiver() {
        return receiver;
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
     * 设置：收件人电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
    /**
     * 获取：收件人电话
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }
    /**
     * 设置：收件人证件号码
     */
    public void setReceiverIdcard(String receiverIdcard) {
        this.receiverIdcard = receiverIdcard;
    }
    /**
     * 获取：收件人证件号码
     */
    public String getReceiverIdcard() {
        return receiverIdcard;
    }
    /**
     * 设置：发货人名称
     */
    public void setSender(String sender) {
        this.sender = sender;
    }
    /**
     * 获取：发货人名称
     */
    public String getSender() {
        return sender;
    }
    /**
     * 设置：发货人地址
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
    /**
     * 获取：发货人地址
     */
    public String getSenderAddress() {
        return senderAddress;
    }
    /**
     * 设置：发货人电话
     */
    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }
    /**
     * 获取：发货人电话
     */
    public String getSenderPhone() {
        return senderPhone;
    }
    /**
     * 设置：商品数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    /**
     * 获取：商品数量
     */
    public Integer getQuantity() {
        return quantity;
    }
    /**
     * 设置：商品总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    /**
     * 获取：商品总价
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    /**
     * 设置：商品单价
     */
    public void setGoodsValue(BigDecimal goodsValue) {
        this.goodsValue = goodsValue;
    }
    /**
     * 获取：商品单价
     */
    public BigDecimal getGoodsValue() {
        return goodsValue;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }
}
