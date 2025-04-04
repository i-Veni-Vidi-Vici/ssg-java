package com.sh.io._03.filter.stream;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre> ✨중요!!✨
 *     ObjectInputStream / objectOutputStream
 *     - 객체 단위로 읽기 / 쓰기를 지원하는 스트림 클래스. 보조 스트림
 *     - Serializable 인터페이스를 구현한 타입만 지원.만약, 필드를 가지고 있다면, 모든 필드 역시 Serializable 인터페이스를 구현하고 있어야 함 -> DTO클래스에는 무조건 붙혀주는 게 좋음!
 *
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        File target = new File(App.ROOT, "user.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) { //FileOutputStream 객체는 파일 루트를 받기도 함, 여러개 쓸때 원하는 기능을 쓰고 싶은 stream을 가장 바깥에 써줘야 함
//            User user = new User(1L, "honggd", "1234", "홍길동", 'M', new Phone("01012341234"), 1000, LocalDateTime.now(), true);
//            oos.writeObject(user);

            List<User> users = new ArrayList<>();
            users.add(new User(1L, "honggd", "1234", "홍길동",'M', new Phone("01012341234"), 1000, LocalDateTime.now(), true));
            users.add(new User(2L, "sinsa", "1234", "신사임당",'F', new Phone("01033334444"), 2000, LocalDateTime.now(), false));
            users.add(new User(3L, "leess", "1234", "이순신",'M', new Phone("01055556666"), 3000, LocalDateTime.now(), true));
            System.out.println("쓰기 전 : " + users );
            oos.writeObject(users);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(target)))) {
            Object obj = ois.readObject();
//            User user = (User) obj; //다운 캐스팅
//            System.out.println(user);

            List<User> users = (List<User>) obj;
            System.out.println("읽은 후" + users);

        } catch (IOException | ClassNotFoundException e) {
            // multicatch 절 : 부모/자식 관계가 아닌 타입을 n개 나열
            e.printStackTrace();
        }
    }
}
