package com.manhnv.vimaserver.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String role;
}
