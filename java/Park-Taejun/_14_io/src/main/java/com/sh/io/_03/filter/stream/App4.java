package com.sh.io._03.filter.stream;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * ObjectInputStream  / ObjectOutputStram
 * - 객체 단위로 읽기/쓰기를 지원하는 스트림 클래스. 보조스트림.
 * -  Serializable 인터페이스를 구현한 타입만 지원.
 * - 만약, 필드를 가지고 있다면, 모든 필드역시 Serializable 인터페이스를 구현하고 있어야 한다.
 *
 *
 * </pre>
 */
public class App4 {
    public static void main(String[] args) { //보조스트림이면 주스트림
        File target = new File(App.ROOT, "user.ser");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target))) {

            List<User>users = new ArrayList<>();
            User user = new User (1L, "honggd", "1234", "홍길동", 'M', new Phone("01012345678"), 1000, LocalDateTime.now(), true);
            User user = new User ( 2L, "honggd", "1234", "홍길동"], 'M', new Phone("01012345678"), 1000, LocalDateTime.now(), true);
            User user = new User (1L, "honggd", "1234", "홍길동", 'M', new Phone("01012345678"), 1000, LocalDateTime.now(), true);

            oos.writeObject(user);

        } catch (IOException e) {
            e.printStackTrace();
        }


 }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target))) {
            Object obj = ois.readObject();
            List<User> = User) obj;
            System.out.println(user);
        } catch (IOException | ClassNotFoundException e) {
            // multicatch 절
            e.printStackTrace();

        }
    }
}
