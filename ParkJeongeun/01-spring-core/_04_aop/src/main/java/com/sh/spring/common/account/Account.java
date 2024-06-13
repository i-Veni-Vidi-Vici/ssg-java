package com.sh.spring.common.account;

public interface Account {
    String getBalanceInfo();
    String deposit(int money);
    String withdraw(int money);
}