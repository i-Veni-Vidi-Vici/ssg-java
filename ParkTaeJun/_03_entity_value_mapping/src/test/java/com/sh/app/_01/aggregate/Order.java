package com.sh.app._01.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <h1>도메인 주도 설계(DDD)에서 애그리게이트(Aggregate), 엔티티(Entity), 밸류 오브젝트(Value Object) 구분</h1>
 *
 * <pre>
 * 1. 엔티티(Entity)
 * - 식별자(Identifier): 엔티티는 고유한 식별자를 가진다. 이 식별자를 통해 엔티티를 식별하고 구분할 수 있다.
 * - 상태와 행동: 엔티티는 상태(state)와 행동(behavior)을 가진다. 상태는 엔티티의 속성을 나타내고, 행동은 엔티티가 수행할 수 있는 동작을 의미한다.
 * - 변경 가능성: 엔티티의 상태는 시간에 따라 변경될 수 있다.
 *
 * 예시:
 * - 사용자(User) 엔티티: 이름, 이메일, 주소 등의 속성을 가지고 있으며, 사용자 정보를 변경하는 행동을 포함한다.
 *
 * 2. 밸류 오브젝트(Value Object)
 * - 식별자 없음: 밸류 오브젝트는 고유한 식별자를 가지지 않는다. 그 대신 속성의 값 자체가 객체를 정의한다.
 * - 불변성(Immutability): 밸류 오브젝트는 생성된 이후에 상태가 변경되지 않는다. 상태 변경이 필요할 경우 새로운 밸류 오브젝트를 생성한다.
 * - 동등성(Equality): 밸류 오브젝트는 속성의 값이 동일하다면 같은 객체로 간주된다.
 *
 * 예시:
 * - 주소(Address) 밸류 오브젝트: 거리, 도시, 우편번호 등의 속성을 포함하며, 두 주소의 속성이 모두 같다면 두 주소는 동일한 것으로 간주된다.
 *
 * 3. 애그리게이트(Aggregate)
 * - 경계(Boundary): 애그리게이트는 관련된 엔티티와 밸류 오브젝트를 하나의 논리적인 단위로 묶은 것이다. 이는 시스템에서 일관성을 유지해야 할 경계로 간주된다.
 * - 루트 엔티티(Root Entity): 애그리게이트는 항상 하나의 루트 엔티티를 가진다. 외부에서는 루트 엔티티를 통해서만 애그리게이트 내부에 접근할 수 있다.
 * - 일관성 유지: 애그리게이트 내의 모든 변경은 일관성을 유지하며 일어나야 한다. 이를 위해 트랜잭션 단위로 처리된다.
 *
 * 예시:
 * - 주문(Order) 애그리게이트:
 *      주문은 주문(Order) 루트엔티티, 주문상품(OrderLine) 밸류 오브젝트, 주문자(Orderer) 밸류 오브젝트, 배송정보(DeliveryInfo) 밸류 오브젝트  등을 포함하며, 주문은 애그리게이트의 루트 엔티티가 된다.
 *      주문내역은 주문 루트엔티티를 통해서만 주문 정보 조회나 배송정보를 변경할 수 있다.
 * </pre>
 *
 */
@Data
@Setter(AccessLevel.PRIVATE) // 외부에서 값을 임의로 변경하는 것을 방지
@NoArgsConstructor
public class Order {
    private Long id; // OrderEntity의 식별자
    private Orderer orderer;
    private DeliveryInfo deliveryInfo;
    private List<OrderLine> orderLines; // 주문내역
    private int totalPrice;
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;

    public Order(Long id, Orderer orderer, DeliveryInfo deliveryInfo, List<OrderLine> orderLines, int totalPrice, OrderStatus orderStatus, LocalDateTime orderDate) {
        this.id = id;
        this.orderer = orderer;
        this.deliveryInfo = deliveryInfo;
        // 주문내역 설정과 총결제금액 계산은 setter에서 일관되게 작업되어야 한다.
        // 외부에서 호출할수 없게 접근제한자를 private로 지정해두었다.
        this.setOrderLines(orderLines);
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        // 총결제금액 계산
        this.totalPrice = orderLines.stream()
                .map((orderLine) -> orderLine.getPrice() * orderLine.getCount())
                .reduce(0, Integer::sum);
    }

    public void changeDeliveryAddress(Address newAddress) {
        if (this.orderStatus == OrderStatus.주문확인중 || this.orderStatus == OrderStatus.배송준비중) {
            this.deliveryInfo.changeAddress(newAddress);
        }
        else
            throw new IllegalStateException("주문상품이 이미 발송되어서, 배송지정보를 수정할 수 없습니다.");


    }
}
