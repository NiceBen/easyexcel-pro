package com.zsl.easyexcelpro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsl.easyexcelpro.mapper.ProductInfoMapper;
import com.zsl.easyexcelpro.model.entity.ProductInfo;
import com.zsl.easyexcelpro.service.intf.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {
}
