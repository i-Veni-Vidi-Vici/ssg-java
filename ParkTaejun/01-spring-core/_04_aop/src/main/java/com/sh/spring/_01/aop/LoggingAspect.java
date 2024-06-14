package com.sh.spring._01.aop;

import com.sh.spring.common.member.MemberDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Pointcut
 * - 여러 JoinPoint중에 Advice를 삽입할 위치를 지정하는 표현식
 * - execution (리턴타입 패키지.클래스.메서드명(매개변수타입, ...))
 * - *는 모든 글자를 의미하는 와일드카드이다.
 * - *Service, *Service.get*
 * - (...)로 매개변수를 작성하면 , 모든 매개변수를 의미한다
 * - (*, ..)로 매개변수를 작성하면, 매개변수 1개 이상을 의미한다.
 */
@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.sh.spring.common.member.Member*.getMember(..))") //포인트컷은 여기다 작성함
    public void pointcut(){}

    /**
     * Around Advice
     * - pointcut이 선정한 JoinPoint의 실행전,후 위치에 코드를 삽입할 수 있다.
     * @param joinPoint
     * @return
     * @throws Throwable
     */
//    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName= joinPoint.getSignature().getName();
        // joinPoint 실행 전 삽입코드
        System.out.println("Around Advice [Before]" + className + " . " + methodName);

        Object returnObj = joinPoint.proceed(); //실제 JoinPoint 실행구문
        // jointPoint 실행 후 삽입코드
        System.out.println("Around Advice [After]" + className + " . " + methodName);
        return  returnObj;
    }

//    @Before("LoggingAspect.pointcut()") // memberdao 앞에들어가고, service앞에 들어갈거당
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName= joinPoint.getSignature().getName();
        System.out.println("👉🏻Before Advice" + className + " . " + methodName);
    }

//    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName= joinPoint.getSignature().getName();
        System.out.println("👉🏻After Advice" + className + " . " + methodName);
    }

    /**
     * returning 속성은 joinPoint의 실제 반환값이다.
     * - 실제 반환값에 대한 후처리가 가능하다
     * @param joinPoint
     * @param result
     */

    @AfterReturning(pointcut="pointcut()", returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName= joinPoint.getSignature().getName();
        System.out.println("👉🏻AfterReturning Advice" + className + " . " + methodName);
        System.out.println("👉🏻 리턴값 : " + result);

        // 리턴값에 ㅐ대한 후처리 수식
        MemberDto memberDto = (MemberDto) result;
        memberDto.setName(memberDto.getName() + "🔥");
    }
    /**
     * 예외처리가 아닌 예외가 발생한 경우의 후처리 작업을 작성한다
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "exception")
    public void afterThrowing(Throwable exception){
        System.out.println("👉🏻" + exception);
    }

//    @AfterThrowing(pointcut="pointcut()", throwing="exception")
//    public void afterThrowing(Throwable exception) {}

}
