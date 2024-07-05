package com.sh.app._01.aggregate;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfo {

    // 수신자 정보를 Receiver클래스로 관리한다.
    private Receiver receiver;

    // 주소 관련 정보를 Address클래스로 관리한다.
    private Address address; // 관련된 정보들은 하나로 묶어서 관리 -> 응집도

    public void changeAddress(Address newAddress) {
        this.address = newAddress;
    }
}
