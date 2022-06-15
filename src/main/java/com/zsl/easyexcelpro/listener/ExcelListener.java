package com.zsl.easyexcelpro.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zsl.easyexcelpro.model.dto.UserData;

import java.util.Map;

public class ExcelListener extends AnalysisEventListener<UserData> {

    /**
     * 一行一行的读取excel内容
     * @param data
     * @param analysisContext
     */
    @Override
    public void invoke(UserData data, AnalysisContext analysisContext) {
        System.out.println("****" + data);
    }

    /**
     * 读取表头内容
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头" + headMap);
    }

    /**
     * 读取完成操作
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取Excel完毕");
    }
}
