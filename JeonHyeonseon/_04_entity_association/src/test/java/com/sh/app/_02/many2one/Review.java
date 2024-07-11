package com.sh.app._02.many2one;

import jakarta.persistence.*;
import lombok.*;

import java.lang.ref.PhantomReference;

/**
 * <pre>
 * Review-Restaurant 관계(다대일 관계, 다 -> review, 일 -> restaurant)
 * - 1개의 Restaurant은 N개의 Review를 가진다.
 * - 1개의 Review는 1개의 Restaurant을 반드시 가진다. (Collection이 아니다)
 * - N쪽인 Review엔티티는 @ManyToOne Restaurant엔티티를 가질 수 있다.
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
    @ManyToOne // many가 현재 클래스(Review) one이 필드타입(restaurant)
    @JoinColumn(name = "restaurant_id") // tbl_review.restaurant_id컬럼(FK)으로 tbl_restaurant.id컬럼(PK)을 참조한다.
    private Restaurant restaurant; // 리뷰할 대상인 restaurant객체
    private Grade grade;
    private String comment;
}
