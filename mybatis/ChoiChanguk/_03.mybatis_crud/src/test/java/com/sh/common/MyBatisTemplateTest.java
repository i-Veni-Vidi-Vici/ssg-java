package com.sh.common;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyBatisTemplateTest {
    //findAll, findById, insert, update, delete
    @DisplayName("SqlSession객체가 정상적으로 반환된다")
    @Test
    void test() {
        SqlSession sqlSession=getSqlSession();
        assertThat(sqlSession)
                .isNotNull();

    }
}