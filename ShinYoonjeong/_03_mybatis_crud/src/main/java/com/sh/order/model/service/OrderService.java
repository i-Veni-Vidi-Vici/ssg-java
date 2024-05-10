package com.sh.order.model.service;

import com.sh.order.model.dao.OrderMapper;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;
import com.sh.order.model.exception.CreatOrderTransactionException;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

/**
 * 트랜잭션
 * - 1건의 주문정보(insert)
 * - n건의 주문메뉴정보 (insert)
 */
public class OrderService {
    public int createOrder(OrderDto orderDto){
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        try{
            // 트랜잭션 처리코드
            // 1건의 주문등록
            int result = orderMapper.insertOrder(orderDto);
            // n건의 주문 메뉴 등록
            for(OrderMenuDto orderMenuDto : orderDto.getOrderMenuList()){
                result=orderMapper.insertOrderMenu(orderMenuDto);
            }
            sqlSession.commit();
            return result;
        }catch (Exception e){
            throw new CreatOrderTransactionException;
        }finally{
            sqlSession.close();
        }

    }

}
