package com.sh._03.element.collection._02.list._03.map._02.setting.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class PropValue {
    @Column(name = "value", nullable = false)
    private String value;
    @Column(name = "enabled")
    private boolean enabled;
}
