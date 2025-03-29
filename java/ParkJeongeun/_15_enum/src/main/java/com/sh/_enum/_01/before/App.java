package com.sh._enum._01.before;

/**
 * <pre>
 * 상수
 * - public static final 키워드로써 상수필드 사용 (상수는 공유목적이 크기때문에 public)
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        Member honggd = new Member("honggd", Member.MEMBER_ROLE, Member.GENDER_MALE);
        Member sinsa = new Member("sinsa", Member.ADMIN_ROLE, Member.GENDER_FEMALE);
        System.out.println(honggd);
        System.out.println(sinsa);

        // 1. role과 gender 값을 구분할 수 없음(M값을 둘 다 갖고 있음)
        System.out.println(Member.MEMBER_ROLE.equals(Member.GENDER_MALE)); // true
        // 2. 일반 String, int 타입으로는 타입 안정성을 보장할 수 없음
        System.out.println(createMember("leess", Member.ADMIN_ROLE, Member.MEMBER_ROLE)); // username, role, gender 순을 안지켰는데도 입력가능
        // 3. 상수를 묶어서 반복처리 등을 묶을 수 없음 (롤은 롤끼리. 성별은 성별끼리 묶는게 X)

    }

    public static Member createMember(String username, String role, String gender){
//        return new Member(username, role, gender);
        return new Member(username, gender, role); // 원래 위와 같이 작성해야하는데 이렇게 써도 오류를 잡아내지 못함
    }
}
