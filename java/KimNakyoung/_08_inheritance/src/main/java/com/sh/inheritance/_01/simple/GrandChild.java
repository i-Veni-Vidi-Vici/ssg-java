package com.sh.inheritance._01.simple;


// 상속은 두개 안됨 근데 이미 상속받은 클래스를 상속받으면 줄줄이 상속
//public class GrandChild extends Child,Perent{
//}
public class GrandChild extends Child {

    // 메소드 오버라이딩 해줘서 바꿔줌 같은명으로 메소드 만들고 안에 내용만 다름
    @Override
    public void introduce(){
        System.out.println("손자입니다~~~~");
    }

}
