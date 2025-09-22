package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.response.UserResponse;
import com.manhnv.vimaserver.exception.ApiException;
import com.manhnv.vimaserver.mapper.UserMapper;
import com.manhnv.vimaserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> getAll() {
        return userRepository.findAll().stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    public UserResponse getUserProfile(String username) {
        return userRepository.findByUsername(username).map(userMapper::toResponse)
                .orElseThrow(() -> new ApiException("User not found with username: " + username));
    }
}
