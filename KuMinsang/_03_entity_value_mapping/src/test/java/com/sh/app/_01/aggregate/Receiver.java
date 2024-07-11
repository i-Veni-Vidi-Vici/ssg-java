package com.sh.app._01.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receiver {
    //수신자 정보를 Receiver 클래스로 관리한다.
    private String receiverName;
    private String receiverPhone;
    private String receiverMessage;
    //주소관련 정보를 Address 클래스로 관리한다
}
