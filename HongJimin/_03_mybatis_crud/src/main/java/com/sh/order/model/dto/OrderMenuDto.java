package com.sh.order.model.dto;

import lombok.*;

//@NoArgsConstructor // 기본 생성자
//@AllArgsConstructor // 모든 매개인자 생성자
//@Getter
//@Setter
//@ToString
@Data // @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor //@RequiredArgsConstructor -> final필드에 대해 생성자 만들어주는 역할
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 매개인자 생성자

public class OrderMenuDto {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
}
