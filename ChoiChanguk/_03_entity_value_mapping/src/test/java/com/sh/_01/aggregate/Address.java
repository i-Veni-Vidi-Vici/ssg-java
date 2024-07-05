package com.sh._01.aggregate;

import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String address1;
    private String address2;
    private String zipCode;
}
