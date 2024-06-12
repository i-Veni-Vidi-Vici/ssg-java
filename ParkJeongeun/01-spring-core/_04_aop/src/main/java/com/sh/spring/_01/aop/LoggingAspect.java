package com.sh.spring._01.aop;

import com.sh.spring.common.member.MemberDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Aspect
 * - Advice와 Pointcut을 작성하는 클래스
 */
@Component
@Aspect
public class LoggingAspect {
    /**
     * Pointcut
     * - 여러 JoinPoint 중에 Advice를 삽입할 위치를 지정하는 표현식
     * - execution(리턴타입 패키지.클래스.메소드명(매개변수타입,..))
     * - *는 모든 글자를 의미하는 와일드카드
     * - *Service, *Service.get* 형식으로도 작성 가능
     * - (..)로 매개변수를 작성하면, 모든 매개변수를 의미
     * - (*)로 매개변수를 작성하면, 매개변수 1을 의미
     * - (*, ..)로 매개변수를 작성하면, 매개변수 1개 이상을 의미
     */
//    @Pointcut("execution(* com.sh.spring.common.member.MemberService.getMember(..))")
    @Pointcut("execution(* com.sh.spring.common.member.Member*.getMember(..))")
    public void pointcut(){}

    /**
     * Around Advice
     * - pointcut이 선정한 JoinPoint의 실행전/후 위치에 코드 삽입
     */

//    @Around("pointcut()") // 위에 작성한 pointcut과 연결됨
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        // joinPoint 실행 전 삽입 코드
        System.out.println("👉 Around Advice [Before] " + className + "." + methodName);
        Object returnObj = joinPoint.proceed(); // 실제 JoinPoint 실행구문
        // joinPoint 실행 후 삽입 코드
        System.out.println("👉 Around Advice [After] " + className + "." + methodName);
        return returnObj;
    }

//    @Before("LoggingAspect.pointcut()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("👉 Before Advice" + className + "." + methodName);
    }

//    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("👉 After Advice" + className + "." + methodName);
    }

    /**
     * returning 속성은 joinPoint의 실제 반환값
     * - 실제 반환값에 대한 후처리 가능
     */
//    @AfterReturning(pointcut="pointcut()", returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("👉 AfterReturning Advice" + className + "." + methodName);
        System.out.println("👉 리턴값 : " + result);

        // 리턴값에 대한 후처리 조작
        MemberDto memberDto = (MemberDto) result;
        memberDto.setName(memberDto.getName() + "🥩");
    }

    /**
     * 예외처리가 아닌 예외가 발생한 경우의 후처리 작업을 작성함
     */
    @AfterThrowing(pointcut="pointcut()", throwing="exception")
    public void afterThrowing(Throwable exception) {
        System.out.println("👉" + exception);
    }
}