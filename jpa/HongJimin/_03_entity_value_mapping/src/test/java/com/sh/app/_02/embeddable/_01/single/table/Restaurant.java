package com.sh.app._02.embeddable._01.single.table;

import com.sh.app._01.aggregate.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.Year;

@Entity
@Table(name = "tbl_restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "since")
    private Year since; // 개장년도 -> 자바 타입에서 년도만 관리해주는 클래스!

    @Column(name = "grade") // 이넘은 기본값으로 순서 인덱스로 관리됨
    @Enumerated(EnumType.STRING) // 그래서 문자로 관리함
    private Grade grade;

    @Embedded
    private Address address;

    @Column(name = "created_at")
    @CreationTimestamp // insert 시각을 자동으로 주입
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp // update 시각을 자동으로 갱신
    private LocalDateTime updatedAt;
}
