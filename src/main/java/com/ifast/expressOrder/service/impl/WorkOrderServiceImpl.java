package com.ifast.expressOrder.service.impl;

import com.ifast.common.base.CoreServiceImpl;
import com.ifast.common.domain.Tree;
import com.ifast.common.utils.BuildTree;
import com.ifast.expressOrder.dao.WorkOrderDao;
import com.ifast.expressOrder.domain.WorkOrderDO;
import com.ifast.expressOrder.service.WorkOrderService;
import com.ifast.sys.domain.DeptDO;
import com.ifast.sys.domain.UserDO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
 * 工单表
 * </pre>
 * <small> 2018-08-17 17:38:39 | Aron</small>
 */
@Service
public class WorkOrderServiceImpl extends CoreServiceImpl<WorkOrderDao, WorkOrderDO> implements WorkOrderService {

    @Autowired
    WorkOrderDao baseMapper;

    public Tree<T> getTree() {
        List<Tree<T>> trees = new ArrayList<>();
        List<DeptDO> depts = baseMapper.selectDept();
        for (DeptDO sysDept:
                depts) {
            Tree<T> tree = new Tree<T>();
            tree.setId(String.valueOf(sysDept.getId()));
            tree.setText(sysDept.getName());
            tree.setParentId("0");

            List<Tree<T>> utrees = new ArrayList<>();
            List<UserDO> users = baseMapper.selectUser(sysDept.getId());
            for (UserDO sysUser: users) {
                Tree<T> utree = new Tree<T>();
                utree.setId(String.valueOf(sysUser.getId()));
                utree.setText(sysUser.getName());
                utrees.add(utree);
                Tree<T> t = BuildTree.build(utrees, "");
            }
            tree.setChildren(utrees);
            trees.add(tree);

        }

        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<T> t = BuildTree.build(trees, "选择用户");
        return t;
    }
}
