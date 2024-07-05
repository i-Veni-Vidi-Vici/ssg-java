package com.sh.app._03.element.collection._01.set._01.auth;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity(name = "Role0301")
@Table(name = "tbl_role")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    private String id;
    private String name;
    /**
     * <pre>
     *     fetch = FetchType.LAZY (기본값) Role 객체 조회가 아닌 실제 permission 사용직전 조회
     *     fetch = FetchType.EAGER : Role 객체 조회 시 함께 조회
     * </pre>
     */

    @ElementCollection(fetch = FetchType.LAZY)
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
