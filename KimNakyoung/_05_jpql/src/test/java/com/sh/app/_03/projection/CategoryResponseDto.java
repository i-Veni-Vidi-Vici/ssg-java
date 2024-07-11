package com.sh.app._03.projection;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//이건 엔티티도 아니고 DTO라서 Setter도 그냥 써도 됨 프라이빗 x
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {
    private Long categoryCode;
    private String categoryName;
    private Integer number;
}
