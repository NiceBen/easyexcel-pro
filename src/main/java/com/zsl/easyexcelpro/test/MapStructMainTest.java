package com.zsl.easyexcelpro.test;

import com.zsl.easyexcelpro.mapper.UserRoleMapper;
import com.zsl.easyexcelpro.model.dto.UserRoleDto;
import com.zsl.easyexcelpro.model.entity.Role;
import com.zsl.easyexcelpro.model.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class MapStructMainTest {
    User user = null;

    /**
     * 模拟从数据库中查出user对象
     */
    @Before
    public void before() {
        Role role = new Role(2L, "zhangsan", "超级管理员");
        user = new User(1L, "zhangsan", "123456", "13612345678", "123@qq.com", role);
    }

    /**
     * 模拟通过 MapStruct 把 user 对象转换成 UserRoleDto 对象
     */
    @Test
    public void testUserToUserRoleDto() {
        UserRoleMapper userRoleMapper = UserRoleMapper.INSTANCES;
        UserRoleDto userRoleDto = userRoleMapper.toUserRoleDto(user);
        System.out.println(userRoleDto);
    }

    @Test
    public void test1() {
        UserRoleMapper userRoleMapper = UserRoleMapper.INSTANCES;
        UserRoleDto userRoleDto = userRoleMapper.defaultConvert();
        System.out.println(userRoleDto);
    }

    @Test
    public void test2() {
        UserRoleMapper instances = UserRoleMapper.INSTANCES;
        UserRoleDto userRoleDto = instances.useParameter(user, "myUserRole");
        System.out.println(userRoleDto);
    }
}