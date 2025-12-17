package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.model.Follow;

public interface FollowService {
    Follow follow(Long userId);

    Follow unfollow(Long userId);
}
