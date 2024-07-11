package com.sh.app._01.aggregate;

import lombok.*;

@Setter(AccessLevel.PRIVATE)
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String address1;
    private String address2;
    private String zipCode;
}
