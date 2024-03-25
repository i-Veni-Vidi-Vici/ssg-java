package com.sh.inheritance._03.abstraction;

import java.time.LocalDateTime;

/**
 * <pre>
 *  상속구조의 객체지향 설계
 *  - 부모의 필드.메서드를 자식클래스 선언없이 사용가능
 *  - 공통점이 있는 여러개의 자식클래스에서 중복된 부분만 뽑아서 부모클래스 설계가 가능하다.
 *  - 중복된 부분을 부모클래스에서 한번만 관리하므로, 유지보수성이 좋다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Computer computer1 = new Computer();
        System.out.println(computer1.getInfo());
        System.out.println();

        Computer computer2 = new Computer("com1234", "삼성", "갤럭시북",
                2_000_000, LocalDateTime.now(), "i9", 32, 1000, "Windows11");

        System.out.println(computer2.getInfo());

        Tv tv1 = new Tv();
        System.out.println(tv1.getInfo());

        System.out.println();

        Tv tv2 = new Tv("tv4567", "엘지", "엘지롤러블Tv", 5_000_000, LocalDateTime.now(),
                "8k", 10);
        System.out.println(tv2.getInfo());



    }
}
