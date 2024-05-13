package com.sh.order.model.dto;

import com.sh.menu.model.dto.MenuDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor // 기본생성자
//@AllArgsConstructor // 모든 매개인자 생성자
//@Getter
//@Setter
//@ToString
@Data // @ToString, @EqualsAndHashCode, @Getter  @Setter @RequiredArgsConstructor
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 매개인자 생성자
public class OrderMenuDto {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
    private MenuDto menu;
}
