package com.ifast.expressOrder.controller;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.enums.SqlLike;
import com.ifast.common.annotation.Log;
import com.ifast.common.domain.Message;
import com.ifast.common.domain.Status;
import com.ifast.customer.domain.CustomerInfoDO;
import com.ifast.customer.service.CustomerInfoService;
import com.ifast.expressOrder.domain.ExpressOrderDO;
import com.ifast.expressOrder.service.ExpressOrderService;
import com.ifast.sys.domain.UserDO;
import com.ifast.sys.service.UserService;
import org.apache.commons.lang3.StringUtils;
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

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerInfoService customerInfoService;
	@GetMapping()
	String ExpressOrder(){
	    return "common/expressOrder/expressOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public Result<Page<ExpressOrderDO>> list(ExpressOrderDO expressOrderDTO){
      	EntityWrapper ew = new EntityWrapper();
      	ew.setEntity(new ExpressOrderDO());
      	ew.like("total_waybill_no",expressOrderDTO.getTotalWaybillNo(), SqlLike.DEFAULT);
      	ew.or("lading_bill_no like '%"+expressOrderDTO.getTotalWaybillNo()+"%'");
		ew.or("waybill_no like '%"+expressOrderDTO.getTotalWaybillNo()+"%'");
		ew.orderBy("id",false);
		Page<ExpressOrderDO> page = expressOrderService.selectPage(getPage(ExpressOrderDO.class), ew);

		return Result.ok(page);
	}



	@ResponseBody
	@GetMapping("/todo")
	public Result<Page<ExpressOrderDO>> getToDo(ExpressOrderDO expressOrderDTO) {
		EntityWrapper ew = new EntityWrapper();
		ew.where("1=1");
		ew.and("schedule = 1");
		if(StringUtils.isNotBlank(expressOrderDTO.getTotalWaybillNo())){
			ew.and("(total_waybill_no like '%"+expressOrderDTO.getTotalWaybillNo()+"%' or lading_bill_no like '%"+expressOrderDTO.getTotalWaybillNo()+"%' or  waybill_no like '%"+expressOrderDTO.getTotalWaybillNo()+"%')");
		}

		ew.and("(datediff(date_format(now(),'%y-%m-%d %h'), turnup_date)>=2 and logistics_type =1  or  datediff(date_format(now(),'%y-%m-%d %h'), turnup_date)>=3 and logistics_type =2)");
		Page<ExpressOrderDO> page = expressOrderService.selectPage(getPage(ExpressOrderDO.class), ew);
 		return Result.ok(page);
	}
	@GetMapping("/add")
	String add(){
	    return "common/expressOrder/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id,Model model){
		ExpressOrderDO expressOrder = expressOrderService.selectById(id);
		model.addAttribute("expressOrder", expressOrder);
	    return "common/expressOrder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result<String> save( ExpressOrderDO expressOrder){
		expressOrderService.insert(expressOrder);
        return Result.ok();
	}


	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result<String>  update( ExpressOrderDO expressOrder){
		expressOrderService.updateById(expressOrder);
		return Result.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public Result<String>  remove( Long id){
		expressOrderService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public Result<String>  remove(@RequestParam("ids[]") Long[] ids){
		expressOrderService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}

	@GetMapping("/userList")
	@ResponseBody
	public  String  userList(UserDO userDTO){
		Wrapper<UserDO> wrapper = new EntityWrapper<UserDO>(userDTO);
		wrapper.setSqlSelect("id,name").orderBy("id",false);
		List <UserDO> userDOList = userService.selectList(wrapper);
		String userList = JSON.toJSONString(userDOList);
		return userList;
	}

	@RequestMapping("/customerList")
	@ResponseBody
	public  String  customerList(CustomerInfoDO customerInfoDTO){
		Wrapper<CustomerInfoDO> wrapper = new EntityWrapper<CustomerInfoDO>(customerInfoDTO);
		wrapper.setSqlSelect("id,name").orderBy("id",false);
		List <CustomerInfoDO> customerList = customerInfoService.selectList(wrapper);
		String customerInfo = JSON.toJSONString(customerList);
		return customerInfo;
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
					expressOrderService.importExcel(file,1,1,getUserId());
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