package com.sh._02.embeddable._03.attribute.override;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    @Column(name = "addr1")
    private String address1;

    @Column(name = "addr2")
    private String address2;

    @Column(name = "zip_code")
    private String zipCode;
}
