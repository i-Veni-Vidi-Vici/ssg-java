package com.sh.custom.type.encapsulation;

/**
 * <pre>
 * 은행 계좌 사용자 자료형
 * - name : String
 * - balance : int
 * </pre>
 */
public class Account {
    /**
     * 접근 제한자 Access modifire
     * - 클래스 / 필드/ 메소드의 사용 범위를 한정 하는 것
     * -(개방적) public - protected - default - private (폐쇄적)
     * public = 모든 패키지
     * protected = 같은 패키지 + 자식 클래스
     * default = 같은 패키지. 키워드를 작성하지 않으면 기본
     * private = 같은 클래스 에서만 접근 가능
     */
    private String name;    //private = 접근 제한자
    private long balance;

    /**
     * 입금 메소드
     */
    public void deposit(int money){
        if(money <= 0 ){
            System.out.println("유효한 입금액이 아닙니다."+ money + "원");
        }
        else{
            //입금처리
            balance += money;
        }
    }
    /**
     * 출금 메소드
     */
    public void withdraw(int money){
        //유효성 검사1 - 0, 음수가 아니어야 한다.
        if(money<=0){
            System.out.println("유효한 금액이 아닙니다. - "+ money + "원");
            return;
        }
        //유효성 검사2 - 잔액과 같거나 작은 금액을 출금해야 한다
        if(money>balance){
            System.out.println("잔액이 부족합니다. - " + money + "원");
            return;
        }
        //출금처리
        balance -= money;
    }   //end of withdraw

    public void printInfo(){
        System.out.println(name+"님의 잔액은 " + balance+"원 입니다.");
    }   //end of withdraw

    public void init(String name, int balance){
        this.name = name;
        this.balance = balance;
    }


}
