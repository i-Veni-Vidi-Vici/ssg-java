package com.sh.encapsulation;

/**
 * 객체지향의 3대원칙 - 면접질문 많이 나옴
 * 1. 캡슐화
 * 2. 상속
 * 3. 다형성
 *
 * 캡슐화 - encapsulation
 * - 필드/메소드를 클래스 내부에 함께 작성하는 것.
 * - private 필드의 직접 접근을 방지하고, 메소드를 통해 제어하는 것이다
 * - 은닉화*중요한 정보를 외부에 숨기는 것
 */
public class App
{
    public static void main(String[] args) {
        Account account=new Account();
        account.init("홍길동",1_000_000);
        account.printInfor();

        //입금
        //account.balance+=1_000_000;
        //account.balance-=1_000_000;//음수 입금
        account.printInfor();

        //출급
        //account.balance -= 1_000_000;
       // account.balance -= 5_000_000;//잔액보다 많이 출금 될 때
        account.withdraw(500_000);
        account.withdraw(-500000);
        account.printInfor();

    }
}
