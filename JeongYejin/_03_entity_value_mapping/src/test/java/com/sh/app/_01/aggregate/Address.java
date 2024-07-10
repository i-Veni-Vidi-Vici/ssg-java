package com.sh.app._01.aggregate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Address {
    private String address1;
    private String address2;
    private String zipCode;
}
