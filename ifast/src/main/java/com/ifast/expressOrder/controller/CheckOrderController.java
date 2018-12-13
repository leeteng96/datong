package com.ifast.expressOrder.controller;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
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
import com.ifast.expressOrder.domain.CheckOrderDO;
import com.ifast.expressOrder.service.CheckOrderService;
import com.ifast.common.utils.Result;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <pre>
 * 待检测清单
 * </pre>
 * <small> 2018-11-01 16:24:23 | Aron</small>
 */
@Controller
@RequestMapping("/common/checkOrder")
public class CheckOrderController extends AdminBaseController {
	@Autowired
	private CheckOrderService checkOrderService;

	@GetMapping()
	String CheckOrder(){
	    return "common/checkOrder/checkOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public Result<Page<CheckOrderDO>> list(CheckOrderDO checkOrderDTO){
        Wrapper<CheckOrderDO> wrapper = new EntityWrapper<CheckOrderDO>(checkOrderDTO);
        Page<CheckOrderDO> page = checkOrderService.selectPage(getPage(CheckOrderDO.class), wrapper);
        return Result.ok(page);
	}

	@GetMapping( "/comparison")
	@ResponseBody
	public Result<Page<CheckOrderDO>> comparison(CheckOrderDO checkOrderDTO){
		Page<CheckOrderDO> page = new Page(1,10);
		page = checkOrderService.comparisonData(page, "NORMAL");
		return Result.ok(page);
	}


	@GetMapping("/add")
	String add(){
	    return "common/checkOrder/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id,Model model){
		CheckOrderDO checkOrder = checkOrderService.selectById(id);
		model.addAttribute("checkOrder", checkOrder);
	    return "common/checkOrder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public Result<String> save( CheckOrderDO checkOrder){
		checkOrderService.insert(checkOrder);
        return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result<String>  update( CheckOrderDO checkOrder){
		checkOrderService.updateById(checkOrder);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public Result<String>  remove( Long id){
		checkOrderService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public Result<String>  remove(@RequestParam("ids[]") Long[] ids){
		checkOrderService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}

	@GetMapping( "/exportExcel")
	@ResponseBody
	public void  exportExcel(HttpServletResponse response){
		Workbook wb = checkOrderService.exportExcel();
		try {
			ServletOutputStream out = response.getOutputStream();
			response.addHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode("比对结果表","UTF-8")+".xls");
			response.setContentType("octets/stream;charset=UTF-8");
			wb.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
