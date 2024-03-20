package com.sh.custom.type.encapsulation;

/**
 * <pre>
 *     객체지향의 3대 원칙
 *     1. 캡슐화   encapsulation
 *     2. 상속    inheritance
 *     3. 다형성   polymorphism
 *
 *     캡슐화 Encapsulation
 *     - 필드와 메소드를 클래스 내부에 함께 작성하는것
 *     - private 필드의 직접 접근을 방지하고, 메소드를 통해 제어하는 것
 *     - 은닉화 (중요한 정보를 외부에 숨기는것)
 *
 * </pre>
 */
public class App {
    //은행 계좌 관리
    public static void main(String[] args) {
        Account account = new Account();
//        account.name = "홍길동";
//        account.balance = 1_000_000;
        account.init("홍길동", 1_000_000);
        account.printInfo();
        //입금
//        account.balance += 1_000_000;
//        System.out.println(account.name+"님의 잔액은 " + account.balance+"원 입니다.");
        account.deposit(1_000_000);
        account.printInfo();
//        System.out.println(account.name+"님의 잔액은 " + account.balance+"원 입니다.");
        account.deposit(-500_000);

        //출금
//        account.balance -= 500_000;
//        System.out.println(account.name+"님의 잔액은 " + account.balance+"원 입니다.");
        account.withdraw(5000);
        account.printInfo();
//        System.out.println(account.name+"님의 잔액은 " + account.balance+"원 입니다.");
        account.withdraw(-3000);

    }


}
