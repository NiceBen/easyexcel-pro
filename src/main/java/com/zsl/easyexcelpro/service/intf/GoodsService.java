package com.zsl.easyexcelpro.service.intf;

import com.zsl.easyexcelpro.model.entity.Goods;

public interface GoodsService {
    Goods getGoodsById(long id);

    void updateGoods(Goods goods);

    void deleteGoods(long id);
}
