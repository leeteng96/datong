package com.ifast.expressOrder.service;

import com.ifast.common.domain.Tree;
import com.ifast.expressOrder.domain.WorkOrderDO;
import com.ifast.common.base.CoreService;
import org.apache.poi.ss.formula.functions.T;

/**
 * 
 * <pre>
 * 工单表
 * </pre>
 * <small> 2018-08-17 17:38:39 | Aron</small>
 */
public interface WorkOrderService extends CoreService<WorkOrderDO> {

    Tree<T> getTree();
}
