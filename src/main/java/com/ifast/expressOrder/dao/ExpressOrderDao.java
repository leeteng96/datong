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

    @Select("select  tb.ladingNo as 'ladingBillNo',count(tp.id) as 'id', tb.Unlisted as 'printStatus',tb.Listed as 'boardStatus'" +
            " from tb_pack_info tp inner join" +
            "  (select count(DISTINCT lading_bill_no) as ladingNo, sum( case" +
            "  when clean_date is null then 1" +
            "  else 0 end )as Unlisted," +
            "  sum( case" +
            "  when clean_date is not null then 1" +
            "  else 0 end )as Listed,lading_bill_no from tb_express_order where  logistics_type =#{logistics_type} and month(indate) = Month(curdate())) tb on tp.lading_bill_no = tb.lading_bill_no ")
    ExpressOrderDO selectData(Integer logisticsType);
}
