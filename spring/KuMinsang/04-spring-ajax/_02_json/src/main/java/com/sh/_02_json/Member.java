package com.sh._02_json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Long id;
    private String name;
    private int age;
    private boolean married;
    private Pet pet;
}
