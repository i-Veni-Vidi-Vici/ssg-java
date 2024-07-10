package com.sh._03.element.collection._02.list._03.map._02.setting.embeddable;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Map;

@Entity(name = "UserSetting0302")
@Table(name = "tbl_user_setting0302")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSetting {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
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
    @MapKeyColumn(name = "name") // Map의 key컬럼명
    private Map<String, PropValue> props;

    public void changeProp(String name, String value, boolean enabled) {
        this.props.put(name, new PropValue(value, enabled));
    }

    public void removeProp(String name) {
        this.props.remove(name);
    }

}
