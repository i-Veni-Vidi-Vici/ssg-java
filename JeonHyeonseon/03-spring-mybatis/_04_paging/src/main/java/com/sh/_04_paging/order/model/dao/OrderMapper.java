package com.sh._04_paging.order.model.dao;

import com.sh._04_paging.order.model.dto.OrderDto;
import com.sh._04_paging.order.model.dto.OrderMenuDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 사용자가 정의한 Mapper인터페이스의 구현클래스를 mybatis가 동적으로 생성한다.
 * 여기에 @Mapper 어노테이션을 등록하면, 이후 @MapperScan에 의해 해당 객체가 빈으로 등록된다.
 * (빈으로 등록하면 필요할 때 달라고 하면 준다.)
 */
@Mapper // 마이바티스의 mapper역할을 함
public interface OrderMapper {
    int insertOrder(OrderDto orderDto);

    int insertOrderMenu(OrderMenuDto orderMenuDto);
}
