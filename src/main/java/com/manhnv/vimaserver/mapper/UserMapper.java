package com.manhnv.vimaserver.mapper;

import com.manhnv.vimaserver.dto.response.UserResponse;
import com.manhnv.vimaserver.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserResponse> {
}
