package com.ifast.expressOrder.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.expressOrder.domain.CheckOrderDO;
import com.ifast.common.base.CoreService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 
 * <pre>
 * 待检测清单
 * </pre>
 * <small> 2018-11-01 16:24:23 | Aron</small>
 */
public interface CheckOrderService extends CoreService<CheckOrderDO> {
    void importExcel(MultipartFile file, Integer titleRows, Integer headerRows);

    Page<CheckOrderDO> comparisonData(Page<CheckOrderDO> page, String state);

    Workbook    exportExcel();
}
