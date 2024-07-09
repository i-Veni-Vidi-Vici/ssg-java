package com.sh.app._03.element.collection._03.map._01.setting;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "tbl_user_setting")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 이렇게 해야 auto-increment처리됨
    private Long id;
    @Column(name = "user_id")
    private Long userId; // 사용자 Aggregate의 루트엔티티 PK
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tbl_user_setting_map",
            joinColumns = @JoinColumn(name = "user_setting_id")
    )
    @MapKeyColumn(name = "name") // Map의 Key 컬럼명
    @Column(name = "value") // Map의 value 컬럼명
    private Map<String, String> props; // 1 : N이어서 테이블로 관리해야함

    public void changeProp(String key, String value) {
        this.props.put(key, value);
    }

    public void removeProp(String key) {
        this.props.remove(key);
    }
}
