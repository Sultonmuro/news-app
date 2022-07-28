package com.example.kunuztokenbased.repository;

import com.example.kunuztokenbased.entity.Article;
import com.example.kunuztokenbased.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
