package com.sh.app._01.aggregate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Receiver {
    private String receiverName;
    private String receiverPhone;
    private String receiverMessage;
}
