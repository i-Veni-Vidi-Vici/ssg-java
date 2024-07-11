package com.sh.app._05.aggregate.association;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable // Embeddable 어노테이션은 NoArgsConstructor 어노테이션과 Serializable을 임플리먼츠 해야한다.
@Data
@Setter(AccessLevel.PRIVATE) // 외부에서 값을 임의로 변경하는 것을 방지
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private String address1;
    private String address2;
    private String zipCode;
}
