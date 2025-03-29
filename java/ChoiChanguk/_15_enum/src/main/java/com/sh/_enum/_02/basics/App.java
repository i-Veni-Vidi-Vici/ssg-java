package com.sh._enum._02.basics;

public class App {
    public static void main(String[] args) {
        // new Member(username:String, role:MemberRole, gender:Gender)
        //Member honggd=new Member("honggd",Gender.M,MemberRold.M);
        Member honggd=new Member("honggd",MemberRole.M,Gender.M);
        Member sinsa=new Member("honggd",MemberRole.A,Gender.F);
        System.out.println(honggd);
        System.out.println(sinsa+"\n");

        //동등비교시 무조건 다르다.
        System.out.println("동등비교 equals : "+MemberRole.M.equals(Gender.M));
        // enum은 단일 인스턴스를 사용한다 (싱글턴) -> 동일비교(주소값 비교)가 가능하다
        MemberRole memberRole1=MemberRole.M; // new MemberRole 안됨
        MemberRole memberRole2=MemberRole.M; // new MemberRole 안됨
        //MemberRole memberRole3=new MemberRole.M; // new MemberRole 안됨

        System.out.println((memberRole1==memberRole2)+"\n"); //true
        // 동일한 값을 가지고 있어도 enum 네임스페이스가 달라서 구분할 수 있다.
        // 네임스페이스 = 디렉토리같은 느낌
        // 홍길동, 고길동 =>디렉토리로 묶으면 "길동"이다 이것과 같이 MemberRold.M과 Gender.M 구분이 가능하다

        //enum toString 처리를 통해 실제 이름을 문자열로 반환받을 수 있다
        System.out.printf(MemberRole.M.toString()+" ");
        System.out.printf(MemberRole.A.toString()+" ");
        System.out.printf(Gender.F.toString()+" ");
        System.out.printf(Gender.M.M.toString()+"\n");

        //value():E[] 반복처리 가능
        MemberRole[] memberRoles=MemberRole.values();
        for(MemberRole memberRole:memberRoles)
        {
            System.out.print(memberRole+" ");
        }

        printRole(MemberRole.A);
        printRole(MemberRole.M);
        //printRole(Gender.M);// MemberRole이 아니라 빨간줄 + 컴파일 오류 + 실수가 어려워진다

        Subject subject1=new Subject(SubjectType.JAVA,"자바는 어쩌구 저쩌구 설명",40);
        Subject subject2=new Subject(SubjectType.MYSQL,"대표 DBMS",30);
        Subject subject3=new Subject(SubjectType.HTML,"웹언어",20);
    }


    private static void printRole(MemberRole memberRole) {
        System.out.println("회원 권한은 "+memberRole+"입니다");
    }
}
