package com.sh.app._02.embeddable._02.secondary.table;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable // Embeddable 어노테이션은 NoArgsConstructor 어노테이션과 Serializable을 임플리먼츠 해야한다.
@Data
@Setter(AccessLevel.PRIVATE) // 외부에서 값을 임의로 변경하는 것을 방지
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    @Column(name = "addr1")
    private String address1;
    @Column(name = "addr2")
    private String address2;
    @Column(name = "zip_code")
    private String zipCode;
}
