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
     * fetch (멀리있는 것을 가서 가져온다)
     *  - fetch = FetchType.LAZY (기본값) : Role객체 조회가 아닌 실제 permission 사용 직전에 조회
     *  - fetch = FetchType.EAGER : Role객체 조회시 함꼐 조회
     * </pre>
     */

    @ElementCollection(fetch = FetchType.EAGER) // EAGER = 안달난
    @CollectionTable(
            name = "tbl_role_permission_0302",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Permission> permissions;

    public void changePermissions(Set<Permission> newPermissions) {
        this.permissions = newPermissions;
    }

}
