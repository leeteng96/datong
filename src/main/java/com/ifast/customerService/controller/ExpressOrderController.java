package com.ifast.customerService.controller;


import java.io.IOException;
import java.util.Arrays;

import com.ifast.common.domain.Message;
import com.ifast.common.domain.Status;
import com.ifast.customerService.domain.ExpressOrderDO;
import com.ifast.customerService.service.ExpressOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.base.AdminBaseController;
import com.ifast.common.utils.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * <pre>
 * 快递订单
 * </pre>
 * <small> 2018-08-28 15:04:45 | Aron</small>
 */
@Controller
@RequestMapping("/common/expressOrder")
public class ExpressOrderController extends AdminBaseController {
	@Autowired
	private ExpressOrderService expressOrderService;
	
	@GetMapping()
	@RequiresPermissions("common:expressOrder:expressOrder")
	String ExpressOrder(){
	    return "common/expressOrder/expressOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:expressOrder:expressOrder")
	public Result<Page<ExpressOrderDO>> list(ExpressOrderDO expressOrderDTO){
        Wrapper<ExpressOrderDO> wrapper = new EntityWrapper<ExpressOrderDO>(expressOrderDTO);
        wrapper.orderBy("id",false);
        Page<ExpressOrderDO> page = expressOrderService.selectPage(getPage(ExpressOrderDO.class), wrapper);
        return Result.ok(page);
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:expressOrder:add")
	String add(){
	    return "common/expressOrder/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:expressOrder:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ExpressOrderDO expressOrder = expressOrderService.selectById(id);
		model.addAttribute("expressOrder", expressOrder);
	    return "common/expressOrder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:expressOrder:add")
	public Result<String> save( ExpressOrderDO expressOrder){
		expressOrderService.insert(expressOrder);
        return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:expressOrder:edit")
	public Result<String>  update( ExpressOrderDO expressOrder){
		expressOrderService.updateById(expressOrder);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:expressOrder:remove")
	public Result<String>  remove( Long id){
		expressOrderService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:expressOrder:batchRemove")
	public Result<String>  remove(@RequestParam("ids[]") Long[] ids){
		expressOrderService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}

	@RequestMapping(value = "/importExcel", method = RequestMethod.POST, produces = "application/json;charset=utf8")
	@ResponseBody
	public Message uploadFileHandler(@RequestParam("file") MultipartFile file) throws IOException {
		if(!file.isEmpty()){
			String fileName = file.getOriginalFilename();
			Message msg = new Message();
			if("xls".equals(fileName.split("\\.")[1]) || "xlsx".equals(fileName.split("\\.")[1])){

				try {
					expressOrderService.importExcel(file,1,1);
					msg.setStatus(Status.SUCCESS);
					msg.setStatusMsg("File upload success");
					return msg;
				} catch (Exception e) {
					msg.setStatus(Status.ERROR);
					msg.setError("File upload file");
					return msg;
				}
			}else {
				msg.setStatus(Status.ERROR);
				msg.setError("请选择xls或xlsx格式文件!");
				return msg;
			}


		}else {
			Message msg = new Message();
			msg.setStatus(Status.ERROR);
			msg.setError("File is empty");
			return msg;
		}





	}
}
