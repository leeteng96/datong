package com.ifast.customerService.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.ifast.common.base.CoreServiceImpl;
import com.ifast.customerService.dao.ExpressOrderDao;
import com.ifast.customerService.domain.ExpressOrderDO;
import com.ifast.customerService.service.ExpressOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@Transactional(readOnly = true)
@Service
public class ExpressOrderServiceImpl extends CoreServiceImpl<ExpressOrderDao,ExpressOrderDO> implements ExpressOrderService {


    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public List<ExpressOrderDO> importExcel(MultipartFile file, Integer titleRows, Integer headerRows){
        if (file == null){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<ExpressOrderDO> list ;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), ExpressOrderDO.class, params);
            for (int i = 0; i < list.size(); i++) {
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
