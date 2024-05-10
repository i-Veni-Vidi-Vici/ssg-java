package com.sh._01.java.config;

import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

public interface TestMapper {
    @Select("select now()") //1행 반환 후 자바 객체로 전달
    LocalDate selectNow();
}
