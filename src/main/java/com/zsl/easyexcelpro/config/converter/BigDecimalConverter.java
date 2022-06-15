package com.zsl.easyexcelpro.config.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal 数据类型，显示到 Excel 表格上，展示 2 位小数
 */
public class BigDecimalConverter implements Converter<BigDecimal> {

    @Override
    public Class<BigDecimal> supportJavaTypeKey() {
        return BigDecimal.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public BigDecimal convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty,
                                     GlobalConfiguration globalConfiguration) throws Exception {
        return new BigDecimal(String.valueOf(cellData.getNumberValue())).setScale(2, RoundingMode.DOWN);
    }

    @Override
    public CellData<String> convertToExcelData(BigDecimal bigDecimal, ExcelContentProperty excelContentProperty,
                                               GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData<>(bigDecimal.setScale(2, RoundingMode.DOWN));
    }
}
