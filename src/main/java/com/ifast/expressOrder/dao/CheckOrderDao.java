package com.ifast.expressOrder.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.ifast.expressOrder.domain.CheckOrderDO;
import com.ifast.common.base.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * 
 * <pre>
 * 待检测清单
 * </pre>
 * <small> 2018-11- 16:24:23 | Aron</s01mall>
 */
public interface CheckOrderDao extends BaseDao<CheckOrderDO> {

    String sql = "select t1.*,t2.lading_bill_no from tb_check_order t1  left join tb_pack_info t2 on  t1.waybill_no = t2.waybill_no " +
            " where  str_to_date(receiver_date,'%Y%m%d') between date_sub(curdate(), interval 3 month)  and curdate()";

    void addData(@Param("cos") List<CheckOrderDO> cos);

    @Select(sql)
    List<CheckOrderDO> comparisonData(Pagination page, String state);

    @Select(sql)
    List<CheckOrderDO> comparisonData();
}
