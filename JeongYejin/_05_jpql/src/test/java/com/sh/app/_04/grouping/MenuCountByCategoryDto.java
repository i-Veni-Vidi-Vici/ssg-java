package com.sh.app._04.grouping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuCountByCategoryDto {
    private Long categoryCode;
    private Long countMenu;
}
