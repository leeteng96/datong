package com.ifast.customer.dao;

import com.ifast.customer.domain.CustomerDO;
import com.ifast.customer.domain.CustomerInfoDO;
import com.ifast.common.base.BaseDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 
 * <pre>
 * 客户信息
 * </pre>
 * <small> 2018-08-07 14:36:07 | Aron</small>
 */
public interface CustomerInfoDao extends BaseDao<CustomerInfoDO> {
    @Insert("insert into tb_user_customer values(0,#{userId},#{customerId})")
    boolean insertCustomer(@Param("userId") Long userId,@Param("customerId") Long customerId);
    /*@Select("select max(id) from tb_user_customer")
    Long selectMaxId();*/
}
