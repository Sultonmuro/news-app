package com.example.kunuztokenbased.service;

import com.example.kunuztokenbased.dto.ApiResponse;
import com.example.kunuztokenbased.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    @Value("${spring.mail.username}")
    String sender;
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(userRepository.findByPhone(username));
        return (UserDetails) userRepository.findByPhone(username);
    }


}
