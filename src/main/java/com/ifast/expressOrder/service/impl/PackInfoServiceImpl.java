package com.ifast.expressOrder.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.springframework.stereotype.Service;

import com.ifast.expressOrder.dao.PackInfoDao;
import com.ifast.expressOrder.domain.PackInfoDO;
import com.ifast.expressOrder.service.PackInfoService;
import com.ifast.common.base.CoreServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 
 * <pre>
 * 包裹信息
 * </pre>
 * <small> 2018-10-18 15:04:33 | Aron</small>
 */
@Service
public class PackInfoServiceImpl extends CoreServiceImpl<PackInfoDao, PackInfoDO> implements PackInfoService {

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Long userId){
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<PackInfoDO> list ;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), PackInfoDO.class, params);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setIndate(indate());

            }
            baseMapper.addPackInfo(list);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("excel文件不能为空");
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }

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
}
