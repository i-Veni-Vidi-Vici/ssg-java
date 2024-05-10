package com.sh.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    CREATE_ORDER_ERROR("주문 중 오류가 발생했습니다."),
    FIND_ALL_MENU_ERROR("메뉴 전체 조회중 오류가 발생했습니다."),
    USER_INVALID_INPUT_ERROR("사용자 입력값이 유효하지 않습니다.");

    @Getter // 필드 레벨에 작성 (특정 필드만 getter 생성)
    final String msg;

    ErrorCode(String msg) {
        this.msg = msg;
    }
}
