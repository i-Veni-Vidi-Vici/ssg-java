package com.sh.app._02.embeddable._01.single.table;

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
    // Year를 사용한 이유 : 구체화 시킨 것. 의도가 분명해짐.
    private Year since; // 개장년도
    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade; // 등급
    @Embedded
    private Address address; // 주소
    @Column(name = "created_at")
    @CreationTimestamp // insert 시각을 자동으로 주입
    private LocalDateTime createdAt; // 등록일시
    @Column(name = "updated_at")
    @UpdateTimestamp // update 시각을 자동으로 갱신
    private LocalDateTime updatedAt; // 마지막 수정일시
}
