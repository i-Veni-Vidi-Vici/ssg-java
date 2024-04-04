package com.sh._enum._02.basics;

public class App {
    public static void main(String[] args) {
        Member honggd = new Member("honggd", MemberRole.M, Gender.M);
//        Member honggd1 = new Member("honggd", Gender.M, MemberRole.M); // 순서 안지키면 컴파일 오류 -> 실수 어려움

        Member sinsa = new Member("sinsa", MemberRole.A, Gender.F);
        System.out.println(honggd);
        System.out.println(sinsa);

        // 동등비교시 무조건 다름
        System.out.println(MemberRole.M.equals(Gender.M)); // false
        // enum은 단일 인스턴스 사용 (싱글톤 -> 동일비교(주소값비교) 가능)
//        MemberRole memberRole = new MemberRole(); // new 연산자로 객체 생성 못함
        MemberRole memberRole = MemberRole.M;
        MemberRole memberRole2 = MemberRole.M;
        System.out.println(memberRole == memberRole2); // true
        // 동일한 값을 가지고 있어도 enum 네임스페이스(디렉토리와 유사/그룹핑 목적)가 달라서 구분 가능
        // -> 홍길동, 고길동(성으로 구분)과 같이 MemberRole.M과 Gender.M은 구분 가능

        // enum toString 처리를 통해 실제 이름을 문자열로 반환받을 수 있음
        System.out.println(MemberRole.M); // 자동으로 .toString() 붙어서 생략가능 - "M"

        // values():E[] 반복처리 가능
        MemberRole[] memberRoles = MemberRole.values();
        for (MemberRole role : memberRoles) {
            System.out.println(role); // M, A
        }
        Gender[] genders = Gender.values();
        for (int i = 0; i < genders.length; i++) {
            System.out.println(genders[i]); // M, F
        }

        // 타입 안정성 보장
        printRole(MemberRole.A);
        printRole(MemberRole.M);
//        printRole(Gender.M); // 컴파일 오류

        // 과목타입, 설명, 배점
        Subject subject1 = new Subject(SubjectType.JAVA, "자바는 어쩌구", 40);
        Subject subject2 = new Subject(SubjectType.MYSQL, "대표 DBMS", 30);
        Subject subject3 = new Subject(SubjectType.HTML, "웹언어", 20);
        System.out.println(subject1);
        System.out.println(subject2);
        System.out.println(subject3);
    }

    private static void printRole(MemberRole memberRole) {
        System.out.println("회원 권한은 " + memberRole + "입니다.");
    }
}
