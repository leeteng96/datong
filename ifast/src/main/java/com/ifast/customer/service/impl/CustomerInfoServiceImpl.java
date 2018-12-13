package com.ifast.customer.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ifast.common.domain.Tree;
import com.ifast.common.utils.BuildTree;
import com.ifast.customer.dao.CustomerInfoDao;
import com.ifast.customer.domain.CustomerInfoDO;
import com.ifast.customer.service.CustomerInfoService;
import com.ifast.sys.domain.MenuDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifast.common.base.CoreServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Override
    public Tree<CustomerInfoDO> getTree() {
        List<Tree<CustomerInfoDO>> trees = new ArrayList<Tree<CustomerInfoDO>>();
        List<CustomerInfoDO> menuDOs = baseMapper.selectList(null);
        for (CustomerInfoDO sysMenuDO : menuDOs) {
            Tree<CustomerInfoDO> tree = new Tree<CustomerInfoDO>();
            tree.setId(sysMenuDO.getId().toString());
            tree.setText(sysMenuDO.getName());
            trees.add(tree);
        }
        Map<String, Object> state = new HashMap<>(16);
        state.put("disabled",true);
        state.put("opened",true);
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<CustomerInfoDO> t = BuildTree.buildParent(trees,"请选择客户",state);
        return t;
    }


}
