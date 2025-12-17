package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
//    @GetMapping("/profile")
//    public ResponseEntity<UserResponse> getUserProfile(final Authentication authentication) {
//        UserResponse result = userService.getUserProfile(authentication.getName());
//        return ResponseEntity.ok(result);
//    }
//
//    @GetMapping("/get-all")
//    public ResponseEntity<List<UserResponse>> getAllUsers() {
//        return ResponseEntity.ok(userService.getAll());
//    }
}
