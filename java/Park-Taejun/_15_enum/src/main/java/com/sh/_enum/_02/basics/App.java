//package com.sh._enum._02.basics;
//
//
//
//public class App {
//    public static void main(String[] args) {
//        //new Member(username :String, role: MemberRole, gender : Gender)
//
//        Member honggd = new Member("honggd", MemberRole.M, Gender.M);
//        Member sinsa = new Member("sinsa", MemberRole.M, Gender.F);
//        System.out.println(honggd);
//        System.out.println(sinsa);
//
//        //동등비교시 무조건 다르다
//        System.out.println(MemberRole.M.equals(Gender.M)); //false
//        //enum은 단일인스턴스를 사용한다.(싱글턴) -> 동일비교(주소값비교) 가능
//        MemberRole memberRole1 = MemberRole.M; // new emberRole() x
//        MemberRole memberRole2 = MemberRole.M;
////        MemberRole memberRole3 = new MemberRole.M; // new 연산자 호출 불가
//        System.out.println(memberRole1 == memberRole2); //true
//        //동일한 값을 가지고 있어도 enum 네임스페이스가 달라서 구분할 수 있다
//        //홍길동, 고길동와 같이 MemberRole.M과 Gender.M 은 구분이 가능하다
//
//        // enum toString 오버라이딩이 되어있어 처리를 통해 실제 이름을 문자열로 반환받을 수 있다
//        System.out.println(MemberRole.M.toString());
//        System.out.println(MemberRole.A.toString());
//        System.out.println(Gender.M.toString());
//        System.out.println(Gender.F.toString());
//
//        // values():E[] 반복처리 가능하다
//        MemberRole[] memberRoles = MemberRole.values();
//        for(MemberRole role : memberRoles){
//            System.out.println(role);
//        }
//
//        Gender[] genders = Gender.values();
//        for (int i = 0; i< genders.length; i++ ){
//            System.out.println(genders[i]);
//        }
//
//        //타입안정성 보장
//        printRole(MemberRole.A);
//        printRole(MemberRole.M);
////        printRole(Gender.M); // 컴파일 오류
//        // 과목타입, 설명,배점
//        Subject subject1 = new Subject(SubjectType.JAVA, "자바는 어쩌구 저쩌구", 40);
//        Subject subject2 = new Subject(SubjectType.MYSQL, "대표 DBMS", 30);
//        Subject subject3 = new Subject(SubjectType.HTML, "웹언어", 20);
//        System.out.println(subject1);
//        System.out.println(subject2);
//        System.out.println(subject3);
//    }
//
//    private static void printRole(MemberRole memberRole) {
//        System.out.println("회원 권한은" + memberRole + "입니다 . ");
//    }
//
//}
