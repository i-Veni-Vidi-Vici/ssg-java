package com.sh._02_transaction.order.model.dao;

import com.sh._02_transaction.order.model.dto.OrderDto;
import com.sh._02_transaction.order.model.dto.OrderMenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 사용자가 정의한 Mapper인터페이스의 구현클래스를 mybatis가 동적으로 생성함
 * 여기에 @Mapper 어노테이션을 등록하면, 이후 @MapperScan에 의해 해당 객체가 빈으로 등록됨
 */
@Mapper
public interface OrderMapper {
    int insertOrder(OrderDto orderDto);
    int insertOrderMenu(OrderMenuDto orderMenuDto);
}