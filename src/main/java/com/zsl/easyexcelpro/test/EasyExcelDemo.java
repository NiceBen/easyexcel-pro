package com.zsl.easyexcelpro.test;

import com.alibaba.excel.EasyExcel;
import com.zsl.easyexcelpro.model.dto.UserData;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EasyExcelDemo {

    public static void main(String[] args) {
        // 实现 excel 写操作
        // 1.设置写入文件夹地址和excel文件名称
        String fileName = "D:\\test\\write.xlsx";
        // 调用 easyExcel 里面的方法实现写操作
        // 2个参数，第一个参数是文件名称，第二个参数是实体类
//        EasyExcel.write(fileName, UserData.class).sheet("学生信息表").doWrite(getData());
        EasyExcel.write(fileName, UserData.class)
                .sheet("学生信息表")
                .excludeColumnFiledNames(Collections.singletonList("address"))
                .doWrite(getData());
    }

    // 创建方法返回 list 集合
    private static List<UserData> getData() {
        List<UserData> list = new ArrayList<>();

        UserData userData1 = new UserData();
        userData1.setUsername("张三");
        userData1.setAge(22);
        userData1.setBirthday(formatDate("2000-10-11"));
        userData1.setSex(1);
        userData1.setAddress("北京");
        userData1.setWeight(new BigDecimal("201.1111"));
        userData1.setWeight2(new BigDecimal("202.2222"));
        userData1.setWeight3(new BigDecimal("203.3333"));
        list.add(userData1);

        UserData userData2 = new UserData();
        userData2.setUsername("李四");
        userData2.setAge(23);
        userData2.setSex(0);
        userData2.setAddress("上海");
        userData2.setWeight(new BigDecimal("101.1111"));
        userData2.setWeight2(new BigDecimal("102.2222"));
        userData2.setWeight3(new BigDecimal("103.3333"));
        userData2.setBirthday(formatDate("1999-10-11"));
        list.add(userData2);

        return list;
    }

    private static Date formatDate(String birthday) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
