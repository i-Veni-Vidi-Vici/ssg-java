package com.sh.app._01.aggregate;

import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE) // 외부에서 값을 임의로 변경하는 것을 방지
@NoArgsConstructor
@AllArgsConstructor
public class Receiver {
    private String receiverName;
    private String receiverPhone;
    private String receiverMessage;
}
