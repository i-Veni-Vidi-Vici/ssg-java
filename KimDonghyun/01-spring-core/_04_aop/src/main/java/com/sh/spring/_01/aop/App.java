package com.sh.spring._01.aop;

import com.sh.spring.common.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AOP가 사용하는 Proxy객체 
 * - JDK Dynamic Proxy객체 : 인터페이스 구현클래스에 대한 Proxy
 * - CGLIB Proxy객체 (Code Generator Lib) : 인터페이스를 구현하지 않은 클래스에 대한 Proxy 
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);

        // AOP를 위해(어드바이스 삽입) 실제 MemberService객체가 아닌 MemberService Proxy객체가 빈으로 관리된다.
        System.out.println(new MemberService(null).getClass()); // class com.sh.spring.common.member.MemberService
        System.out.println(memberService.getClass()); // class com.sh.spring.common.member.MemberService$$SpringCGLIB$$0

        System.out.println(memberService.getMember(1L));
        // MemberService#getMember() -> MemberDao.getMember()
    }
}
