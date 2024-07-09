package com.sh._02.embeddable._01.single.table;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.Year;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private Year since; // 개장년도
    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
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
