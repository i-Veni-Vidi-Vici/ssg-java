package com.sh._03.element.collection._03.map._01.setting;


import jakarta.persistence.*;
import jdk.jfr.StackTrace;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Map;


@Entity
@Table(name = "tbl_user_setting")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter(AccessLevel.PRIVATE)
public class UserSetting {


    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt; // Aggregate의 루트 엔티티 pk를 참조한다고 생각하자

    // collection을 쓸 때는 이렇게 써야 한다
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tbl_user_setting_map",
            joinColumns = @JoinColumn(name = "user_setting_id")
            // 여기서 Long id를 참조하는 거다
    )

    @MapKeyColumn(name = "name") // Map의 key컬럼명
    @Column(name = "value") // Map의 value 컬럼명
    private Map<String ,String > props;

    public void changeProp(String key, String value)
    {
        this.props.put(key,value);
    }

    public void removeProp(String key)
    {
        this.props.remove(key);
    }
}
