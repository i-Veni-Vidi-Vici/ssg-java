package com.sh.spring.common.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Data안의 @RequiredArgsConstructor덕분에 상수값을 셋팅해줌 / @NoArgsConstructor을 추가하면 상수값을 어떻게 셋팅할건데? 하면서 오류가 남!
@NoArgsConstructor
@AllArgsConstructor
public class DefaultAccount implements Account {
    private int bankCode; // 은행 코드
    private String accountNo; // 계좌번호
    private long balance; // 잔액


    @Override
    public String getBalanceInfo() {
        return this.accountNo + "계좌의 현재 잔액은 " + this.balance + "원 입니다.";
    }

    //입금
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

    //출금
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
