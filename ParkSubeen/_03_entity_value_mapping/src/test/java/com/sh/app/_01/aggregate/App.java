package com.sh.app._01.aggregate;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 주문을 생성하라
        // 결제금액을 계산하라
        Order order = new Order(
                1L,
                new Orderer(100L, "홍길동"),
                new DeliveryInfo(
                        new Receiver("신사임당", "010-1234-1234", "로켓배송 부탁드립니다."),
                        new Address("서울시 서초구", "방배동 123", "01234")),
                List.of(new OrderLine(1L, 3, 3000), new OrderLine(2L, 2, 5000)),
                0,
                OrderStatus.주문확인중,
                LocalDateTime.now());
//        order.setTotalPrice(30000); // Entity 객체 하위 정보를 임의로 수정해서는 안된다.
        System.out.println(order);

        // 주문을 취소하라
//        order.setOrderStatus(OrderStatus.주문취소);


        // 배송지 주소를 변경하라. order > deliveryInfo > address
        // 1. order 배송지 주소를 변경해라. (주문상태가 배송준비중까지만 변경이 가능하다.)
        // 2. order는 Address를 알지 못하므로, DeliveryInfo에게 배송지 주소를 변경해라
        // 3. DeliveryInfo가 Address를 알고있으므로, 직접 Address객체를 변경!
//        order.getDeliveryInfo().setAddress(new Address("미국 뉴욕주 뉴욕시", "브롱크스가 123", "99999"));
        order.changeDeliveryAddress(new Address("미국 뉴욕주 뉴욕시", "브롱크스가 123", "99999"));
        System.out.println(order);
    }
}
