package com.ifast.customer.service;

import com.ifast.common.base.CoreService;
import com.ifast.common.domain.Tree;
import com.ifast.customer.domain.CustomerInfoDO;

/**
 * 
 * <pre>
 * 客户信息
 * </pre>
 * <small> 2018-08-07 14:36:07 | Aron</small>
 */
public interface CustomerInfoService extends CoreService<CustomerInfoDO> {
    /*
     **客户信息与用户关联
     */

    boolean relationCustomer(Long userId,Long customerId);

    boolean insertCustomer(CustomerInfoDO customerInfoDO);

    Tree<CustomerInfoDO> getTree();

}
