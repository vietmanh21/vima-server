package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.request.LogInRequest;
import com.manhnv.vimaserver.dto.request.SignUpRequest;
import com.manhnv.vimaserver.dto.response.LogInResponse;
import com.manhnv.vimaserver.exception.ApiException;
import com.manhnv.vimaserver.jwt.JwtService;
import com.manhnv.vimaserver.model.Cart;
import com.manhnv.vimaserver.model.Role;
import com.manhnv.vimaserver.model.User;
import com.manhnv.vimaserver.repository.CartRepository;
import com.manhnv.vimaserver.repository.RoleRepository;
import com.manhnv.vimaserver.repository.UserRepository;
import com.manhnv.vimaserver.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
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
    private final RoleRepository roleRepository;

    public String signUp(SignUpRequest request) {
        boolean emailExists = userRepository.existsByEmail((request.getEmail()));
        if (emailExists) {
            throw new ApiException("Email already exists");
        }
        boolean usernameExists = userRepository.existsByUsername((request.getUsername()));
        if (usernameExists) {
            throw new ApiException("Username already exists");
        }
        Role role = roleRepository.findByName(Constants.Role.ROLE_USER).orElseThrow(() -> new ApiException("Role not found"));
        User user = User.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();
        User newUser = userRepository.save(user);
        return "Sign up successfully";
    }

    public LogInResponse signIn(LogInRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new ApiException("Invalid username"));
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
        LogInResponse response = new LogInResponse();
        response.setAccessToken(jwtToken);

        return response;
    }

}
