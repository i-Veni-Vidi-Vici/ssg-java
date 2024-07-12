package com.sh.app._04.grouping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuStatByCategoryDto {
    private Long categoryCode;
    private Double avgMenuPrice;
}
