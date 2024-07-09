package com.sh.app._01.aggregate;

import lombok.*;

@Getter
@EqualsAndHashCode
@Setter(AccessLevel.PRIVATE)

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfo {
    // 🌟수신자 정보(주문자와 다를 수 있음)를 Receiver 클래스로 관리한다. -> 하위의 3개를 묶어서 관리
    private Receiver receiver;
//    private String receiverName;
//    private String receiverPhone;
//    private String receiverMessage;

    // 🌟주소 관련 정보를 Address Class로 관리한다.
    private Address address; // 하위의 3개를 묶어서 관리해주면 좋아서 클래스 따로 만듦 -> ✨응집도를 높혀줌!
//    private String address1;
//    private String address2;
//    private String zipCode;

    public void changeAddress(Address newAddress) {
        this.address = newAddress;
    }

}
