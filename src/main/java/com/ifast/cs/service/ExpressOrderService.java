package com.ifast.cs.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.base.CoreService;
import com.ifast.common.domain.Tree;
import com.ifast.common.utils.Result;
import com.ifast.cs.domain.ExpressOrderDO;
import com.ifast.customer.domain.CustomerInfoDO;
import com.ifast.sys.domain.MenuDO;
import io.swagger.models.auth.In;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExpressOrderService extends CoreService<ExpressOrderDO> {

    List<ExpressOrderDO> importExcel(MultipartFile file, Integer titleRows, Integer headerRows,Long userId);



}
