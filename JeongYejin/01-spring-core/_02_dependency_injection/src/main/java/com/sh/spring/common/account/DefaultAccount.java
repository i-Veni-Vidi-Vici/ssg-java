package com.sh.spring.common.account;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class DefaultAccount implements Account {
    private final int bankCode; // final이면 바로 값 대입해야 해서 오류 -> @Date를 붙이면 사라지는 빨간줄!
    // @RequiredArgsConstructor 때문에 사라지는 거임 // 은행코드
    private final String accountNo; // 계좌번호
    private long balance; // 잔액

    @Override
    public String getBalanceInfo() {
        return this.accountNo + "계좌의 현재 잔액은 " + this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) {
        String result = "";
        if (money > 0) {
            this.balance += money;
            result = money + "원이 입금되었습니다.";
        }
        else {
            result = "유효하지 않은 입금액입니다.";
        }
        return result;
    }

    @Override
    public String withdraw(int money) {
        String result = "";
        if (money <= this.balance) {
            this.balance -= money;
            result = money + "원이 출금되었습니다.";
        }
        else {
            result = "잔액이 부족합니다.";
        }
        return result;
    }
}
