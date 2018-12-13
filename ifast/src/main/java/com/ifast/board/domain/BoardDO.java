package com.ifast.board.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * 
 * <pre>
 * 打板表
 * </pre>
 * <small> 2018-08-10 09:09:03 | Aron</small>
 */
 @TableName("tb_board")
public class BoardDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /** 快递单号 */
    @TableId
    private String waybillNo;
    /** 板号 */
    private String boardId;
    /** 航空提单号 */
    private String ladingBillNo;

    /**
     * 设置：快递单号
     */
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
     * 设置：板号
     */
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
    /**
     * 获取：板号
     */
    public String getBoardId() {
        return boardId;
    }
    /**
     * 设置：航空提单号
     */
    public void setLadingBillNo(String ladingBillNo) {
        this.ladingBillNo = ladingBillNo;
    }
    /**
     * 获取：航空提单号
     */
    public String getLadingBillNo() {
        return ladingBillNo;
    }

    @Override
    public String toString() {
        return "BoardDO{" +
                "waybillNo='" + waybillNo + '\'' +
                ", boardId='" + boardId + '\'' +
                ", ladingBillNo='" + ladingBillNo + '\'' +
                '}';
    }
}
