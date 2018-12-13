
package com.ifast.delivery.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.annotation.Log;
import com.ifast.common.base.AdminBaseController;
import com.ifast.common.domain.Message;
import com.ifast.common.domain.Status;
import com.ifast.common.domain.Tree;
import com.ifast.common.utils.Result;
import com.ifast.delivery.domain.ProductDO;
import com.ifast.delivery.service.ProductService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.thymeleaf.util.StringUtils.endsWith;


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
	    return "common/product/product";
	}


	@Log("查询定时任务列表")
	@ResponseBody
	@RequestMapping("/list")
	List<ProductDO> list(ProductDO ProductDTO) {
		List<ProductDO> plist = productService.findAll();
		return 	plist;
	}


	@ResponseBody
	@GetMapping("/getList")
	public Result<Page<ProductDO>> getList(ProductDO productDTO){
		Wrapper<ProductDO> wrapper = new EntityWrapper<ProductDO>(productDTO);
		wrapper.orderBy("id",false);
		Page<ProductDO> page = productService.selectPage(getPage(ProductDO.class), wrapper);
		return Result.ok(page);
	}

	@GetMapping("/getAdd")
	String getAdd(){
		return "common/product/add";
	}

	@GetMapping("/getEdit/{id}")
	String getEdit(@PathVariable("id") Integer id,Model model) {
		ProductDO product = productService.selectById(id);
		model.addAttribute("product",product);
		return "common/product/edit";
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/getUpdate")
	public Result<String>  getUpdate( ProductDO product){
		productService.updateById(product);
		return Result.ok();
	}
	@PostMapping( "/remove")
	@ResponseBody
	public Result<String>  remove(Long id){
		productService.deleteById(id);
		return Result.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public Result<String>  remove(@RequestParam("ids[]") Long[] ids){
		productService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
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

	@ResponseBody
	@PostMapping("/getSave")
	public Result<String> getSave( ProductDO product){
		productService.insert(product);
		return Result.ok();
	}




}

