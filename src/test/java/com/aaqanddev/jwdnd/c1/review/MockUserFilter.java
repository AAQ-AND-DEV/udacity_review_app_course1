//package com.aaqanddev.jwdnd.c1.review;
//
//import com.aaqanddev.jwdnd.c1.review.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.test.web.support.WebTestUtils;
//import org.springframework.security.web.context.HttpRequestResponseHolder;
//import org.springframework.security.web.context.SecurityContextRepository;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//// code copied from https://stackoverflow.com/a/30153141/8049500 answer (and q) by Romain F.
//// ruku advises against using in dev environment, but fine for local testing
////and offers enhancements in this  answer to same post: https://stackoverflow.com/a/37680608/8049500
////which references this: https://stackoverflow.com/a/8336233/2688076
//@Component("MockUserFilter")
//public class MockUserFilter extends GenericFilterBean {
//    @Autowired
//    private UserService userDetailsService;
//
//    private SecurityContext securityContext;
//
//    @Autowired
//    private AuthenticationProvider authProvider;
//
//    public void setUserDetailsService(UserService userDetailService){
//        this.userDetailsService = userDetailService;
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        if (securityContext !=null){
//            SecurityContextRepository secCntxtRepo = WebTestUtils.getSecurityContextRepository(request);
//            HttpRequestResponseHolder requestResponseHolder = new HttpRequestResponseHolder(request,response);
//            secCntxtRepo.loadContext(requestResponseHolder);
//
//            request = requestResponseHolder.getRequest();
//            response = requestResponseHolder.getResponse();
//
//            secCntxtRepo.saveContext(securityContext, request, response);
//
//            securityContext = null;
//        }
//        chain.doFilter(request, response);
//    }
//
//    public void authenticateNextRequestAs(String username, ServletRequest request){
//        UserDetails principal = userDetailsService.loadUserByUsername(username);
//        Authentication authntctn = new UsernamePasswordAuthenticationToken(principal, principal.getPassword(), principal.getAuthorities());
//        securityContext = SecurityContextHolder.createEmptyContext();
//        securityContext.setAuthentication(authntctn);
//        SecurityContextHolder.getContext().setAuthentication(authntctn);
//
//        HttpSession session = ((HttpServletRequest) request).getSession(true);
//        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
//    }
//}
