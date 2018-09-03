package com.ifast.customerService.service;

import com.ifast.common.base.CoreService;
import com.ifast.customerService.domain.ExpressOrderDO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExpressOrderService extends CoreService<ExpressOrderDO> {

    List<ExpressOrderDO> importExcel(MultipartFile file, Integer titleRows, Integer headerRows);
}
