package com.manhnv.vimaserver.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String email;
    private String userName;
    private String avatar;
    private List<String> roles = List.of("USER");
}
