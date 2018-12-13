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
 * 商品表
 * </pre>
 * <small> 2018-11-22 17:42:43 | Aron</small>
 */
@TableName("tb_product")
public class ProductDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /** 商品id */
    @TableId
    private Long id;
    /** 商品名称 */
    @Excel(name="商品名称")
    private String name;
    /** 商品编码 */
    @Excel(name="税号")
    private String code;
    /** 原产国 */
    @Excel(name="原产国")
    private String originCountry;
    /** 商品价格 */
    @Excel(name="商品价格")
    private BigDecimal price;
    /** 商品重量 */
    @Excel(name="商品重量")
    private BigDecimal weight;
    /** 商品规格 */
    @Excel(name="商品规格")
    private String model;
    /** 商品颜色 */
    private String color;
    /** 生产日期 */

    private Date produceDate;
    /** 有效期 */
    private Date shelfLife;
    /** 商品录入时间 */
    private Date indate;
    /** 第一单位 */
    @Excel(name="第一单位")
    private String unit1;
    /** 第一数量 */
    @Excel(name="第一数量")
    private Integer qty1;
    /** 第二单位 */
    @Excel(name="第二单位")
    private String unit2;
    /** 第二数量 */
    @Excel(name="第二数量")
    private Integer qty2;
    /** 净重 */
    @Excel(name="净重")
    private BigDecimal netwt;

    /**
     * 设置：商品id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：商品id
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：商品名称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：商品名称
     */
    public String getName() {
        return name;
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
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    /**
     * 获取：商品价格
     */
    public BigDecimal getPrice() {
        return price;
    }
    /**
     * 设置：商品重量
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    /**
     * 获取：商品重量
     */
    public BigDecimal getWeight() {
        return weight;
    }
    /**
     * 设置：商品规格
     */
    public void setModel(String model) {
        this.model = model;
    }
    /**
     * 获取：商品规格
     */
    public String getModel() {
        return model;
    }
    /**
     * 设置：商品颜色
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * 获取：商品颜色
     */
    public String getColor() {
        return color;
    }
    /**
     * 设置：生产日期
     */
    public void setproduceDate(Date producedate) {
        this.produceDate = producedate;
    }
    /**
     * 获取：生产日期
     */
    public Date getproduceDate() {
        return produceDate;
    }
    /**
     * 设置：有效期
     */
    public void setShelfLife(Date shelfLife) {
        this.shelfLife = shelfLife;
    }
    /**
     * 获取：有效期
     */
    public Date getShelfLife() {
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
    /**
     * 设置：第一单位
     */
    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }
    /**
     * 获取：第一单位
     */
    public String getUnit1() {
        return unit1;
    }
    /**
     * 设置：第一数量
     */
    public void setQty1(Integer qty1) {
        this.qty1 = qty1;
    }
    /**
     * 获取：第一数量
     */
    public Integer getQty1() {
        return qty1;
    }
    /**
     * 设置：第二单位
     */
    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }
    /**
     * 获取：第二单位
     */
    public String getUnit2() {
        return unit2;
    }
    /**
     * 设置：第二数量
     */
    public void setQty2(Integer qty2) {
        this.qty2 = qty2;
    }
    /**
     * 获取：第二数量
     */
    public Integer getQty2() {
        return qty2;
    }

    /**
     * 设置：净重
     */
    public void setNetwt(BigDecimal netwt) {
        this.netwt = netwt;
    }
    /**
     * 获取：净重
     */
    public BigDecimal getNetwt() {
        return netwt;
    }
}
