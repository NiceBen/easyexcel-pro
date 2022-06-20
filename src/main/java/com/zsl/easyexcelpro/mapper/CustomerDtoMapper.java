package com.zsl.easyexcelpro.mapper;

import com.zsl.easyexcelpro.model.dto.CustomerDto;
import com.zsl.easyexcelpro.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Repository;

// 这里主要是这个componentModel 属性，它的值就是当前要使用的依赖注入的环境
@Repository
@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {

    @Mapping(source = "name", target = "customerName")
    CustomerDto toCustomerDto(Customer customer);
}
