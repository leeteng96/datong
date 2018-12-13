package com.ifast.delivery.domain;

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
 * 申报资料
 * </pre>
 * <small> 2018-12-10 17:07:11 | Aron</small>
 */
@TableName("tb_declare")
public class DeclareDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**  */
    @TableId
    private Integer id;
    /** 类别 */
    @Excel(name="类别")
    private String category;
    /** 收发货人编号 */
    @Excel(name="收发货人编号")
    private String transceiverNo;
    /** 收发货人名称 */
    @Excel(name="收发货人名称")
    private String transceiverName;
    /** 收发货人统一社会信用代码 */
    @Excel(name="收发货人统一社会信用代码")
    private String creditCode;
    /** 提单号 */
    @Excel(name="提单号")
    private String ladingBillNo;
    /** 分运单号 */
    @Excel(name="分运单号")
    private String waybillNo;
    /** 商品序号 */
    @Excel(name="商品序号")
    private Integer serialNo;
    /** 货物名称 */
    @Excel(name="货物名称")
    private String productName;
    /** 货物英文名称 */
    @Excel(name="货物英文名称")
    private String enName;
    /** 产销城市 */
    @Excel(name="产销城市")
    private String city;
    /** 商品编码 */
    @Excel(name="商品编码")
    private String code;
    /** 数量 */
    @Excel(name="数量")
    private Integer quantity;
    /** 净重(KG) */
    @Excel(name="净重(KG)")
    private BigDecimal netwt;
    /** 毛重(KG) */
    @Excel(name="毛重(KG)")
    private BigDecimal weight;
    /** 规格/型号 */
    @Excel(name="规格/型号")
    private String model;
    /** 申报单价 */
    @Excel(name="申报单价")
    private BigDecimal price;
    /** 申报数量 */
    @Excel(name="申报数量")
    private Integer applyQuantity;
    /** 申报总价 */
    @Excel(name="申报总价")
    private BigDecimal totalPrice;
    /** 成交总价 */
    @Excel(name="成交总价")
    private BigDecimal transactionPrice;
    /** 申报计量单位 */
    @Excel(name="申报计量单位")
    private String firstUit;
    /** 收件人 */
    @Excel(name="收件人")
    private String receiver;
    /** 收件人证件号 */
    @Excel(name="收件人证件号")
    private String receiverIdcard;
    /** 收件人证件类型 */
    @Excel(name="收件人证件类型")
    private Integer recevierType;
    /** 收件人城市 */
    @Excel(name="收件人城市")
    private String receiverCity;
    /** 收件人地址 */
    @Excel(name="收件人地址")
    private String receiverAddress;
    /** 收件人电话 */
    @Excel(name="收件人电话")
    private String receiverPhone;
    /** 货主单位名称 */
    @Excel(name="货主单位名称")
    private String unitName;
    /** 货主单位代码 */
    @Excel(name="货主单位代码")
    private String unitNo;
    /** 货主单位统一社会信用代码 */
    @Excel(name="货主单位统一社会信用代码")
    private String ownerCode;
    /** 货主单位地区代码 */
    @Excel(name="货主单位地区代码")
    private String ownerAreaCode;
    /** 贸易国别 */
    @Excel(name="贸易国别")
    private String tradingCountry;
    /** 产销国 */
    @Excel(name="产销国")
    private String copam;
    /** 发件人 */
    @Excel(name="发件人")
    private String sender;
    /** 英文发件人 */
    @Excel(name="英文发件人")
    private String senderEn;
    /** 发件人国别 */
    @Excel(name="发件人国别")
    private String senderNation;
    /** 发件人城市 */
    @Excel(name="发件人城市")
    private String senderCity;
    /** 英文发件人城市 */
    @Excel(name="英文发件人城市")
    private String senderCityEn;
    /** 英文经停城市 */
    @Excel(name="英文经停城市")
    private String stopcityEn;
    /** 发件人地址 */
    @Excel(name="发件人地址")
    private String senderAddress;
    /** 英文发件人地址 */
    @Excel(name="英文发件人地址")
    private String senderAddressEn;
    /** 发件人电话 */
    @Excel(name="发件人电话")
    private String senderPhone;
    /** 包装种类 */
    @Excel(name="包装种类")
    private String packageType;
    /** 是否含木质包装 */
    @Excel(name="是否含木质包装")
    private String woodenFlag;
    /** 是否为旧物品 */
    @Excel(name="是否为旧物品")
    private String oldgoodsFlag;
    /** 是否为低温运输 */
    @Excel(name="是否为低温运输")
    private String lowshipFlag;
    /** 用途 */
    @Excel(name="用途")
    private String use;
    /** 随附单证类型 */
    @Excel(name="随附单证类型")
    private String documentType;
    /** 随附单证编号 */
    @Excel(name="随附单证编号")
    private String documentNo;

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
     * 设置：类别
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * 获取：类别
     */
    public String getCategory() {
        return category;
    }
    /**
     * 设置：收发货人编号
     */
    public void setTransceiverNo(String transceiverNo) {
        this.transceiverNo = transceiverNo;
    }
    /**
     * 获取：收发货人编号
     */
    public String getTransceiverNo() {
        return transceiverNo;
    }
    /**
     * 设置：收发货人名称
     */
    public void setTransceiverName(String transceiverName) {
        this.transceiverName = transceiverName;
    }
    /**
     * 获取：收发货人名称
     */
    public String getTransceiverName() {
        return transceiverName;
    }
    /**
     * 设置：收发货人统一社会信用代码
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }
    /**
     * 获取：收发货人统一社会信用代码
     */
    public String getCreditCode() {
        return creditCode;
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
     * 设置：分运单号
     */
    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }
    /**
     * 获取：分运单号
     */
    public String getWaybillNo() {
        return waybillNo;
    }
    /**
     * 设置：商品序号
     */
    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }
    /**
     * 获取：商品序号
     */
    public Integer getSerialNo() {
        return serialNo;
    }
    /**
     * 设置：货物名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    /**
     * 获取：货物名称
     */
    public String getProductName() {
        return productName;
    }
    /**
     * 设置：货物英文名称
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }
    /**
     * 获取：货物英文名称
     */
    public String getEnName() {
        return enName;
    }
    /**
     * 设置：产销城市
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * 获取：产销城市
     */
    public String getCity() {
        return city;
    }
    /**
     * 设置：商品编码
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * 获取：商品编码
     */
    public String getCode() {
        return code;
    }
    /**
     * 设置：数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    /**
     * 获取：数量
     */
    public Integer getQuantity() {
        return quantity;
    }
    /**
     * 设置：净重(KG)
     */
    public void setNetwt(BigDecimal netwt) {
        this.netwt = netwt;
    }
    /**
     * 获取：净重(KG)
     */
    public BigDecimal getNetwt() {
        return netwt;
    }
    /**
     * 设置：毛重(KG)
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    /**
     * 获取：毛重(KG)
     */
    public BigDecimal getWeight() {
        return weight;
    }
    /**
     * 设置：规格/型号
     */
    public void setModel(String model) {
        this.model = model;
    }
    /**
     * 获取：规格/型号
     */
    public String getModel() {
        return model;
    }
    /**
     * 设置：申报单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    /**
     * 获取：申报单价
     */
    public BigDecimal getPrice() {
        return price;
    }
    /**
     * 设置：申报数量
     */
    public void setApplyQuantity(Integer applyQuantity) {
        this.applyQuantity = applyQuantity;
    }
    /**
     * 获取：申报数量
     */
    public Integer getApplyQuantity() {
        return applyQuantity;
    }
    /**
     * 设置：申报总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    /**
     * 获取：申报总价
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    /**
     * 设置：成交总价
     */
    public void setTransactionPrice(BigDecimal transactionPrice) {
        this.transactionPrice = transactionPrice;
    }
    /**
     * 获取：成交总价
     */
    public BigDecimal getTransactionPrice() {
        return transactionPrice;
    }
    /**
     * 设置：申报计量单位
     */
    public void setFirstUit(String firstUit) {
        this.firstUit = firstUit;
    }
    /**
     * 获取：申报计量单位
     */
    public String getFirstUit() {
        return firstUit;
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
     * 设置：收件人证件号
     */
    public void setReceiverIdcard(String receiverIdcard) {
        this.receiverIdcard = receiverIdcard;
    }
    /**
     * 获取：收件人证件号
     */
    public String getReceiverIdcard() {
        return receiverIdcard;
    }
    /**
     * 设置：收件人证件类型
     */
    public void setRecevierType(Integer recevierType) {
        this.recevierType = recevierType;
    }
    /**
     * 获取：收件人证件类型
     */
    public Integer getRecevierType() {
        return recevierType;
    }
    /**
     * 设置：收件人城市
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }
    /**
     * 获取：收件人城市
     */
    public String getReceiverCity() {
        return receiverCity;
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
     * 设置：货主单位名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    /**
     * 获取：货主单位名称
     */
    public String getUnitName() {
        return unitName;
    }
    /**
     * 设置：货主单位代码
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }
    /**
     * 获取：货主单位代码
     */
    public String getUnitNo() {
        return unitNo;
    }
    /**
     * 设置：货主单位统一社会信用代码
     */
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }
    /**
     * 获取：货主单位统一社会信用代码
     */
    public String getOwnerCode() {
        return ownerCode;
    }
    /**
     * 设置：货主单位地区代码
     */
    public void setOwnerAreaCode(String ownerAreaCode) {
        this.ownerAreaCode = ownerAreaCode;
    }
    /**
     * 获取：货主单位地区代码
     */
    public String getOwnerAreaCode() {
        return ownerAreaCode;
    }
    /**
     * 设置：贸易国别
     */
    public void setTradingCountry(String tradingCountry) {
        this.tradingCountry = tradingCountry;
    }
    /**
     * 获取：贸易国别
     */
    public String getTradingCountry() {
        return tradingCountry;
    }
    /**
     * 设置：产销国
     */
    public void setCopam(String copam) {
        this.copam = copam;
    }
    /**
     * 获取：产销国
     */
    public String getCopam() {
        return copam;
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
     * 设置：英文发件人
     */
    public void setSenderEn(String senderEn) {
        this.senderEn = senderEn;
    }
    /**
     * 获取：英文发件人
     */
    public String getSenderEn() {
        return senderEn;
    }
    /**
     * 设置：发件人国别
     */
    public void setSenderNation(String senderNation) {
        this.senderNation = senderNation;
    }
    /**
     * 获取：发件人国别
     */
    public String getSenderNation() {
        return senderNation;
    }
    /**
     * 设置：发件人城市
     */
    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }
    /**
     * 获取：发件人城市
     */
    public String getSenderCity() {
        return senderCity;
    }
    /**
     * 设置：英文发件人城市
     */
    public void setSenderCityEn(String senderCityEn) {
        this.senderCityEn = senderCityEn;
    }
    /**
     * 获取：英文发件人城市
     */
    public String getSenderCityEn() {
        return senderCityEn;
    }
    /**
     * 设置：英文经停城市
     */
    public void setStopcityEn(String stopcityEn) {
        this.stopcityEn = stopcityEn;
    }
    /**
     * 获取：英文经停城市
     */
    public String getStopcityEn() {
        return stopcityEn;
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
     * 设置：英文发件人地址
     */
    public void setSenderAddressEn(String senderAddressEn) {
        this.senderAddressEn = senderAddressEn;
    }
    /**
     * 获取：英文发件人地址
     */
    public String getSenderAddressEn() {
        return senderAddressEn;
    }
    /**
     * 设置：发件人电话
     */
    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }
    /**
     * 获取：发件人电话
     */
    public String getSenderPhone() {
        return senderPhone;
    }
    /**
     * 设置：包装种类
     */
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
    /**
     * 获取：包装种类
     */
    public String getPackageType() {
        return packageType;
    }
    /**
     * 设置：是否含木质包装
     */
    public void setWoodenFlag(String woodenFlag) {
        this.woodenFlag = woodenFlag;
    }
    /**
     * 获取：是否含木质包装
     */
    public String getWoodenFlag() {
        return woodenFlag;
    }
    /**
     * 设置：是否为旧物品
     */
    public void setOldgoodsFlag(String oldgoodsFlag) {
        this.oldgoodsFlag = oldgoodsFlag;
    }
    /**
     * 获取：是否为旧物品
     */
    public String getOldgoodsFlag() {
        return oldgoodsFlag;
    }
    /**
     * 设置：是否为低温运输
     */
    public void setLowshipFlag(String lowshipFlag) {
        this.lowshipFlag = lowshipFlag;
    }
    /**
     * 获取：是否为低温运输
     */
    public String getLowshipFlag() {
        return lowshipFlag;
    }
    /**
     * 设置：用途
     */
    public void setUse(String use) {
        this.use = use;
    }
    /**
     * 获取：用途
     */
    public String getUse() {
        return use;
    }
    /**
     * 设置：随附单证类型
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    /**
     * 获取：随附单证类型
     */
    public String getDocumentType() {
        return documentType;
    }
    /**
     * 设置：随附单证编号
     */
    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }
    /**
     * 获取：随附单证编号
     */
    public String getDocumentNo() {
        return documentNo;
    }
}
