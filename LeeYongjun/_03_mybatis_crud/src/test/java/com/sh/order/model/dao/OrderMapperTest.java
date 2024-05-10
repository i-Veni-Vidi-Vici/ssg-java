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
     * 특정컬럼값 하나만 조회할 수 있다.
     * (그룹함수 결과 등)
     * </pre>
     */
    @DisplayName("단일값 조회할 수 있다.")
    @Test
    void test1 () {
        // given
        // when
        int cnt = orderMapper.countAll();
        System.out.println(cnt);
        // then
        assertThat(cnt).isPositive();
    }

    /**
     * <pre>
     * 조인쿼리 처리 (1:N)
     * - tbl_order(1) - tbl_order_menu(N)
     * - tbl_category(1) - tbl_menu(N)
     *
     * 조인쿼리 처리 (1:1)
     * - tbl_order_menu(1) - tbl_menu(1)
     * - tbl_menu(1) - tbl_category(1)
     *
     * </pre>
     */
    @DisplayName("1:N관계(collection), 1:1관계(association)태그로 처리할 수 있다.")
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