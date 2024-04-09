package com.sh._enum._02.basics;

public class App {
    public static void main(String[] args) {
        // 혼용시 실수하기 어렵다.
        Member honggd = new Member("honggd", MemberRole.M, Gender.M);
        Member sinsa = new Member("sinsa", MemberRole.A, Gender.F);
        System.out.println(honggd);
        System.out.println(sinsa);

        System.out.println(MemberRole.M.equals(Gender.M));
        // enum 은 단일 인스턴스를 사용한다. (싱글톤) -> 동일비교가 가능하다.
        MemberRole memberRole1= MemberRole.M;
        MemberRole memberRole2= MemberRole.M;
        // MemberRole memberRole3= new MemberRole(); // new 연산자 호출 불가
        System.out.println(memberRole1 == memberRole2);
        // 동일한 값을 가지고 있어도 enum 네임스페이스(디렉토리와 유사. 그룹핑 목적)가 달라서 구분할 수 있다.

        // enum toString 처리를 통해 실제 문자열로 반환 받을 수 있다.

        // values():E[] 반복처리 가능하다.
        MemberRole[] memberRoles = MemberRole.values();
        for (MemberRole role : memberRoles) {
            System.out.println(role);
        }

        Gender[] genders = Gender.values();
        for (int i = 0; i < genders.length; i++) {
            System.out.println(genders[i]);
        }

        printRole(MemberRole.M);
        printRole(MemberRole.A);
//        printRole(Gender.M); // 컴파일 오류

        Subject subject1 = new Subject(SubjectType.JAVA, "자바", 40);
        Subject subject2 = new Subject(SubjectType.MYSQL, "데이터베이스", 40);
        Subject subject3 = new Subject(SubjectType.HTML, "웹", 40);
        System.out.println(subject1);
        System.out.println(subject2);
        System.out.println(subject3);
    }

    private static void printRole(MemberRole memberRole) {
        System.out.println("회원 권한은 " + memberRole + "입니다.");
    }
}
