package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.common.CommonResult;
import com.manhnv.vimaserver.dto.request.LogInRequest;
import com.manhnv.vimaserver.dto.request.SignUpRequest;
import com.manhnv.vimaserver.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public CommonResult register(@RequestBody SignUpRequest request) {
        // Logic for user registration
        return CommonResult.success(authService.signUp(request));
    }

    @PostMapping("/sign-in")
    public CommonResult<?> login(@RequestBody LogInRequest request) {
        // Logic for user login
        return CommonResult.success(authService.signIn(request));
    }
}
