package com.ifast.delivery.service;

import com.ifast.delivery.domain.DeclareDO;
import com.ifast.common.base.CoreService;
import com.ifast.delivery.domain.ProductDO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *
 * <pre>
 * 快件运单
 * </pre>
 * <small> 2018-12-10 17:07:11 | Aron</small>
 */
public interface DeclareService extends CoreService<DeclareDO> {
    Workbook exportProduct(List<DeclareDO> plist);

    List<DeclareDO>  importExcel(MultipartFile file, Integer titleRows, Integer headerRows);
}
