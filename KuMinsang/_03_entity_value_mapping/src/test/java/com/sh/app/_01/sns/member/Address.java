package com.sh.app._01.sns.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String address1;
    private String address2;
    private String zipCode;
}
