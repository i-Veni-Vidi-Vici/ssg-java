package com.sh._01.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receiver {
    private String receiverName; // 수취인 이름, 받는사람
    private String receiverPhone;
    private String receiverMessage;
}
