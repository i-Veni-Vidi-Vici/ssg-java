package com.sh.order.model.dao;

import com.sh.order.model.dto.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {
    SqlSession sqlSession;
    OrderMapper orderMapper;
    @BeforeEach
    void setUp() {
        sqlSession=getSqlSession();
        orderMapper=sqlSession.getMapper(OrderMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.close();
    }

    /**
     * <pre>
     * 특정컬럼값 하나만 조회할 수 있다
     * (그룹함수 결과 등)
     * </pre>
     */

    @DisplayName("단일값 조회할 수 있다.")
    @Test
    void test1(){
        int cnt=orderMapper.countAll();
        System.out.println(cnt);
        //given
        //when
        //then

    }

    /**
     * <pre>
     * 조인쿼리 처리 (1:N)
     * - tbl_order(1) - tbl_order_menu(N)
     * - tbl_category(1) - tbl_menu(N)
     * </pre>
     */
    @DisplayName("1:N관계(collection), 1:1관계 association 태그를 사용해 처리할 수 있다. ")
    @Test
    void test2() {
        // given
        int orderCode = 1;
        // when
        OrderDto orderDto = orderMapper.findByOrderCode(orderCode);
        System.out.println(orderDto);

        // then


    }
}