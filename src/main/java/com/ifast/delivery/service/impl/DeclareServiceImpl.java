package com.ifast.delivery.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.ifast.delivery.domain.ProductDO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.ifast.delivery.dao.DeclareDao;
import com.ifast.delivery.domain.DeclareDO;
import com.ifast.delivery.service.DeclareService;
import com.ifast.common.base.CoreServiceImpl;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 
 * <pre>
 * 快件运单
 * </pre>
 * <small> 2018-12-10 17:07:11 | Aron</small>
 */
@Service
public class DeclareServiceImpl extends CoreServiceImpl<DeclareDao, DeclareDO> implements DeclareService {
    @Override
    public List<DeclareDO> importExcel(MultipartFile file, Integer titleRows, Integer headerRows) {
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<DeclareDO> list ;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), DeclareDO.class, params);

            return list;

        }catch (NoSuchElementException e){
            throw new NoSuchElementException("excel文件不能为空");
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }

    }

    @Override
    public Workbook exportProduct(List<DeclareDO> plist) {
        List<DeclareDO> list = baseMapper.exportProduct(plist);
        return  ExcelExportUtil.exportExcel(new ExportParams("匹配成功数据","数据结果"), DeclareDO.class,list);
    }
}
