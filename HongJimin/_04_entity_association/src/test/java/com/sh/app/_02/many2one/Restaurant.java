package com.sh.app._02.many2one;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tbl_restaurant")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // ❔여기서 n개의 리뷰를 보는 방법은 뭘까?❔
//    private List<Review> reviews; 이거는 일대다에서 다룰 예정! -> ⛔하지만 이거는 쓰면 안됨!⛔
}
