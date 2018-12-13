package com.ifast.expressOrder.service;

import com.ifast.expressOrder.domain.DataComparisonDO;
import com.ifast.common.base.CoreService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * <pre>
 * 数据对比
 * </pre>
 * <small> 2018-10-31 10:32:38 | Aron</small>
 */
public interface DataComparisonService extends CoreService<DataComparisonDO> {
    void importExcel(MultipartFile file, Integer titleRows, Integer headerRows);
}
