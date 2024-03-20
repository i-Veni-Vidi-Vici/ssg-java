package com.sh.encapsulation;


/**
 * <pre>
 *   은행 계좌 사용자 자료형
 *  - name : String
 *  - balance : long
 *
 *  접근 제한자 Access Modifier
 *  - 클래스/ 필드 / 메소드의 사용 범위를 한정하는 것
 *  -
 * </pre>
 */

public class Account {
    private String name; //이름
    private long balance; // 잔액

    /**
     * 초기값 설정 메소드
     * @param name
     * @param balance
     */
    public void init(String name, int balance) {
        //이름 충돌이 안나는 경우
//        name = _name;
//        balance = _balance;

        //this는 현재 객체를 가리키는 숨은 참조 변수 -> this.name = 위의 private String name과 같음
        //이름 충돌이 있는 경우, 전역 변수를 가리킬 수 있음!
        this.name = name;
        this.balance = balance;
    }

    /**
     * 입금 메소드
     */

    public void deposit(int money) {
        //유효성 검사
        if(money <= 0) {
            System.out.println("유효한 입금액이 아닙니다.");
            return; //조기 리턴 -> 밑의 입금 처리(하위코드)를 실행하지 않기 위함!
        }

        //입금처리
        balance += money;

    }

    /**
     * 출금 메소드
     */

    public void withdraw(int money) {
        //유효성 검사1 - 0,  음수가 아니어야 함
        if(money <=0 ) {
            System.out.println("유효한 출금액이 아닙니다." + money + "원");
            return; //조기 리턴 -> 밑의 출금 처리(하위코드)를 실행하지 않기 위함!
        }
        //유효성 검사2 - 잔액과 같거나 작은 금액을 출금해야 한다.
        if(money > balance) {
            System.out.println("잔액 부족합니다." + money + "원");
            return; //조기 리턴
        }

        //출금 처리
        balance -= money;
    }

    public void printInfo() {
        System.out.println(name + "님의 잔액은 " + balance + "원 입니다.");
    }


}
