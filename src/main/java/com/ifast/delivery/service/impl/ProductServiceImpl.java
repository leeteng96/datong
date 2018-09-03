package com.ifast.delivery.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ifast.delivery.dao.ProductDao;
import com.ifast.delivery.domain.ProductDO;
import com.ifast.delivery.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao,ProductDO> implements ProductService {






    public String selectByPId(String productId){
        ProductDO pdd = new ProductDO();
        //商品id有多个
       if(productId != null){
           if (productId.contains(",")){
               String [] str = productId.split(",");
               StringBuilder sb = new StringBuilder();
               for (int i = 0; i < str.length; i++) {
                   pdd = baseMapper.selectById(str[i]);
                   sb.append(pdd.getProductName()+"\r\n");


               }
               return sb.toString();
           }
           else {
               pdd=baseMapper.selectById(productId);
               return pdd.getProductName();
           }
       }else{
           pdd.setProductName("请添加商品!");
           return pdd.getProductName();
       }



    }
    //layer.open checkbox 返回数据格式——，1,2,3
    public List<ProductDO> showPro(String productId){
        List<ProductDO> plist = new ArrayList<>();
        ProductDO pdd ;
        if(StringUtils.isBlank(productId)){
            return plist;
        }else {

            String[] str = productId.split(",");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                if (!"'".equals(str[i])) {
                    pdd = baseMapper.selectById(str[i]);
                    plist.add(pdd);
                    Collections.sort(plist, new Comparator<ProductDO>() {
                        @Override
                        public int compare(ProductDO o1, ProductDO o2) {
                            if (o1.getProductId() > o2.getProductId()) {
                                return 1;
                            }
                            if (o1.getProductId() < o2.getProductId()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                   plist.size();
                }
            }
        }
        return plist;
    }




    @Override
    public List<ProductDO> findAll() {
        return baseMapper.selectList(null);
    }

    public ProductDO selectById(String productId) {
        ProductDO pdd = new ProductDO();
        if("".equals(productId) || "0".equals(productId) || productId == null){

            pdd.setProductName("请添加商品!");
        }else{
            pdd = baseMapper.selectById(productId);
        }
        return pdd;
    }
}
