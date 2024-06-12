package com.sh.spring._01.aop;

import com.sh.spring.common.member.MemberDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * Aspect
 * - Advice와 Pointcut을 작성하는 클래스
 */
@Component
@Aspect
public class LoggingAspect {
    /**
     * ## Pointcut
     * - 여러 JoinPoint 중에 Advice를 삽입할 위치를 지정하는 표현식
     * - execution(리턴 타입 패키지.클래스.메소드명(매개변수타입, ...))
     * - *는 모든 글자를 의미하는 와일드 카드
     *     - *Service, *Service.get* 처럼 쓸 수 있음
     * - (..)로 매개변수를 작성하면, 모든 매개변수를 의미한다.
     * - (*)로 매개변수를 작성하면, 매개변수 1을 의미한다.
     * - (*, ..)로 매개변수를 작성하면, 매개변수 1개 이상을 의미한다.
     */
//    @Pointcut("execution(* com.sh.spring.common.member.MemberService.getMember(..))")
    @Pointcut("execution(* com.sh.spring.common.member.Member*.getMember(..))")
    public void pointcut() {}

    /**
     * Around Advice
     * - pointcut이 선정한 JoinPoint의 실행 전, 후 위치에 코드를 삽입할 수 있다.
     */
//    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        // ✨joinPoint 실행전 삽입 코드
        System.out.println("🖖Around Advice [Before] " + className + "." + methodName);

        Object returnObj = joinPoint.proceed(); // ✨실제 joinPoint 실행 구문
        // ✨joinPoint 실행 후 삽입 코드
        System.out.println("🖖Around Advice [After] " + className + "." + methodName);

        return returnObj;
    }

//    @Before("LoggingAspect.pointcut()") // joinPoint 전에 단독으로 실행됨, Dao 앞에서 실행됨
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("🖖 Before Advice" + className + "." + methodName);
    }

//    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("🖖 After Advice" + className + "." + methodName);
    }

    /**
     * returning 속성은 joinPoint의 실제 반환 값이다.
     * - 실제 반환 갑에 대한 후 처리가 가능하다.
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut="pointcut()", returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("🖖 AfterReturning Advice" + className + "." + methodName);
        System.out.println("🖖 리턴값 : " + result);

        //리턴값에 대한 후처리 조직
        MemberDto memberDto = (MemberDto) result;
        memberDto.setName(memberDto.getName() +"🖖");
    }

    /**
     * 예외처리가 아닌 예외가 발생한 경우의 후처리 작업을 작성한다.
     * @param exception
     */
    @AfterThrowing(pointcut="pointcut()", throwing="exception")
    public void afterThrowing(Throwable exception) {
        System.out.println( "🖖" + exception);
    }
}
