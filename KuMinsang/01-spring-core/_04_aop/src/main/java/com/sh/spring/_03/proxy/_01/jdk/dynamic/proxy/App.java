package com.sh.spring._03.proxy._01.jdk.dynamic.proxy;

import com.sh.spring.common.student.SsgStudent;
import com.sh.spring.common.student.Student;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * <pre>
 * AOP가 사용하는  Proxy 객체
 * - JDK Dynamic Proxy객체 : 인터페이스 구현클래스에 대한 Proxy
 * - CGLIB Proxy객체 (Code Generator Lib) : 인터페이스를 구현하지 않은 클래스에 대한 Proxy
 *
 * 프록시란?
 * 실제 Target의 기능을 수행하면서 기능을 확장하거나 추가하는 실제 객체를 의미한다.
 * 디자인패턴의 프록시 패턴과는 조금 다른 개념이긴 하다.
 *
 * 실제 응용 프로그램을 만들 시 프록시는 직접 기능을 구현할 일은 없다.
 * 프록시는 대상의 요청을 가로채 기능을 확장시킬 목적으로 사용하며 reflection 기능을 이용해서 간단히 구현해보자
 *
 * JDK 동적 Proxy객체 만드는 방법
 * 1. 실제 Target 객체 생성
 * 2. Proxy객체각 내부적으로 호출한 InvocationHandler 클래스 작성
 * 3. Proxy.newProxyInstance(클래스로더, 클래스객체, InvocationHandler)
 *
 * CGLIB Proxy객체 만드는 방법
 * 1. 실제 Target객체 생성 (인터페이스 없음)
 * 2. Proxy객체가 내부적으로 호출할 InvocationHandler 클래스 작성
 * 3. Enhancer
 * </pre>
 */

public class App {
//    public static void main(String[] args) {
//        //1. Target 객체 생성
//        Student student = new SsgStudent();
//        //2. InvocationHandler 객체 (target 메소드 대리호출, 부가기능) 생성
//        StudentHandler studentHandler = new StudentHandler(student);
//        //3. Proxy객체 생성
//        Student proxy = (Student) Proxy.newProxyInstance(
//                student.getClass().getClassLoader(),
//                new Class[]{Student.class},
//                studentHandler);
//
//        //스프링 Ioc Container는 위와같이 Proxy Bean을 생성 후 의존 주입한다.
//        student.study(8);
//        System.out.println();
//
//        proxy.study(8);
//        System.out.println(proxy.getClass());
//    }

//    public static void main(String[] args) {
//        //1. Target 객체 생성
//        SsgStudent student = new SsgStudent();
//        //2. InvocationHandler 객체 (target 메소드 대리호출, 부가기능) 생성
//        StudentHandler studentHandler = new StudentHandler(student);
//        //3. Proxy객체 생성
//        SsgStudent proxy = (SsgStudent) Enhancer.create(SsgStudent.class, studentHandler);
//
//        //스프링 Ioc Container는 위와같이 Proxy Bean을 생성 후 의존 주입한다.
//        student.study(8);
//        System.out.println();
//
//        proxy.study(8);
//        System.out.println(proxy.getClass());   //class com.sh.spring.common.student.SsgStudent$$EnhancerByCGLIB$$f9f8eee4
//    }

    public static void main(String[] args) {
        //1. Target 객체 생성
        Student student = new SsgStudent();
        //2. InvocationHandler 객체 (target 메소드 대리호출, 부가기능) 생성
        StudentHandler studentHandler = new StudentHandler(student);
        //3. Proxy객체 생성
        Student proxy = (Student) Proxy.newProxyInstance(
                Student.class.getClassLoader(),
                new Class[]{Student.class},
                studentHandler);

        //스프링 Ioc Container는 위와같이 Proxy Bean을 생성 후 의존 주입한다.
        student.study(8);
        System.out.println();

        proxy.study(8);
        System.out.println(proxy.getClass());
    }

}
