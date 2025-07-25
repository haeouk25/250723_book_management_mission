package com.haeouk25.book_management.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard {
    private Long authorId;
    private String authorName;
    private Long bookCount;
}