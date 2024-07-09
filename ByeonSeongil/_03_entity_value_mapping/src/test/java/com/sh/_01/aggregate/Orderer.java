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
public class Orderer {
    private Long ordererId; // 주문한 회원정보. 애그리게이트 경계가 있으므로 직접 회원을 참조하지 않는다.
    private String ordererName;
}
