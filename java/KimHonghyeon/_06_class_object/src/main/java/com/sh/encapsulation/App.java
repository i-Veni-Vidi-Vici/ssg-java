package com.sh.encapsulation;


/**
 * 객체지향의 3대 원칙
 * 1. 캡슐화
 * 2. 상속
 * 3. 다형성
 *
 * 캡슐화
 * - 필드/메소드를 클래스 내부에 함께 작성하는 것
 * - private 필드의 직접접근을 방지, public 메소드를 통해 제어하는 것
 * - 중요한 정보를 외부에 숨기는 은닉화 가능
 */
public class App {
    public static void main(String[] args) {
        Account account = new Account("홍길동", 1000000);
        //account.name = "홍길동";
        //account.balance = 1000000;
        account.deposit(1000000);

        //입금
        //account.balance += 1000000;
        account.deposit(1000000);
        account.deposit(-1000000);

        //출금
        //account.balance -= 500000;
        account.withdraw(500000);
        //System.out.println("account.balance = " + account.balance);
        account.printInfo();

        //필드를 직접 제어하면 의도하지 않은 잘못된 연산 수행할 수 있음. -> 메소드를 통한 제어
    }
}
