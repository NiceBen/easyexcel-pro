package com.zsl.easyexcelpro.test;

import com.zsl.easyexcelpro.model.dto.UserRoleDto;
import com.zsl.easyexcelpro.model.entity.Role;
import com.zsl.easyexcelpro.model.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class MapStructMainTest {
    User user = null;

    /**
     * 模拟从数据库中查出user对象
     */
    @BeforeEach
    public void before() {
        Role role  = new Role(2L, "administrator", "超级管理员");
        user  = new User(1L, "zhangsan", "12345", "17677778888", "123@qq.com", role);
    }

    /**
     * 模拟把 user 对象抓换乘 UserRoleDto 对象
     */
    @Test
    public void test1() {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId(user.getId());
        userRoleDto.setName(user.getUsername());
        userRoleDto.setRoleName(user.getRole().getRoleName());
        System.out.println(userRoleDto);
    }
}
