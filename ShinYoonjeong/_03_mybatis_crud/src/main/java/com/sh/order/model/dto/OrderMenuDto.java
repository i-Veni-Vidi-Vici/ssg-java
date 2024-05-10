package com.sh.order.model.dto;

import lombok.*;

//@NoArgsConstructor // 기본 생성자
//@AllArgsConstructor // 모든 매개인자 생성자
//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMenuDto {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
}
