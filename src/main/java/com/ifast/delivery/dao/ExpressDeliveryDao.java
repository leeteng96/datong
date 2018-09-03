package com.ifast.delivery.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ifast.delivery.domain.ExpressDeliveryDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 
 * <pre>
 * 揽收快件
 * </pre>
 * <small> 2018-07-02 18:34:07 | Aron</small>
 */
public interface ExpressDeliveryDao extends BaseMapper<ExpressDeliveryDO> {
    @Select("select p.*, ed.* from  tb_Product p ,tb_express_delivery ed where p.product_id = ed.product_id")
    @Results({
           @Result(property = "products" , column = "product_id",
           many = @Many(select = "com.ifast.delivery.dao.ProductDao.selectById")
           )
    })
    List<ExpressDeliveryDO> getExpressDeliverys();

    @Insert("insert into tb_express_delivery values (0,#{orderNo},#{receiverAddress},#{receiver},#{receiverCtype},#{receiverIdcard},#{senderAddress}," +
            "#{sender},#{senderCtype},#{senderIdcard},#{productId},#{data},#{weight})")
    @Options(useGeneratedKeys = true ,keyProperty = "id",keyColumn = "id")
    boolean saveExpressDelivery(ExpressDeliveryDO edd);

    @Select("select max(id) from tb_express_delivery")
    Long selectMaxId();


    @Select("select product_id from tb_express_delivery where id = #{id}")
    String selectProductId(Long id);

    @Select("select * from tb_express_order")
    List<ExpressDeliveryDO> selectExpress();

}
