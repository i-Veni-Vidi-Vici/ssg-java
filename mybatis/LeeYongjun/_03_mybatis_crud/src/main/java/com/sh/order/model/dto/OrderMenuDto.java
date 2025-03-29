package com.sh.order.model.dto;

import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
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
