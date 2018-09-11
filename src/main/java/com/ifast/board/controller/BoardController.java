package com.ifast.board.controller;


import com.ifast.board.service.BoardService;
import com.ifast.cs.domain.ExpressOrderDO;
import com.ifast.cs.service.ExpressOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.base.AdminBaseController;
import com.ifast.common.utils.Result;

/**
 * 
 * <pre>
 * 选择打板
 * </pre>
 * <small> 2018-08-10 09:09:03 | LT</small>
 */
@Controller
@RequestMapping("/common/board")
public class BoardController extends AdminBaseController {

	String prefix = "common/board";

	@Autowired
	private ExpressOrderService expressOrderService;
    @Autowired
    private BoardService boardService;
	@GetMapping()
	@RequiresPermissions("common:board:chooseBoard")
	String Board(){
	    return prefix+"/chooseBoard";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:board:chooseBoard")
	public Result<Page<ExpressOrderDO>> list(ExpressOrderDO expressOrderDO){
        Wrapper<ExpressOrderDO> wrapper = new EntityWrapper<ExpressOrderDO>(expressOrderDO);
        wrapper.where("board_status=1");
		wrapper.orderBy("id",false);
        Page<ExpressOrderDO> page = expressOrderService.selectPage(getPage(ExpressOrderDO.class), wrapper);
        return Result.ok(page);

	}

	/**
	 * 打板
	 */
	@PostMapping("/playBoard")
	@ResponseBody
	@RequiresPermissions("common:board:playBoard")
	public Result<String>  playBoard(@RequestParam("waybillNo[]") String[] waybillNo,@RequestParam("boardId") String boardId){
        boardService.insertBatch(waybillNo,boardId);
		return Result.ok();
	}

	@RequiresPermissions("common:board:scanningBoard")
	@GetMapping("/scanningBoard")
	String scanningBoard(){
		return "common/board/scanningBoard";
	}






}
