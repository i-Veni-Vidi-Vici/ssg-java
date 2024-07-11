package com.sh.app._02.many2one;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity // name을 안주면 자동으로 클래스 이름이 들어간다.
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

//    private List<Review> reviews;
    // 원래라면 이렇게 레스토랑이 여러 리뷰를 가지고 있어야 하지만 이렇게 하면 객체지향적으로 순환참조 오류가 생기기 때문에
    // jpa를 사용하면 안쓰고도 참조할 수 있다.
}
