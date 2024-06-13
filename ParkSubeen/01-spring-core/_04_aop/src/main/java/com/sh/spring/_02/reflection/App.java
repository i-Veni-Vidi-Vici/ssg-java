package com.sh.spring._02.reflection;

import com.sh.spring.common.account.Account;
import com.sh.spring.common.account.DefaultAccount;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * <pre>
 *
 * 리플렉션 Reflction이란?
 * 컴파일된 자바 코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법으로 반사, 투영 이라는 의미를 가진다.
 * 리플렉션은 JVM에서 실행되는 애플리케이션의 런타임 동작을 검사하거나 수정할 수 있는 기능이 필요한 경우 사용한다.
 * 스프링프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용한다.
 * Reflection을 사용해서 스프링에서는 런타임 시 에 개발자가 등록한 빈을 애플레케이션 내에서 사용할 수 있게 하는 것이다.
 *
 * refletion은 강력한 도구이지만 무분별하게 사용해서는 안된다.
 * 주의사항
 * 1. 오버헤드 발생 : 성능 저하를 발생할 수 있기 때문에 성능에 민감한 애플리케이션에서는 사용하지 않는다.
 * 2. 캡슐화 저해 : private로 설정한 member에 접근 가능하기 때문에 코드 기능이 저하되며 여러 가지 문제를 발생시킬 수 있다.
 *
 * reflection이 무엇인지 예제를 통해 살펴보자 (참고 : https://docs.oracle.com/javase/tutorial/reflect/)
 *
 * 리플렉션이 사용되는 경우
 * 1. IOC컨테이너
 * 2. AOP
 * 3. 마이바티스 매퍼
 * 4. log4jdbc
 *
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        App app = new App();
//        app.test1();
        app.test2();
    }

    private void test2() {
        Class<DefaultAccount> clz = DefaultAccount.class;

        // 생성자 가져오기
        Constructor<DefaultAccount>[] declaredConstructors = (Constructor<DefaultAccount>[]) clz.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        try {
            // 기본생성자로 객체 생성
            // 기본생성자
            Constructor<DefaultAccount> constructor1 = (Constructor<DefaultAccount>) clz.getDeclaredConstructor(null);
            // 객체 생성
            DefaultAccount account1 = (DefaultAccount) constructor1.newInstance(null);
            System.out.println(account1);

            // 생성자로 객체 생성
            // 생성자
            Constructor<DefaultAccount> constructor2 =
                    (Constructor<DefaultAccount>) clz.getDeclaredConstructor(int.class, String.class, long.class);
            // 객체 생성
            DefaultAccount account2 = (DefaultAccount) constructor2.newInstance(30, "111-22-3333333", 1_000_000);
            System.out.println(account2);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 1. 클래스 객체 가져오기
     */
    private void test1() {
        Class clz1 = DefaultAccount.class;
        System.out.println(clz1);

        Class clz2 = new DefaultAccount(10, "110-234-1234567", 0).getClass();
        System.out.println(clz2);

        // 메모리상에 class객체는 하나밖에 없다.
        // 하나의 class를 참조하여 여러 개의 객체를 생성하게 된다.
        System.out.println(clz1 == clz2); // true

        try {
            Class clz3 = Class.forName("com.sh.spring.common.account.DefaultAccount");
            System.out.println(clz3);
            System.out.println(clz1 == clz3); // true

            // 배열의 클래스객체 가져오기
            Class clz4 = Class.forName("[D");
            Class clz5 = double[].class;
            System.out.println(clz4);
            System.out.println(clz5);

            // 참조형 클래스배열의 클래스 객체
            Class clz6 = Class.forName("[Ljava.lang.String;");
            Class clz7 = String[].class;
            System.out.println(clz6);
            System.out.println(clz7);

            // 부모클래스 객체
            Class clz8 = clz1.getSuperclass(); // 부모클래스객체(extends)
            System.out.println(clz8);

            Class[] interfaces = clz1.getInterfaces();
            System.out.println(Arrays.toString(interfaces));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
