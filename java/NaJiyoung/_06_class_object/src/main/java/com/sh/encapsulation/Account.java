package com.sh.encapsulation;

/**
 * <pre>
 * 은행계좌 사용자 자료형
 * - name: String
 * - balance: long
 *
 * 접근제한자 Access Modifier
 * - 클래스/필드/메소드의 사용범위를 한정하는 것.
 *
 * (개방적)
 * - public 모든 패키지의 클래스에서 접근 가능
 * - protected 같은 패키지 접근 가능 + 다른 패키지의 자식클래스 접근 가능
 * - default(package) 같은 패키지 접근 가능. 키워드를 작성하지 않는다.
 * - private 같은 클래스에서만 접근 가능
 * (폐쇄적)
 *
 * </pre>
 */
public class Account {
    private String name;
    private long balance;    // 잔액

    /**
     * 초기값 설정 메소드
     * @param name
     * @param balance
     */
    public void init(String name, int balance) {
        // 이름 충돌이 안나는 경우
//        name = _name;
//        balance = _balance;

        // this는 현재 객체를 가리키는 숨은 참조변수
        // 이름충돌이 있는 경우 전역변수를 가리킬 수 있다.
        this.name = name;
        this.balance = balance;
    }

    /**
     * 입금메소드
     */
    public void deposit(int money) {
        // 유효성검사
        if(money <= 0) {
            System.out.println("유효한 입금액이 아닙니다.");
            return; // 조기리턴
        }

        // 입금처리
        balance += money;
    }

    /**
     * 출금메소드
     */
    public void withdraw(int money) {
        // 유효성 검사1 - 0, 음수가 아니어야 한다.
        if(money <= 0) {
            System.out.println("유효한 출금액이 아닙니다. - " + money + "원");
            return;
        }
        // 유효성 검사2 - 잔액과 같거나 작은 금액을 출금해야 한다.
        if(money >= balance) {
            System.out.println("잔액이 부족합니다. - " + money + "원");
            return;
        }

        // 출금처리
        balance -= money;
    }

    public void printInfo() {
        System.out.println(name + "님의 잔액은 " + balance + "원 입니다.");
    }
}
