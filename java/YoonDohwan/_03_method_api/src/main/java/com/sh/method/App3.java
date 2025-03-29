package com.sh.method;
/*
매개변수 Parameter
-메소드 선언부에 작성된 변수(공간)
-메소드 호출시 매개인자가 대입된다.
-메소드안에 선언된 변수와 동일하다.
매개인자 Argument
-메소드 호출부에서 전달하는 값
-메소드 호출시에 매개변수에 대입되어 호출시 사용된다.
 */

public class App3 {
    public static void main(String[] args){
        App3 app = new App3();
        String name = "홍길동";
        app.PrintNameAndAge("홍길동",36); //변수를 사용해도 변수의 값이 매개인자로써 사용된다.
        app.PrintNameAndAge("신사임당",45);
        //자바에서 선언부와 호출부의 매개변수-매개인자는 정확히 일치해야 한다.
        byte bnum=100;
        app.test(bnum);
        long lnum=1L;
        app.test((int)lnum);
    }
   /* public void printName(String name){
        System.out.println("이름은 " +name+" 입니다");
    }
    */
   public void PrintNameAndAge(String id,int age){
        System.out.println("이름은 "+ id + " 나이는 "+age +" 입니다");
    }

   public void test(int n){
       System.out.println(n);
   }
}
