package com.sh.app._02.embeddable._01.single.table;

import com.sh.app._01.aggregate.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.MemberSubstitution;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.Year;

@Entity
@Table(name="tbl_restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="name", nullable=false) // NotNull 제약조건
    private String name;
    @Column(name="since")
    private Year since; // 개장년도 (자바TypePackage의 Year사용)
    @Column(name="grade")
    @Enumerated(EnumType.STRING) // Grade는 enum이므로 문자열타입으로 관리하도록 .STRING속성 줌
    private Grade grade;
    @Embedded
    private Address address;
    @Column(name="created_at")
    @CreationTimestamp // insert 시각을 자동으로 주입
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    @UpdateTimestamp // update 시각을 자동으로 갱신
    private LocalDateTime updatedAt; // 마지막 업데이트 시각
}
