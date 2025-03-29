package com.sh.encapsulation;


/**
 * -name: String
 * -balance: int
 *
 * 접근제한자
 * - 필드/메소드/클래스의 사용범위를 한정
 * - (개방적)
 *   public -> 모든 패키지에서 접근 가능
 *   protected -> 동일패키지 + 자식패키지
 *   default -> 동일패키지
 *   private -> 동일클래스
 *   (폐쇠적)
 */
public class Account {
    private String name;
    private long balance;

    Account(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public void init(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public void printInfo(){
        System.out.println("name: " + this.name + " balance: "+ balance);
    }

    public void deposit(int money){
        //유효성 검사
        if(money<=0){
            System.out.println("유효하지 않은 입금 금액입니다.");
            return;
        }
        this.balance += money;
        //입금처리
    }

    public void withdraw(int money){
        if(money<=0){
            System.out.println("유효하지 않은 출금 금액입니다.");
            return;
        }
        else if (this.balance<money) {
            System.out.println("잔액이 부족합니다. 현재 잔액: " + balance + "원");
            return;
        }
        balance-=money;
    }

}
