package com.sh.app._03.element.collection._01.set._01.auth;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "Role0301")
@Table(name = "tbl_role_0301")
@Data
@Setter(AccessLevel.PRIVATE) // vo객체는 불변으로 관리하자
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    private String id;
    private String name;
    /**
     * <pre>
     * fetch
     *  - fetch = FetchType.LAZY (기본값) Role객체 조회가 아닌 실제  permission 사용 직전 조회
     *  - fetch = FetchType.EAGER  : Role객체 조회시 함께 조회
     * </pre>
     */

//    @ElementCollection(fetch = FetchType.LAZY)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tbl_role_permission_0301",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @Column(name = "permission")
    Set<String> permissions;

    public void changePermissions(Set<String> newPermissions) {
        this.permissions = newPermissions;
    }
}
