package com.sh.app._01.sns.member;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Picture {
    private String pictureName;
    private String path;
}
