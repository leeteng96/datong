package com.ifast.expressOrder.dao;

import com.ifast.common.base.BaseDao;
import com.ifast.expressOrder.domain.PackInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * <pre>
 * 包裹信息
 * </pre>
 * <small> 2018-10-18 15:04:33 | Aron</small>
 */
public interface PackInfoDao extends BaseDao<PackInfoDO> {
    void addPackInfo(@Param("pis") List<PackInfoDO> pis);
}
