package com.sh.app._02.embeddable._01.single.table;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable // Embeddable어노테이션 사용시 @NoArgsContructor & implements Serializable 필수로 정의
@Data
@Setter(AccessLevel.PRIVATE) // 외부에서 값을 임의로 변경하는 것을 방지
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private String address1;
    private String address2;
    private String zipCode;
}
