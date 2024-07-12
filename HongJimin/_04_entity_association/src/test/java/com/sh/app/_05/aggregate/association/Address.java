package com.sh.app._05.aggregate.association;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor //✨✨✨✨ 꼭 있어야 함
@AllArgsConstructor
public class Address implements Serializable {//✨✨✨✨꼭 있어야 함
    private String address1;
    private String address2;
    private String zipCode;
}
