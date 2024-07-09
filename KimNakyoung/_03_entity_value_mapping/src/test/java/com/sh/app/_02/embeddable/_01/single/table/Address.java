package com.sh.app._02.embeddable._01.single.table;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private String address1;
    private String address2;
    private String zipCode;
}
