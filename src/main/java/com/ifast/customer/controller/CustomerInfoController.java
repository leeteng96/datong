package com.ifast.customer.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.base.AdminBaseController;
import com.ifast.common.utils.Result;
import com.ifast.customer.domain.CustomerInfoDO;
import com.ifast.customer.service.CustomerInfoService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 
 * <pre>
 * 客户信息
 * </pre>
 * <small> 2018-08-07 14:36:07 | Aron</small>
 */
@Controller
@RequestMapping("/common/customerInfo")
public class CustomerInfoController extends AdminBaseController {

	String prefix = "common/customerInfo";

	@Autowired
	private CustomerInfoService customerInfoService;
	
	@GetMapping()
	String CustomerInfo(){
	    return prefix+"/customerInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public Result<Page<CustomerInfoDO>> list(CustomerInfoDO customerInfoDTO){
        Wrapper<CustomerInfoDO> wrapper = new EntityWrapper<CustomerInfoDO>(customerInfoDTO);
		wrapper.orderBy("id",false);
        Page<CustomerInfoDO> page = customerInfoService.selectPage(getPage(CustomerInfoDO.class), wrapper);
        return Result.ok(page);
	}
	
	@GetMapping("/add")
	String add(){
	    return "common/customerInfo/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") String id,Model model){
		CustomerInfoDO customerInfo = customerInfoService.selectById(id);
		model.addAttribute("customerInfo", customerInfo);
	    return prefix+"/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public Result<String> save( CustomerInfoDO customerInfo){
		customerInfoService.insertCustomer(customerInfo);
		customerInfoService.relationCustomer(getUserId(),customerInfo.getId());
        return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result<String>  update( CustomerInfoDO customerInfo){
		customerInfoService.updateById(customerInfo);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public Result<String>  remove( Long id){
		customerInfoService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public Result<String>  remove(@RequestParam("ids[]") String[] ids){
		customerInfoService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}
	
}
