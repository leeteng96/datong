package com.ifast.expressOrder.service;

import com.ifast.common.base.CoreService;
import com.ifast.expressOrder.domain.ExpressOrderDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface ExpressOrderService extends CoreService<ExpressOrderDO> {

    Date indate();

    boolean changeStatus(Long id,Date cleanDate,String Remark,Integer cleanStatus);

    ExpressOrderDO selectData(Integer logisticsType);

    boolean insertExpress(ExpressOrderDO expressOrderDO);
}
