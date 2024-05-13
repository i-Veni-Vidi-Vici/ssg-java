package com.sh.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    CREATE_ORDER_ERROR("주문 중 오류가 발생했습니다."),
    FIND_ALL_MENU_ERROR("메뉴 전체 조회 중 오류가 발생했습니다."),
    USER_INVALID_INPUT_ERROR("사용자 입력값이 유효하지 않습니다.");

    // 클래스레벨에 작성하면 모든 필드에 대한 getter생성
    // 필드레벨에 작성하면 특정 필드의 getter만 생성
    @Getter
    final String msg;
}
