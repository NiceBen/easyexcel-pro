package com.zsl.easyexcelpro.controller;

import com.zsl.easyexcelpro.model.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 通过 Junit5 的 API 进行集成测试
 * @author ZhouSL
 * @date 2022年6月9日
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        System.out.println("setup()");
    }

    @Test
    public void testHello() {
        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/api/hello", String.class);
        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("hello world", response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    public void testWhenNotExists() {
        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/api/world", String.class);
        // then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertNull(response.getBody());
    }

    @Test
    public void testGetByNameWhenExists() {
        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/api/name?name=zhangsan", String.class);
        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("name:zhangsan", response.getBody());
    }

    @Test
    @Disabled
    public void getByNameWhenNotExists() {
        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/api/world?name=lisi", String.class);
        // then
       assertEquals(HttpStatus.OK, response.getStatusCode());
       assertNull(response.getBody());
    }

    @Test
    public void testAdd() {
        // when
        ResponseEntity<List> response = restTemplate.postForEntity("/api/add", new Student("zhangsan", 20), List.class);
        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
    }


    /**
     * 校验请求头中，是否包含某个属性值
     */
    @Test
    public void testWorderFilter() {
        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/pai/hello", String.class);
        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getHeaders().get("X-CHOBIT-APP").contains("chobit-header"));
    }
}
