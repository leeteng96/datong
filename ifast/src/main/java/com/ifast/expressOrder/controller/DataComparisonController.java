package com.ifast.expressOrder.controller;


import java.util.Arrays;

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
import com.ifast.expressOrder.domain.DataComparisonDO;
import com.ifast.expressOrder.service.DataComparisonService;
import com.ifast.common.utils.Result;

/**
 * 
 * <pre>
 * 数据对比
 * </pre>
 * <small> 2018-10-31 10:32:38 | Aron</small>
 */
@Controller
@RequestMapping("/common/dataComparison")
public class DataComparisonController extends AdminBaseController {
	@Autowired
	private DataComparisonService dataComparisonService;
	
	@GetMapping()
	String DataComparison(){
	    return "common/dataComparison/dataComparison";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public Result<Page<DataComparisonDO>> list(DataComparisonDO dataComparisonDTO){
        Wrapper<DataComparisonDO> wrapper = new EntityWrapper<DataComparisonDO>(dataComparisonDTO);
        wrapper.orderBy("id",false);
        Page<DataComparisonDO> page = dataComparisonService.selectPage(getPage(DataComparisonDO.class), wrapper);
        return Result.ok(page);
	}
	
	@GetMapping("/add")
	String add(){
	    return "common/dataComparison/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		DataComparisonDO dataComparison = dataComparisonService.selectById(id);
		model.addAttribute("dataComparison", dataComparison);
	    return "common/dataComparison/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public Result<String> save( DataComparisonDO dataComparison){
		dataComparisonService.insert(dataComparison);
        return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result<String>  update( DataComparisonDO dataComparison){
		dataComparisonService.updateById(dataComparison);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public Result<String>  remove( Integer id){
		dataComparisonService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public Result<String>  remove(@RequestParam("ids[]") Integer[] ids){
		dataComparisonService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}
	
}
