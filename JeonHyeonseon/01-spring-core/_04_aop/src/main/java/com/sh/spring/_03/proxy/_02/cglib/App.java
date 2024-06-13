package com.sh.spring._03.proxy._02.cglib;

import com.sh.spring.common.student.SsgStudent;
import com.sh.spring.common.student.Student;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * <pre>
 * AOP가 사용하는 Proxy객체
 *  - JDK의 Dynamic Proxy객체 : 인터페이스 구현클래스에 대한 Proxy객체
 *  - CGLIB의(Code Generator Lib) Proxy객체 : 인터페이스를 구현하지 않는 클래스에 대한 Proxy객체
 *
 * 프록시란?
 *  실제 Target의 기능을 수행하면서 기능을 확장하거나 추가하는 실제 객체를 의미한다.
 *  디자인패턴의 프록시 패턴과는 조금 다른 개념이긴 하다.
 *
 * 실제 응용 프로그램을 만들 시 프록시는 직접 기능을 구현할 일은 없다. (미리 만들어져있다)
 * 프록시는 대상의 요청을 가로채 기능을 확장시킬 목적으로 사용하며 reflection 기능을 이용해서 간단히 구현해보자
 *
 * CGLIB Proxy객체 만드는 방법
 * 1. 실제 Target객체 생성 (인터페이스 없음(사용안함))
 * 2. Proxy객체가 내부적으로 호출할 InvocationHandler클래스 작성
 * 3. Enhancer.create(클래스객체, InvocationHandler)S
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 1. Target객체 생성
        SsgStudent student = new SsgStudent();

        // 2. InvocationHandler객체(target 메소드 대리호출, 부가기능) 생성
        StudentHandler studentHandler = new StudentHandler(student);

        // 3. Proxy객체 생성
        SsgStudent proxy = (SsgStudent) Enhancer.create(SsgStudent.class, studentHandler);
        // 스프링 IoC Container는 위와같이 Proxy빈(객체)를 생성후 의존주입한다.
        student.study(8);
        System.out.println();

        proxy.study(8);
        System.out.println(proxy.getClass()); // class com.sh.spring.common.student.SsgStudent$$EnhancerByCGLIB$$f9f8eee4
    }
}
