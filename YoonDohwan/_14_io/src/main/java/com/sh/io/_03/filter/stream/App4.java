package com.sh.io._03.filter.stream;

import java.io.*;
import java.time.LocalDateTime;

/**
 * ObjectInputStream / ObjectOutputStream
 * -객체 단위로 읽기/쓰기를 지원하는 스트림클래스.보조스트림.
 * -Serializable 인터페이스를 구현한 타입만 지원.
 * -만약, 필드를 가지고 있다면, 모든 필드역시 Serializable 인터페이스를 구현하고 있어야 한다.
 *
 */
public class App4 {
    public static void main(String[] args) {
        File target = new File(App.ROOT,"user.ser");
     //   try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(target))){
       //   User user = new User(1L,"honggd","1234","홍길동",'M',1000, LocalDateTime.now(),true);
       // }catch(IOException e) {
        //    e.printStackTrace();
       // }

     //   try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target))){
       //     Object obj = ois.readObject();
         //   User user = (User)obj;
           // System.out.println(user);
        //}catch(IOException e){
         //   e.printStackTrace();
        //} catch (ClassNotFoundException e) {
         //   e.printStackTrace();
       // }
    }
}
