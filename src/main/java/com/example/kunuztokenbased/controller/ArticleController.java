package com.example.kunuztokenbased.controller;

import com.example.kunuztokenbased.dto.ApiResponse;
import com.example.kunuztokenbased.dto.ArticleDto;
import com.example.kunuztokenbased.entity.Article;
import com.example.kunuztokenbased.repository.ArticleRepository;
import com.example.kunuztokenbased.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleRepository articleRepository;
    private  final ArticleService articleService;
    @GetMapping
    public ResponseEntity<?> read(){
        ApiResponse<?> read = articleService.read();
      return  ResponseEntity.ok(read);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ArticleDto articleDto) {
        ApiResponse<?> edit = articleService.edit(id, articleDto);
        return ResponseEntity.ok(edit);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        ApiResponse<?> delete = articleService.delete(id);
        return ResponseEntity.ok(delete);
    }

}
