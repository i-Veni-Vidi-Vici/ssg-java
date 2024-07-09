package com.sh.app._01.aggregate;

import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Receiver {
    private String receiverName;
    private String receiverPhone;
    private String receiverMessage;
}
