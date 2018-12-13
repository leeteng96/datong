package com.ifast.expressOrder.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 *
 * <pre>
 * 订单表
 * </pre>
 * <small> 2018-12-04 15:48:57 | Aron</small>
 */
@TableName("tb_express_order")
public class ExpressOrderDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**  */
    @TableId
    private Long id;
    /** 总运单号 */
    private String totalWaybillNo;
    /** 关联单号 */
    private String relaNo;
    /** 企业运单编号 */
    private String waybillNo;
    /** 提单号 */
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
    /** 放行 */
    private Integer release;
    /** 国检 */
    private Integer nationalInspection;
    /** 海关 */
    private Integer customs;
    /** 联合 */
    private Integer unity;
    /** 异常 */
    private Integer odd;
    /** 无数据 */
    private Integer nodata;
    /** 票数 */
    private Integer billNo;
    /** 备注 */
    private String cleanRemark;
    /** 邮编 */
    private String zipCode;
    /** 公司ID */
    private Long corpId;
    /** 清关口岸ID */
    private Long portId;
    /** 快递公司 */
    private String expressCompany;
    /** 创建时间 */
    private Date createTime;
    /** 操作用户 */
    private Integer userId;
    /** 客户ID */
    private Integer customerId;
    /** 集包地名称 */
    private String packageCenterName;
    /** 打印状态 */
    private Integer printStatus;
    /** 打板状态:1未打板,2打板 */
    private Integer boardStatus;
    /** 初始化时间 */
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
     * 设置：总运单号
     */
    public void setTotalWaybillNo(String totalWaybillNo) {
        this.totalWaybillNo = totalWaybillNo;
    }
    /**
     * 获取：总运单号
     */
    public String getTotalWaybillNo() {
        return totalWaybillNo;
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
     * 设置：企业运单编号
     */
    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }
    /**
     * 获取：企业运单编号
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
     * 设置：放行
     */
    public void setRelease(Integer release) {
        this.release = release;
    }
    /**
     * 获取：放行
     */
    public Integer getRelease() {
        return release;
    }
    /**
     * 设置：国检
     */
    public void setNationalInspection(Integer nationalInspection) {
        this.nationalInspection = nationalInspection;
    }
    /**
     * 获取：国检
     */
    public Integer getNationalInspection() {
        return nationalInspection;
    }
    /**
     * 设置：海关
     */
    public void setCustoms(Integer customs) {
        this.customs = customs;
    }
    /**
     * 获取：海关
     */
    public Integer getCustoms() {
        return customs;
    }
    /**
     * 设置：联合
     */
    public void setUnity(Integer unity) {
        this.unity = unity;
    }
    /**
     * 获取：联合
     */
    public Integer getUnity() {
        return unity;
    }
    /**
     * 设置：异常
     */
    public void setOdd(Integer odd) {
        this.odd = odd;
    }
    /**
     * 获取：异常
     */
    public Integer getOdd() {
        return odd;
    }
    /**
     * 设置：无数据
     */
    public void setNodata(Integer nodata) {
        this.nodata = nodata;
    }
    /**
     * 获取：无数据
     */
    public Integer getNodata() {
        return nodata;
    }
    /**
     * 设置：票数
     */
    public void setBillNo(Integer billNo) {
        this.billNo = billNo;
    }
    /**
     * 获取：票数
     */
    public Integer getBillNo() {
        return billNo;
    }
    /**
     * 设置：备注
     */
    public void setCleanRemark(String cleanRemark) {
        this.cleanRemark = cleanRemark;
    }
    /**
     * 获取：备注
     */
    public String getCleanRemark() {
        return cleanRemark;
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
    /**
     * 设置：快递公司
     */
    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }
    /**
     * 获取：快递公司
     */
    public String getExpressCompany() {
        return expressCompany;
    }
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
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    /**
     * 获取：操作用户
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置：客户ID
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    /**
     * 获取：客户ID
     */
    public Integer getCustomerId() {
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
    /**
     * 设置：初始化时间
     */
    public void setIndate(Date indate) {
        this.indate = indate;
    }
    /**
     * 获取：初始化时间
     */
    public Date getIndate() {
        return indate;
    }
}
