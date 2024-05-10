package com.sh.order.model.dto;

import lombok.*;

//@NoArgsConstructor // 기본생성자
//@AllArgsConstructor // 모든 매개인자 생성자
//@Getter
//@Setter
//@ToString
@Data // @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class OrderMenuDto {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
}
