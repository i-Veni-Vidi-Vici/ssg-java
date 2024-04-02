package com.sh.polymorphism._03._interface;

public interface IProduct {
//    public static final int MAX_NUM = 100 ;
     int MAX_NUM = 100 ;
//    public abstract void printInfo();
     void printInfo();


//     public void method(){} , 일반 메소드를 작성할 수 없다

     /**
      * 자식
      */
     public default void defaultMethod(){
          System.out.println("~~~~호출");
     }
     /**
      * 객체 생성없이 바로 사용이 가능하다
      */
     public static void staticMethod(){}
}
