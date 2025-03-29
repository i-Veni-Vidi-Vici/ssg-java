package com.sh._01.aggregate;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryInfo {
    // 수신자 정보를 Receiver클래스로 관리한다, 주문자와 받는 사람이 다를 수 있기 때문에 따로 관리한다
    private Receiver receiver; // 수취인 정보가 있다

    // 주소 관련 정보를 Address 클래스로 관리한다
    private Address address;

    public void changeAddress(Address newAddress) {
        this.address=newAddress;
    }
}
