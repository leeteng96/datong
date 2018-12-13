package com.ifast.delivery.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.annotation.Log;
import com.ifast.common.base.AdminBaseController;
import com.ifast.common.utils.Result;
import com.ifast.delivery.domain.ExpressDeliveryDO;
import com.ifast.delivery.domain.ProductDO;
import com.ifast.delivery.service.ExpressDeliveryService;
import com.ifast.delivery.service.ProductService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * <pre>
 * 揽收快件
 * </pre>
 * <small> 2018-07-02 18:34:07 | Aron</small>
 */
@Controller
@RequestMapping("/common/expressDelivery")
public class ExpressDeliveryController extends AdminBaseController {
	String prefix = "common/expressDelivery";

	@Autowired
	private ExpressDeliveryService expressDeliveryService;
	@Autowired
	private ProductService productService;
    @Log("进入定时任务管理页面")
	@GetMapping()
	String ExpressDelivery(){

	    return prefix+"/list";
	}

	@Log("查询定时任务列表")
	@ResponseBody
	@GetMapping("/list")
	public Result<Page<ExpressDeliveryDO>> list(ExpressDeliveryDO ExpressDeliveryDTO) {
		// 查询列表数据
		Wrapper<ExpressDeliveryDO> wrapper = new EntityWrapper<ExpressDeliveryDO>(ExpressDeliveryDTO);
		wrapper.orderBy("id",false);
		Page<ExpressDeliveryDO> page = expressDeliveryService.selectPage(getPage(ExpressDeliveryDO.class),wrapper);
		//获取productName
        for (ExpressDeliveryDO record:
                page.getRecords()) {
            record.setProductName(productService.selectByPId(record.getProductId()));

        }

		return Result.ok(page);
	}

	@GetMapping("/add")
	String add(){
	    return "common/expressDelivery/add";
	}


	@ResponseBody
	@PostMapping("/save")
	public Result<String> save( ExpressDeliveryDO expressDelivery){
		expressDeliveryService.saveExpressDelivery(expressDelivery);
		return Result.ok();
	}
    @ResponseBody
    @PostMapping("/selectPro")
    public Result<String> selectPro(){
        productService.selectList(null);
        return Result.ok();
    }

	@ResponseBody
	@PostMapping( "/remove")
	public Result<String>  remove( Long id){
		expressDeliveryService.deleteById(id);
		return Result.ok();
	}
	@PostMapping("/batchRemove")
	@ResponseBody
	public Result<String>  remove(@RequestParam("ids[]") Long[] ids){
		expressDeliveryService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}


	@Log("编辑订单")
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id,Model model){
		ExpressDeliveryDO expressDelivery = expressDeliveryService.selectById(id);
		expressDelivery.setProductName(productService.selectById(expressDelivery.getProductId()).getName());
		model.addAttribute("expressDelivery", expressDelivery);
		return prefix+ "/edit";

	}
	/**
	 * 修改
	 */
	@Log("修改用户")
	@ResponseBody
	@RequestMapping("/update/{id}")
	public Result<String>  update( @PathVariable("id")String productId, ExpressDeliveryDO expressDelivery){
		expressDelivery.setProductId(productId);
		expressDeliveryService.updateById(expressDelivery);
		return Result.ok();
	}

	@Log("修改用户")
	@ResponseBody
	@RequestMapping("/insertPro/{id}")
	public Result<String>  insertPro(@PathVariable("id")String id){
		expressDeliveryService.updatePId(id);
		return Result.ok();
	}


}
