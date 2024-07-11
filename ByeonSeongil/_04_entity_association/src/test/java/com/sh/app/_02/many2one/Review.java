package com.sh.app._02.many2one;

import jakarta.persistence.*;
import lombok.*;

/**
 * <pre>
 * Review-Restaurant 관계
 * - 1개의 Restaurant은 N개의 Review를 가진다.
 * - 1개의 Review는 1개의 Restaurant를 반드시 가진다. (Collection이 아니다.)
 * - N쪽인 Review엔티티 @ManyToOne Restaurant 엔티티를 가질 수 있다.
 * </pre>
 */
@Entity
@Table(name="tbl_review")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id") // tbl_review.restaurant_id컬럼(fk)으로  tbl_restaurant.id(PK)컬럼을 참조한다.
    private Restaurant restaurant;
    private Grade grade;
    private String comment;

}
