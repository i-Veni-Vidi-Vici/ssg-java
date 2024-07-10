package com.sh.app._02.many2one;

import jakarta.persistence.*;
import lombok.*;

/**
 * <pre>
 * Review-Restaurant 관계
 * - 1개의 Restaurant은 N개의 Review를 가진다.
 * - 1개의 Review는 1개의 Restaurant을 반드시 가진다. (Collection이 아니다 !)
 * - N쪽인 Review엔티티에 @ManyToOne Restaurant엔티티를 가질수 있다.
 *
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
    @ManyToOne // 왜 매니투원인가? 앞(현재클래스) 뒤(필드타입)
    @JoinColumn(name = "restaurant_id") // tbl_review.restaurant_id(FK)칼럼을 restaurant_id을 참조한다.
    private Restaurant restaurant;
    private Grade grade;
    private String comment;
}
