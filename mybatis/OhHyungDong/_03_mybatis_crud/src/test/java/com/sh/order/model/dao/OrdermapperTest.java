package com.sh.order.model.dao;

import com.sh.menu.dao.MenuMapper;
import com.sh.order.model.dto.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class OrdermapperTest {
    SqlSession sqlSession;
    OrderMapper orderMapper;

    @BeforeEach
    void setUp() {
        sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.close();
    }

    /**
     * 특정 컬럼 값 하나만 조회 할 수 있음.
     * (그룹함수 결과 등)
     */
    @Test
    @DisplayName("단일값 조회 " )
    void test1() {
        //given
        //when
       int cnt = orderMapper.countAll();
        //then
        assertThat(cnt).isPositive();
        System.out.println(cnt);

    }


    /**
     * 조원쿼리 처리 ( 1 : N )
     * - tbl_roder(1) ; tbl_roder_menu ( N )
     * - tbl_categroy(1) - tbl_menu ( N )
     */
    @Test
    @DisplayName("1 : N 관계는 resultMap 태그 - collction 태그를 사용해 처리할 수 있다.")
    void test2() {
        //given
        int orderCode = 1;
        //when
        OrderDto orderDto = orderMapper.findByOrderCode(orderCode);
        System.out.println(orderDto);
        //then
        assertThat(orderDto).isNotNull();
        assertThat(orderDto.getOrderMenuList()).isNotEmpty().isNotEmpty();

    }
}
