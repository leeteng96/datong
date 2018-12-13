package com.ifast.expressOrder.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.base.CoreServiceImpl;
import com.ifast.expressOrder.dao.CheckOrderDao;
import com.ifast.expressOrder.domain.CheckOrderDO;
import com.ifast.expressOrder.service.CheckOrderService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 
 * <pre>
 * 待检测清单
 * </pre>
 * <small> 2018-11-01 16:24:23 | Aron</small>
 */
@Service
public class CheckOrderServiceImpl extends CoreServiceImpl<CheckOrderDao, CheckOrderDO> implements CheckOrderService {


    @Override
    public void importExcel(MultipartFile file, Integer titleRows, Integer headerRows) {
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        params.setStartSheetIndex(1);
        List<CheckOrderDO> list ;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), CheckOrderDO.class, params);
            baseMapper.addData(list);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("excel文件不能为空");
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }

    }

    @Override
    public Page<CheckOrderDO> comparisonData(Page<CheckOrderDO> page, String state) {

        return page.setRecords(baseMapper.comparisonData(page,state));
    }

    @Override
    public Workbook exportExcel() {
        List<CheckOrderDO> list= baseMapper.comparisonData();
        return ExcelExportUtil.exportExcel(new ExportParams("非我司运单数据","剔除单"),CheckOrderDO.class,baseMapper.comparisonData());
    }


}
