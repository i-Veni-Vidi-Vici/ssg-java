package com.sh.order.model.dao;

import com.sh.order.model.dto.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    SqlSession sqlSession;
    OrderMapper orderMapper;
    @BeforeEach
    void setUp() {
        sqlSession = getSqlSession();
        this.orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @AfterEach
    void tearDown() {
//        sqlSession.rollback();
        sqlSession.close();
    }

    /**
     * <pre>
     *     특정 컬럼 값 하나만 조회할수 있다.
     *     (그룹함수 결과 등)
     * </pre>
     */
    @DisplayName("단일 값 조회할 수 있다.")
    @Test
    public void test1() {
        //given
        int cnt = orderMapper.countAll();
        //when
        //then
        assertThat(cnt).isPositive();
    }


    @DisplayName("1:N관계는 resultMap태그 - collection태그를 사용해 처리할 수 있다")
    @Test
    public void name() {
        //given
        int orderCode = 2;
        // when
        OrderDto orderDto = orderMapper.findByOrderCode(orderCode);
        System.out.println(orderDto);

        // then
        assertThat(orderDto).isNotNull();
        assertThat(orderDto.getOrderMenuList()).isNotNull().isNotEmpty();

    }


}