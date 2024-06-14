package com.sh.spring._03.proxy._02.cglib;

import com.sh.spring.common.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.proxy.InvocationHandler;


import java.lang.reflect.Method;
import java.util.Arrays;


@RequiredArgsConstructor
public class StudentHandler implements InvocationHandler {
    private final Student target;
    /**
     *
     생성할 Proxy 객체가 내부적으로 호출한 메서드
     Target 객체 대리호출
     부가기능 수행

     Object proxy : 생성된 proxy 객체
     Method method : Target 객체의 호출할 메서드객체(reflect)
     Object[] args : Target메서드 호출 시 전달할 매개인자

     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 타겟 메서드 호출 전 부가기능 여기에 작성
        System.out.println("> 청소를 시작합니다 . . . .");
        System.out.println(Arrays.toString(args));


        // 타겟메서드 호출
        Object returnValue = method.invoke(target, args); // target 객체의 이 메서드를 호출하겠다

        // 타겟메서드 호출 후 부가기능
        System.out.println("> 공부 내용 노트 기록 ..  .. . . ");

        return returnValue != null ? returnValue : proxy;
    }
}
