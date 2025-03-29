package com.sh._01.aggregate;

import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
    private Long productId; // 상품 id // 상품객체를 직접 참조하지 않고, 실제 pk값만 참조한다.
    private int count; // 몇개 주문했는지
    private int price;
}
