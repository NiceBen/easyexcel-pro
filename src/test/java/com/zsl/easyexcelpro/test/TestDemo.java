package com.zsl.easyexcelpro.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class TestDemo {


    @Test
    public void test() {
        List<String> list = Arrays.asList("张三", "李四", "王五", "赵六", "田七", "孙八");
        // Java8 Lambda表达式：forEach
        list.forEach(name -> {
            if ("赵六".equals(name)) {
                System.out.println("终止或跳出for循环");
                return;
            }
            System.out.println(name);
        });
    }
}
