package com.ifast.delivery.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;


/**
 *
 * <pre>
 * 商品表
 * </pre>
 * <small> 2018-07-24 15:07:42 | Aron</small>
 */
@TableName("tb_product")
public class ProductDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    @TableId
    private Long productId;
    /** 商品名称 */
    private String productName;
    /** 商品编码 */
    private String productCode;
    /** 原产国 */
    private String originCountry;
    /** 商品价格 */
    private BigDecimal productPrice;
    /** 商品重量 */
    private BigDecimal productWeight;
    /** 商品规格 */
    private String productModel;
    /** 商品颜色 */
    private String productColor;
    /** 生产日期 */
    private Date productionDate;
    /** 有效期 */
    private String shelfLife;
    /** 商品录入时间 */
    private Date indate;

    /**
     * 设置：商品ID
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    /**
     * 获取：商品ID
     */
    public Long getProductId() {
        return productId;
    }
    /**
     * 设置：商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    /**
     * 获取：商品名称
     */
    public String getProductName() {
        return productName;
    }
    /**
     * 设置：商品编码
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    /**
     * 获取：商品编码
     */
    public String getProductCode() {
        return productCode;
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
     * 设置：商品价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
    /**
     * 获取：商品价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }
    /**
     * 设置：商品重量
     */
    public void setProductWeight(BigDecimal productWeight) {
        this.productWeight = productWeight;
    }
    /**
     * 获取：商品重量
     */
    public BigDecimal getProductWeight() {
        return productWeight;
    }
    /**
     * 设置：商品规格
     */
    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }
    /**
     * 获取：商品规格
     */
    public String getProductModel() {
        return productModel;
    }
    /**
     * 设置：商品颜色
     */
    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }
/**
     * 获取：商品颜色
     */

    /**
     * 设置：生产日期
     */
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
    /**
     * 获取：生产日期
     */
    public Date getProductionDate() {
        return productionDate;
    }
    /**
     * 设置：有效期
     */
    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }
    /**
     * 获取：有效期
     */
    public String getShelfLife() {
        return shelfLife;
    }
    /**
     * 设置：商品录入时间
     */
    public void setIndate(Date indate) {
        this.indate = indate;
    }
    /**
     * 获取：商品录入时间
     */
    public Date getIndate() {
        return indate;
    }
}
