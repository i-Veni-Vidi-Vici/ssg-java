package com.sh.spring._02.reflection;

import com.sh.spring.common.account.Account;
import com.sh.spring.common.account.DefaultAccount;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;

import java.lang.reflect.Constructor;
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
//        app.test2();
//        app.test3();
        app.test4();
    }

    private void test1() {
        Class clz1 = DefaultAccount.class;
        System.out.println(clz1);

        Class clz2 = new DefaultAccount(10, "110-123-12345678", 0).getClass();
        System.out.println(clz2);
        System.out.println(clz1 == clz2);

        try {
            Class clz3 = Class.forName("com.sh.spring.common.account.DefaultAccount");
            System.out.println(clz3);
            System.out.println(clz1 == clz3);

            // 배열 클래스객체 가져오기
            Class clz4 = Class.forName("[D");
            Class clz5 = double[].class;
            System.out.println(clz4);
            System.out.println(clz5);

            // 참조형 클래스 배열의 클래스 객체
            Class clz6 = Class.forName("[Ljava.lang.String;");
            Class clz7 = String[].class;
            System.out.println(clz6);
            System.out.println(clz7);

            // 부모클래스 객체
            Class clz8 =  clz1.getSuperclass();
            System.out.println(clz8);

            Class[] clz9 = clz1.getInterfaces();
            System.out.println(Arrays.toString(clz9));


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // 생성자 제어
    private void test2() {
        Class<DefaultAccount> clz = DefaultAccount.class;

        // 생성자 가져오기
        Constructor<DefaultAccount>[] constructors = (Constructor<DefaultAccount>[]) clz.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));

        try {
            Constructor<DefaultAccount> constructor1 = clz.getDeclaredConstructor(null);
            DefaultAccount account1 = (DefaultAccount) constructor1.newInstance(null);
            System.out.println(account1);

            Constructor<DefaultAccount> constructor2 = (Constructor<DefaultAccount>) clz.getDeclaredConstructor(int.class, String.class, long.class);
            DefaultAccount account2 = (DefaultAccount) constructor2.newInstance(30, "111-123-444444", 1_000_000);
            System.out.println(account2);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    // 필드 제어
    private void test3() {
        DefaultAccount account = new DefaultAccount(20, "100- 200-300000", 3_000_000);
//        Class<DefaultAccount> clazz = (Class<DefaultAccount>) account.getClass();
        Class<?> clazz = account.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
        // [private int com.sh.spring.common.account.DefaultAccount.bankCode,
        // private java.lang.String com.sh.spring.common.account.DefaultAccount.accountNumber,
        // private long com.sh.spring.common.account.DefaultAccount.balance]

        try {
            Field bankCode = clazz.getDeclaredField("bankCode");
            // private 접근제한자 해체
            bankCode.setAccessible(true);
            // 필드값 가져오기
            Object bankCodeValue = bankCode.get(account);
            System.out.println(bankCodeValue); // 20

            // 필드값 설정
            bankCode.set(account, 30);
            System.out.println(account); // DefaultAccount(bankCode=30, accountNumber=100- 200-300000, balance=3000000)
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // 메소드 제어
    private void test4() {
        DefaultAccount account = new DefaultAccount(20, "100- 200-300000", 3_000_000);
        Class<?> clazz = account.getClass();

        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(System.out::println);
//        public boolean com.sh.spring.common.account.DefaultAccount.equals(java.lang.Object)
//        public java.lang.String com.sh.spring.common.account.DefaultAccount.toString()
//        public int com.sh.spring.common.account.DefaultAccount.hashCode()
//        public int com.sh.spring.common.account.DefaultAccount.getBankCode()
//        public java.lang.String com.sh.spring.common.account.DefaultAccount.getAccountNumber()
//        public java.lang.String com.sh.spring.common.account.DefaultAccount.getBalanceInfo()
//        public void com.sh.spring.common.account.DefaultAccount.setBankCode(int)
//        public void com.sh.spring.common.account.DefaultAccount.setAccountNumber(java.lang.String)
//        protected boolean com.sh.spring.common.account.DefaultAccount.canEqual(java.lang.Object)
//        public long com.sh.spring.common.account.DefaultAccount.getBalance()
//        public java.lang.String com.sh.spring.common.account.DefaultAccount.deposit(int)
//        public java.lang.String com.sh.spring.common.account.DefaultAccount.withdraw(int)
//        public void com.sh.spring.common.account.DefaultAccount.setBalance(long)

        try {
            // 1. 매개인자 없는 메소드
            Method getBalanceMethod = clazz.getDeclaredMethod("getBalance");
            System.out.println(getBalanceMethod);

            // invoke (타겟객체, ...매개인자): Object 리턴값을 반환한다.
            Object returnValue = getBalanceMethod.invoke(account);
            System.out.println(returnValue); // 3000000

            // 2. 매개인자 있는 메소드
            Method depositMethod = clazz.getDeclaredMethod("deposit", int.class);
            returnValue = depositMethod.invoke(account, 500_000);
            System.out.println(returnValue); // 500000원이 입금되었습니다.
            System.out.println(account); // DefaultAccount(bankCode=20, accountNumber=100- 200-300000, balance=3500000)
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
