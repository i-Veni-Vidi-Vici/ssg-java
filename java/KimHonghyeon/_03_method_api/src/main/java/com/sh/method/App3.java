package com.sh.method;

public class App3 {

    /**
     * 매개뱐수(Parameter)
     * -메소드 선언부에 선언한 변수(메모리 공간 할당)
     * -메소드 호출 시 매개인자가 대입된다.
     * -메소드 안에서 선언된 지역 변수와 동일하다.
     * 매개인자(Argument)
     * -메소드 호출부에서 전달하는 값.
     * -메소드 호출 시 매개변수에 대입되어 사용됨.
     *
     */
    public static void main(String[] args) {
        App3 app = new App3();
        String name = "홍길동";
        app.printName(name);
        name = "신사임당";
        app.printName(name);
        //자바에서 선언부와 호출부의 매개변수-매개인자는 타입과 개수가 정확히 일치해야 한다.
        app.printUsernameAndAge("honggd", 33);
        app.printUsernameAndAge("sinsa", 45);
        // 매개인자와 매개변수의 타입은 일치해야 한다.
        byte bNum = 100;
        app.test(bNum);
        long lNum = 1L;
        app.test((int)lNum); // long->int 명시적 형변환 필요.
        // 연산식으로 작성하면, 우선적으로 계산하고 결과를 전달한다. 
    }

    public void printName(String name){
        System.out.println("이름은 "+name+" 입니다.");
    }

    public void printUsernameAndAge(String userName, int age){
        System.out.println("-------------------------");
        System.out.println("이름은 " + userName + " 나이는 " + age + " 입니다.");
        System.out.println("-------------------------");
    }

    public void test(int n){
        System.out.println("n = " + n);

    }
}
