package com.sh._01.java.config;

import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

public interface TestMapper { // 쿼리를 가진 interface를 mapper라고 함
    @Select("select now()")
    LocalDateTime selectNow();

}
