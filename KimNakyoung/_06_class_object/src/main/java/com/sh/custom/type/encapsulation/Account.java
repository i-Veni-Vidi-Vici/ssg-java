package com.sh.custom.type.encapsulation;

/**
 *<pre>
 * 은행계좌 사용자 자료형
 * - name : String
 * - balance : long
 *
 * 접근제한자 Access Modifier
 * - 클래스/ 필드/ 메소드의 사용범위를 한정하는 것
 *
 * (개방적)
 * - pulic 모든 패키지의 클래스에서 접근 가능
 * - protected 같은 패키지 접근 가능 + 다른 패키지의 자식클래스 접근 가능
 * - default(package) 같은 패키지 접근 가능. 키워드를 작성하지 않아야 한다!
 * - private !같은 클래스!에서 접근 가능. 문법적으로 사용자가 실수 할 수도 있으니까 실수 막은 거임
 * (폐쇄적)
 *
 *</pre>
 *
 */
public class Account {
    private String name;
    private long balance; // 금액

    /**
     * 초기값 설정 메서드
     *
     * @param name
     * @param balance
     */

    public void init(String name, int balance) {
//            name = name;
        // this는 현재객체를 가리키는 숨은 참조변수
        // 이름충돌이 있는 경우 전역변수를 가리킬 수 있다. = (같은이름 변수면 가까운 지역변수 name을 사용함)
        this.name = name;
//            balance = balance;
        this.balance = balance;
    }

    /**
     * 입금메소드
     */

    public void deposit(int money) {
    // 유효성 검사

        if(money <= 0) {
            System.out.println("유효한 입금액이 아닙니다.");
            return; // 이거 만나면 하위코드 로 가지 않고 처음으로 옴
        }

        balance += money;
    }

    /**
     * 출금메소드
     */

    public void withdraw(int money) {
        //  유효성 검사 1 - 0, 음수가 아니어야 한다.

        if(money <= 0){
            System.out.println("유효한 출금액이 아닙니다. -" + money);
            return;
        }

        // 유효성 검사2 - 잔액과 같거나 작은 금액을 출금해야 한다.
        if(money > balance) {
            System.out.println("잔액이 부족합니다. - " + money + "원");
            return;

        }
        // 출금처리
        balance -= money;
    }

    public void printInfo() {
        System.out.println(name + "님의 잔액은 " + balance + "원 입니다."); // 그냥 선언한 변수 필드에 접근가능
    }

}




