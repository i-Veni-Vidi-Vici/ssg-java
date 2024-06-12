package com.sh.spring.common.member.account;


import lombok.Data;

@Data  // 왜 Data 하면 오류 사라지는지?
public class DefaultAccount implements Account {

    private final int bankCode;
    private final String accountNo;
    private long balance;

    @Override
    public String getBalanceInfo() {
        return this.accountNo + "계좌의 현재 잔액은" + this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) {
        String result = "";
        if(money > 0) {
            this.balance += money;
            result = money + "원이 입금 되었습니다.";
        }else {
            result = "유효하지 않은 입금액 입니다";
        }
        return result;

    }



    @Override
    public String withdraw(int money) {
        String result = "";
        if (money <= this.balance){
            this.balance -= money;
            result = money + " 원이 출금되었습니다.";
        }else {
            result = "잔액이 부족합니다.";
        }
        return result;
    }
}
