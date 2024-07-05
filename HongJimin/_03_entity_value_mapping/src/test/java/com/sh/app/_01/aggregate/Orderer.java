package com.sh.app._01.aggregate;

import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Orderer { // 멤버 자체를 갖고 있지 않는 것!
    private Long ordererId; // 주문한 회원 정보, 애그리게이트 경계가 있으므로 직접 회원을 참조하지 않는다. -> 식별자 아님!
    private String ordererName;
}
