package com.zsl.easyexcelpro.mapper;

import com.zsl.easyexcelpro.config.format.BooleanStrFormat;
import com.zsl.easyexcelpro.model.dto.CustomerDto;
import com.zsl.easyexcelpro.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {BooleanStrFormat.class})
public interface CustomerMapper2 {

    CustomerMapper2 INSTANCES = Mappers.getMapper(CustomerMapper2.class);

    @Mappings({
            @Mapping(source = "name", target = "customerName"),
            @Mapping(source = "isDisable", target = "disable")
    })
    CustomerDto toCustomerDto(Customer customer);
}
