package com.zsl.easyexcelpro.cache;

import com.zsl.easyexcelpro.model.entity.Goods;
import com.zsl.easyexcelpro.service.intf.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

// 伪代码示例 Xx代表你的业务对象 如User Goods等等
@Component
public class GoodsLazyCache {

//    @Autowired
//    private RedisTemplate<String, Goods> redisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private GoodsService goodsService;  // 业务Service

    /**
     * 查询 通过查询缓存是否存在驱动缓存加载 建议在前置业务保证id对应数据是绝对存在于数据库中的
     */
    public Goods getGoods(long id) {
        // 1.查询缓存里面有没有数据
        Goods goodsCache = getGoodsFromCache(id);
        if (Objects.nonNull(goodsCache)) {
            return goodsCache; // 卫语句使代码更有利于阅读
        }
        // 2.查询数据库获取数据 我们假定到业务这一步，传过来的id都是在数据库中有对应的数据
        Goods goods = goodsService.getGoodsById(id);
        // 3.设置缓存，这一步相当于Redis缓存懒加载，下次在查询此id，则会走缓存
        setGoodsFromCache(goods);
        return goods;
    }

    /**
     * 对于 xx 数据进行需改或者删除操作，操作数据库成功后，删除缓存
     * 删除请求 - 删除数据库数据，删除缓存
     * 修改请求 - 更新数据库请求，删除缓存，下次在查询时候就会从数据库拉取新的数据到缓存中
     */
    public void deleteGoodsFromCache(long id) {
        String key = "Goods:" + id;
        redisTemplate.delete(key);
    }

    private void setGoodsFromCache(Goods goods) {
        String key = "Goods:" + goods.getId();
        redisTemplate.opsForValue().set(key, goods);
    }

    private Goods getGoodsFromCache(long id) {
        // 通过缓存前缀拼装唯一主键作为缓存key，如Xxx信息，就是Xxx:id
        String key = "Goods:" + id;
        return (Goods) redisTemplate.opsForValue().get(key);
    }
}
