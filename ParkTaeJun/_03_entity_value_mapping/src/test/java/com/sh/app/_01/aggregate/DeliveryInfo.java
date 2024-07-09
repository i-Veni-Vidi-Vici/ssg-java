package com.sh.app._01.aggregate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE) // 외부에서 값을 임의로 변경하는 것을 방지
public class DeliveryInfo {
    // 수신자 정보를 Receiver클래스로 관리한다.
    private Receiver receiver;
    // 주소관련 정보를 Address클래스로 관리한다.
    private Address address;

    public void changeAddress(Address newAddress) {
        this.address = newAddress;
    }
}
