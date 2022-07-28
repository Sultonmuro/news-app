package com.example.kunuztokenbased.controller;

import com.example.kunuztokenbased.dto.ApiResponse;

import com.example.kunuztokenbased.dto.UserDto;
import com.example.kunuztokenbased.entity.User;
import com.example.kunuztokenbased.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

@GetMapping("/")
public ResponseEntity<?>  read(){
    ApiResponse<?> read = userService.read();
  return  ResponseEntity.ok(read);
}
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid UserDto userDto){
        ApiResponse<?> edit = userService.edit(id,userDto);
return ResponseEntity.status(edit.isSuccess() ? 202:404).body(edit);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        ApiResponse<?> delete = userService.delete(id);
     return   ResponseEntity.ok(delete);
    }

}
