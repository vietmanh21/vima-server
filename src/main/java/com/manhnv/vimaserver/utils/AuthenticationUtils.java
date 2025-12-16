package com.manhnv.vimaserver.utils;

import com.manhnv.vimaserver.constants.ApiConstant;
import com.manhnv.vimaserver.exception.AccessDeniedException;
import com.manhnv.vimaserver.exception.ApiException;
import com.manhnv.vimaserver.jwt.UserDetailsImpl;
import com.manhnv.vimaserver.model.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class AuthenticationUtils {
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static User extractUser() {
        Authentication authentication = getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new AccessDeniedException(ApiConstant.ACCESS_DENIED);
        }

        return ((UserDetailsImpl) authentication.getPrincipal()).getUser();
    }
}
