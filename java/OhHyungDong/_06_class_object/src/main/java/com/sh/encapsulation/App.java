package com.sh.encapsulation;

/**
 * <pre>
 * 객체지향의 3대원칙
 * 1. 캡슐화
 * 2. 상속
 * 3. 다형성
 *
 *
 *
 * 캡슐화 Encapsulation
 * - 필드/메소드를 클래스 내부에 함께 작성하는 것.
 * - private 필드의 직접 접근을(오용, 실수) 방지하고, public 메소드를 통해 제어하는 것.
 * - 은닉화 (중요한 정보를 외부에 숨기는 것)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //은행 계좌관리
        Account account = new Account();
        //초기값 설정
        account.init("홍길동",1_000_000);

//        account.name = "홍길동";
//        account.balance = 1_000_000;

        account.printInfo();
        //입금
       // account.balance +=1_000_000;
//        account.balance += -1_000_000; //음수 입금
//        account.balance *=1_000_000; //잘못 입금
        account.deposit(1000000);
        account.deposit(-1000000); //입금 처리 안됨.
        account.printInfo();

        //출금
//        account.balance -=500000;
//        System.out.println(account.name + "님의 잔액은" + account.balance + "원 입니다.");
        account.withdraw(500000);
        account.withdraw(500000);
        account.withdraw(10000000);
    }
}
