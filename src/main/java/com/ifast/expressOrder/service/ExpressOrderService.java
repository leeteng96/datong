package com.ifast.expressOrder.service;

import com.ifast.common.base.CoreService;
import com.ifast.expressOrder.domain.ExpressOrderDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExpressOrderService extends CoreService<ExpressOrderDO> {

    List<ExpressOrderDO> importExcel(MultipartFile file, Integer titleRows, Integer headerRows,Long userId);



}