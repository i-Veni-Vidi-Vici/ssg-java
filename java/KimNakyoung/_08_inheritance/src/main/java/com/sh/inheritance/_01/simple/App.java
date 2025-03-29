package com.sh.inheritance._01.simple;

/**
 * <pre>
 * 상속(inheritance) ->  단방향 ( 부모 -> 자식)
 * - 부모클래스의 자산(필드 / 메소드)을 자식에게 물려주는 것.
 * - 자식클래스는 선언없이 부모클래스의 필드 / 메소드를 사용할 수 있다.
 * - 메소드를 재작성할 수 있다.
 * - 단일 상속만 가능하다.
 * - 모든 클래스의 최상위 클래스는 object이다.
 *
 * - 자식클래스는 부모클래스를 확장(extends)한다. -> 물려받은 필드/메소드외에도 추가로 필드/메소드 작성이 가능하다.
 * - public class 자식 클래스 extends 부모클래스 {} // extends s 빼먹지 마세요
 * </pre>
 */


public class App {
    public static void main(String[] args) {

        //자식클래스는 선언없이 부모클래스의 필드 / 메소드를 사용할 수 있다. 예시

        // Parent 객체
        Perent perent= new Perent();
        perent.name = "홍길동"; // 필드 직접 접근
        perent.age = 33;
        perent.introduce(); // 애비다
        System.out.println(perent.info());
//        perent.game(); // 상속은 단방향이다. 부모클래스는 자식클래스에 접근할 수 없다.


        // Child 객체
        Child child = new Child(); // 지금 차일드 몸통 비어 있지만 상속받아서 쓰기 가능
        child.name = "홍난파"; // 물려받아서  name 과 age 공간이 있구나
        child.age = 22;
        child.introduce(); // 자식입니다 // 재작성하면 재작성한 메소드가 우선실행! 오버라이딩 함
        System.out.println(child.info());
        child.game();

        // GrandChild 객체
        GrandChild grandChild = new GrandChild();
        grandChild.name = "홍진경";
        grandChild.age = 15;
        grandChild.introduce(); // 자식입니다~~ -> 손자입니다.
        System.out.println(grandChild.info());
        grandChild.game();



    }
}
