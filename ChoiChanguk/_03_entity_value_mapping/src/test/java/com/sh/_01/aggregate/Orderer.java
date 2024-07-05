package com.sh._01.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderer {
    private Long orderId; // 주문한 회원정보입니다/ 애그리게이트 경계가 있으므로
    private String ordererName; //
}
