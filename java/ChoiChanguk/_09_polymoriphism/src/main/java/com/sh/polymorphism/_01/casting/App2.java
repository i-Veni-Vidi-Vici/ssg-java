package com.sh.polymorphism._01.casting;

/**
 * 다형성이 적용된 객체배열
 * - 다양한 자식객체들 부모타입의 객체배열로 제어할 수 있다.
 */
public class App2 {
    public static void main(String[] args) {
        Animal[] animals=new Animal[5];
        animals[0]=new Rabbit();// 정적바인딩
        animals[1]=new Tiger();
        animals[2]=new Rabbit();
        animals[3]=new Tiger();
        animals[4]=new Rabbit();

        for(int i=0;i<animals.length;i++)
        {
            animals[i].eat();
        }

        //2 다운캐스팅 후 실행
//        if(animals instanceof Tiger)
//        {
//            ((Tiger)animals).bite();
//        }
//
//        if(animals instanceof Rabbit)
//        {
//            ((Tiger)animals).bite();;
//        }
    }
}
