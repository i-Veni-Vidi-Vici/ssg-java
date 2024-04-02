package com.sh.io._03.filter.stream;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * ObjectInputStream / ObjectOutputStream
 * - 객체 단위로 읽기/쓰기를 지원하는 스트림클래스, 보조스트림
 * - Serializable인터페이스를 구현한 타입만 지원 // 이거 안하면 오류남
 * - 만약, 필드를 가지고 있다면, 모든 필드역시 Serializable인터페이스를 구현하고 있어야 한다.
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {

        File target=new File(App1.ROOT,"user.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target))) {
            //dlrjs
//            User user=new User(1L,"honggd","1234","홍길동",'남',
//                    1000, LocalDateTime.now(),true,new Phone("01041748861"));
//
//            oos.writeObject(users);

            List<User> users=new ArrayList<>();
            users.add(new User(1L,"honggd","1234","홍길동",'남',
                    1000, LocalDateTime.now(),true,new Phone("01041748861")));
            users.add(new User(1L,"honggd","1234","홍길동",'남',
                    1000, LocalDateTime.now(),true,new Phone("01041748861")));
            users.add(new User(1L,"honggd","1234","홍길동",'남',
                    1000, LocalDateTime.now(),true,new Phone("01041748861")));
            System.out.println("쓰기전 : "+users);
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(target))){

            Object obj=ois.readObject();
            List<User>users=( List<User>) obj;
            System.out.println("읽은 후 : "+users);
            //혹시라도 클래스가 없을까봐 classNotFindError이 있다
        }
        catch (IOException | ClassNotFoundException e)
                //multicatch절 : 부모/자식관계가 아닌 타입을 n개 나열
                //IOException | ClassNotFoundException | Exception 이건 안된다
        {
            e.printStackTrace();
        }
    }
}
