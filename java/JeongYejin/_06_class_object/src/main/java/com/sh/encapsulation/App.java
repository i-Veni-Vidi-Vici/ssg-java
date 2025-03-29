package com.sh.encapsulation;

/**
 * <pre>
 * 객체지향의 3대 원칙
 * 1. 캡슐화 Encapsulation
 * 2. 상속
 * 3. 다형성
 *
 * 캡슐화 Encapsulation
 * - 필드/메소드를 클래스 내부에 함께 작성하는 것
 * - private 필드의 직접 접근을 방지하고, public 메소드를 통해 제어하는 것
 * ㄴ 은닉화 (중요한 정보를 외부로부터 숨김)
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        // 은행계좌관리
        Account account = new Account();
        // 초기값 설정
//        account.name = "홍길동";
//        account.balance = 1_000_000;
        account.init("홍길동" , 0);

        // 입금
//        account.balance += 1_000_000;
        account.deposit(1_000_000);
        account.printInfo();
        //음수입금
        account.deposit(-1_000_000);
        //거래한도초과
        account.deposit(55_000_000);

        // 출금
//        account.balance -= 500_000;
        account.withdraw(500_000);
        account.printInfo();
        // 음수출금
        account.withdraw(-1_000_000);
        // 잔액부족
        account.withdraw(4_000_000);

        account.printInfo();
    }
}
