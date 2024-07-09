package com.sh.app._01.one2one._01.non.identifying;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 1. 1:1 비식별관계
 * - 회원카드는 1명의 회원을 가질 수 있다.
 * - 회원카드는 지정된 회원이 없을 수도 있다,
 */
@Entity
@Table(name = "tbl_membership_catd")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Builder
public class MembershipCard {
    @Id
    private String number;

    @OneToOne(fetch = FetchType.EAGER) // oneTone fetch 기본값은 EAGER이다
    @JoinColumn(name = "user_email")
    private User owner;


    @Column(name = "Expiry_date")
    private LocalDate dxpiryDate;
    private boolean enabled;
}
