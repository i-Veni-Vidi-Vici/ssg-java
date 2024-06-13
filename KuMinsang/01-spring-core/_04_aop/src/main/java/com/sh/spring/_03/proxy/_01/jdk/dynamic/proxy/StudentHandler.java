package com.sh.spring._03.proxy._01.jdk.dynamic.proxy;
import com.sh.spring.common.student.Student;
import lombok.RequiredArgsConstructor;
//import org.springframework.cglib.proxy.InvocationHandler;   //CGLIB Proxy객체용

import java.lang.reflect.InvocationHandler;   //JDK 동적프록시 객체용
import java.lang.reflect.Method;
import java.util.Arrays;

@RequiredArgsConstructor
public class StudentHandler implements InvocationHandler {

    private final Student target;

    /**
     *  생성할 Proxy객체가 내부적으로 호출할 메소드
     *  - Target객체 대리호출
     *  - 부가기능 수행
     *
     *  Object proxy : 생성된 proxy객체
     *  Method method : Targt객체의 호출할 메소드(reflect)
     *  Object[] args : Target메소드 호출시 전달한 매게인자
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //타겟메소드 호출 전 부가기능
        System.out.println(">청소를 시작합니다.");
        System.out.println(Arrays.toString(args));

        //타켓메소드 호출
        Object returnValue = method.invoke(target, args);
        System.out.println(returnValue);

        //타겟메소드 호출 후 부가기능
        System.out.println(">공부 내용을 정리합니다.");

        return returnValue != null ? returnValue : proxy;
    }
}
