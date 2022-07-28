package com.example.kunuztokenbased.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;


public class Attachment {
    private String fileName;
    private String contentType; //.xls .doc
    private long size;
    private String url;

}
