package com.sh.app.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopMember extends Member {
    private String address;

    public ShopMember(Long id, String name, String address) {
        super(id, name);
        this.address = address;
    }
}
