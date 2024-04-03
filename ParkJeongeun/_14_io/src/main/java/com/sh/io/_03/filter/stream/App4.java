package com.sh.io._03.filter.stream;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * ObjectInputStream / ObjectOutputStream
 * - 객체 단위로 읽기/쓰기를 지원하는 스트림클래스. 보조클래스
 * - Serializable 인터페이스를 구현한 타입만 지원
 * - 만약 필드를 가지고 있다면, 모든 필드 역시 Serializable 인터페이스를 구현하고 있어야 함
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(App.ROOT + "user.ser"))){
//            User user = new User(1L, "honggd", "1234", "홍길동", 'M', new Phone("01012341234"), 1000, LocalDateTime.now(),  true);
//            oos.writeObject(user);

            List<User> users = new ArrayList<>();
            users.add(new User(1L, "honggd", "1234", "홍길동", 'M', new Phone("01012341234"), 1000, LocalDateTime.now(),  true));
            users.add(new User(2L, "sinsa", "1234", "신사임당", 'F', new Phone("01012341234"), 1000, LocalDateTime.now(),  true));
            users.add(new User(3L, "leess", "1234", "이순신", 'M', new Phone("01012341234"), 1000, LocalDateTime.now(),  true));
        }catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(App.ROOT + "user.ser"))){
            Object obj = ois.readObject();
//            User user = (User) obj; // 다운캐스팅
//            System.out.println(user);
            List<User> users = (List<User>) obj;
            System.out.println("읽은 후 : " + users);
        }catch (IOException | ClassNotFoundException e){
            // multicatch절 : 부모/자식 관계가 아닌 (아무상관 없는) 타입을 n개 나열
            e.printStackTrace();
        }
    }
}
