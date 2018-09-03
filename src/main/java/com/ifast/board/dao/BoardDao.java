package com.ifast.board.dao;

import com.ifast.board.domain.BoardDO;
import com.ifast.common.base.BaseDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * <pre>
 * 打板表
 * </pre>
 * <small> 2018-08-10 09:09:03 | Aron</small>
 */
public interface BoardDao extends BaseDao<BoardDO> {
    @Insert("insert into tb_board(waybill_no,board_id) values(#{waybillNo},#{boardId})")
    Integer insertBorad(@Param("waybillNo") String waybillNo, @Param("boardId") String boardId);

    Integer updateLadingBill(@Param("list") List<String> list,@Param("ladingBillNo") String ladingBillNo);

    Integer updateBoardStatus(String [] waybillNo);
}
