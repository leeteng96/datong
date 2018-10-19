package com.ifast.expressOrder.dao;

import com.ifast.common.base.BaseDao;
import com.ifast.expressOrder.domain.ExpressOrderDO;
import org.apache.ibatis.annotations.Select;

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

    @Select("select count(DISTINCT lading_bill_no) as 'ladingBillNo',count(id) as 'id',sum( case  when  clean_date is null then 1  else 0 end ) as 'printStatus'," +
            "  sum( case when  clean_date is not null then 1" +
            "  else 0 end )as 'boardStatus' from tb_express_order" +
            " where  month(indate) = Month(curdate()) and (datediff(date_format(now(),'%y-%m-%d %h'), turnup_date)>=2 and logistics_type =1" +
            "  or  datediff(date_format(now(),'%y-%m-%d %h'), turnup_date)>=3 and logistics_type =2) and logistics_type =#{logistics_type}")
    ExpressOrderDO selectData(Integer logisticsType);
}
