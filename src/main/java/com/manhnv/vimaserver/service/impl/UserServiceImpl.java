package com.manhnv.vimaserver.service.impl;

import com.manhnv.vimaserver.exception.NotFoundException;
import com.manhnv.vimaserver.model.User;
import com.manhnv.vimaserver.repository.UserRepository;
import com.manhnv.vimaserver.service.UserService;
import com.manhnv.vimaserver.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.USER_NOT_FOUND, id));
    }
}
