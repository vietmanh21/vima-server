package com.manhnv.vimaserver.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponse {
    private String token;
    private UserResponse user;
}
