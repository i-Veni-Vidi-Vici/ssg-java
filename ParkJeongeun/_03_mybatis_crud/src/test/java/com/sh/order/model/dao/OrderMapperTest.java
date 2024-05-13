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
        this.sqlSession = getSqlSession();
        this.orderMapper = this.sqlSession.getMapper(OrderMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.close();
    }

    /**
     * <pre>
     * 특정 컬럼값 하나만 조회 가능
     * (그룹함수 결과 등)
     * </pre>
     */
    @Test
    @DisplayName("단일값 조회할 수 있다.")
    void name() {
        // given

        // when
        int cnt = orderMapper.countAll();
        // then
        assertThat(cnt).isPositive();
    }

    /**
     * <pre>
     * 조인쿼리 처리 (1:N)
     * - tbl_order(1) - tbl_order_menu(N)
     * - tbl_category(1) - tbl_menu(N)
     * </pre>
     */
    @DisplayName("1:N관계는 resultMap태그 - collection태그를 사용해 처리할 수 있다. ")
    @Test
    void test2() {
        // given
        int orderCode = 1;
        // when
        OrderDto orderDto = orderMapper.findByOrderCode(orderCode);
        System.out.println(orderDto);

        // then
        assertThat(orderDto).isNotNull();
        assertThat(orderDto.getOrderMenuList()).isNotNull().isNotEmpty();
    }
}