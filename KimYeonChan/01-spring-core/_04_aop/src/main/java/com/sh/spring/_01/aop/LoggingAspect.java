package com.sh.spring._01.aop;

import com.sh.spring.common.member.MemberDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Aspect
 * - Advice 와 Pointcut 을 작성하는 클래스
 */
@Component
@Aspect
public class LoggingAspect {
    /**
     * Pointcut
     * - 여러 JoinPoint 중에 Advice 를 삽입할 위치를 지정하는 표현식
     * - execution(리턴타입 패키지.클래스.메소드명(매개변수타입, ...))
     * - * 는 모든 글자를 의미하는 와일드카드
     * - (..)로 매개변수를 작성하면, 모든 매개변수를 의미한다.
     * - (*)로 매개변수를 작성하면, 매개변수 1개를 의미한다.
     * -(*, ..)로 매개변수를 작성하면, 매개변수 1개 이상을 의미한다.
     */
//    @Pointcut("execution(* com.sh.spring.common.member.MemberService.getMember(..))")
    @Pointcut("execution(* com.sh.spring.common.member.Member*.getMember(..))")
    public void pointcut() {}

    /**
     * Around Advice
     * - pointcut 이 선정한 jointPoint 의 실행전, 후 위치에 코드를 삽입할 수 있다.
     */
//    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        // joinPoint 실행전 삽입코드
        System.out.println("Around Advice [Before] " + className + "." + methodName);

        Object returnObj = joinPoint.proceed(); // 실제 JoinPoint 를 실행구문

        // joinPoint 실행후 삽입코드
        System.out.println("Around Advice [After] " + className + "." + methodName);

        return returnObj;
    }

//    @Before("LoggingAspect.pointcut()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Around Before " + className + "." + methodName);
    }

//    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Around After " + className + "." + methodName);
    }

    /**
     * returning 속성은 joinPoint 의 실제 반환값이다.
     * - 실제 반환값에 대한 후처리가 가능하다.
     */
//    @AfterReturning(pointcut="pointcut()", returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Around After " + className + "." + methodName);

        MemberDto memberDto = (MemberDto) result;
        memberDto.setName(memberDto.getName() + "추가!!!");
        System.out.println("리턴값: " + result);
    }

    /**
     * 예외 처리가 아닌 예외가 발생한 경우의 후처리 작업을 작성한다.
     */
    @AfterThrowing(pointcut="pointcut()", throwing="exception")
    public void afterThrowing(Throwable exception) {
        System.out.println(exception + "헉!!!");
    }
}
