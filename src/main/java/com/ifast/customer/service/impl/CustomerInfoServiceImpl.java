package com.ifast.customer.service.impl;

import com.ifast.customer.dao.CustomerInfoDao;
import com.ifast.customer.domain.CustomerInfoDO;
import com.ifast.customer.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifast.common.base.CoreServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <pre>
 * 客户信息
 * </pre>
 * <small> 2018-08-07 14:36:07 | Aron</small>
 */
@Service
public class CustomerInfoServiceImpl extends CoreServiceImpl<CustomerInfoDao, CustomerInfoDO> implements CustomerInfoService {

    @Autowired
    private CustomerInfoDao baseMapper;

    @Override
    public boolean relationCustomer(Long userId,Long customerId) {
        baseMapper.insertCustomer(userId,customerId);
        return true;
    }

    @Override
    public boolean insertCustomer(CustomerInfoDO customerInfoDO) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Date = df.format(new Date());
        try {
            customerInfoDO.setIndate(df.parse(Date));
            baseMapper.insert(customerInfoDO);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

    }
}
