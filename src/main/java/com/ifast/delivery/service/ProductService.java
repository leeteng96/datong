package com.ifast.delivery.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ifast.common.domain.Tree;
import com.ifast.delivery.domain.ProductDO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;


/**
 * 
 * <pre>
 * 商品表
 * </pre>
 * <small> 2018-07-06 15:41:06 | Aron</small>
 */

public interface ProductService extends IService<ProductDO>{


    Workbook exportProduct(List<ProductDO> plist);

    List<ProductDO>  importExcel(MultipartFile file, Integer titleRows, Integer headerRows);

    String selectByPId(String productId);

    List<ProductDO> showPro(String productId);



    List<ProductDO> findAll();

    ProductDO selectById(String productId);
}

