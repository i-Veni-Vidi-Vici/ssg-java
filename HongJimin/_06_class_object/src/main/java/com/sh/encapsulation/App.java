package com.sh.encapsulation;

/**
 * <pre>
 * ✅ **객체 지향의 3대 원칙 - 그냥 외우기🤭, 외우라고 한 것 = 면접 단골 질문!!!**
 *
 * - **캡슐화**
 * - **상속**
 * - **다형성**
 *
 * 캡슐화 **Encapsulation**
 *
 * - 필드 /메소드를 클래스 내부에 함께 작성하는 것
 * - private 필드의 직접접근을 방지하고,  public 메소드를 통해 제어하는 것
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //은행 계좌 관리
        Account account = new Account();

        //초기값 설정
//        account.name = "홍길동"; -> 변수 이름을 private로 호출햇을 경우
//        account.balance = 1_000_000;
        account.init("홍길동", 1_000_000);

        account.printInfo();

        //입금 -> 필드에 직접 접근했을 때, 잘못 적용한 걸 막을 수 없음
//        account.balance += 1_000_000;
//        account.balance += -1_000_000; //음수 입금
//        account.balance *= 1_000_000; //입금 연산 잘못하기

        account.deposit(1_000_000);
        account.deposit(-1_000_000); //입금 처리 안됨 -> 음수인지 유효성 검사를 했기 때문!!!
        account.printInfo();

        //출금
//        account.balance -= 500_000;
//        account.balance -= -500_000; // 음수 출금
//        account.balance -= 5_000_000; // 잔액보다 많은 금액 출금

        account.withdraw(500_000);
        account.withdraw(-500_000); // 출금 처리 안됨 -> 음수인지 유효성 검사를 했기 때문!!!
        account.withdraw(10_000_000); //잔액보다 출금액이 많아서 출금처리 안됨 -> 유효성 검사 2

        account.printInfo();






    }
}
