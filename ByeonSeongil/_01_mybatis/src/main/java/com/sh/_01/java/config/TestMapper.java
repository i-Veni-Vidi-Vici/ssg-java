package com.sh._01.java.config;

import org.apache.ibatis.annotations.Select;
import java.time.LocalDateTime;

public interface TestMapper {
    @Select("select now()")
    LocalDateTime selectNow();
    /*
    사용자가 인터페이스까지 만들면 이후 코드 한줄로 mybatis가 구현해줌
    LocalDateTime selectNow(){
        String sql = "select now()"
        PreparedStatement 생성
        ResultSet 생성
    }
     */
}
