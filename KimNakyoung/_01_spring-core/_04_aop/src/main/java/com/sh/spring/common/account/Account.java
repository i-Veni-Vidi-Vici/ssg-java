package com.sh.spring.common.account;

public interface Account {
    String getBalanceInfo();
    String deposit(int money); // 입금
    String withdraw(int money); // 출금

}
