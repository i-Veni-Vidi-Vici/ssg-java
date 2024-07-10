package com.sh._03.element.collection._01.set._02.auth.embeddable;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Set<Permission> permissions;

    public void changePermissions(Set<Permission> newPermissions) {
        this.permissions = newPermissions;
    }
}
