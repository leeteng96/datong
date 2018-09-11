package com.ifast.cs.dao;

import com.ifast.cs.domain.WorkOrderDO;
import com.ifast.common.base.BaseDao;
import com.ifast.sys.domain.DeptDO;
import com.ifast.sys.domain.UserDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * <pre>
 * 工单表
 * </pre>
 * <small> 2018-08-17 17:38:39 | Aron</small>
 */
public interface WorkOrderDao extends BaseDao<WorkOrderDO> {

    @Select("select * from sys_user where dept_id=#{id}")
    List<UserDO> selectUser(Long id);
    @Select("select * from sys_dept")
    List<DeptDO> selectDept();
}
