package com.sh.encapsulation;

/**
 * 객체지향의 3대원칙
 * 1.캡슐화
 * 2.상속
 * 3.다형성
 * 캡슐화
 * -필드/메소드를 클래스 내부에 함께 작성하는 것.
 * -private 필드의 직접접근을 방지하고, public 메소드를 통해 제어하는 것.
 * -은닉화(중요한 정보를 외부에 숨기는 것)
 */
public class App {
    public static void main(String[] args) {
        Account account = new Account();
        //초기값 설정
        account.init("홍길동",1_000_000);

        account.printInfo();
        account.deposit(1_000_000);
        //account.balance=1_000_000;

        //System.out.println(account.name+"님의 잔액은 "+account.balance+"원 입니다.");
        account.printInfo();
        //입금
        //account.balance += 1_000_000;
        //System.out.println(account.name+"님의 잔액은 "+account.balance+"원 입니다.");
        //출금
        account.withdraw(500_000);
        account.withdraw(2000000);
        //account.balance -=500_000;
        //System.out.println(account.name+"님의 잔액은 "+account.balance+"원 입니다.");
        account.printInfo();
    }
}
