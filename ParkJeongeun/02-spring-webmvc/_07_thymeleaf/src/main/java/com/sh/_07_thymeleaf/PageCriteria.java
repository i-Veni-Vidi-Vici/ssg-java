package com.sh._07_thymeleaf;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageCriteria {
    private int startPage;
    private int lastPage;
    private int currentPage;
}