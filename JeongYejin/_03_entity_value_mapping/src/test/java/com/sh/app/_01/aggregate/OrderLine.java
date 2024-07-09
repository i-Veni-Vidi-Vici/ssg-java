package com.sh.app._01.aggregate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class OrderLine {
    private Long productId; // 상품객체를 직접참조하지 않고, 실제 PK값만 참조한다.
    private int count;
    private int price;
}
