package com.sh.app._01.sns.member;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Picture implements Serializable {
    private String pictureName;
    private String path;
}
