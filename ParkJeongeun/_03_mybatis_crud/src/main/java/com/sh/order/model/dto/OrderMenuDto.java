package com.sh.order.model.dto;

import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data // @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor(final필드에 대한 생성자 만들어줌)
@NoArgsConstructor // mybatis에서는 dto 객체에서 기본 생성자 없으면 오류남
@AllArgsConstructor
public class OrderMenuDto {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
}
