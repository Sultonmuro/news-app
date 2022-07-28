package com.example.kunuztokenbased.controller;

import com.example.kunuztokenbased.dto.ApiResponse;
import com.example.kunuztokenbased.dto.UserDto;
import com.example.kunuztokenbased.entity.Comment;
import com.example.kunuztokenbased.service.CommentService;
import com.example.kunuztokenbased.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/comment")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

@GetMapping("/")
public ResponseEntity<?>  read(){
    ApiResponse<?> read = commentService.read();
  return  ResponseEntity.ok(read);
}
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid Comment comment){
        ApiResponse<?> edit = commentService.edit(id,comment);
return ResponseEntity.status(edit.isSuccess() ? 202:404).body(edit);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        ApiResponse<?> delete = commentService.delete(id);
     return   ResponseEntity.ok(delete);
    }

}
