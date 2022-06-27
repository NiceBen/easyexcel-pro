package com.zsl.easyexcelpro.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class IPage<T> {

    private int sum;

    private int pageNum;

    private int pageSize;

    private List<T> list;
}
