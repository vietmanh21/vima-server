package com.manhnv.vimaserver.service.impl;

import com.manhnv.vimaserver.dto.request.SignInRequest;
import com.manhnv.vimaserver.dto.request.SignUpRequest;
import com.manhnv.vimaserver.dto.response.SignInResponse;
import com.manhnv.vimaserver.exception.ApiException;
import com.manhnv.vimaserver.exception.DuplicatedException;
import com.manhnv.vimaserver.exception.NotFoundException;
import com.manhnv.vimaserver.jwt.JwtService;
import com.manhnv.vimaserver.model.User;
import com.manhnv.vimaserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
public class AuthServiceImpl {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String signUp(SignUpRequest request) {
        boolean emailExists = userRepository.existsByEmail((request.getEmail()));
        if (emailExists) {
            throw new DuplicatedException("Email already exists");
        }
        boolean usernameExists = userRepository.existsByUsername((request.getUsername()));
        if (usernameExists) {
            throw new DuplicatedException("Username already exists");
        }
        User user = User.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        return "Sign up successfully";
    }

    public SignInResponse signIn(SignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NotFoundException("Invalid email"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ApiException("Invalid password");
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
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
        response.setToken(jwtToken);
        BeanUtils.copyProperties(user, response.getUser());
        return response;
    }

}
