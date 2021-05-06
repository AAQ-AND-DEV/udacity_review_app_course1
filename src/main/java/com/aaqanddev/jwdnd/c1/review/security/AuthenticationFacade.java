package com.aaqanddev.jwdnd.c1.review.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

//code attained from https://www.baeldung.com/get-user-in-spring-security option #4
@Component
public class AuthenticationFacade implements IAuthFacade{

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
