package com.sh.common;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyBatisTemplateTest {
//    @DisplayName("SqlSession객체가 정상적으로 가져올 수 있다.")
    @DisplayName("SqlSession객체가 정상적으로 찾을 수 없습니다.")
    @Test
    void test() {
        SqlSession sqlSession = getSqlSession();
        assertThat(sqlSession).isNotNull();
    }
}