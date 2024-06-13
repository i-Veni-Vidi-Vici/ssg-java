package com.sh.spring._01.aop;

import com.sh.spring.common.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AOP가 사용하는 proxy객체
 * - JDK Dynamic Proxy객체 : 인터페이스 구현클래스에 대한 Proxy
 * - CGLIB Proxy객체 (Code Generate Lib) : 인터페이스를 구현하지 않은 클래스에 대한 Proxy - 지금은 Service가 구현체가 아니라서 GCLIB가 나옴
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(ContextConfiguration.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);



        // AOP를 위해(어드바이스 삽입) 실제 MemberService객체가 아닌 MembeService Proxy객체가 빈으로 관리된다
        //new memberService : class com.sh.spring.common.member.MemberService
        System.out.println("new memberService : "+new MemberService(null).getClass());

        //memberService : class com.sh.spring.common.member.MemberService$$SpringCGLIB$$0
        System.out.println("memberService : "+memberService.getClass());

        System.out.println(memberService.getMember(1L));
        // MemberService#getMember() -> MemberDao.getmember()
    }
}
