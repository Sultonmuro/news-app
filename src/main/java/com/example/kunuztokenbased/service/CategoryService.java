package com.example.kunuztokenbased.service;

import com.example.kunuztokenbased.dto.ApiResponse;
import com.example.kunuztokenbased.entity.Category;
import com.example.kunuztokenbased.entity.User;
import com.example.kunuztokenbased.exception.ResourceNotFoundException;
import com.example.kunuztokenbased.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private  final CategoryRepository categoryRepository;

    public ApiResponse<?> read() {
        List<Category> all = categoryRepository.findAll();
        return ApiResponse.builder().success(true).message("Category READ !!").data(all).build();
    }

    public ApiResponse<?> edit(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", "id", id));
category.setName(category.getName());
        Category save = categoryRepository.save(category);
return ApiResponse.builder().data(save).success(true).message("Edited ").build();
    }

    public ApiResponse<?> delete(Long id) {
       Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", "id", id));
        categoryRepository.delete(category);
        if(!categoryRepository.existsById(id)){
            return ApiResponse.builder().message("Bunday Idli user Yo'q!").success(true).build();
        }
        return ApiResponse.builder().message("Deleted!").success(true).build();
    }



    public ApiResponse<?> getOne(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", "id", id));

       return ApiResponse.builder().success(true).data(category).message("Got One !!").build();


    }
}
