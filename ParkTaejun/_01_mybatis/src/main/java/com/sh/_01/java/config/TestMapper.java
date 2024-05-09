package com.sh._01.java.config;

import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

public interface TestMapper {
    @Select("select now() ")
    LocalDateTime selectNow();
}
