package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

/**
 * <pre>
 *     ### **상속 구조의 객체 지향 설계**
 *
 * - 부모의 필드/메소드를 자식 클래스 선언 없이 사용 가능
 * - 공통점이 있는 여러 개의 자식 클래스에서 중복된 부분만 뽑아서 부모 클래스 설계가 가능함
 * - 중복된 부분을 부모 클래스에서 한번만 관리하므로, 유지보수성이 좋음
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Computer computer1 = new Computer();
        System.out.println(computer1.getInfo());

        Computer computer2 =
                new Computer("com1234", "삼성", "갤러시북", 2_000_000,
                        LocalDate.now(), "i9", 32,  1000, "windows11");
        System.out.println(computer2.getInfo());

        Tv tv1 = new Tv();
        System.out.println(tv1.getInfo());
        Tv tv2 = new Tv("tv4567", "엘지", "엘지롤러블 TV", 5_000_000, LocalDate.now(), "8k", 100);

    }
}
