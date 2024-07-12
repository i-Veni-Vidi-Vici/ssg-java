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
//    private List<String> reviews; // 이렇게 작성하지 않는다.
}
