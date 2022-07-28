package com.example.kunuztokenbased.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArticleDto {
   private  Long id;
private String news;
   private Long category_id;

}
