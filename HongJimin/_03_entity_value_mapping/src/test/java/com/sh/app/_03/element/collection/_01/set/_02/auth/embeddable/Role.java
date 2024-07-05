package com.sh.app._03.element.collection._01.set._02.auth.embeddable;

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Entity(name = "Role0302")
@Table(name = "tbl_role_0302")
@Data // VO객체의 기본값
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
     *  fetch
     *   - fetch = FetchType.LAZY(기본값) Role 객체 조회가 아닌 실제 permission 사용 직전 조회
     *   - fetch = FetchType.EAGER : Role 객체 조회 시, 함께 조회
     * </pre>
     */
    @Embedded
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tbl_role_permission_0302",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @Column(name = "permission")
    Set<Permission> permissions; // manager/members "매니져용 회원 관리"

    public void changePermissions(Set<Permission> newPermissions) {
        this.permissions = newPermissions;
    }
}
