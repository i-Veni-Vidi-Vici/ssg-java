package com.sh.order.model.dto;

import lombok.*;

/*@NoArgsConstructor// 기본 생성자
@AllArgsConstructor// 모든 매개인자 생성자
@Getter
@Setter
@ToString*/
@Data // @ToString, @EqualsAndHashCode, @Getter / @Setter and
// @RequiredArgsConstructor 이건 final 필드에 대해서 만들어준다
@NoArgsConstructor// mybatis가 호출할 때 저절로 생성자를 먼저 건드린다
@AllArgsConstructor
public class OrderMenuDto {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
}
