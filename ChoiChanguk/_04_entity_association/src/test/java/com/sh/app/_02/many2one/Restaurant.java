package com.sh.app._02.many2one;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private String name; // 식당이람

//    private List<Review> // 이건 나중에 한다 // 이렇게 생각할 수도 있는데 아직은 아님
}
