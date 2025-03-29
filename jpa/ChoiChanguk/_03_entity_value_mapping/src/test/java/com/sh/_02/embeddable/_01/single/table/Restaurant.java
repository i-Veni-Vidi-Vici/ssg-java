package com.sh._02.embeddable._01.single.table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.Year;

@Builder
@Entity
@Table(name = "tbl_restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "since")
    private Year since; // 개장년도

    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Embedded
    private Address address; // 에러가 나는 이유 VO를 개별적으로

    @Column(name = "created_at")
    @CreationTimestamp // insert할 상황에 insert시각을 자동으로주입
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp // update 시각을 자동으로 갱신
    private LocalDateTime updatedAt;

}
