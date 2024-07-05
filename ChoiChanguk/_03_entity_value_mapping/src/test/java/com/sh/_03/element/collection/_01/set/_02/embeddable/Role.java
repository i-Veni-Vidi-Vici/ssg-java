package com.sh._03.element.collection._01.set._02.embeddable;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "Role0302")
@Table(name = "tbl_role_0302")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    private String id;

    private String name;

    /**
     * @ElementCollection(fetch = FetchType.LAZY) // 기본값,
     * permission을 조회하기 직전까지 할 께 = 그니깐 permission을 가장 늦게 조회한다
     *
     *
     * @ElementCollection(fetch = FetchType.EAGER)
     * 이거는 Role객체 조회시 함께 조회를 한다
     *
     */

//    @Embedded 이걸 단독으로 들어오면 써줘야 하고, 지금은 안에 있는게 단독이 아니고, 또 setter를 써줘서 안써줘도 된다
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "tbl_role_permission_0302",
        joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    Set<Permission> permessions;  // 권한느낌으로 생각해, admin이 findByList, updateList 이런걸 할 수 있겟지??

    public void changePermissions(Set<Permission> newPermissions)
    {
        this.permessions=newPermissions;
    }
}
