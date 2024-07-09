package com.sh.app._01.aggregate;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 주문을 생성하라
        // 결제금액을 계산하라
        Order order = new Order(
                1L, // 이것만 엔티티, 나머지 아래에 있는 것들은 value(VO)이다.
                new Orderer(100L, "홍길동"),
                new DeliveryInfo(
                        new Receiver("신사임당", "010-1234-1234", "로켓배송 부탁드립니다."),
                        new Address("서울시 서초구", "방배동 123", "01234")
                ),
                List.of(new OrderLine(1L, 3, 3000), new OrderLine(2L, 2, 5000)),
                0,
                OrderStatus.주문확인중,
                LocalDateTime.now());
//        order.setTotalPrice(30000); // Entity객체 하위 정보를 임의로 수정해서는 안된다. Order클래스에서 @Setter(AccessLevel.PRIVATE)를 썼기 때문에 불가능하다. 바꾸고 싶으면 Order클래스에서 바꿔야 한다.

        // 주문을 취소하라
//        order.setOrderStatus(OrderStatus.주문취소); // 임의로 변경해서는 안된다. Order에게 위임해야한다(맡겨야한다)

        // 배송지 주소를 변경하라 -> 배송지 주소를 알고 있는 것은 order > deliveryInfo > address이다.
        // 1. order에게 배송지 주소를 변경해라. (주문상태가 배송준비중까지만 변경이 가능하다.) (order가 실제로 배송지 주소를 알고 있지 않다.)
        // 2. order는 Address를 알지 못하므로, DeliveryInfo에게 배송지 주소를 변경해라. (변경하라고 요청한다)
        // 3. DeliveryInfo가 Address를 알고 있으므로, 직접 Address객체(통째로 변경됨. 하나만 변경되지 않음)를 변경한다.
//        order.getDeliveryInfo().setAddress(new Address("미국 뉴욕주 뉴욕시", "브롱크스가 123", "99999"));
        order.changeDeliveryAddress(new Address("미국 뉴욕주 뉴욕시", "브롱크스가 123", "99999")); // order야. 나 ("미국 뉴욕주 뉴욕시", "브롱크스가 123", "99999") 이렇게 주소 바꾸고 싶어
    }
}
