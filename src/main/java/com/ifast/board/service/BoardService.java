package com.ifast.board.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.board.domain.BoardDO;
import com.ifast.common.base.CoreService;
import com.ifast.delivery.domain.ExpressDeliveryDO;

/**
 * 
 * <pre>
 * 打板表
 * </pre>
 * <small> 2018-08-10 09:09:03 | Aron</small>
 */
public interface BoardService extends CoreService<BoardDO> {

    boolean  createLadingBill(String [] boardId,String ladingBillNo);

    boolean insertBatch(String [] waybillNos, String boardId);



    boolean updateBoard(String [] waybillNo);
}
