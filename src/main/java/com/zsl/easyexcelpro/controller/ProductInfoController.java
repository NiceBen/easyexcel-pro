package com.zsl.easyexcelpro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zsl.easyexcelpro.global.result.ResultVo;
import com.zsl.easyexcelpro.model.entity.ProductInfo;
import com.zsl.easyexcelpro.model.query.Page;
import com.zsl.easyexcelpro.model.query.product.ProductInfoQuery;
import com.zsl.easyexcelpro.model.vo.IPage;
import com.zsl.easyexcelpro.model.vo.ProductInfoVo;
import com.zsl.easyexcelpro.service.intf.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/product/product-info")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/findById")
    public ProductInfoQuery findById(Integer id) {
        // ...
        return null;
    }

    @PostMapping("/findPage")
    public IPage<ProductInfoQuery> findPage(Page page) {
        // ...
        return null;
    }

    @PostMapping("/findByVo")
    public ProductInfo findByVo(@RequestBody @Validated ProductInfoVo vo) {
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(vo, productInfo);
        return productInfoService.getOne(new QueryWrapper<>(productInfo));
    }
}
