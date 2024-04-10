package com.ssg.io.member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    List<Member> members;
    public static String ROOT = "/Users/jeong-yejin/2024SSGI&C/java/JeongYejin/_14_io/members.ser";
    File target = new File(ROOT);
    public void readMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target))) {
            Object obj = ois.readObject();
            members = (List<Member>) obj;
            System.out.println(members);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void addMember(Member member) {
        members.add(member);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target))) {
            System.out.println(members);
            oos.writeObject(members);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
