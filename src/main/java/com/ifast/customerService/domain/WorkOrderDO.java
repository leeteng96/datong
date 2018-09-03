package com.ifast.customerService.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * 
 * <pre>
 * 工单表
 * </pre>
 * <small> 2018-08-17 17:38:39 | Aron</small>
 */
 @TableName("tb_work_order")
public class WorkOrderDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /**  */
    @TableId
    private Integer id;
    /** 主题 */
    private String title;
    /** 类型：1 丢件 */
    private Integer type;
    /** 描述 */
    private String description;
    /** 解决方案 */
    private String solution;
    /** 状态:1接收 2分配 3完结 4挂起 */
    private Integer status;
    /** 结果 */
    private String result;
    /** 指派 */
    private String assignment;

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
     * 设置：主题
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * 获取：主题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：类型：1 丢件
     */
    public void setType(Integer type) {
        this.type = type;
    }
    /**
     * 获取：类型：1 丢件
     */
    public Integer getType() {
        return type;
    }
    /**
     * 设置：描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * 获取：描述
     */
    public String getDescription() {
        return description;
    }
    /**
     * 设置：解决方案
     */
    public void setSolution(String solution) {
        this.solution = solution;
    }
    /**
     * 获取：解决方案
     */
    public String getSolution() {
        return solution;
    }
    /**
     * 设置：状态:1接收 2分配 3完结 4挂起
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    /**
     * 获取：状态:1接收 2分配 3完结 4挂起
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * 设置：结果
     */
    public void setResult(String result) {
        this.result = result;
    }
    /**
     * 获取：结果
     */
    public String getResult() {
        return result;
    }
    /**
     * 设置：指派
     */
    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
    /**
     * 获取：指派
     */
    public String getAssignment() {
        return assignment;
    }
}
