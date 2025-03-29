package com.sh.app._03.element.collection._01.set._02.auth.embeddable;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "Role0302")
@Table(name = "tbl_role_0302")
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
     * fetch
     * - fetch = FetchType.LAZY (기본값) Role객체 조회가 아닌 실제 permission 사용직전 조회
     * - fetch = FetchType.EAGER : Role객체 조회시 함께 조회
     * </pre>
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tbl_role_permission_0302",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )

    Set<Permission> permissions; // Set타입일땐 Embeded 안써도 된다.

    public void changePermissions(Set<Permission> newPermissions) {
        this.permissions = newPermissions;
    }
}
