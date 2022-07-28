package com.example.kunuztokenbased.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "comment")

public class Comment {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String info;





}
