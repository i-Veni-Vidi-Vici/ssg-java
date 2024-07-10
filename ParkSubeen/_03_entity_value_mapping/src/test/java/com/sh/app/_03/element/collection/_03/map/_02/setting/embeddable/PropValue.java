package com.sh.app._03.element.collection._03.map._02.setting.embeddable;

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
