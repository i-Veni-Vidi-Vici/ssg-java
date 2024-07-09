package com.sh.app._02.embeddable._01.single.table;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE) // 외부에서 값을 임의로 변경하는 것을 방지
public class Address {
    private String address1;
    private String address2;
    private String zipCode;
}
