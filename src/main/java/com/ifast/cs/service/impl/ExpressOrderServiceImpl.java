package com.ifast.cs.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.base.CoreServiceImpl;
import com.ifast.common.domain.Tree;
import com.ifast.common.utils.BuildTree;
import com.ifast.common.utils.Result;
import com.ifast.cs.dao.ExpressOrderDao;
import com.ifast.cs.domain.ExpressOrderDO;
import com.ifast.cs.service.ExpressOrderService;
import com.ifast.customer.domain.CustomerInfoDO;
import com.ifast.sys.domain.MenuDO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional(readOnly = true)
@Service
public class ExpressOrderServiceImpl extends CoreServiceImpl<ExpressOrderDao,ExpressOrderDO> implements ExpressOrderService {


    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public List<ExpressOrderDO> importExcel(MultipartFile file, Integer titleRows, Integer headerRows,Long userId){
        if (file == null){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<ExpressOrderDO> list ;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), ExpressOrderDO.class, params);
            SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            String createTime = df.format(new Date());
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setCreateTime(df.parse(createTime));
                list.get(i).setUserId(userId);
                list.get(i).setSchedule(1);
                baseMapper.insert(list.get(i));
            }
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("excel文件不能为空");
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
        return list;
    }



}
