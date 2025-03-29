package com.sh._03.filter.stream;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  ObjectInputStream / ObjectOutputStream
 *  - 객체 단위로 읽기 / 쓰기 지원하는 스트림 클래스. 보조스트림(혼자 사용 못함)
 *  - Serializable 인터페이스를 구현한 타입만 지원 -
 *  - 만약, 필드를 가지고 있다면, 모든 필드 역시 Serializable 인터페이스를 구현하고 있어야 한다.
 *
 *  보조 스트림
 *  - ObjectInputStream / ObjectOutputStream
 *  - BufferedReader / BufferedWriter
 *
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        File target = new File(App.ROOT, "user.ser");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target))) {
//            User user = new User(1L, "honggd", "1234", "홍길동",
//                    'M',new Phone("01012341234"), 1999, LocalDateTime.now(), true);
//            oos.writeObject(user);
            List<User> users = new ArrayList<>();
            users.add(new User(1L,"dhgudehd","1234","dhgudehd",'M',new Phone("01012345678"),1999,LocalDateTime.now(),true));
            users.add(new User(2L,"ghdrlfehd","1234","dhgudehd",'M',new Phone("01012345678"),1999,LocalDateTime.now(),true));
            users.add(new User(3L,"ghdrlfehd","1234","dhgudehd",'M',new Phone("01012345678"),1999,LocalDateTime.now(),true));
            System.out.println("쓰기전 : " + users);
        } catch(IOException e){
                e.printStackTrace();
            }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target))) {
            List<User> users = (List<User>)ois.readObject();
//            Object obj = ois.readObject();
//            User user = (User) obj;
           // List<User> users = (List<User>) obj;
            System.out.println("읽은 후 :" + users);
//            ois.readObject(); //객체를 구현한 클래스가 없을까봐 ClassNotFoundException 예외도 처리해줘야함.
        }catch (IOException | ClassNotFoundException e){
            //multicatch절 : 부모 / 자식 관계가 아닌 타입을 n개 나열
            e.printStackTrace();
        }
    }


}

