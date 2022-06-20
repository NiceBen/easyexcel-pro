package com.zsl.easyexcelpro.mapper;

import com.zsl.easyexcelpro.model.dto.UserRoleDto;
import com.zsl.easyexcelpro.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UpdateUserRoleMapper {

    UpdateUserRoleMapper INSTANCES = Mappers.getMapper(UpdateUserRoleMapper.class);

    @Mappings({
            @Mapping(source = "userId", target = "id"),
            @Mapping(source = "name", target = "username"),
            @Mapping(source = "roleName", target = "role.roleName")
    })
    void updateDto(UserRoleDto userRoleDto, @MappingTarget User user);

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    void update(User user, @MappingTarget UserRoleDto userRoleDto);
}
