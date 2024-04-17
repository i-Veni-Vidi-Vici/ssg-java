package com.ssg.io.member;

import com.sh.io._03.filter.stream.App;
import com.sh.io._03.filter.stream.Phone;
import com.sh.io._03.filter.stream.User;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    private List<Member> members;

    public void readMembers() {
        File target = new File("ByeonSeongil/_14_io/", "members.ser");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target))) {
            Object obj = ois.readObject();
            members = (List<Member>) obj;
            System.out.println(members);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addMember(Member member) {
        File target = new File("ByeonSeongil/_14_io/", "members.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target))) {
            members.add(member);
            oos.writeObject(members);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
