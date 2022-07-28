package com.example.kunuztokenbased.config;

import com.example.kunuztokenbased.security.JwtFilter;
import com.example.kunuztokenbased.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;

@EnableWebSecurity
@RequiredArgsConstructor
public class Security extends WebSecurityConfigurerAdapter {
private final JwtFilter jwtFilter;
private final AuthService authService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()

                .antMatchers(HttpMethod.GET, "/users/**").permitAll()
                .antMatchers(HttpMethod.POST, "/users/**").hasAnyRole("ADMIN", "MODERATOR")
                .antMatchers(HttpMethod.DELETE, "/users/**").hasAnyRole("ADMIN", "MODERATOR")
                .and()
                .csrf().disable()
                .exceptionHandling()
                .and()
                        .cors().disable();


        http.addFilterBefore((Filter) jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }
}

