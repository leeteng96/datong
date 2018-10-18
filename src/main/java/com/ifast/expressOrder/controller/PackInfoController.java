package com.ifast.expressOrder.controller;


import java.io.IOException;
import java.util.Arrays;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.ifast.common.annotation.Log;
import com.ifast.common.domain.Message;
import com.ifast.common.domain.Status;
import com.ifast.expressOrder.domain.PackInfoDO;
import com.ifast.expressOrder.service.PackInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.base.AdminBaseController;
import com.ifast.expressOrder.domain.PackInfoDO;
import com.ifast.expressOrder.service.PackInfoService;
import com.ifast.common.utils.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * <pre>
 * 包裹信息
 * </pre>
 * <small> 2018-10-18 15:04:33 | Aron</small>
 */
@Controller
@RequestMapping("/common/packInfo")
public class PackInfoController extends AdminBaseController {
	@Autowired
	private PackInfoService packInfoService;
	
	@GetMapping()
	String PackInfo(){
	    return "common/packInfo/packInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public Result<Page<PackInfoDO>> list(PackInfoDO packInfoDTO){
        Wrapper<PackInfoDO> wrapper = new EntityWrapper<PackInfoDO>(packInfoDTO);
		wrapper.like("waybill_no",packInfoDTO.getWaybillNo(), SqlLike.DEFAULT);
        wrapper.orderBy("id",false);
        Page<PackInfoDO> page = packInfoService.selectPage(getPage(PackInfoDO.class), wrapper);
        return Result.ok(page);
	}
	
	@GetMapping("/add")
	String add(){
	    return "common/packInfo/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id,Model model){
		PackInfoDO packInfo = packInfoService.selectById(id);
		model.addAttribute("packInfo", packInfo);
	    return "common/packInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public Result<String> save( PackInfoDO packInfo){
		packInfo.setIndate(packInfoService.indate());
		packInfoService.insert(packInfo);
        return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result<String>  update( PackInfoDO packInfo){
		packInfoService.updateById(packInfo);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public Result<String>  remove( Long id){
		packInfoService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public Result<String>  remove(@RequestParam("ids[]") Long[] ids){
		packInfoService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}

	@Log("excel 导入")
	@RequestMapping(value = "/importExcel", method = RequestMethod.POST, produces = "application/json;charset=utf8")
	@ResponseBody
	public Message uploadFileHandler(@RequestParam("file") MultipartFile file) throws IOException {
		if(!file.isEmpty()){
			String fileName = file.getOriginalFilename();
			Message msg = new Message();
			if("xls".equals(fileName.split("\\.")[1]) || "xlsx".equals(fileName.split("\\.")[1])){

				try {
					packInfoService.importExcel(file,1,1,getUserId());
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
