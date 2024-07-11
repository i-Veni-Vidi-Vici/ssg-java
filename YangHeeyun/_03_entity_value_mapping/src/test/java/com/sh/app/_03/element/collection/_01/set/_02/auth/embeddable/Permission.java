package com.sh.app._03.element.collection._01.set._02.auth.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    @Column(name = "url", nullable = false)
    private String url;
    @Column(name = "description", nullable = false)
    private String description;
}