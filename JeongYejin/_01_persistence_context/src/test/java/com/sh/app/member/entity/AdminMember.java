package com.sh.app.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminMember extends Member {
    private String adminRole;

    public AdminMember(Long id, String name, String adminRole) {
        super(id, name);
        this.adminRole = adminRole;
    }
}
