package com.sh.app._02.embeddable._03.attribute.override;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;


@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor //✨✨✨✨ 꼭 있어야 함
@AllArgsConstructor
public class Address {
    @Column(name = "addr1") // 다시 재정의할 수 있음을 의미함
    private String address1;
    @Column(name = "addr2")
    private String address2;
    @Column(name = "zip_code")
    private String zipCode;
}
