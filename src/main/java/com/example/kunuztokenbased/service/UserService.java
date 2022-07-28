package com.example.kunuztokenbased.service;

import com.example.kunuztokenbased.dto.ApiResponse;
import com.example.kunuztokenbased.dto.UserDto;
import com.example.kunuztokenbased.entity.User;
import com.example.kunuztokenbased.exception.ResourceNotFoundException;
import com.example.kunuztokenbased.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;
    public ApiResponse<?> read(){
        List<User> all = userRepository.findAll();
return ApiResponse.builder().message("Read All!!").success(true).data(all).build();
    }

    public ApiResponse<?> edit(Long id, User user) {
        User user1 = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
   user.setPhone(user1.getPhone());
   user.setPassword(user1.getPassword());
   user.setName(user1.getName());
   user.setAge(user1.getAge());
        User save = userRepository.save(user);
        return    ApiResponse.builder().data(save).message("Mana").success(true).build();
    }

    public ApiResponse<?> delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
        userRepository.delete(user);
        if(!userRepository.existsById(id)){
            return ApiResponse.builder().message("Bunday Idli user Yo'q!").success(false).build();
        }
        return ApiResponse.builder().message("Deleted!").success(true).build();
    }
}
