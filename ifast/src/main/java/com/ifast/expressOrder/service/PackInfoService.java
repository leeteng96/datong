package com.ifast.expressOrder.service;

import com.ifast.expressOrder.domain.PackInfoDO;
import com.ifast.common.base.CoreService;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 
 * <pre>
 * 包裹信息
 * </pre>
 * <small> 2018-10-18 15:04:33 | Aron</small>
 */
public interface PackInfoService extends CoreService<PackInfoDO> {
   void importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Long userId);

    Date indate();
}
