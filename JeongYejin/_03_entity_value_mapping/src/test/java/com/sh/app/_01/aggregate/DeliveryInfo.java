package com.sh.app._01.aggregate;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
// = @Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfo {
    // 수신자 정보를 Receiver클래스로 관리한다.
    private Receiver receiver;
//    private String receiverName;
//    private String receiverPhone;
//    private String receiverMessage;
    // 묶어서 address 하면 응집성을 높일 수 있다
    // 주소관련 정보를 Address클래스로 관리한다.
    private Address address;

    public void changeDeliveryAddress(Address newAddress) {
        this.address = newAddress;
    }
//    private String address1;
//    private String address2;
//    private String zipCode; // 우편번호
}
