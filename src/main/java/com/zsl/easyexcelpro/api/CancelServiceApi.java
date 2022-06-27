package com.zsl.easyexcelpro.api;

import com.zsl.easyexcelpro.global.asserts.AssertUtil;
import com.zsl.easyexcelpro.mapper.ServiceOrderMapper;
import com.zsl.easyexcelpro.model.dto.ServiceOrder;
import com.zsl.easyexcelpro.global.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequestMapping("/cancel")
@RestController
public class CancelServiceApi {

    private static final int cancelOrderStatus = 1;

    @Autowired
    ServiceOrderMapper serviceOrderMapper;

    @GetMapping("/del/{serviceOrderId}")
    public ApiResult cancelService(@PathVariable("serviceOrderId") Long serviceOrderId) {
        ServiceOrder serviceOrder = serviceOrderMapper.selectById(serviceOrderId);
        if (Objects.isNull(serviceOrder)) {
            return ApiResult.fail("查无此服务单");
        }
        if (Objects.equals(cancelOrderStatus, serviceOrder.getOrderStatus())) {
            return ApiResult.fail("已取消的服务单不允许再次取消");
        }
        if (Objects.isNull(serviceOrder.getSortOrderId())) {
            return ApiResult.fail("已配置物料的服务单不允许取消");
        }
        // ...other check

        // ...do something
        return ApiResult.success();
    }

    /**
     * 取消服务单
     */
    @GetMapping("/del/2/{serviceOrderId}")
    public ApiResult cancelService2(@PathVariable("serviceOrderId") Long serviceOrderId) {
        ServiceOrder serviceOrder = serviceOrderMapper.selectById(serviceOrderId);
        AssertUtil.businessInvalid(Objects.isNull(serviceOrder), "查无此服务单");
        AssertUtil.businessInvalid(serviceOrder.getOrderStatus().equals(cancelOrderStatus), "查无此服务单");
        AssertUtil.businessInvalid(serviceOrder.getSortOrderId() != null, "查无此服务单");
        // ...other check

        // ...do something
        return ApiResult.success();
    }
}
