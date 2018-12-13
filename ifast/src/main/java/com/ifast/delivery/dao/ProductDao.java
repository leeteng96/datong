package com.ifast.delivery.dao;

import com.ifast.common.base.BaseDao;
import com.ifast.delivery.domain.ProductDO;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * <pre>
 * 商品表
 * </pre>
 * <small> 2018-07-06 15:41:06 | Aron</small>
 */
public interface ProductDao extends BaseDao<ProductDO> {

    List<ProductDO> listMenuByUserId(Long id);
    List<Long> listMenuIdByRoleId(Serializable roleId);

    List<ProductDO> exportProduct(List<ProductDO> list);
}
