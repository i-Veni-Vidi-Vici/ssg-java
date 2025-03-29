package com.sh._01.java.config;

import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

public interface TestMapper { // 쿼리를가진메소드를 가진 인터페이스
    @Select("select now()")
    LocalDateTime selectNow(); // java객체로 변환하여 반환
}
