package com.ifast.board.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.board.domain.BoardDO;
import com.ifast.board.service.BoardService;
import com.ifast.common.base.AdminBaseController;
import com.ifast.common.utils.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * <pre>
 * 打板发货 航单管理
 * </pre>
 * <small> 2018-08-13 17:51 | LT</small>
 */
@Controller
@RequestMapping("/common/ladingBill")
public class LadingBillController extends AdminBaseController {
    String prefix = "common/ladingBill";

    @Autowired
    private BoardService boardService;

    @RequiresPermissions("common:ladingBill:ladingBillBoard")
    @GetMapping("")
    String LadingBill(){
        return "common/board/ladingBillBoard";
    }


    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("common:ladingBill:ladingBillBoard")
    public Result<Page<BoardDO>> list(BoardDO boardDO){
        Wrapper<BoardDO> wrapper = new EntityWrapper<BoardDO>(boardDO);

        wrapper.orderBy("boardId",false);
        Page<BoardDO> page = boardService.selectPage(getPage(BoardDO.class), wrapper);
        return Result.ok(page);
    }

    @ResponseBody
    @PostMapping("/playLadingBill")
    @RequiresPermissions("common:ladingBill:playLadingBill")
    public boolean playLadingBill(@RequestParam("boardId[]")String [] boardId,@RequestParam("ladingBillNo")String ladingBillNo){

        return boardService.createLadingBill(boardId,ladingBillNo);
    }


}
