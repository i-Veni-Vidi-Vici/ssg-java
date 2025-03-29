package com.sh.order.model.service;

import com.sh.common.error.ErrorCode;
import com.sh.order.model.dao.OrderMapper;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;
import com.sh.order.model.exception.CreateOrderTrasactionException;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

/**
 * <pre>
 *     트랜잭션
 *     - 1건의 주문정보 (insert)
 *     - n건의 주문메뉴정보(insert)
 * </pre>
 */
public class OrderService {
    public int createOrder(OrderDto orderDto) {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        try{
            //1건의 주문등록
            int result = orderMapper.insertOrder(orderDto);
            System.out.println(orderDto.getOrderCode());
            //n건의 주문메뉴 등록
            for(OrderMenuDto orderMenuDto : orderDto.getOrderMenuList()){
                orderMenuDto.setOrderCode(orderDto.getOrderCode());
                result = orderMapper.insertOrderMenu(orderMenuDto);
            }
            sqlSession.commit();
            return result;
        }catch(RuntimeException e){
            sqlSession.rollback();
            throw new CreateOrderTrasactionException(ErrorCode.CREATE_ORDER_ERROR, e);
        } finally {
            sqlSession.close();
        }
    }
}
