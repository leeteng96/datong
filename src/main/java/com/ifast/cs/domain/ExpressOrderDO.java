package com.ifast.cs.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import cn.afterturn.easypoi.excel.annotation.Excel;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * <pre>
 * 快递订单
 * </pre>
 * <small> 2018-08-28 15:04:45 | Aron</small>
 */
@TableName("tb_express_order")
public class ExpressOrderDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @TableId
    private Long id;

    /** 总运单号 */
    private String totalWaybillNo;

    /** 关联单号 */
    @Excel(name="关联单号",orderNum="0")
    @NotBlank(message = "关联单号不能为空")
    private String relaNo;

    /** 快递单号 */
    @Excel(name ="企业运单编号" ,orderNum="1")
    @NotBlank(message = "企业运单编号不能为空")
    private String waybillNo;

    /** 提单号 */
    @Excel(name ="提单号" ,orderNum="2")
    @NotBlank(message = "提单号不能为空")
    private String ladingBillNo;

    /** 航班号 */
    private String flightNo;

    /** 模式 */
    private Integer logisticsType;
    /** 提货日期 */
    private Date pickupDate;
    /** 到场日期 */
    private Date turnupDate;
    /** 清关日期 */
    private Date cleanDate;
    /** 清关状态 */
    private Integer cleanStatus;
    /** 备注 */
    private String cleanRemark;
    /** 发件人 */
    @NotBlank(message = "发货人名称不能为空")
    @Excel(name="发货人名称",orderNum="3")
    private String sender;

    /** 发件人地址 */
    @NotBlank(message = "发货人地址不能为空")
    @Excel(name="发货人地址",orderNum="4")
    private String senderAddress;

    /** 发件人电话 */
    @Pattern(regexp="^((/(/d{3}/))|(/d{3}/-))?13[0-9]/d{8}|15[89]/d{8}", message = "电话格式不正确")
    @Excel(name="发货人电话",orderNum="5")
    private String senderPhone;

    /** 收件人 */
    @Pattern(regexp = "[\\u4E00-\\u9FA5]{2,5}", message = "姓名中文2-5位")
    @Excel(name="收件人姓名",orderNum="6")
    private String receiver;

    /** 收件人身份证号 */
    @NotBlank(message = "收货人证件号码不能为空")
    @Excel(name="收货人证件号码",orderNum="7")
    private String receiverIdcard;

    /** 收件人电话 */
    @Pattern(regexp="^((/(/d{3}/))|(/d{3}/-))?13[0-9]/d{8}|15[89]/d{8}", message = "电话格式不正确")
    @Excel(name="收货人电话",orderNum="8")
    private String receiverPhone;


    /** 邮编 */
    private String zipCode;

    /** 收件人地址 */
    @NotBlank(message = "收件人地址不能为空")
    @Excel(name="收件人地址",orderNum="9")

    private String receiverAddress;
    /** 商品序号 */
    private String goodsSeq;

    /** 本包裹名称 */
    @NotBlank(message = "主要商品不能为空")
    @Excel(name="主要商品",orderNum="10")
    private String goodsName;
    /** 国家简称 */
    private String nationalShortName;
    /** 原产国 */
    private String originCountry;
    /** 货号 */
    private String goodsCode;
    /** 商品规格 */
    private String goodsModel;
    /** 品牌名称 */
    private String brand;
    /** 单价 */
    @Pattern(regexp="/(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)/", message = "商品单价格式不正确")
    @Excel(name = "商品单价RMB（两位小数）",orderNum="11")
    private BigDecimal goodsValue;

    /**商品总价*/
    @Pattern(regexp="/(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)/", message = "商品总价格式不正确")
    @Excel(name = "商品总价RMB（两位小数）",orderNum="12")
    private BigDecimal totalPrice;
    /** 币制 */
    private Integer currency;
    /** 毛重 */
    @Pattern(regexp="/(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)/", message = "毛重格式不正确")
    @Excel(name = "毛重(kg)",orderNum="13")
    private BigDecimal grossWeight;
    /** 净重 */
    private BigDecimal netWt;
    /** 数量 */
    @Pattern(regexp="^[0-9]*$", message = "商品数量格式不正确")
    @Excel(name="商品数量",orderNum="14")
    private BigDecimal quantity;

    /** 海关商品编码 */
    private String hsCode;
    /** 公司ID */
    private Long corpId;
    /** 清关口岸ID */
    private Long portId;
    /** 快递公司 */
    private String expressCompany;



    /** 创建时间 */
    private Date createTime;
    /** 操作用户 */
    private Long userId;
    /** 客户ID */
    private Long customerId;

    /** 集包地名称 */
    private String packageCenterName;
    /** 打印状态 */
    private Integer printStatus;
    /** 打板状态:1未打板,2打板 */
    private Integer boardStatus;

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

    public String getTotalWaybillNo() {
        return totalWaybillNo;
    }

    public void setTotalWaybillNo(String totalWaybillNo) {
        this.totalWaybillNo = totalWaybillNo;
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



    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }
    /**
     * 获取：快递单号
     */
    public String getWaybillNo() {
        return waybillNo;
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
     * 设置：航班号
     */
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }
    /**
     * 获取：航班号
     */
    public String getFlightNo() {
        return flightNo;
    }
    /**
     * 设置：票数
     */

    /**
     * 设置：模式
     */
    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }
    /**
     * 获取：模式
     */
    public Integer getLogisticsType() {
        return logisticsType;
    }
    /**
     * 设置：提货日期
     */
    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }
    /**
     * 获取：提货日期
     */
    public Date getPickupDate() {
        return pickupDate;
    }
    /**
     * 设置：到场日期
     */
    public void setTurnupDate(Date turnupDate) {
        this.turnupDate = turnupDate;
    }
    /**
     * 获取：到场日期
     */
    public Date getTurnupDate() {
        return turnupDate;
    }
    /**
     * 设置：清关日期
     */
    public void setCleanDate(Date cleanDate) {
        this.cleanDate = cleanDate;
    }
    /**
     * 获取：清关日期
     */
    public Date getCleanDate() {
        return cleanDate;
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
     * 设置：收件人身份证号
     */
    public void setReceiverIdcard(String receiverIdcard) {
        this.receiverIdcard = receiverIdcard;
    }
    /**
     * 获取：收件人身份证号
     */
    public String getReceiverIdcard() {
        return receiverIdcard;
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
     * 设置：邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    /**
     * 获取：邮编
     */
    public String getZipCode() {
        return zipCode;
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
     * 设置：商品序号
     */
    public void setGoodsSeq(String goodsSeq) {
        this.goodsSeq = goodsSeq;
    }
    /**
     * 获取：商品序号
     */
    public String getGoodsSeq() {
        return goodsSeq;
    }
    /**
     * 设置：本包裹名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
     * 获取：本包裹名称
     */
    public String getGoodsName() {
        return goodsName;
    }


    /**
     * 设置：国家简称
     */
    public void setNationalShortName(String nationalShortName) {
        this.nationalShortName = nationalShortName;
    }
    /**
     * 获取：国家简称
     */
    public String getNationalShortName() {
        return nationalShortName;
    }
    /**
     * 设置：原产国
     */
    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
    /**
     * 获取：原产国
     */
    public String getOriginCountry() {
        return originCountry;
    }
    /**
     * 设置：货号
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
    /**
     * 获取：货号
     */
    public String getGoodsCode() {
        return goodsCode;
    }
    /**
     * 设置：商品规格
     */
    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }
    /**
     * 获取：商品规格
     */
    public String getGoodsModel() {
        return goodsModel;
    }
    /**
     * 设置：品牌名称
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     * 获取：品牌名称
     */
    public String getBrand() {
        return brand;
    }
    /**
     * 设置：单价
     */
    public void setGoodsValue(BigDecimal goodsValue) {
        this.goodsValue = goodsValue;
    }
    /**
     * 获取：单价
     */
    public BigDecimal getGoodsValue() {
        return goodsValue;
    }

    /**
     * 获取：商品总价
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    /**
     * 设置：商品总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 设置：币制
     */
    public void setCurrency(Integer currency) {
        this.currency = currency;
    }
    /**
     * 获取：币制
     */
    public Integer getCurrency() {
        return currency;
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
     * 设置：净重
     */
    public void setNetWt(BigDecimal netWt) {
        this.netWt = netWt;
    }
    /**
     * 获取：净重
     */
    public BigDecimal getNetWt() {
        return netWt;
    }
    /**
     * 设置：数量
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    /**
     * 获取：数量
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * 设置：海关商品编码
     */
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }
    /**
     * 获取：海关商品编码
     */
    public String getHsCode() {
        return hsCode;
    }
    /**
     * 设置：公司ID
     */
    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }
    /**
     * 获取：公司ID
     */
    public Long getCorpId() {
        return corpId;
    }
    /**
     * 设置：清关口岸ID
     */
    public void setPortId(Long portId) {
        this.portId = portId;
    }
    /**
     * 获取：清关口岸ID
     */
    public Long getPortId() {
        return portId;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String  expressCompany) {
        this.expressCompany = expressCompany;
    }

    /**

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：操作用户
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    /**
     * 获取：操作用户
     */
    public Long getUserId() {
        return userId;
    }
    /**
     * 设置：客户ID
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    /**
     * 获取：客户ID
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 设置：集包地名称
     */
    public void setPackageCenterName(String packageCenterName) {
        this.packageCenterName = packageCenterName;
    }
    /**
     * 获取：集包地名称
     */
    public String getPackageCenterName() {
        return packageCenterName;
    }
    /**
     * 设置：打印状态
     */
    public void setPrintStatus(Integer printStatus) {
        this.printStatus = printStatus;
    }
    /**
     * 获取：打印状态
     */
    public Integer getPrintStatus() {
        return printStatus;
    }
    /**
     * 设置：打板状态:1未打板,2打板
     */
    public void setBoardStatus(Integer boardStatus) {
        this.boardStatus = boardStatus;
    }
    /**
     * 获取：打板状态:1未打板,2打板
     */
    public Integer getBoardStatus() {
        return boardStatus;
    }

    public Integer getCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(Integer cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    public String getCleanRemark() {
        return cleanRemark;
    }

    public void setCleanRemark(String cleanRemark) {
        this.cleanRemark = cleanRemark;
    }
}
