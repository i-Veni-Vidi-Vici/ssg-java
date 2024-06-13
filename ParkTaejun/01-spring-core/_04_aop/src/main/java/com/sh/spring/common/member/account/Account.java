package com.sh.spring.common.member.account;

public interface Account {
    String getBalanceInfo();
    String deposit(int money);
    String withdraw(int money);
}
