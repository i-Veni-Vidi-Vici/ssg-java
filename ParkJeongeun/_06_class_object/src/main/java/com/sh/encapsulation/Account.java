package com.sh.encapsulation;

/**
 * <pre>
 * 은행계좌 사용자 자료형
 * - name : String
 * - balance : long
 *
 * 접근제한자 Access Modifier
 * - 클래스/필드/메소드의 사용범위를 한정하는 것
 * - 코드를 엉망으로 작성해도 실행이 될 수 있는 것을 필드가 아니라 메소드로 작성할 수 있게 해서 문법적으로 막아도
 *   여전히 필드를 작성할 수 있음 => 접근제한자로 아예 못쓰게 함
 *
 * (개방적)
 * 1. public : 모든 패키지의 클래스에 접근 가능
 * 2. protected : 같은 패키지 접근 가능 + 다른 패키지의 자식클래스 접근 가능
 * 3. default(package) : 같은 패키지 접근 가능. 키워드를 작성하지 않음
 * 4. private : 같은 클래스에서만 접근 가능
 * (폐쇄적)
 *
 * </pre>
 */

public class Account {
    private String name; // private 없으면 default
    private long balance; // 잔액

    /**
     * 입금 메소드
     */
    public void deposit(int money){
        // 유효성 검사
        if (money <= 0){
            System.out.println("유효한 입금액이 아닙니다.");
            return; // 조기리턴 (아래 입금처리X)
        }
        // 입금 처리
        balance += money;
    }

    /**
     * 출금 메소드
     * @param money
     */
    public void withdraw(int money){
        // 유효성 검사1 : 0, 음수가 아니어야 함
        if (money <= 0){
            System.out.println("유효한 출금액이 아닙니다. : " + money + "원");
            return;
        }
        // 유효성 검사2 : 잔액과 같거나 작은 금액을 출금해야 함
        if (money >= balance){
            System.out.println("잔액이 부족합니다. : " + money + "원");
            return;
        }

        // 출금 처리
        balance -= money;
    }

    public void printInfo() {
        System.out.println(name + "님의 잔액은 " + balance + "원입니다.");
    }

    /**
     * 초기값 설정 메소드
     * @param name
     * @param balance
     */
    public void init(String name, int balance) {
        // this는 현재 객체를 가리키는 숨은 참조변수
        // 이름 충돌이 있는 경우 전역변수를 가리킬수 있음
        this.name = name; //전달받은 매개변수 name(init 메소드 내 지역변수)을 위의 전역변수(현재 클래스) name에 대입
        this.balance = balance;
    }
}
