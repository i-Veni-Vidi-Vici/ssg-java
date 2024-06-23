package com.sh._02_json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private int age;
    private boolean married;
    private Pet pet;
}
