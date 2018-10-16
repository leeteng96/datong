package com.ifast.expressOrder.dao;

import com.ifast.common.base.BaseDao;
import com.ifast.expressOrder.domain.ExpressOrderDO;

import java.util.List;

/**
 * 
 * <pre>
 * 快递订单
 * </pre>
 * <small> 2018-08-28 15:04:45 | Aron</small>
 */
public interface ExpressOrderDao extends BaseDao<ExpressOrderDO> {
    Integer insertBatch(List<ExpressOrderDO> list);
}
