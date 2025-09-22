package com.manhnv.vimaserver.mapper;

import com.manhnv.vimaserver.dto.response.UserResponse;
import com.manhnv.vimaserver.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserResponse> {
    @Override
    @Mapping(target = "role", source = "role.name")
    UserResponse toResponse(User user);
}
