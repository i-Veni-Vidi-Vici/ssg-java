package com.sh.spring._03.proxy._02.cglib;

import com.sh.spring.common.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

@RequiredArgsConstructor
public class StudentHandler implements InvocationHandler {
    private final Student target;

    /**
     * 생성할 Proxy객체가 내부적으로 호출할 메소드
     * - Target객체 대리호출
     * - 부가기능 수행
     *
     * 파라미터 순서
     * Object proxy : 생성된 proxy 객체
     * method : target 객체의 호출할 메소드객체 (reflect
     * Object[] args : target 메소드 호출 시 전달할 매개인자
     *
     */

     @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         // 타겟메소드 호출 전 부가기능
         // 그 부가기능들을 여기에 작성한다
         System.out.println(">> 청소를 시작합니다....");

         // 타겟메소드 호출
         Object returnValue = method.invoke(target,args);
         System.out.println("returnValue = " + returnValue);

         // 타겟메소드 호출 후 부가기능
         System.out.println(">>> 공부 내용을 노트에 기록합니다");

        return returnValue !=null ? returnValue : proxy;
    }
}
