package com.sh._enum._01.before;

import com.sh.Main;

import javax.swing.plaf.metal.MetalMenuBarUI;

/**
 * <pre>
 * 상수
 * - public static final 키워드로써 상수필드 사용
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        //new Member(userName:String, role:Stirng, gender:String
        Member honggd=new Member("honggd",Member.MEMBER_ROLE,Member.GENDER_FEMALE);
        Member sinsa=new Member("sinsa", Member.ADMIN_ROLE,Member.GENDER_FEMALE);
        System.out.println(honggd);
        System.out.println(sinsa);

        //1. role, gender값을 구분할 수 없다.
        System.out.println(Member.MEMBER_ROLE.equals(Member.GENDER_MALE));//true

        //2. 일반 String, int, 타입으로는 타입안정성을 보장할 수 없다.//적절한 타입인지 모른다
        // 같은 String이라서 자리가 바뀌어도 모른다
        System.out.println(createMember("leess", Member.ADMIN_ROLE, Member.MEMBER_ROLE));

        //3. 상수를 묶어서 반보처리등을 묶을 수 없다.

    }
    public static Member createMember(String username,String role, String gendger)
    {
        //return new Member(username, role, gendger);
        return new Member(username, gendger, role);
    }
}
