package com.example.kunuztokenbased.security;

import com.example.kunuztokenbased.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter {
    private final JwtProvider jwtProvider;
    private final AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

        if (authorization != null && authorization.startsWith("Bearer")) {
            String token = authorization.substring(7);
            if (jwtProvider.isExpired(token)) {
                if (jwtProvider.validateToken(token)) {
                    String username = jwtProvider.getUsernameFromToken(token);
                    UserDetails userDetails = authService.loadUserByUsername(username);
                    //tizimga kim kirganini set qilib qoyadi
                    SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities()));
                } else {
                    System.out.println("JWT token emas!");
                    log.error("JWT token emas!");
                }
            } else {
                System.out.println("Vaqti tugagan");
                log.error("Vaqti tugagan!");
            }
        }
        doFilter(request, response, filterChain);
    }
}
