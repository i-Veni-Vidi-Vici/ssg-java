package com.sh._01.aggregate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Receiver {
    private String receiverName;
    private String receiverPhone;
    private String receiverMessage;
}
