package com.sh.inheritance._01.simple;

import java.util.PropertyResourceBundle;

/**
 * <pre>
 *     상속(inheritance)
 * - 모든 클래스의 최상위클래스 = Object
 * - 부모 클래스의 `필드`, `메소드`을 자식 클래스에게 물려주는 것
 * - 자식 클래스는 선언 없이 부모클래스의 `필드`,  `메소드`를 사용할 수 있다.
 * - 메소드를 재작성할 수 있다.
 *     - 재작성할 때, 부모 클랫의 메소드 이름이 완벽하게 같아야 오버라이드가 가능함!
 * - 단일 상속만 가능함
 * - 자식클래스는 부모 클래스를 확장한다 → 물려받은 필드/메소드 외에도 추가로 필드/메소드 작성이 가능하다.
 * - 상속 = 단방향, 부모클래스는 자식 클래스에 접근할 수 없다
 * - 상속 시에는 부모 생성자를 자동으로 먼저 호출한다.
 *     - this( ) 클래스 자신의 다른 생성자 호출
 *     - super() 부모 클래스의 기본 생성자 호출 → 생략 가능
 * - 딱 한 번, 맨 첫 줄에서만 호출 가능
 * - public class `자식 클래스` extends `부모 클래스` { }
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //Parent 객체
        Parent parent = new Parent();
        parent.name = "홍홍홍";
        parent.age = 52;
        parent.introduce(); //애비다~~~
        System.out.println(parent.info()); // 홍홍홍, 52
//        parent.game(); //상속은 단방향이다. 부모클래스는 자식 클래스에 접근할 수 없다.

        //Child 객체
        Child child = new Child();
        child.name = "홍지민";
        child.age = 26;
        child.introduce(); //애비다~~~ ---> 자식입니다~~~~
        System.out.println(child.info()); //홍지민, 26
        child.game();

        //GrandChild 객체
        GrandChild grandChild = new GrandChild();
        grandChild.name = "홍진경";
        grandChild.age = 15;
        grandChild.game();
        grandChild.introduce();//자식입니다~~~~ ---> 손자입니다.
        System.out.println(grandChild.info()
        );
    }
}
