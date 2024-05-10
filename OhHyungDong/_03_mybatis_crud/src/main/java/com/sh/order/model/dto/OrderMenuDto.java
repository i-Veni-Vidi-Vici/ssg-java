package com.sh.order.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

//@NoArgsConstructor //기본 생성자
//@AllArgsConstructor // 모든 매개인자 생성자
//@Getter
//@Setter
//@ToString
@Data //@ToString, @EqualsAndHashCode, @Getter , @Setter, @RequiredArgsContructor
@NoArgsConstructor //기본 생성자
@AllArgsConstructor // 모든 매개인자 생성자
public class OrderMenuDto {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
}
