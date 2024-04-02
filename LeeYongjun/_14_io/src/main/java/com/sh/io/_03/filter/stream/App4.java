package com.sh.io._03.filter.stream;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * ObjectInputStream/ ObjectOutputStream
 * - 객체 단위로 읽기/쓰기를 지원하는 스트림클래스. 보조스트림.
 * - Serializable 인터페이스를 구현한 타입만 지원.
 * - 만약, 필드를 가지고 있다면, 모든 필드역시 Serializable 인터페이스를 구현하고 있어야한다.
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        File target = new File(App.Root, "user.ser");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target))) {
//            User user = new User(1L,"yongjun","1234","홍길동",'M',new Phone("01012345678"),1000, LocalDateTime.now(),true);
//            oos.writeObject(user);
            List<User> users = new ArrayList<>();
            users.add(new User(1L,"yongjun","1234","홍길동",'M',new Phone("01012345678"),1000, LocalDateTime.now(),true));
            users.add(new User(2L,"hong","1234","홍길동",'M',new Phone("01012345678"),1000, LocalDateTime.now(),true));
            users.add(new User(3L,"shin","1234","홍길동",'M',new Phone("01012345678"),1000, LocalDateTime.now(),true));
            System.out.println("쓰기전 : " + users);
            oos.writeObject(users);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target))) {
            Object obj = ois.readObject();
//            User user = (User) obj;
            List<User> users = (List<User>) obj;
            System.out.println("읽은후 : " + users);
        } catch (IOException  | ClassNotFoundException e) {
            // multicatch절 : 부모/자식관계가 아닌 타입을 n개 나열
            e.printStackTrace();
        
        }
    }
}
