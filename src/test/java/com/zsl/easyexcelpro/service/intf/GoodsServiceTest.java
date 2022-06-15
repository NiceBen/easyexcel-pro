package com.zsl.easyexcelpro.service.intf;

import com.zsl.easyexcelpro.cache.GoodsLazyCache;
import com.zsl.easyexcelpro.model.entity.Goods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsServiceTest {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodsLazyCache goodsLazyCache;

    static final Long id = 1L;

    @Test
    public void testGetGoodsById() {
        Goods goods = goodsService.getGoodsById(id);
        System.out.println(goods);
        // 查询验证
        Assertions.assertEquals("zhangsan", goods.getName());
    }

    @Test
    public void testUpdateGoods() {
        Goods goods = new Goods(id, "lisi", 18);
        goodsService.updateGoods(goods);
        // 查询验证
        goods = goodsService.getGoodsById(id);
        Assertions.assertEquals("zhangsan", goods.getName());
    }

    @Test
    public void testDeleteGoods() {
        goodsService.deleteGoods(id);
        // 查询验证
        Goods goods = goodsService.getGoodsById(id);
        Assertions.assertEquals("zhangsan", goods.getName());
    }

    @Test
    public void testGetGoods() {
        Goods goods = goodsLazyCache.getGoods(id);
        // 查询验证
        Assertions.assertEquals("zhangsan", goods.getName());
    }
}
