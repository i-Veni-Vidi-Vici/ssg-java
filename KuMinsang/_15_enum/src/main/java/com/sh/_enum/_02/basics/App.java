package com.sh._enum._02.basics;

public class App {
    public static void main(String[] args) {
        Member honggd = new Member("honggd", MemberRole.M, Gender.M);
//        Member sinsa = new Member("sinsa", MemberRole.A, Member.F);   //혼용시 컴파일 오류
        Member sinsa = new Member("honggd", MemberRole.M, Gender.F);
        System.out.println(honggd);
        System.out.println(sinsa);

        System.out.println(MemberRole.M.equals(Gender.M));
        //enum은 단일 인스턴스를 사용한다 (싱글턴) -> 동일비교(주소값비교)가능
        MemberRole memberRole1 = MemberRole.M;
        MemberRole memberRole2 = MemberRole.M;
        //MemberRole memberRole = new MemberRole(); //new연산자 호출 불가
        System.out.println(memberRole1 == memberRole2);
        //동일한 값을 가지고 있어도 enum 네임스페이스(디렉토리와 유사, 그룹핑 목적)가 달라서 그분할수 있다
        //홍길동, 고길동과 같이 MemberRole.M과 Gender.M 구분이 가능하다

        //enum toString 처리를 통해 실제 이름을 문자열로 반환 받을 수 있다
        System.out.println(MemberRole.M.toString());    //"M"
        System.out.println(MemberRole.A.toString());    //"A"
        System.out.println(Gender.M.toString());    //"M"
        System.out.println(Gender.F.toString());    //"F"

        MemberRole[] memberRoles = MemberRole.values();
        for(MemberRole role : memberRoles){
            System.out.println(role);
        }

        Gender[] genders = Gender.values();
        for(int i =0; i<genders.length; i++){
            System.out.println(genders[i]);
        }

        //타입 안정성 보장
        printRole(MemberRole.A);
        printRole(MemberRole.M);
//        printRole(Gender.M);    //컴파일 오류

        Subject subject1 = new Subject(SubjectType.JAVA, "자바는 왈라불라 불라", 40);
        Subject subject2 = new Subject(SubjectType.MYSQL, "대표 DBMS", 30);
        Subject subject3 = new Subject(SubjectType.HTML, "웹언어", 20);
        System.out.println(subject1);
        System.out.println(subject2);
        System.out.println(subject3);
    }

    private static void printRole(MemberRole memberRole){
        System.out.println("회원 권한은 " + memberRole + "입니다");
    }
}
