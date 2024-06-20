package com.sh._02_transaction.order.model.service;

import com.sh._02_transaction.order.model.dao.OrderMapper;
import com.sh._02_transaction.order.model.dto.OrderDto;
import com.sh._02_transaction.order.model.dto.OrderMenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 *  전파행위옵션 (propagation)
    REQUIRED : 진행 중인 트랜젝션이 있으면 현재 메서드를 그 트랜젝션에서 실행하되 그렇지 않은 경우 새 트랜젝션을 시작해서 실행한다.
    REQUIRED_NEW : 항상 새 트랜젝션을 시작해 메서드를 실행하고 진행중인 트랜젝션이 있으면 잠시 중단시킨다.
    SUPPORTS : 진행중인 트랜젝션이 있으면 현재 메서드를 그 트랜젝션 내에서 실행하되, 그렇지 않을 경우 트랜젝션 없이 실행한다.
    NOT_SUPPORTED : 트랜젝션 없이 현재 메서드를 실행하고 진행중이 트랜젝션이 있으면 잠시 중단한다.
    MANDATORY : 반드시 트랜젝션을 걸고 현재 메서드를 실행하되 진행중인 트랜젝션이 없으면 예외를 던진다.
    NEVER : 반드시 트랜젝션 없이 현재 메서드를 실행하되 진행중인 트랜젝션이 있으면 예외를 던진다.
    NESTED : 진행중인 트랜젝션이 있으면 현재 메서드를 이 트랜젝션의 중첩트랜젝션 내에서 실행한다.진행중인 트랜젝션이 없으면 새 트랜젝션을 실행한다.
             배치 실행 도중 처리할 업무가 백만개라고 하면 10만개씩 끊어서 커밋하는 경우 중간에 잘못 되어도 중첩트랜젝션을 롤백하면 전체가 아닌 10만개만 롤백된다.
             세이브포인트를 이용하는 방식이다. 따라서 세이브포인트를 지원하지 않는 경우 사용 불가능하다.
*/

/**
 * 격리 레벨 (동시성 고려) isolation
 *
 * DEFATUL : DB의 기본 격리 수준을 사용한다. 대다수는 READ_COMMITTED가 기본 격리 수준이다.
 * READ_UNCOMMITTED : 다른 트랜젝션이 아직 커밋하지 않은 값을 한 트랜젝션이 읽을 수 있다.
 *                    따라서 오염된 값을 읽거나, 재현 불가능한 읽기, 허상 읽기 등의 문제가 발생할 수 있다.
 * READ_COMMITTED : 트랜젝션이 다른 트랜젝션에서 커밋한 값만 읽을 수 있다.
 *                  오염(수정)된 값 읽기 문제는 해결되지만 재현 불가능한 읽기 및 허상읽기는 여전히 발생할 수 있다.
 * REPEATABLE_READ : 트랜젝션이 어떤 필드를 여러 번 읽어도 동일한 값을 읽도록 보장한다.
 *                   트랜젝션이 지속되는 동안에는 다른 트랜젝션이 해당 필드를 변경할 수 없다.
 *                   오염된값 읽기, 재현 불가능한 읽기는 해결되지만 허상읽기는 여전이 발생할 수 있다.
 * SERIALIZABLE : 트랜젝션이 테이블을 여러 번 읽어도 정확히 동일한 로우를 읽도록 보장한다. 트랜젝션이 지속되는 동안에는
 *                다른 트랜젝션이 해당 테이블에 삽입, 수정, 삭제를 할 수 없다.
 *                동시성 문제는 모두 해소되지만 성능은 현저하게 떨어진다.
 *
 * 오염된 값 : 하나의 트랜젝션이 데이터를 변경 후 잠시 기다리는 동안 다른 트랜젝션이 데이터를 읽게 되면,
 *         격리레벨이 READ_UNCOMMITTED인 경우 아직 변경 후 커밋하지 않은 재고값을 그대로 읽게 된다.
 *         그러나 처음 트랜젝션이 데이터를 롤백 하게 되면 다른 트렌젝션이 읽은 값은 더 이상 유효하지 않은 일시적인 값이 된다. 이것을 오염된 값이라 한다.
 * 재현 불가능한 읽기 : 처음 트랜젝션이 데이터를 수정하면 수정이 되고 아직 커밋되지 않은 로우에 수정 잠금을 걸어둔 상태이다.
 *               결국 다른 트랜젝션은 이 트랜젝션이 커밋 혹은 롤백 되고 수정잠금이 풀릴때까지 기다렸다가 읽을 수 밖에 없게 된다.
 *               하지만 다른 로우에 대해서는 또 다른 트랜젝션이 데이터를 수정하고 커밋을 하게 되면
 *               가장 처음 동작한 트랜젝션이 데이터를 커밋하고 다시 조회를 한 경우 처음 읽은 그 값이 아니게 된다. 이것이 재현 불가능한 읽기이다.
 * 허상읽기 : 처음 트랜젝션이 테이블에서 어러 로우를 읽은 후 이후 트랜젝션이 같은 테이블의 로우를 추가하는 경우
 *         처음 트랜젝션이 같은 테이블을 다시 읽으면 자신이 처음 읽었을 때와 달리 새로 추가된 로우가 있을 것이다.
 *         이것을 허상읽기라고 한다. (재현불가한 읽기와 유사하지만 허상 읽기는 여러 로우가 추가되는 경우를 말한다.)
 */

/**
 * 클래스레벨
 * - 하위 모든 메소드에 @Transactional을 적용
 *
 * @Transactional 메소드안에서 던져진 예외가 RuntimeException 후손인 경우만, rollback처리한다. (기본값)
 * -> 모든 예외에 대해 rollback 처리하도록 처리할 예외클래스를 Exception.class로 확장한다.
 */
@Transactional (
        propagation = Propagation.REQUIRED,
        isolation = Isolation.READ_COMMITTED,
        rollbackFor = Exception.class
)
@Service
public class OrderService {
    /**
     * @Mapper 구현클래스 빈이 의존 주입되어 처리된다.
     * - SqlSessionTemplate#getMapper는 더이상 작성하지 않아도 된다.
     */
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * 메소드레벨
     * - 현재 메소드에만 @Transactional을 적용
     */
//    @Transactional
    public int createOrder(OrderDto orderDto) {
        // 1. 주문등록
        int result = orderMapper.insertOrder(orderDto);
        // 2. n건의 주문메뉴 등록
        List<OrderMenuDto> orderMenuDtos = orderDto.getOrderMenuDtos();
//        orderMenuDtos.forEach(orderMenuDto -> {
//            // 방금 발급된 orderCode를 대입
//            orderMenuDto.setOrderCode(orderDto.getOrderCode());
//            result = orderMapper.insertOrderMenu(orderMenuDto);
//        });
        for(OrderMenuDto orderMenuDto : orderMenuDtos) {
            // 방금 발급된 orderCode를 대입
            orderMenuDto.setOrderCode(orderDto.getOrderCode());
            result = orderMapper.insertOrderMenu(orderMenuDto);
        }
        return result;
    }

    public int createOrderMenu(OrderMenuDto orderMenuDto) {
        return orderMapper.insertOrderMenu(orderMenuDto);
    }
}
