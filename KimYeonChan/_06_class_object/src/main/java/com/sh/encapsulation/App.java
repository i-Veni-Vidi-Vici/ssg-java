package com.sh.encapsulation;

/**
 * 객체지향의 3대 원칙
 * 1. 캡슐화
 * 2. 상속
 * 3. 다향성
 * 캡슐화 Encapsulation
 * - 서로 관련 있는 필드/메소드를 클래스 내부에 함께 작성하는 것.
 * - private 필드의 직접접근을 방지하고, public 메소드를 통해 제어하는 것
 * - 은닉화 (중요한 정보를 외부에 숨기는 것)
 */
public class App {
    public static void main(String[] args) {
        // 은행계좌 관리
        Acount acount = new Acount();
        // 초기값 설정
        acount.init("홍길동", 1_000_000);
        acount.printInfo();

        // 입금
        acount.deposit(1_000_000);
        acount.deposit(-1_000_000); // 입금 처리 안됨
        acount.printInfo();

        // 출금
        acount.withdraw(1_000_000);
        acount.withdraw(-1);
        acount.withdraw(1_000_000_000);
        acount.printInfo();
    }
}
