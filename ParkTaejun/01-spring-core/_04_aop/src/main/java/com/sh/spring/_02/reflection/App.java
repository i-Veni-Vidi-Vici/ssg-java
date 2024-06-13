package com.sh.spring._02.reflection;

import com.sh.spring.common.member.account.DefaultAccount;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * <pre>
 *
 * 리플렉션이란?
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
//        app.test3();
        app.test4();
    }
//
//    private void test1(){
//        Class clz1 = DefaultAccount.class;
//        System.out.println(clz1);
//
//        Class clz2 = new DefaultAccount(10, "110-234-1234567", 3_000_0000).getClass();
//        System.out.println(clz2);
//        System.out.println(clz1 == clz2);
//
//        Class clz3 = Class.forName("com.sh.spring.common.account.DefaultAccount");
//        System.out.println(clz3);
//        System.out.println(clz1 = clz3);
//
//        // 배열의 클래스객체 생성하기
//
//    }

    /**
     * 필드 제어
     */
    private void test3(){
        DefaultAccount account = new DefaultAccount(20, "100-200-300000", 3_000_000);
        Class<DefaultAccount> clazz = (Class<DefaultAccount>) account.getClass();
        // 필드 객체 가져오기
        Field[] ddeclaredFields = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(ddeclaredFields));

        try {
            Field bankCode = clazz.getDeclaredField("bankCode");
            bankCode.setAccessible(true);
            Object bankCodeValue = bankCode.get(account);
            System.out.println(bankCodeValue);

            // 값
            bankCode.set(account, 30);
            System.out.println(account);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    // 메소드 제어
    public void test4(){
        DefaultAccount account = new DefaultAccount(20, "100-200-300000", 3_000_000);
        Class<DefaultAccount> clazz = (Class<DefaultAccount>) account.getClass();

        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(System.out::println);

        try {
            //1. 매개인자가 없는 메소드
            Method getBalanceMethod = clazz.getDeclaredMethod("getBalance");
            System.out.println(getBalanceMethod);
            // invoke ( 타겟객체, ...매게인자) : Object 리턴값 반환
            Object returnValue = getBalanceMethod.invoke(account);
            System.out.println(returnValue); //3000000

            // 매개인자가 있는 메소드
            Method depositMethod = clazz.getDeclaredMethod("deposit", int.class);
            returnValue = depositMethod.invoke(account, 500_000);
            System.out.println(returnValue);  // 500000원이 입금되었습니다
            System.out.println(account); //DefaultAccount(bankCode=20, accountNo=100-200-300000, balance=3500000)

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
