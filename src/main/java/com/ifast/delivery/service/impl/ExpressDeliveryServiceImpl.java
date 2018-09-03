package com.ifast.delivery.service.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ifast.board.domain.BoardDO;
import com.ifast.delivery.dao.ExpressDeliveryDao;
import com.ifast.delivery.domain.ExpressDeliveryDO;
import com.ifast.delivery.service.ExpressDeliveryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * <pre>
 * 揽收快件
 * </pre>
 * <small> 2018-07-02 18:34:07 | Aron</small>
 */
@Service
public class ExpressDeliveryServiceImpl extends ServiceImpl<ExpressDeliveryDao,ExpressDeliveryDO>  implements ExpressDeliveryService {


    @Override
    public boolean saveExpressDelivery(ExpressDeliveryDO ed) {
        if(StringUtils.isBlank(ed.getProductId())){
            ed.setProductId(null);
            baseMapper.saveExpressDelivery(ed);
        }else {
            //解析productId
            String str[] = ed.getProductId().toString().split(",");
            for (int i = 0; i < str.length; i++) {
                if (str[i].charAt(0) != '-') {
                    ed.setProductId((str[i]));
                    baseMapper.saveExpressDelivery(ed);
                }
            }

        }
        return true;
    }

   @Override
    public boolean updatePId(String productId) {
       ExpressDeliveryDO edd = new ExpressDeliveryDO();
       edd.setId(baseMapper.selectMaxId());
       //判断ProductId是否已经存在
       String oldProductId = baseMapper.selectProductId(edd.getId());
       if (StringUtils.isBlank(oldProductId)) {
           edd.setProductId(productId);
           baseMapper.updateById(edd);
           return true;
       } else if (oldProductId.contains(productId)) {
           return true;
       }else{
           String productList = oldProductId+","+productId;
           edd.setProductId(productList);
           baseMapper.updateById(edd);
           return true;
       }

   }


}
