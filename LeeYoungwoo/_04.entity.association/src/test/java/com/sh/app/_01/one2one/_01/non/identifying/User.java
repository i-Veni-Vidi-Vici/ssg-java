package com.sh.app._01.one2one._01.non.identifying;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Builder
public class User {
    @Id
    private String email;
    private String name;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
