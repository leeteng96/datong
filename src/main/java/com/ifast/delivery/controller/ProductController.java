
package com.ifast.delivery.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.annotation.Log;
import com.ifast.common.base.AdminBaseController;
import com.ifast.common.domain.Tree;
import com.ifast.common.utils.Result;
import com.ifast.delivery.domain.ProductDO;
import com.ifast.delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * 
 * <pre>
 * 商品表
 * </pre>
 * <small> 2018-07-06 15:41:06 | Aron</small>
 */

@Controller
@RequestMapping(value = "/common/product")
public class ProductController extends AdminBaseController {
	private String prefix = "common/product";
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	String Product(){
	    return prefix+"/list";
	}


	@Log("查询定时任务列表")
	@ResponseBody
	@RequestMapping("/list")
	List<ProductDO> list(ProductDO ProductDTO) {
		List<ProductDO> plist = productService.findAll();
		return 	plist;
	}


	@Log("新增页面跳转商品页面")
    @RequestMapping("/jumpPro/{ids}")
    String jumpPro(@PathVariable("ids") String ids, Model model){
		model.addAttribute("ids",ids);
		return "common/expressDelivery/product";
    }

	@Log("新增页面跳转商品页面")
	@RequestMapping("/jumpPro")
	String jumpPro(){
		return "common/expressDelivery/product";
	}


	@ResponseBody
 	@RequestMapping("/jumpAdd/{ids}")
	List<ProductDO> jumpAdd(@PathVariable("ids")String ids){
		return productService.showPro(ids);
	}

	@GetMapping("/add")
	String add(){
		return "common/expressDelivery/addProduct";
	}

	@ResponseBody
	@PostMapping("/save")
	public Result<String> save( ProductDO product){
		product.setIndate(new Date());
		productService.insert(product);
		return Result.ok();
	}
}

