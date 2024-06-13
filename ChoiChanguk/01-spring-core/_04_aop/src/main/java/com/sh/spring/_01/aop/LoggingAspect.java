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
     * - 여러 joinPoint중에 Advice를 삽입할 위치를 지정하는 표현식
     * - execution(리턴타입 패키지, 클래스, 메소드명(매개변수 타입,..)
     * - *(아스타)는 모든 글자를 의미하는 와일드카드
     *
     * *Service, *Service.get*
     * - 매개변수부는 보통 (..)로 매개변수를 작성하면, 모든 매개변수를 의미한다
     * - (..)로 매개변수를 작성하면, 모든 매개변수를 의미한다
     * - (*)로 매개변수를 작성하면, 매개변수 1를 의미한다.
     * - (*, ..)로 매개변수를 작성하면, 매개변수 1개 이상을 의미한다.
     */

    //@Pointcut("execution(* com.sh.spring.common.member.MemberService.getMember(..))")
    @Pointcut("execution(* com.sh.spring.common.member.Member*.getMember(..))")
    public void pointcut() {

    }

    /**
     * Around Advice
     * - pointcut이 선정한 JoinPoint의 실행 전, 후 위치에 코드를 삽입할 수 있다
     * 이걸 많이 쓰더라
     * @param joinPoint
     * @return
     * @throws Throwable
     */

//    @Around("pointcut()") // 어떤 pointcut을 쓸지
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        String className=joinPoint.getSignature().getDeclaringTypeName(); // 이게 클래스 네임
        String methodName = joinPoint.getSignature().getName();// joinpoint의 메소드다

        // joinPoint 실행전 삽입코드
        System.out.println("Around Advice [Before]" + className + "."+methodName);

        Object returnObj = joinPoint.proceed(); // 실제 JoinPoint 실행구문

        // joinPoint 실행 후 삽입코드
        System.out.println("Around Advice [After]" + className + "."+methodName);

        return returnObj;
    }

    //@Before("LoggingAspect.pointcut()")
    public void before(JoinPoint joinPoint) {
        String className=joinPoint.getSignature().getDeclaringTypeName(); // 이게 클래스 네임
        String methodName = joinPoint.getSignature().getName();// joinpoint의 메소드다

        System.out.println("> Before Advice"+ className + "."+methodName);
    }

    //@After("pointcut()")
    public void after(JoinPoint joinPoint) {
        String className=joinPoint.getSignature().getDeclaringTypeName(); // 이게 클래스 네임
        String methodName = joinPoint.getSignature().getName();// joinpoint의 메소드다

        System.out.println("> After Advice"+ className + "."+methodName);
    }

    /**
     * Returning속성은 joinPoint의 실제 반환 값
     *  - 필요하면 조작이 가능
     *  - 실제 반환값에 대한 후처리가 가능하다.
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut="pointcut()", returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String className=joinPoint.getSignature().getDeclaringTypeName(); // 이게 클래스 네임
        String methodName = joinPoint.getSignature().getName();// joinpoint의 메소드다

        System.out.println("> AfterReturning Advice"+ className + "."+methodName);
        System.out.println("> 리턴값 : "+result);

        // 리턴값에 대한 후처리 조직
        MemberDto memberDto=(MemberDto) result;
        memberDto.setName(memberDto.getName()+"🚗");
    }

    /**
     * 예외처리가 아닌 예외가 발생한 경우의 후처리 작업을 작성한다.
     * 예외가 발생하면 어떻게 할 건지 여기서 코드로 작성한다
     * @param exception
     */
    @AfterThrowing(pointcut="pointcut()", throwing="exception")
    public void afterThrowing(Throwable exception) {
        System.out.println(exception);
    }
}
