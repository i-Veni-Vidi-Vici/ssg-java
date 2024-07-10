package com.sh.app._01.aggregate;

public class Orderer {
    private Long ordererId; // 주문한 회원정보. aggregate경계가 있으므로 직접 회원을 참조하지 않음
    private String ordererName;
}