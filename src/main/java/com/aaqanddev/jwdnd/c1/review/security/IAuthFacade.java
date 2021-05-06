package com.aaqanddev.jwdnd.c1.review.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

//code attained from https://www.baeldung.com/get-user-in-spring-security option #4
public interface IAuthFacade{
    Authentication getAuthentication();
}
