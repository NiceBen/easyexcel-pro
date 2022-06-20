package com.zsl.easyexcelpro.mapper;

import com.zsl.easyexcelpro.model.dto.CustomerDto;
import com.zsl.easyexcelpro.model.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCES = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "customerName", target = "name")
    Customer toCustomer(CustomerDto customerDto);

    @InheritInverseConfiguration
    CustomerDto fromCustomer(Customer customer);
}
