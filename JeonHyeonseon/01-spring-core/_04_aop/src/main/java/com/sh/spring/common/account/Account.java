package com.sh.spring.common.account;

public interface Account {
    String getBalanceInfo(); // 잔액 조회
    String deposit(int money); // 입금
    String withdraw(int money); // 출금
}
