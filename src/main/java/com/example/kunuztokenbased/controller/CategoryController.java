package com.example.kunuztokenbased.controller;

import com.example.kunuztokenbased.dto.ApiResponse;
import com.example.kunuztokenbased.entity.Category;
import com.example.kunuztokenbased.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private  final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> read(){
        ApiResponse<?> read = categoryService.read();
        return ResponseEntity.ok(read);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> edit(@RequestBody Long id,@RequestBody  @Valid  Category category){
        ApiResponse<?> edit = categoryService.edit(id);
        return ResponseEntity.status(edit.isSuccess() ? 202 :  404 ).body(edit);
    }
    @DeleteMapping("/delte/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        ApiResponse<?> delete = categoryService.delete(id);
        return ResponseEntity.ok(delete);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id){
        ApiResponse<?> one = categoryService.getOne(id);
        return ResponseEntity.ok(one);
    }
}
