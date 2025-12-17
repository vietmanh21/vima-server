package com.manhnv.vimaserver.repository;

import com.manhnv.vimaserver.model.Follow;
import com.manhnv.vimaserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFollowerAndFolloweeUser(User follower, User followeeUser);
}
