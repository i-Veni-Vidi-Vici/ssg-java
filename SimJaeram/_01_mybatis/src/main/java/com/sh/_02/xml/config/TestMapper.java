package com.sh._02.xml.config;

import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

public interface TestMapper {
    @Select("select now()")
    LocalDateTime selectNow();
}
