package com.sh.spring.common.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 상수값으로 필드를 설정했기 때문에 생성자를 작성하지 않는다.
public class DefaultAccount implements Account{
    private int backCode; // 은행코드
    private String accountNo; // 계좌번호
    private long balance; // 잔액

    @Override
    public String getBalanceInfo() {
        return this.accountNo + "계좌의 현재 잔액은 " + this.balance + "원입니다.";
    }

    @Override
    public String deposit(int money) {
        String result = "";
        if (money > 0) {
            this.balance += money;
            result = money + "원이 입금되었습니다.";
        } else {
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
        } else {
            result = "잔액이 부족합니다.";
        }
        return result;
    }
}
