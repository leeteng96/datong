package com.ifast.expressOrder.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.ifast.expressOrder.domain.PackInfoDO;
import org.springframework.stereotype.Service;

import com.ifast.expressOrder.dao.DataComparisonDao;
import com.ifast.expressOrder.domain.DataComparisonDO;
import com.ifast.expressOrder.service.DataComparisonService;
import com.ifast.common.base.CoreServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 
 * <pre>
 * 数据对比
 * </pre>
 * <small> 2018-10-31 10:32:38 | Aron</small>
 */
@Service
public class DataComparisonServiceImpl extends CoreServiceImpl<DataComparisonDao, DataComparisonDO> implements DataComparisonService {

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void importExcel(MultipartFile file, Integer titleRows, Integer headerRows) {
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<DataComparisonDO> list ;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), DataComparisonDO.class, params);
            for (int i = 0; i < list.size(); i++) {
               baseMapper.insert(list.get(i));
            }
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("excel文件不能为空");
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }

    }
}
