package com.ifast.delivery.dao;

import com.ifast.common.base.BaseDao;
import com.ifast.delivery.domain.DeclareDO;

import java.util.List;

/**
 * 
 * <pre>
 * 快件运单
 * </pre>
 * <small> 2018-12-10 17:07:11 | Aron</small>
 */
public interface DeclareDao extends BaseDao<DeclareDO> {
    List<DeclareDO> exportProduct(List<DeclareDO> list);
}
