package com.zsl.easyexcelpro.service.impl;

import com.zsl.easyexcelpro.cache.GoodsLazyCache;
import com.zsl.easyexcelpro.model.entity.Goods;
import com.zsl.easyexcelpro.service.intf.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务类
 */
@Service
public class GoodsServiceImpl  implements GoodsService {

    @Autowired
    private GoodsLazyCache goodsLazyCache;



    // 查询数据库
    @Override
    public Goods getGoodsById(long id) {
        // 省略实现
        return new Goods(1L, "zhangsan", 17);
    }

    @Override
    public void updateGoods(Goods goods) {
        // 更新 MySQL 数据库 省略
        // 删除缓存
        goodsLazyCache.deleteGoodsFromCache(goods.getId());

    }

    @Override
    public void deleteGoods(long id) {
        // 删除 MySQL 数据库 省略
        // 删除缓存
        goodsLazyCache.deleteGoodsFromCache(id);
    }
}
