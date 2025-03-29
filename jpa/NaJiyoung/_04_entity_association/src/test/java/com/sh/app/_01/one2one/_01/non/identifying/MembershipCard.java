package com.sh.app._01.one2one._01.non.identifying;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * <pre>
 * 1:1 비식별관계
 * - 회원카드는 1명의 회원을 가질 수 있다.
 * - 회원카드는 지정된 회원이 없을 수도 있다.
 * </pre>
 */
@Entity
@Table(name = "tbl_membership_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Builder
public class MembershipCard {
    @Id
    private String number;

//    @OneToOne(fetch = FetchType.EAGER) // @OneToOne fetch 기본값은 EAGER이다.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email") // User @Id 컬럼 email을 tbl_membership_card.user_email컬럼(FK)으로 참조
    private User owner;

    @Column(name = "expiry_date")
    private YearMonth expiryDate; // 년,월만 관리
    private boolean enabled;
}
