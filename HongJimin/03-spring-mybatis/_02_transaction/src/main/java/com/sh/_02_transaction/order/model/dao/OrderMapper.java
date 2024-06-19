package com.sh._02_transaction.order.model.dao;

import com.sh._02_transaction.order.model.dto.OrderDto;
import com.sh._02_transaction.order.model.dto.OrderMenuDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 사용자가 정의한 Mapper 인터페이스의 구현 클래스를 mybatis가 동적으로 생성한다.
 * 여기에 @Mapper 어노테이션을 등록하면, 이후 @Mapperscan에 의해 해당 객체가 빈으로 등록된다.
 * - 보통 @Mapperscan을 application에 넣어줌
 * - 빈으로 등록되면, 필요할 때 넣어줌( = DI, 의존성 주입)
 */
@Mapper // mybatis의 매퍼를 의미하는 것
public interface OrderMapper {
    int insertOrder(OrderDto orderDto); // 빈으로써 관리할 수 있게 됨!

    int insertOrderMenu(OrderMenuDto orderMenuDto);
}
