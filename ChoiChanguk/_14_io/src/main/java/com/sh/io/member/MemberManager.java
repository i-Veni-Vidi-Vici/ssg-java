package com.sh.io.member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    private static final String OBJ_ROOT = "ChoiChanguk/_14_io/members.ser";
    List<Member> members;
    public void readMember() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(OBJ_ROOT))) {

            Object obj = ois.readObject();
            //members.add(List<Member> obj);
            members = (List<Member>) obj;
            System.out.println("불러온 내용 : \n"+members);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void addMember(Member member) {
        members.add(member);

        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("ChoiChanguk/_14_io/members.ser")))
        {
            oos.writeObject(members);
            System.out.printf("입력에 성공 했습니다\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void deleteMember()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(OBJ_ROOT))) {

            Object obj = ois.readObject();
            members = (List<Member>) obj;
            members.remove(members.size()-1);
            System.out.println("삭제 후 : \n"+members);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteAllMember()
    {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("ChoiChanguk/_14_io/members.ser")))
        {
            members.clear();
            oos.writeObject(members);
            System.out.printf("전체 삭제\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
