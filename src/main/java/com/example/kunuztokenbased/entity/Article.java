package com.example.kunuztokenbased.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "article")

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String news;
   @Column(nullable = false)
private String title;

private String description;
    @ManyToOne
    private Category category;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Comment> comments;

}
