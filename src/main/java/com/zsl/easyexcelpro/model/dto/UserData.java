package com.zsl.easyexcelpro.model.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.zsl.easyexcelpro.config.converter.BigDecimalConverter;
import com.zsl.easyexcelpro.config.converter.SexConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor  // 一定要有无参构造方法
//@ExcelIgnoreUnannotated       // 忽略所有不带“ExcelProperty”注解的属性
public class UserData {

    @ExcelProperty(index = 0, value = "姓名")
    private String username;

    @ExcelProperty(index = 1, value = "年龄")
    private Integer age;

    @ExcelProperty(index = 3, value = "性别", converter = SexConverter.class)
    private Integer sex;

//    @ExcelIgnore    // 该字段不生成 excel
    private String address;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(index = 2, value = "生日")
    private Date birthday;

    @ExcelProperty(index = 4, value = "体重KG-1")
    @NumberFormat("0.##")   // 会以字符串形式生成单元格，要计算的列不推荐
    private BigDecimal weight;

    @ExcelProperty(index = 5, value = "体重KG-2")
    @ContentStyle(dataFormat = 2)
    private BigDecimal weight2;

    @ExcelProperty(index = 6, value = "体重KG-3", converter = BigDecimalConverter.class)
    private BigDecimal weight3;
}
