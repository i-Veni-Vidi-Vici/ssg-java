package com.sh.app._01.aggregate;

import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Receiver {
    private String receiverName; // 수취인 이름
    private String receiverPhone;
    private String receiverMessage;
}
