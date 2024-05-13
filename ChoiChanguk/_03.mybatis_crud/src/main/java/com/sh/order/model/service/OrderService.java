package com.sh.order.model.service;

import com.sh.order.model.dao.OrderMapper;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class OrderService {
    // service = 진짜 실행 하는 놈
    /**
     * 트랜잭션 commit , try catch
     * 1건의 주문정보 (insert)
     * n건의 주문정보 (insert)
     */
    SqlSession sqlSession = null;
    OrderMapper orderMapper = null;

    public int createOrder(OrderDto orderDto) {
        sqlSession=getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        try {
            // 트랜잭션 처리코드
            // 1건의 주문 등록
            int result = orderMapper.insertOrder(orderDto);

            // n건의 주문메뉴 등록
            for(OrderMenuDto orderMenuDto:orderDto.getOrderMenuList())
            {
                // 발급된 주문코드를 OrderMenuDto#orderCode 대입
                orderMenuDto.setOrderCode(orderDto.getOrderCode());
                result=orderMapper.insertOrderMenu(orderMenuDto);
            }
            System.out.println("주문 정상 종료");
            sqlSession.commit();
            return result;
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            sqlSession.close();;
        }

    }
}
