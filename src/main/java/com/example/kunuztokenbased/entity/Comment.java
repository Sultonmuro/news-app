package com.example.kunuztokenbased.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comment")

public class Comment {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String info;





}
