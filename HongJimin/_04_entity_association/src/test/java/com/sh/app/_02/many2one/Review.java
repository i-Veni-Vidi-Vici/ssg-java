package com.sh.app._02.many2one;

import jakarta.persistence.*;
import lombok.*;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * <pre>
 *     Review - Restaurant 관계
 *   - 1개의 Restuarant는 N개의 Review를 가진다.
 *   - 1개의 Review는 1개의 Restuarant을 반드시 가진다.(Collection이 아님)
 *   - N쪽인 Review엔티티에 @ManyToOne Restaurant 엔티티를 가질 수 있다.
 *   -
 * </pre>
 */
@Entity
@Table(name = "tbl_review")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // @OneToMany과 많이 헷갈림, 앞에 온느 것이 클래스, 뒤에 오는게 필드값!
    @JoinColumn (name = "restaurant_id") // tbl_review.restaurant_id 컬럼(FK)으로 tbl_restaurant.id컬럼(PK)을 참조한다.
    private Restaurant restaurant; // 리뷰할 대상, 기본형이 아닌 것을 썼을 때 오류가 남~~
    private Grade grade;
    private String comment;

}
