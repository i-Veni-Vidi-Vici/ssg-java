package com.sh._enum._02.basics;



public class App {
    public static void main(String[] args) {
        // new Member(username : String, role : MemberRole, gender : Gender)
//        Member honggd = new Member("honggd", Gender.M, MemberRole.M); // enum을 사용했을 때, 타입의 위치까지도 체크가 가능해짐 -> 혼용할 때, 컴파일 오류가 남!✨실수하기 어려움✨

        Member honggd = new Member("honggd", MemberRole.M, Gender.M);
        Member sinsa = new Member("sinsa", MemberRole.A, Gender.F);
        System.out.println(honggd);
        System.out.println(sinsa);
        System.out.println();

        //동등 비교시, 무조건 다름!(클래스가 다르기 때문)
        System.out.println(MemberRole.M.equals(Gender.M)); //false
        System.out.println();

        //enum은 단일 인스턴스를 사용함 (싱글턴) -> 동일 비교(주소값 비교) 가능
        MemberRole memberRole1 = MemberRole.M;
        MemberRole memberRole2 = MemberRole.M;
//        MemberRole memberRole = new MemberRole(); //new 연산자 호출 불가
        System.out.println(memberRole1 ==memberRole2); //true , 주소값이 같음
        //동일한 값을 가지고 있어도 enum 네임 스페이스(디렉토리와 유사, 그룹핑 목적)가 달라서 구분할 수 있다.
        // 홍길동, 고길동과 같이 MemberRole.M과 Gender.M은 구분이 가능함

        //enum toString 처리를 통해 실제 이름을 문자열로 반환받을 수 있음
        System.out.println(MemberRole.M.toString()); //M
        System.out.println(MemberRole.A.toString()); //A
        System.out.println(Gender.M.toString()); //M
        System.out.println(Gender.F.toString()); //F
        System.out.println();

        // values() : E[] 반복 처리 가능하다.
        MemberRole[] memberRoles = MemberRole.values();
        for (MemberRole role : memberRoles) {
            System.out.println(role);
        }
        System.out.println();

        Gender[] genders = Gender.values();
        for (Gender gender : genders) {
            System.out.println(gender);
        }

        //타입 안정성 보장
        printRole(MemberRole.A);
        printRole(MemberRole.M);
//        printRole(Gender.M); //컴파일 오류

        //과목 타입, 설명, 배점
        Subject subject1 = new Subject(SubjectType.JAVA, "자바는 어쩌구 어쩌구", 40);
        Subject subject2 = new Subject(SubjectType.MYSQL, "대표 DBMS", 30);
        Subject subject3 = new Subject(SubjectType.HTML, "웹 언어", 20);
        System.out.println(subject1);
        System.out.println(subject2);
        System.out.println(subject3);


    }

    private static void printRole(MemberRole memberRole) {
        System.out.println("회원 권한은 "+ memberRole + "입니다.");
    }


}
