package com.sh.app._03.element.collection._03.map._01.setting;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

// 설정: 디바이스에 저장하거나 디비[V]에 저장하는 방식

@Entity
@Table(name = "tbl_user_setting")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId; // 사용자 Aggregate의 루트엔티티 PK
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ElementCollection(fetch = FetchType.EAGER) // left join
    @CollectionTable(
            name = "tbl_user_setting_map",
            joinColumns = @JoinColumn(name = "user_setting_id")
    )
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    private Map<String, String> props;

    public void changeProp(String key, String value) {
        this.props.put(key, value);
    }

    public void removeProp(String key) {
        this.props.remove(key);
    }
}