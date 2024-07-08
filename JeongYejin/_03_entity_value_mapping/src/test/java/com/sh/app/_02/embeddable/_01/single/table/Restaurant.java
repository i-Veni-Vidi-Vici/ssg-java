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
public class Restaurant { // 너 왜 엔티티라고 해놓고 ID를 안써? 하는 오류가 난다.
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "since")
    private Year since; // 개장년도
    @Column(name = "grade") // enum은 기본적으로 숫자값으로 순서 인덱스가 적용된다
    @Enumerated(EnumType.STRING) // 이렇게 써주면 그대로 String값이 들어간다!
    private Grade grade;
    @Embedded // (@Embeddable과 짝꿍이다)
    private Address address;
    @Column(name = "created_at")
    @CreationTimestamp // insert 시각을 자동으로 주입
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    @UpdateTimestamp // update 시각을 자동을 갱신
    private LocalDateTime updatedAt;
}
