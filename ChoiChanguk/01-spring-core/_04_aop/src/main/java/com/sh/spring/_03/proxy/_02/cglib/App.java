package com.sh.spring._03.proxy._02.cglib;

import com.sh.spring.common.student.SsgStudent;
import org.springframework.cglib.proxy.Enhancer;

/**
 * <pre>
 *
 * 프록시란?
 * 실제 Target의 기능을 수행하면서 기능을 확장하거나 추가하는 실제 객체를 의미한다.(복제품이라는 뜻이다)
 * 디자인패턴의 프록시 패턴과는 조금 다른 개념이긴 하다.
 *
 * 실제 응용 프로그램을 만들 시 프록시는 직접 기능을 구현할 일은 없다.
 * 프록시는 대상의 요청을 가로채 기능을 확장시킬 목적으로 사용하며 reflection 기능을 이용해서 간단히 구현해보자
 *
 *
 * AOP가 사용하는 proxy객체
 * - JDK Dynamic Proxy객체 : 인터페이스 구현클래스에 대한 Proxy
 * - CGLIB Proxy객체 (Code Generate Lib) : 인터페이스를 구현하지 않은 클래스에 대한 Proxy - 지금은 Service가 구현체가 아니라서 GCLIB가 나옴
 *
 * CGLIB Proxy객체 만드는 방법 -------------------
 * 1. 실제 target객체 생성 (인터페이스 없음)
 * 2. Proxy 객체가 내부적으로 호출할 InvocationHandler 클래스 작성
 * 3. Enhancer.create(클래스객체, InvocationHandler)
 *
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        // 1. Target 객체 생성
        SsgStudent student=new SsgStudent(); // 실제 Target

        // 2. InvocationHandler객체(target 메소드 대리호풀, 부가기능) 생성, 프록시가 호출할 handler 클래스
        StudentHandler studentHandler=new StudentHandler(student);

        // 3. Proxy객체 생성
        // class loader = 메모리상에 올리는 역할이다
        SsgStudent proxy = (SsgStudent)Enhancer.create(SsgStudent.class, studentHandler);

        // 스프링 IoCContainer는 위와 같이 Proxy빈을 생성 후 의존주입한다.
        System.out.printf("평소처럼 출력 > ");
        student.study(9);
        System.out.println();

        System.out.printf("proxy로 출력 > ");
        proxy.study(8);
        System.out.println("proxy.getClass() = "+proxy.getClass());

    }
}
