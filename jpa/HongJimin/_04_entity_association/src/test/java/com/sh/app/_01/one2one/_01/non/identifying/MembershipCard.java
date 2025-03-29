package com.sh.app._01.one2one._01.non.identifying;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * <pre>
 *   1 : 1 비식별 관계
 * - 회원 카드는 1명의 회원을 가질 수 있다.
 * - 회원 카드는 지정된 회원이 없을 수도 있다.(연결된 회원이 0명일 수도 있움)
 *
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
    private String number; // 식별자로 사용

    @OneToOne(fetch = FetchType.LAZY) //@OneToOne의 fetch의 기본값 = EAGER
    @JoinColumn(name = "user_email") // User @Id 컬럼 email을 tbl_membership_card.user_email 컬럼(FK)으루 참조
    private User owner;
    // 멤버십을 조회할 때, User를 무조건 조회해주세요가 FetchType.EAGER
    // FetchType.LAZY -> 멤버십 카드 먼저 조회한 후, User를 조회하게 함 Collection과 같이 여러건을 조회할 때 사용하기도 함

    @Column(name = "expiry_date")
    private YearMonth expiryDate;
    private boolean enabled;
}
