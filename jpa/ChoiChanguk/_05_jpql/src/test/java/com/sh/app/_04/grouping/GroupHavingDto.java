package com.sh.app._04.grouping;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupHavingDto {

    private Long categoryCodeCnt;
    private Long count;
}
