package com.sh.app._03.element.collection._03.map._02.embeddable;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Map;

@Entity(name = "UserSetting0302")
@Table(name = "tbl_user_setting_0302")
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
            name = "tbl_user_setting_map_0302",
            joinColumns = @JoinColumn(name = "user_setting_id")
    )
    @MapKeyColumn(name = "name") // Map의 Key 컬럼명
//    @Column(name = "value") // Map의 value 컬럼명 -> 🙉내부에서 관리할 거라서 필요 없음! => 대신에  PropValue 클래스에서 column명 지정해줌
    private Map<String, PropValue> props; // 1 : N이어서 테이블로 관리해야함

    public void changeProp(String name, String value, boolean enabled) {
        this.props.put(name, new PropValue(value, enabled)); // 🙉처리해야할 데이터가 여러 개인 경우 사용
    }

    public void removeProp(String name) {
        this.props.remove(name);
    }
}
