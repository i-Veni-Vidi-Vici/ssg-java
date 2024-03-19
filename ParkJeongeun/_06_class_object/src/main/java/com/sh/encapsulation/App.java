package com.sh.encapsulation;

/**
 * <pre>
 * 객체지향의 3대원칙
 * 1. 캡슐화
 * 2. 상속
 * 3. 다형성
 *
 * 캡슐화 Encapsulation
 * - 필드/메소드를 클래스 내부에 함께 작성하는 것 (자바에서는 무조건 같이 작성)
 * - private 필드의 직접 접근을 방지하고, public 메소드를 통해 제어할 수 있음
 * - 은닉화 됨 : 중요한 정보를 외부에 숨기는 것 (Account 클래시의 name, balance)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 은행계좌관리
        Account account = new Account();
        // 초기값 설정
        account.init("홍길동", 1_000_000); // private 필드 생성 후 init 메소드 생성하여 사용(필드 사용 제한되므로)

//        account.name = "홍길동";
//        account.balance = 1_000_000;

        account.printInfo();
//        System.out.println(account.name + "님의 잔액은 " + account.balance + "원입니다."); // account.printInfo();만들고 지우기

        // 입금
//        account.balance += 1_000_000;
        // 필드에 직접 접근해서 작성하면 문제를 막을 방법이 없음
//        account.balance -= 1_000_000; // 음수 입금
//        account.balance *= 1_000_000; // 입금 연산 잘못하기
        account.deposit(1_000_000);
        account.deposit(-1_000_000); // 입금처리 안됨

        account.printInfo();
//        System.out.println(account.name + "님의 잔액은 " + account.balance + "원입니다.");

        // 출금
//        account.balance -= 500_000;
//        account.balance -= -500_000; // 음수 출금
//        account.balance -= -5_000_000; // 잔액보다 많은 금액 출금
        account.withdraw(3_500_000); // 잔액부족
        account.printInfo();

//        System.out.println(account.name + "님의 잔액은 " + account.balance + "원입니다.");

    }
}
