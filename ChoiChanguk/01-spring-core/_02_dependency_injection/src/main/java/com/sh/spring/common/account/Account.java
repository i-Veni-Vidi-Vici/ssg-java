package com.sh.spring.common.account;

public interface Account {
    // 잔액을 조회

    String getBalanceInfo();
    String deposit(int money);
    String withdraw(int money);
}
