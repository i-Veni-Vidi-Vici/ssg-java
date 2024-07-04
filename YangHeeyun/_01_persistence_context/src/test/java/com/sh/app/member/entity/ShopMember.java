package com.sh.app.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopMember extends Member {
    private String address;

    public ShopMember(Long id, String name, String adminRole){
        super(id, name);
        this.address = address;
    }
}
