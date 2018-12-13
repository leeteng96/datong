package com.ifast.delivery.controller;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import com.ifast.common.annotation.Log;
import com.ifast.common.domain.Message;
import com.ifast.common.domain.Status;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.base.AdminBaseController;
import com.ifast.delivery.domain.DeclareDO;
import com.ifast.delivery.service.DeclareService;
import com.ifast.common.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <pre>
 * 申报资料
 * </pre>
 * <small> 2018-12-10 17:07:11 | Aron</small>
 */
@Controller
@RequestMapping("/common/declare")
public class DeclareController extends AdminBaseController {
	@Autowired
	private DeclareService declareService;

	List<DeclareDO> doList;
	@GetMapping()
	String Declare(){
	    return "common/declare/declare";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public Result<Page<DeclareDO>> list(DeclareDO declareDTO){
        Wrapper<DeclareDO> wrapper = new EntityWrapper<DeclareDO>(declareDTO);
        Page<DeclareDO> page = declareService.selectPage(getPage(DeclareDO.class), wrapper);
        return Result.ok(page);
	}
	
	@GetMapping("/add")
	String add(){
	    return "common/declare/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		DeclareDO declare = declareService.selectById(id);
		model.addAttribute("declare", declare);
	    return "common/declare/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public Result<String> save( DeclareDO declare){
		declareService.insert(declare);
        return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result<String>  update( DeclareDO declare){
		declareService.updateById(declare);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public Result<String>  remove( Integer id){
		declareService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public Result<String>  remove(@RequestParam("ids[]") Integer[] ids){
		declareService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}

	@Log("excel 导入")
	@RequestMapping(value = "/importExcel", method = RequestMethod.POST, produces = "application/json;charset=utf8")
	@ResponseBody
	public Message uploadFileHandler(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
		if (!file.isEmpty()) {
			doList = declareService.importExcel(file,1,1);
			Message msg = new Message();
			msg.setStatus(Status.SUCCESS);
			msg.setStatusMsg("File upload success");
			return msg;

		} else {
			Message msg = new Message();
			msg.setStatus(Status.ERROR);
			msg.setError("File is empty");
			return msg;
		}

	}

	@GetMapping("/exportDeclare")
	public void exportProduct(HttpServletResponse response){
		Workbook workbook = declareService.exportProduct(doList);
		try {
			ServletOutputStream out = response.getOutputStream();
			response.addHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode("商品信息匹配结果表","UTF-8")+".xls");
			response.setContentType("octets/stream;charset=UTF-8");
			workbook.write(out);
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
