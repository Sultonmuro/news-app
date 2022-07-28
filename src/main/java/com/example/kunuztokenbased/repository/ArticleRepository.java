package com.example.kunuztokenbased.repository;

import com.example.kunuztokenbased.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository  extends JpaRepository<Article,Long> {

}
