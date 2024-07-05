package com.sh._03.element.collection._01.set._02.embeddable;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Setter(AccessLevel.PRIVATE)
public class Permission {

    @Column(name = "url",nullable = false)
    private String url;

    @Column(name = "description",nullable = false)
    private String desc;
}
