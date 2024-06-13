package com.sh.spring.common.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultAccount implements Account{
    private int bankCode;
    private String accountNo;
    private long balance;

    @Override
    public String getBalanceInfo() {
        return this.accountNo + "계좌의 현재 잔액은 " + this.balance + "원입니다.";
    }

    @Override
    public String deposit(int money) {
        String result = "";
        if(money > 0){
            this.balance += money;
            result = money + "원이 입금되었습니다.";
        }else{
            result = "유효하지 않은 입금액입니다.";
        }
        return result;
    }

    @Override
    public String withdraw(int money) {
        String result = "";
        if(money <= this.balance){
            this.balance -= money;
            result = money + "원이 출금되었습니다";
        }else{
            result = "잔액이 부족합니다";
        }
        return result;
    }
}

