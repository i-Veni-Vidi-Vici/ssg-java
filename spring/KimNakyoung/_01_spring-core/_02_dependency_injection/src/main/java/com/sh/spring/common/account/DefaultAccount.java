package com.sh.spring.common.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 왜 이거 붙이면 final 관한 오류 사라짐?
//@NoArgsConstructor 밑에 final 상수값인데 기본생성자로 못받아서 안됨
public class DefaultAccount implements Account{
    private final int bankCode; // 은행코드
    private final String accountNo; // 계좌번호
    private long balance; // 잔액

    @Override
    public String getBalanceInfo() {
        return this.accountNo + "계좌의 현재 잔액은 " + this.balance + "입니다.";
    }

    @Override
    public String deposit(int money) {
        String result = "";
        if(money > 0) {
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
