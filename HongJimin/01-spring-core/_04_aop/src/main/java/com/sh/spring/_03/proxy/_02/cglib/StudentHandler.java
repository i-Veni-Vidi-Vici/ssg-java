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
     * 생성할 Proxy객체가 내부적으로 호출할 메소드
     * - Target 객체 대리 호출
     * - 부가 기능 수행
     *
     * Object Proxy : 생성된 proxy 객체
     * Method method : Target 객체의 호출할 메소드(reflect)
     * Object[] args : Target메소드 호출시 전달할 매개인자
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 타겟 메소드 호출 전, 부가기능
        System.out.println("▶ 청소 시작합니다!🖍");
        System.out.println(Arrays.toString(args));

        // 타겟 메소드 호출
        Object returnValue = method.invoke(target, args); // 매개인자 확인
        System.out.println(returnValue);

        //타겟 메소드 호출 후, 부가기능
        System.out.println("▶ 공부 내용을 노트에 기록합니다!📚");


        return returnValue != null ? returnValue : proxy;
    }
}
