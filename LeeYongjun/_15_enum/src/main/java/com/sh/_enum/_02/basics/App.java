package com.sh._enum._02.basics;



public class App {
    public static void main(String[] args) {
        // new Member(username:String . role:MemberRole, gender:Gender)
        Member honggd = new Member("honngd",MemberRole.M,Gender.M);
//        Member honggd = new Member("honngd",Gender.M,MemberRole.M); // 혼용시 컴파일 오류 유발 -> 실수하기 어렵다.
        Member sinsa = new Member("sinsa",MemberRole.A,Gender.F);
        System.out.println(honggd);
        System.out.println(sinsa);
        System.out.println();

        // 동등비교시 무조건 다르다.
        System.out.println(MemberRole.M.equals(Gender.M));
        System.out.println();
        // enum은 단일인스턴스를 사용한다. (싱글턴) -> 동일비교(주소값비교) 가능
        MemberRole memberRole1 = MemberRole.M;
        MemberRole memberRole2 = MemberRole.M;
        System.out.println();
//        MemberRole memberRole = new MemberRole(); // new 연산자 호출 불가
        System.out.println(memberRole1 == memberRole2);
        System.out.println();
        // 동일한 값을 가지고 있어도 enum 네임스페이스(디렉토리와 유사. 그룹핑 목적)가 달라서 구분할 수 있다.
        // 홍길동, 고길동와 같이 MemberRole.M과 Gender.M은 구분이 가능하다

        // enum toString처리를 통해 실제 이름을 문자열로 반환받을 수 있다.
        System.out.println(MemberRole.M.toString());
        System.out.println(MemberRole.A.toString());
        System.out.println(Gender.M.toString());
        System.out.println(Gender.F.toString());
        System.out.println();
        // values():E[] 반복처리 가능하다.
        MemberRole[] memberRoles = MemberRole.values();
        for(MemberRole role : memberRoles){
            System.out.println(role);
        }
        Gender[] genders = Gender.values();
        for(int i = 0; i < genders.length; i++){
            System.out.println(genders[i]);
        }
        // 타입안정성 보장
        printRole(MemberRole.A);
        printRole(MemberRole.M);
//        printRole(Gender.M); // 컴파일 오류

        Subject subject1 = new Subject(SubjectType.HTML,"자바는 어쩌구 저쩌구", 40);
        Subject subject2 = new Subject(SubjectType.MYSQL,"대표 DBMS", 30);
        Subject subject3 = new Subject(SubjectType.JAVA,"웹언어", 20);
    }

    private static void printRole(MemberRole memberRole) {
        System.out.println("회원 권한은 " + memberRole + "입니다.");
    }
}
