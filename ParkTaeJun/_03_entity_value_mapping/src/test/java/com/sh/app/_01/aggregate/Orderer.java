package com.sh.app._01.aggregate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE) // 외부에서 값을 임의로 변경하는 것을 방지
public class Orderer {
    private Long ordererId; // 주문한 회원정보. 애그리게이트 경계가 있으므로 직접 회원을 참조하지 않는다.
    private String ordererName;
}
