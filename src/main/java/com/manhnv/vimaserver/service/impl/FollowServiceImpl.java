package com.manhnv.vimaserver.service.impl;

import com.manhnv.vimaserver.exception.ApiException;
import com.manhnv.vimaserver.model.Follow;
import com.manhnv.vimaserver.model.User;
import com.manhnv.vimaserver.repository.FollowRepository;
import com.manhnv.vimaserver.service.FollowService;
import com.manhnv.vimaserver.service.UserService;
import com.manhnv.vimaserver.utils.AuthenticationUtils;
import com.manhnv.vimaserver.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {
    private final FollowRepository followRepository;
    private final UserService userService;

    @Override
    public Follow follow(Long userId) {
        User follower = AuthenticationUtils.getCurrentUser();
        User followeeUser = userService.getUserById(userId);
        Follow follow = Follow.builder()
                .follower(follower)
                .followeeUser(followeeUser)
                .build();

        return followRepository.save(follow);
    }

    @Override
    public Follow unfollow(Long userId) {
        User follower = AuthenticationUtils.getCurrentUser();
        User followeeUser = userService.getUserById(userId);

        Follow follow = followRepository.findByFollowerAndFolloweeUser(follower, followeeUser)
                .orElseThrow(() -> new ApiException(Constants.ErrorCode.ACCESS_DENIED));

        followRepository.delete(follow);
        return follow;
    }
}
