package com.ifast.delivery.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ifast.common.domain.Tree;
import com.ifast.delivery.domain.ExpressDeliveryDO;
import com.ifast.delivery.domain.ProductDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 
 * <pre>
 * 揽收快件
 * </pre>
 * <small> 2018-07-02 18:34:07 | Aron</small>
 */
public interface ExpressDeliveryService extends IService<ExpressDeliveryDO> {



       boolean saveExpressDelivery(ExpressDeliveryDO edd);

       boolean updatePId(String productId);

}