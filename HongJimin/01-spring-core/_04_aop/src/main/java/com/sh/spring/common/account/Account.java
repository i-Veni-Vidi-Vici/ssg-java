package com.sh.spring.common.account;

public interface Account {
    // 잔액 조회
    String getBalanceInfo();

    //입금
    String deposit(int money);

    //출금
    String withdraw(int money);
}
