package com.sh.app._02.many2one;


import jakarta.persistence.*;
import lombok.*;

/**
 * <pre>
 * Review - Restaurant 관례
 * Review N : Restaurant 1
 * - 1개의 Restaurant은 N개의 Review를 가진다.
 * - 1개의 Review는 1개의 Restaurant을 반드시 가진다 (Collection 아니다)
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

    @ManyToOne // 현재 클래스 기준으로 생각하면 된다 ex) review입장에서는 review = many, to , restaurant = one
    @JoinColumn(name = "restaurant_id") // tbl_review.restaurant_id컬럼(fk)으로 tbl_restaurant.id컬럼(pk)을 참조한다
    private Restaurant restaurant;

    private Grade grade;
    private String comment;
}
