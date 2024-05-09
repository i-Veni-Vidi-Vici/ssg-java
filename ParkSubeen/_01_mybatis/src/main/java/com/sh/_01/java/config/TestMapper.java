package com.sh._01.java.config;

import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

public interface TestMapper {
    @Select("select now()")
    LocalDateTime selectNow(); // 인터페이스만 생성하면 mybatis가 구현클래스를 동적으로 만들어서 반환
}
