//package com.zsl.easyexcelpro.controller;
//
//import com.zsl.easyexcelpro.mapper.CustomerDtoMapper;
//import com.zsl.easyexcelpro.model.dto.CustomerDto;
//import com.zsl.easyexcelpro.model.entity.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequestMapping("/api/map-struct")
//@RestController
//public class MapStructController {
//
//    @Autowired
//    CustomerDtoMapper mapper;
//
//    @GetMapping("/test")
//    public String test() {
//        Customer customer = new Customer(1L, "张三", true);
//        CustomerDto customerDto = mapper.toCustomerDto(customer);
//        return customer.toString();
//    }
//}
