package com.sh._enum._02.basics;

public class App {
    public static void main(String[] args) {
        // new Member(username:String, role:MemberRole, gender:Gender)
        Member honggd = new Member("honggd", MemberRole.M, Gender.M);
//        Member honggd = new Member("honggd", Gender.M, MemberRole.M); // 혼용시 컴파일오류 발생 -> 실수하기 어렵다
        Member sinsa = new Member("sinsa", MemberRole.M, Gender.F);
        System.out.println(honggd);
        System.out.println(sinsa);

        // 동등비교시 무조건 다르다.
        System.out.println(MemberRole.M.equals(Gender.M)); // always 'false'
        // enum은 단일 인스턴스를 사용한다. (싱글톤) -> 동일비교(주소값비교) 가능
        MemberRole memberRole1 = MemberRole.M; // new 를 쓰지 않음, 여러개를 객체화할 수 없음
        MemberRole memberRole2 = MemberRole.M;
//        MemberRole memberRole3 = new MemberRole(); // Enum types cannot be instantiated
        System.out.println(memberRole1 == memberRole2); // always 'true'
        // 동일한 값을 가지고 있어도 enum 네임스페이스(디렉토리와 유사, 그룹핑 목적)가 달라서 구별할 수 있다.
        // 홍길동, 고길동 ... 홍씨네 고씨네로 구별 가능
        // MemberRole.M과 Gender.M은 구분이 가능하다. => enum은 네임스페이스 역할을 한다

        // enum toString처리를 통해 실제 이름을 문자열로 반환받을 수 있다.
        System.out.println(MemberRole.M.toString()); // "M"
        System.out.println(MemberRole.A.toString()); // "A"
        System.out.println(Gender.M); // "M"
        System.out.println(Gender.F); // "F"

        // values():E[] 반복처리 가능하다.
        MemberRole[] memberRoles = MemberRole.values();
        for (MemberRole role : memberRoles) {
            System.out.println(role);
        }
        Gender[] genders = Gender.values();
        for (int i = 0; i < genders.length; i++) {
            System.out.println(genders[i]);
        }

        // 타입안정성 보장
        printRole(MemberRole.A);
        printRole(MemberRole.M);
//        printRole(Gender.M); // 컴파일 오류 // 근데 이건 class 객체도 그렇지 않나요?

        Subject subject = new Subject(SubjectType.JAVA, "자바는 어쩌구 저쩌구", 40);
        Subject subject2 = new Subject(SubjectType.MYSQL, "대표 DBMS", 30);
        Subject subject3 = new Subject(SubjectType.HTML, "웹언어", 20);
        System.out.println(subject);
        System.out.println(subject2);
        System.out.println(subject3);
    }

    private static void printRole(MemberRole memberRole) {
        System.out.println("회원권한은 " + memberRole + "입니다.");
    }
}
