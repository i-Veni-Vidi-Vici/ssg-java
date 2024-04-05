package com.ssg.io.member.com.ssg.io.member;

import com.ssg.io.member.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    private static final String OBJ_ROOT = "KimYeonChan/_14_io/members.ser";

    public void readMembers() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(OBJ_ROOT))) {
            Object obj = ois.readObject();
            List<Member> members = (List<Member>) obj;
            for (Member member : members) {
                System.out.println(member);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addMember(Member member) {
        List<Member> members = new ArrayList<>();
        members.add(member);
        try(ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(OBJ_ROOT, true))) {
            oop.writeObject(members);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
