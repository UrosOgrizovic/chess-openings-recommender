package com.cor.backend.security.auth;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cor.backend.security.TokenUtils;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
	private TokenUtils tokenUtils;

    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenUtils tokenUtils, UserDetailsService userDetailsService) {
        this.tokenUtils = tokenUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String user;
        String token = tokenUtils.getToken(httpServletRequest);
        if(token != null){
            user = tokenUtils.getUsernameFromToken(token);
            if(user != null){
                UserDetails userDetails = userDetailsService.loadUserByUsername(user);
                if(userDetails != null){
                    TokenBasedAuthentication tokenBasedAuthentication = new TokenBasedAuthentication(userDetails);
                    tokenBasedAuthentication.setToken(token);
                    SecurityContextHolder.getContext().setAuthentication(tokenBasedAuthentication);
                }
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

}
