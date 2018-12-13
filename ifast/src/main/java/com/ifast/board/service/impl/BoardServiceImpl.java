package com.ifast.board.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.board.dao.BoardDao;
import com.ifast.board.domain.BoardDO;
import com.ifast.board.service.BoardService;
import com.ifast.delivery.domain.ExpressDeliveryDO;
import com.ifast.sys.domain.RoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifast.common.base.CoreServiceImpl;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * <pre>
 * 打板表
 * </pre>
 * <small> 2018-08-10 09:09:03 | Aron</small>
 */
@Service
public class BoardServiceImpl extends CoreServiceImpl<BoardDao, BoardDO> implements BoardService {

    @Autowired
    private BoardDao baseMapper;

    @Override
    public boolean createLadingBill(String[] boardId, String ladingBillNo) {
        List list = new ArrayList();
        for (int i = 0; i < boardId.length; i++) {
                list.add(boardId[i]);
        }
        baseMapper.updateLadingBill(list,ladingBillNo);
        return true;
    }

    @Override
    public boolean insertBatch(String[] waybillNo, String boardId) {

        List<String> wlist = new ArrayList<>();
        List<String> strlist = new ArrayList<>();
        //查询数据库waybillNo 是否与新增waybillNo重复 并剔除重复元素
        for (int i = 0; i < waybillNo.length; i++) {
            wlist.add(waybillNo[i]);
            List<BoardDO> blist = baseMapper.selectBatchIds(wlist);
            for (int j = 0; j < blist.size(); j++) {
                strlist.add(blist.get(j).getWaybillNo());
            }
            wlist.removeAll(strlist);
        }

        for (int i = 0; i < wlist.size(); i++) {
            baseMapper.insertBorad(wlist.get(i),boardId);
        }
        updateBoard(waybillNo);
        return true;
    }



    @Override
    public boolean updateBoard(String[] waybillNo) {
        baseMapper.updateBoardStatus(waybillNo);
        return true;
    }


}
