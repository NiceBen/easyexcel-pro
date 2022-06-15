package com.zsl.easyexcelpro.test;

import com.alibaba.excel.EasyExcel;
import com.zsl.easyexcelpro.listener.ExcelListener;
import com.zsl.easyexcelpro.model.dto.UserData;

public class EasyExcelReadDemo {

    public static void main(String[] args) {
        // 实现excel写操作
        // 1.设置写入文件夹地址和excel文件名称
        String fileName = "D:\\test\\write.xlsx";
        // 调用 easyExcel 里面的方法现写操作
        // 2个参数，第一个参数的文件名称，第二个参数是实体类
        EasyExcel.read(fileName, UserData.class, new ExcelListener()).sheet().doRead();
    }
}
