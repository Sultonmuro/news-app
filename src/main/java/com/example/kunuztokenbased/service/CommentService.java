package com.example.kunuztokenbased.service;

import com.example.kunuztokenbased.dto.ApiResponse;
import com.example.kunuztokenbased.dto.UserDto;
import com.example.kunuztokenbased.entity.Comment;
import com.example.kunuztokenbased.exception.ResourceNotFoundException;
import com.example.kunuztokenbased.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    public ApiResponse<?> read() {
        List<Comment> all = commentRepository.findAll();
        return ApiResponse.builder().message("READ").success(true).data(all).build();
    }

    public ApiResponse<?> edit(Long id ,Comment comment) {
        Comment comment2 = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("comment", "id", id));

        comment.setInfo(comment2.getInfo());
        Comment save = commentRepository.save(comment);
return ApiResponse.builder().data(save).success(true).message("Mana").build();
    }

    public ApiResponse<?> delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("comment", "id", id));
        commentRepository.delete(comment);
        return ApiResponse.builder().message("DELETED SUCCESSFULLY").success(true).build();
    }
}
