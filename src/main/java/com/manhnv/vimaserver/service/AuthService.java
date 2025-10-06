package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.request.LogInRequest;
import com.manhnv.vimaserver.dto.request.SignUpRequest;
import com.manhnv.vimaserver.dto.response.SignInResponse;
import com.manhnv.vimaserver.exception.ApiException;
import com.manhnv.vimaserver.exception.DuplicatedException;
import com.manhnv.vimaserver.exception.NotFoundException;
import com.manhnv.vimaserver.jwt.JwtService;
import com.manhnv.vimaserver.mapper.UserMapper;
import com.manhnv.vimaserver.model.User;
import com.manhnv.vimaserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserMapper userMapper;

    public String signUp(SignUpRequest request) {
        boolean emailExists = userRepository.existsByEmail((request.getEmail()));
        if (emailExists) {
            throw new DuplicatedException("Email already exists");
        }
        boolean usernameExists = userRepository.existsByUsername((request.getUsername()));
        if (usernameExists) {
            throw new DuplicatedException("Username already exists");
        }
        boolean phoneNumberExists = userRepository.existsByPhoneNumber((request.getPhoneNumber()));
        if (phoneNumberExists) {
            throw new DuplicatedException("Phone number already exists");
        }
        User user = User.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail())
                .username(request.getUsername())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .authority("CUSTOMER")
                .build();
        userRepository.save(user);
        return "Sign up successfully";
    }

    public SignInResponse signIn(LogInRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new NotFoundException("Invalid username"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ApiException("Invalid password");
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (AuthenticationException ex) {
            log.warn("Authentication exception: {}", ex.getMessage());
            throw new AuthenticationException("Authentication failed: " + ex.getMessage()) {
            };
        }

        String jwtToken = jwtService.generateToken(user.getUsername());
        SignInResponse response = new SignInResponse();
        response.setAccessToken(jwtToken);
        response.setUser(userMapper.toResponse(user));

        return response;
    }

}
