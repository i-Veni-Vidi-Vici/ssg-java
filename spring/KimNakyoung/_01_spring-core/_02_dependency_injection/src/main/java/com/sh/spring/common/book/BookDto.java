package com.sh.spring.common.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private LocalDate creatAt;
}
