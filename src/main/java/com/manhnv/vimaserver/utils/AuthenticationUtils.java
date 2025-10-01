package com.falcon.serveradmin.utils;

import com.manhnv.vimaserver.common.ResultCode;
import com.manhnv.vimaserver.exception.ApiException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationUtils {
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String extractUsername() {
        Authentication authentication = getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new ApiException(ResultCode.FORBIDDEN);
        }

        return authentication.getName();
    }
}
