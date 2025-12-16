package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.response.UserResponse;
import com.manhnv.vimaserver.exception.ApiException;
import com.manhnv.vimaserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
