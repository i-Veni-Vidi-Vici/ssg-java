package com.sh.app._05.aggregate.association;


import jakarta.persistence.*;
import lombok.*;

/*
생각을 해보면 학과, 교수, 과목, 학생이 한 번에 만들어지는게 아니라
교수따로, 과목따로, 학과따로, 학생따로 만들어지고 연관이 되어진다
ex) 학생 1: 지도교수 1
 */
// 학과

@Entity
@Table(name = "tbl_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @ManyToOne // 연관관계 안쓴다
    @Column(name = "department_id")
    private Long departmentId;
}
