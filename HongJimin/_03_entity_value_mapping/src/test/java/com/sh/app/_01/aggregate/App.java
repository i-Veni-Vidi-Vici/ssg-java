package com.sh.app._01.aggregate;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 주문을 생성하라
        // 결제 금액을 계산하라
        Order order = new Order(
                1L,
                new Orderer(100L, "홍길동"),
                new DeliveryInfo(
                        new Receiver("신사임당", "010-1234-1234", "로켓배송 부탁드립니다."),
                        new Address("서울시 서초구", "방배동 123", "01234")
                ),
                List.of(new OrderLine(1L, 3, 3000), new OrderLine(2L, 2, 5000)),
                0, // 여기서 사용된 totalPrice는 무용지물-> Order에서 totalPrice 계산해줌
                OrderStatus.주문확인중,
                LocalDateTime.now());
//        order.setTotalPrice(30000); // ⛔Entity 객체 하위의 정보를 임의로 수정하면 안됨 -> Order에서 @Setter(AccessLevel.PRIVATE) 추가해서 불가능하게 됨!

        System.out.println(order);

        // 주문을 취소하라
//        order.setOrderStatus(OrderStatus.주문취소); // 임의로 변경하지 않는다.

        // 배송지 주소를 변경하라 -> order > deliveryInfo > address
        // 1. order 에게 배송지 주소를 변경해라! 라고 요청함 -> (주문상태가 배송준비중까지만 변경이 가능함) => order한테 가서 orderstatus가 어떤지 먼저 묻고 주소를 변경해야하기 때문!
        // 2. order는 Address는 몰라서 DeliveryInfo에게 배송지 주소를 변경해라! 라고 요청함
        // 3. DeliveryInfo 가 Address를 알고 있으므로, 직접 Address객체를 변경
        order.changeDeliveryAddress(new Address("미국 뉴욕주 뉴욕시", "브롱크스카 123", "99999"));

//        order.getDeliveryInfo().setAddress(new Address("미국 뉴욕주 뉴욕시", "브롱크스카 123", "99999")); // ⛔이렇게 정보를 임의로 수정하면 안됨
    }
}
