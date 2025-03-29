package com.sh.spring._02.reflection;

import com.sh.spring.common.account.Account;
import com.sh.spring.common.account.DefaultAccount;

import java.io.File;
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
        App app=new App();
//        app.test1(); // 클래스 객체 가져오기
//        app.test2(); // 생성자 - 객체생성
//        app.test3(); // 필드 제어 필드.get(어떤 개체) ,
        app.test4(); // 메소드 제어
    }

    private void test4() {
        /**
         * 4. 메소드 제어
         */

        DefaultAccount account=new DefaultAccount(20,"100-200-300000",3_000_000);
        Class<DefaultAccount> classes = (Class<DefaultAccount>) account.getClass();

        Method[] declaredMethods = classes.getDeclaredMethods();
        System.out.println("모든 메소드가 나온다");
        Arrays.stream(declaredMethods).forEach(System.out::println);
//        public boolean com.sh.spring.common.account.DefaultAccount.equals(java.lang.Object)
//        public java.lang.String com.sh.spring.common.account.DefaultAccount.toString()
//        public int com.sh.spring.common.account.DefaultAccount.hashCode()
//        public java.lang.String com.sh.spring.common.account.DefaultAccount.getBalanceInfo()
//        public java.lang.String com.sh.spring.common.account.DefaultAccount.deposit(int)
//        public int com.sh.spring.common.account.DefaultAccount.getBankCode()
//        protected boolean com.sh.spring.common.account.DefaultAccount.canEqual(java.lang.Object)
//        public long com.sh.spring.common.account.DefaultAccount.getBalance()
//        public java.lang.String com.sh.spring.common.account.DefaultAccount.getAccountNo()
//        public java.lang.String com.sh.spring.common.account.DefaultAccount.withdraw(int)
//        public void com.sh.spring.common.account.DefaultAccount.setBankCode(int)
//        public void com.sh.spring.common.account.DefaultAccount.setBalance(long)
//        public void com.sh.spring.common.account.DefaultAccount.setAccountNo(java.lang.String)

        try {
            // 1. 매개인자 없는 메소드
            Method getBalanceMethod = classes.getDeclaredMethod("getBalance");
            System.out.println("getBalanceMethod = " + getBalanceMethod);

            // invoke(타겟객체, ...매개인자) : Object 리턴값을 반환한다
            Object returnValue = getBalanceMethod.invoke(account);// 어느 객체에서 getBalanceMethod 인가?? // getBalanceMethod만큼의 arguement를 쓸 수 있다
            System.out.println("returnValue = " + returnValue);

            // 2. 매개인자 있는 메소드
            Method depositMethod = classes.getDeclaredMethod("deposit", int.class);
            Object depositReturnValue = depositMethod.invoke(account, 500_000);// invoke도 호출 함수 이다
            System.out.println("depositReturnValue = " + depositReturnValue);
            System.out.println("account = " + account);





        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }


    private void test3() {
        /**
         * 3. 필드 제어
         */
        DefaultAccount account=new DefaultAccount(20,"100-200-300000",3_000_000);

        // 이렇게 해도 된다
//        Class<DefaultAccount> classes = (Class<DefaultAccount>) account.getClass();
        Class<?> classes =account.getClass();

        // 필드 객체 가져오기
        Field[] declaredFields = classes.getDeclaredFields();
        System.out.println("declaredFields : "+Arrays.toString(declaredFields));
//        declaredFields :
//        [private int com.sh.spring.common.account.DefaultAccount.bankCode,
//         private java.lang.String com.sh.spring.common.account.DefaultAccount.accountNo,
//         private long com.sh.spring.common.account.DefaultAccount.balance]


        try {
            Field declaredFields1 = classes.getDeclaredField("bankCode");
            System.out.println("declaredFields1 = " + declaredFields1);
//            private int com.sh.spring.common.account.DefaultAccount.bankCode


            Field bankCode=classes.getDeclaredField("bankCode");
            System.out.println("bankCode = " + bankCode);


//            bankCode 필드가 private라서 안된다, 그래서 public으로 하면 접근이 된다
//            Object bankCodeValue=bankCode.get(account);
//            System.out.println("bankCodeValue = " + bankCodeValue);

            // private라도 힘이 쎄서 바로 접근이 가능하다
            bankCode.setAccessible(true);
            System.out.println("(setAccessible)bankCode = " + bankCode);

            // bankCode 필드값 설정
            bankCode.set(account,30);
            System.out.println("(필드 값 바뀐 후)account = " + account); // bankCode = 30으로 바뀜


        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 1. 클래스 객체 가져오기
     */
    private void test1() {
        //가져오는 방법
        Class clz1= DefaultAccount.class;
        System.out.println("clz1 = " + clz1);

        Class clz2=new DefaultAccount(10,"110-234-5687",0).getClass();
        System.out.println("clz2 = " + clz2);

//        clz1 = class com.sh.spring.common.account.DefaultAccount
//        clz2 = class com.sh.spring.common.account.DefaultAccount

        System.out.println(clz1==clz2); // true

        try {
            Class clz3=Class.forName("com.sh.spring.common.account.DefaultAccount");
            System.out.println("clz3 = " + clz3);

            System.out.println(clz1==clz3);


            //참조형 클래스배열의 클래스 객체
            Class clz4=Class.forName("[D");
            Class clz5=Class.forName("[Ljava.lang.String;");
            System.out.println("clz4 = " + clz4);
            System.out.println("clz5 = " + clz5);

            // 참조형 클래스배열의 클래스 객체
            System.out.println("참조형 클래스배열의 클래스 객체");
            Class clz6=Class.forName("[Ljava.lang.String;");
            Class clz7=String[].class;
            System.out.println("clz6 = " + clz6);
            System.out.println("clz7 = " + clz7);

            // 부모클래스의 클래스 객체
            System.out.println("부모클래스의 클래스 객체");
            Class clz8=clz1.getSuperclass(); // 부모클래스객체 (extends)
            System.out.println("clz8 = " + clz8);

            //부모인터페이스 클래스 객체
            System.out.println("부모인터페이스 클래스 객체");
            Class[] interfaces = clz1.getInterfaces();
            System.out.println(Arrays.toString(interfaces));


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 2. 생성자 - 객체 생성
     */
    private void test2()  {
        Class<DefaultAccount> clz=DefaultAccount.class;

        // 생성자 가져오기
        System.out.println("생성자 가져오기");
        Constructor<DefaultAccount>[] declaredConstructor = (Constructor<DefaultAccount>[]) clz.getDeclaredConstructors();
        System.out.printf("declaredConstructor = ");
        System.out.println(Arrays.toString(declaredConstructor));


        try {

            Constructor<DefaultAccount> constructor1=(Constructor<DefaultAccount>) clz.getDeclaredConstructor();
            DefaultAccount account1=(DefaultAccount) constructor1.newInstance(null); // 객체를 만드는 방법 중에 하나이다
            System.out.println("account1 = " + account1);

                                                    // 생성자중에 int.class,String.class,long.class 이거를 속성으로 갖는 객체 있잖아 그걸 줘 라는 뜻
            Constructor<DefaultAccount> constructor2= clz.getDeclaredConstructor(int.class,String.class,long.class);

            DefaultAccount account2= constructor2.newInstance(30,"111-22-333333",1_000_000);
            System.out.println("account2 = " + account2);

        } catch (InstantiationException | IllegalAccessException |InvocationTargetException |NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
