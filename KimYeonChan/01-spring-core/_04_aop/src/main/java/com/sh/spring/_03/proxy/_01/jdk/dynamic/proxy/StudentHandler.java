package com.sh.spring._03.proxy._01.jdk.dynamic.proxy;

import com.sh.spring.common.student.Student;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class StudentHandler implements InvocationHandler {
    private final Student student;
    /**
     * 생성할 Proxy 객체가 내부적으로 호출할 메소드
     * - Target 객체 대리호출
     * - 부가기능 수행
     *
     * Object proxy: 생성된 proxy 객체
     * Method method: Target 객체의 호출할 메소드객체(reflect)
     * Object[] args: Target 메소드 호출시 전달할 매개인자
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 타켓 메소드 호출전 부가기능
        System.out.println("청소를 시작합니다.");

        // 타멧 메소드 호출
        Object returnValue = method.invoke(student, args);

        // 타겟 메소드 호출후 부가기능
        System.out.println("침대에 눕습니다.");
        return returnValue != null ? returnValue : proxy;
    }
}
