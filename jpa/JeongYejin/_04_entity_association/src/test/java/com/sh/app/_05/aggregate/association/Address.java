package com.sh.app._05.aggregate.association;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable // 반드시 (1.시리얼라이저블, 2.non-selected 기본생성자)을 구현해야 한다
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Address implements Serializable {
    private String address1;
    private String address2;
    private String zipCode;
}
