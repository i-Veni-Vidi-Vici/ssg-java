package com.ssg.io.member;

import java.util.List;

public class MemberObjectIOTest {
    public static void main(String[] args) {
        List<Member> members;
        MemberManager memberManager = new MemberManager();
        //@실습문제
        // 1.members.ser 파일읽어서 출력하기
        memberManager.readMembers();
        members = memberManager.getMembers();
        // 2.회원추가 : MemberManager#addMember(Member):void
        // Member객체를 List<Member>에 추가후, List를 members.ser파일에 출력 작업
        memberManager.addMember(new Member("user2","1234","이재용","money@samsung.com", 40, '남', 0.5));

        // 3. 결과확인 : 추가된 회원까지 확인
        System.out.println("추가 회원까지 출력");
        memberManager.readMembers();
    }

}
