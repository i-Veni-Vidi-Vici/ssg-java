package com.sh.app._01.aggregate;

import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE) // 외부에서 값을 임의로 변경하는 것을 방지
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
    private Long productId; // 상품객체를 직접참조하지 않고, 실제 PK값만 참조한다.
    private int count;
    private int price;
}
