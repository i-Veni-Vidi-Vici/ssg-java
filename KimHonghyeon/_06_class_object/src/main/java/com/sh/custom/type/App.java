package com.sh.custom.type;

/**
 * - 변수: 하나의 값을 보관하는 공간
 * - 배열: 동일한 타입의 여려개의 값을 보관하는 공간
 * - 클래스: 다른 타입의 변수 여러개를 보관하는 공간
 */
public class App {

    public static void main(String[] args) {
        String id = "user01";
        String pwd = "pass01";
        int age = 20;
        char gender = '남';
        String[] hobbies = {"축구, 볼링, 테니스"};

        Member member = new Member("user01", "pass01", "신사임당", 40, '여', new String[]{"스쿼시", "클라이밍"});
        member.printMember();
    }
}
