package com.ssg.io.member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    private List<Member> members = new ArrayList<>();
    private File target = new File("C:/Workspaces/java_workspace/NaJiyoung/_14_io/members.ser");
    public void readMembers() {
        if(members.isEmpty()) {
            try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(target)))) {
                Object obj = ois.readObject();
                members = (List<Member>) obj;
                for (Member member : members)
                    System.out.println(member);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void addMember(Member member) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(target)))){
            members.add(member);
            oos.writeObject(members);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
