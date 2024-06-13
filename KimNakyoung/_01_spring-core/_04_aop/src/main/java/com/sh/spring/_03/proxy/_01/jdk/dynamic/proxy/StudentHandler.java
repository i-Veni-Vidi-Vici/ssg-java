package com.sh.spring._03.proxy._01.jdk.dynamic.proxy;

import com.sh.spring.common.student.Student;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

@RequiredArgsConstructor
public class StudentHandler implements InvocationHandler {


    private final Student target; // 반드시 필요하니까


    /**
     * 생성할 Proxy객체가 내부적으로 호출할 메소드
     * - Target 객체 대리호출
     * - 부가기능 수행
     *
     *
     * Object proxy : 생성된 proxy객체
     * Method method : Target객체의 호출할 메소드객체(reflect)
     * Object[] args : Traget 메소드 호출시 전달할 매개인자
     */



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 타겟메소드 호출전 부가기능
        System.out.println("> 청소를 시작합니다....");
        System.out.println(Arrays.toString(args)); // 매개인자 확인

        // 타겟메소드 호출
        Object returnValue = method.invoke(target, args);

        // 타겟메소드 호출 후 부가기능
        System.out.println("> 공부내용을 노트에 기록합니다...");

        return returnValue != null ? returnValue : proxy;
    }
}
