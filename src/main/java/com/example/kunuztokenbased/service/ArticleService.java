package com.example.kunuztokenbased.service;

import com.example.kunuztokenbased.dto.ApiResponse;
import com.example.kunuztokenbased.dto.ArticleDto;
import com.example.kunuztokenbased.entity.Article;
import com.example.kunuztokenbased.exception.ResourceNotFoundException;
import com.example.kunuztokenbased.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    public ApiResponse read() {
        List<Article> all = articleRepository.findAll();
   return     ApiResponse.builder().data(all).message("READ ALL").success(true).build();

    }

    public ApiResponse edit(Long id, ArticleDto articleDto) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("article", "id", id));
        Article article1 = articleRepository.findById(articleDto.getCategory_id()).orElseThrow(() -> new ResourceNotFoundException("category", "id", id));
        Article article2 = articleRepository.findById(articleDto.getComment_id()).orElseThrow(() -> new ResourceNotFoundException("comment", "id", id));

      article.setComments(article.getComments());
        article.setCategory(article.getCategory());
        article.setDescription(article.getDescription());
        article.setTitle(article.getTitle());
        article.setNews(article.getNews());

        Article save = articleRepository.save(article);
        return ApiResponse.builder().data(save).success(true).message("Mana").build();
    }

    public ApiResponse delete(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("article", "id", id));
        articleRepository.delete(article);
        return ApiResponse.builder().success(true).message("DELETED").build();
    }
}
