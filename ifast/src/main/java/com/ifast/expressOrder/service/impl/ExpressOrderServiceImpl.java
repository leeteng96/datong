package com.ifast.expressOrder.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ifast.common.base.CoreServiceImpl;
import com.ifast.expressOrder.dao.ExpressOrderDao;
import com.ifast.expressOrder.domain.ExpressOrderDO;
import com.ifast.expressOrder.service.ExpressOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ExpressOrderServiceImpl extends CoreServiceImpl<ExpressOrderDao,ExpressOrderDO> implements ExpressOrderService {




    @Override
    public boolean changeStatus(Long id,Date cleanDate,String cleanRemark,Integer cleanStatus) {
        ExpressOrderDO expressOrderDO = new ExpressOrderDO();
        expressOrderDO.setId(id);
        expressOrderDO.setCleanDate(cleanDate);
        expressOrderDO.setCleanRemark(cleanRemark);
        baseMapper.updateById(expressOrderDO);
        return true;
    }

    @Override
    public ExpressOrderDO selectData(Integer logisticsType) {
        return baseMapper.selectData(logisticsType);
    }

    @Override
    public Date indate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(df.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertExpress(ExpressOrderDO expressOrderDO) {
        expressOrderDO.setIndate(indate());
        baseMapper.insert(expressOrderDO);
        return true;
    }
}
