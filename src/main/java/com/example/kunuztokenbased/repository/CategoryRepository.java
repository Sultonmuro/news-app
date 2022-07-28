package com.example.kunuztokenbased.repository;

import com.example.kunuztokenbased.entity.Article;
import com.example.kunuztokenbased.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface CategoryRepository extends JpaRepository<Category,Long> {



}
