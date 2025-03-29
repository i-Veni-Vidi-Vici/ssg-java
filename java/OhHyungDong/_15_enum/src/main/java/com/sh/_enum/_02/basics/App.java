package com.sh._enum._02.basics;




public class App
{
    public static void main(String[] args) {
        Member honggd = new Member("honggd", MemberRole.M, Gender.M);
        Member sinsa = new Member("sinsa", MemberRole.A, Gender.F);

        System.out.println(honggd);
        System.out.println(sinsa);
        System.out.println();

        //동등비교시 무조건 다르다.
        System.out.println(MemberRole.M.equals(Gender.M)); // false
        System.out.println();

        //enum은 단일 인스턴스를 사용한다. (싱글턴) -> 동일 비교(주소값 비교)가 가능
        MemberRole memberRole1 = MemberRole.M; // enum -> new MemberRole()같이 외부호출이 불가능하다.
        MemberRole memberRole2 = MemberRole.M;
        System.out.println(memberRole1 == memberRole2);
        //동일한 값을 가지고 있어도 enum 네임 스페이스(디렉토리와 유사. 그룹핑 목적)이 달라서 구분 할 수 있다.
        //홍길동, 고길동와 같이 MemberRole.M, Gender.M은 구분이 가능하다.

        //enum toString처리를 통해 실제 이름을 문자열로 반환받을 수 있다.
        System.out.println(MemberRole.M.toString());
        System.out.println(MemberRole.A.toString());
        System.out.println(Gender.M.toString());
        System.out.println(Gender.F.toString());

        //Values():E[] 반복처리 가능하다.
        MemberRole[] memberRoles = MemberRole.values();
        for(MemberRole role : memberRoles){
            System.out.println(role);
        }

        Gender[] gender = Gender.values();
        for(int i = 0; i< gender.length; i++){
            System.out.println(gender[i]);
        }

        //타입 안정성 보장
        printRole(MemberRole.A);;
        printRole(MemberRole.M);

        //과목타입, 설명, 배점
        Subject subject1 = new Subject(SubjectType.JAVA, "자바는 어쩌구 저쩌구", 40);
        Subject subject2 = new Subject(SubjectType.MYSQL, "대표는 DBMS", 30);
        Subject subject3 = new Subject(SubjectType.HTML, "웹언어", 20);

        System.out.println();
        System.out.println(subject1);
        System.out.println(subject2);
        System.out.println(subject3);
    }

    private static void printRole(MemberRole memberRole) {
        System.out.println("회원 권한은 " + memberRole + "입니다. ");
    }
}
