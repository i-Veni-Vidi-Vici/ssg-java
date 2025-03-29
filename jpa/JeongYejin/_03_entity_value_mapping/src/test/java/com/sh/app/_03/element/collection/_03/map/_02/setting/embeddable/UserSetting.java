package com.sh.app._03.element.collection._03.map._02.setting.embeddable;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Map;

// 설정: 디바이스에 저장하거나 디비[V]에 저장하는 방식

@Entity
@Table(name = "tbl_user_setting_0302")
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
            name = "tbl_user_setting_map_0302",
            joinColumns = @JoinColumn(name = "user_setting_id")
    )
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    private Map<String, PropValue> props;

    public void changeProp(String name, String value, boolean enabled) {
        this.props.put(name, new PropValue(value, enabled)); // value의 데이터타입이 여러개 일때 사용
    }

    public void removeProp(String name) {
        this.props.remove(name);
    }
}
