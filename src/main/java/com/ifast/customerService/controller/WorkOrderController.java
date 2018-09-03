package com.ifast.customerService.controller;


import java.util.Arrays;

import com.ifast.common.annotation.Log;
import com.ifast.common.domain.Tree;
import com.ifast.sys.domain.DeptDO;
import com.ifast.sys.domain.UserDO;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.base.AdminBaseController;
import com.ifast.customerService.domain.WorkOrderDO;
import com.ifast.customerService.service.WorkOrderService;
import com.ifast.common.utils.Result;

/**
 * 
 * <pre>
 * 工单信息
 * </pre>
 * <small> 2018-08-17 17:38:39 | Aron</small>
 */
@Controller
@RequestMapping("/common/workOrder")
public class WorkOrderController extends AdminBaseController {
	@Autowired
	private WorkOrderService workOrderService;
	
	@GetMapping()
	@RequiresPermissions("common:workOrder:workOrder")
	String WorkOrder(){
	    return "common/workOrder/workOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:workOrder:workOrder")
	public Result<Page<WorkOrderDO>> list(WorkOrderDO workOrderDTO){
        Wrapper<WorkOrderDO> wrapper = new EntityWrapper<WorkOrderDO>(workOrderDTO);
		wrapper.orderBy("id",false);
        Page<WorkOrderDO> page = workOrderService.selectPage(getPage(WorkOrderDO.class), wrapper);
        return Result.ok(page);
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:workOrder:add")
	String add(){
	    return "common/workOrder/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:workOrder:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WorkOrderDO workOrder = workOrderService.selectById(id);
		model.addAttribute("workOrder", workOrder);
	    return "common/workOrder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:workOrder:add")
	public Result<String> save( WorkOrderDO workOrder){
		workOrderService.insert(workOrder);
        return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:workOrder:edit")
	public Result<String>  update( WorkOrderDO workOrder){
		workOrderService.updateById(workOrder);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:workOrder:remove")
	public Result<String>  remove( Integer id){
		workOrderService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:workOrder:batchRemove")
	public Result<String>  remove(@RequestParam("ids[]") Integer[] ids){
		workOrderService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}
	@Log("查询菜单树形数据")
	@GetMapping("/tree")
	@ResponseBody
	Tree<T> tree() {
		Tree<T> tree = new Tree<T>();
		tree = workOrderService.getTree();
		return tree;
	}
	
}
