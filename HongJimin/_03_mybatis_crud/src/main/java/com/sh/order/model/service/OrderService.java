package com.sh.order.model.service;

import com.sh.common.error.ErrorCode;
import com.sh.order.model.dao.OrderMapper;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;
import com.sh.order.model.exception.CreateOrderTransactionException;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class OrderService {
    /**
     * <pre>
     *   트랜잭션
     * - 1건의 주문 정보 (insert)
     * - n건의 주문 메뉴 정보 (insert)
     * </pre>
     *
     * @param orderDto
     * @return
     */

    public int createOrder(OrderDto orderDto) {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class); // mybatis의 config에  order-mapper.xml(이 안에 OrderMapper interface 있음)등록함
        try {
            // 트랜잭션 처리 코드
            // 1건의 주문 등록
            int result = orderMapper.insertOrder(orderDto);
            System.out.println(orderDto.getOrderCode());
            // n건의 주문 메뉴 등록
            for (OrderMenuDto orderMenuDto : orderDto.getOrderMenuList()) { // for each에서 : 오른쪽은 list, set 전부 다 가능
                // 발급된 주문 코드를 OrderMenuDto#orderCode 대입
                orderMenuDto.setOrderCode(orderDto.getOrderCode());
                result = orderMapper.insertOrderMenu(orderMenuDto);
            }

            sqlSession.commit(); //💖여기가 중요💖
            return result;
        } catch (Exception e) {
            sqlSession.rollback(); //💖여기가 중요💖
            throw new CreateOrderTransactionException(ErrorCode.CREATE_ORDER_ERROR, e);
        } finally {
            sqlSession.close();
        }

    }
}
