package com.sh.encapsulation;

/**
 * <pre>
 * 은행계좌 자료형
 * - name : String
 * - balance : int
 *
 * 접근제한자 Access Modifier
 * -클래스 / 필드 / 메소드의 사용범위를 한정하는 것.
 *
 * (개방)
 * - public // 모든 패키지의 클래스에서 접근 가능
 * - protected // 같은 패키지 접근가능 + 자식클래스 접근 가능
 * - default(package) 같은 패키지에서만 접근 가능, 키워드를 작성하지 않는다.
 * - private 같은 클래스에서만 접근이 가능
 * (폐쇄적)
 * </pre>
 */
public class Account {
    private String name;
    private long balance;//잔액

    public void init(String name, int balance) {
        //현재 객체를 가르키는 숨은 참조변수
        //이름충돌이 있는 경우 전역변수를 가리킬 수 있다.
        this.name=name;
        this.balance=balance;
    }
    public void deposit(int money) {
        //유효성 검사
        if (money <= 0) {
            System.out.println("유효한 입금액이 아닙니다");
            return; //조기 리턴
        }
        //입금처리
        balance+=money;
    }
    public void withdraw(int money) {
        //유효성 검사1 - 0,음수가 아니여야 한다
        //유효성 검사2 - 잔액과 같거나 작은금액을 출금해야 한다.
        if(money<=0)
        {
            System.out.println("유요한 출금액이 아닙니다 - " + money + "원");
            return;
        }
        if(money>balance)
        {
            System.out.println("잔액이 부족합니다 - "+money+"원");
        }
        balance-=money;

        //출금 처리
    }

    public void printInfor() {
        System.out.println(name+"님은 잔액은 "+ balance+" 원입니다");
    }


}
