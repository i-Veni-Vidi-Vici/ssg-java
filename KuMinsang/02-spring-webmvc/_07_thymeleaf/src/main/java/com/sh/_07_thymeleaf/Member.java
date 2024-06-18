package com.sh._07_thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Long id;
    private String name;
    private int age;
    private LocalDate regDate;
}
