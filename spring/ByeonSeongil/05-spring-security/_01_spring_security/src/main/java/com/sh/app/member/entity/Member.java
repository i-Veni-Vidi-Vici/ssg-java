package com.sh.app.member.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tbl_member")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private String memberId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
//    @ElementCollection(fetch = FetchType.EAGER) // MemberEntity 조회시 조인쿼리를 이용해서 Authority도 함께 조회
    @ElementCollection(fetch = FetchType.LAZY) // (기본값) Member 우선 조회, authorities는 proxy처리해두고, 필요할때 조회
    // LAZY전략은 영속성컨텍스트 밖에서 proxy에 대한 조회를 시도하면, LazyInitializationException을 유발!
    @CollectionTable(
        name = "tbl_authority",
        joinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Authority> authorities;

    public void setDefaultAuthorities() {
        this.authorities = Set.of(Authority.ROLE_USER);
    }

    public void changeName(String name) {
        this.name = name;
    }
}
