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
     * 트랜잭션
     * - 1건의 주문정보 (insert)
     * - n건의 주문메뉴정보 (insert)
     * </pre>
     * @param orderDto
     * @return
     */
    public int createOrder(OrderDto orderDto) {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        try {
            // 트랜잭션 처리코드
            // 1건의 주문 등록
            int result = orderMapper.insertOrder(orderDto);
            System.out.println(orderDto.getOrderCode());
            // n건의 주문메뉴 등록
            for(OrderMenuDto orderMenuDto : orderDto.getOrderMenuList()) {
                // 발급된 주문코드를 OrderMenuDto#orderCode 대입
                orderMenuDto.setOrderCode(orderDto.getOrderCode());
                result = orderMapper.insertOrderMenu(orderMenuDto);
            }
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new CreateOrderTransactionException(ErrorCode.CREATE_ORDER_ERROR, e);
        } finally {
            sqlSession.close();
        }
    }
}
