package com.ifast.customer.service.impl;

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

   /* @Override
    public Tree<CustomerInfoDO> getTree(Long id) {
        // 根据roleId查询权限
        List<MenuDO> menus = baseMapper.selectList(null);
        List<Long> menuIds = roleMenuMapper.listMenuIdByRoleId(id);
        List<Long> temp = menuIds;
        for (MenuDO menu : menus) {
            if (temp.contains(menu.getParentId())) {
                menuIds.remove(menu.getParentId());
            }
        }
        List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
        List<MenuDO> menuDOs = baseMapper.selectList(null);
        for (MenuDO sysMenuDO : menuDOs) {
            Tree<MenuDO> tree = new Tree<MenuDO>();
            tree.setId(sysMenuDO.getId().toString());
            tree.setParentId(sysMenuDO.getParentId().toString());
            tree.setText(sysMenuDO.getName());
            Map<String, Object> state = new HashMap<>(16);
            Long menuId = sysMenuDO.getId();
            if (menuIds.contains(menuId)) {
                state.put("selected", true);
            } else {
                state.put("selected", false);
            }
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<MenuDO> t = BuildTree.build(trees,"顶级节点");
        return t;
    }*/
}
