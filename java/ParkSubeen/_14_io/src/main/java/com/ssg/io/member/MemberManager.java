package com.ssg.io.member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    private List<Member> members = new ArrayList<>();
    public void readMembers() {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("ParkSubeen/_14_io/members.ser")))) {
            members = (List<Member>) ois.readObject();
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for(Member member : members) {
            System.out.println(member);
        }
    }

    public void addMember(Member member) {
        members.add(member);
        writeMember(members);
    }

    private void writeMember(List<Member> members) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("ParkSubeen/_14_io/members.ser")))) {
            oos.writeObject(members);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
