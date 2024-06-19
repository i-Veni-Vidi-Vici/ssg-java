package com.sh._07_thymeleaf;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageCriteria {

    private int startPage;
    private int lastPage;
    private int currentPage;

}
