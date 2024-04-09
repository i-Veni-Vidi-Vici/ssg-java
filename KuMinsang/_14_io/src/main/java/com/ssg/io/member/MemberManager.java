package com.ssg.io.member;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class MemberManager {
    private List<Member> members;
//    private File file = new File("KuMinsang/_14_io/members.ser");
    private File file = new File("_14_io/members.ser");

    public MemberManager(List<Member> members) {
        this.members = members;
    }

    public MemberManager() {

    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void readMembers(){  //파일을 읽어서 필드에 저장하고, 출력
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            Object object = ois.readObject();
            members = (List<Member>)object;
            System.out.println("파일 불러오기 성공");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("파일 불러오기에 실패했습니다");
            e.printStackTrace();
        }
        Iterator<Member> iterator = members.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public void addMember(Member member){
        //매개인자 필드를 members에 추가
        this.members.add(member);
        //members.ser 파일에 저장
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            oos.writeObject(this.members);
        }catch (IOException e){
            System.out.println("파일 저장에 실패했습니다");
            e.printStackTrace();
        }
        //객체 출력시에 이어쓰기 없이 List객체를 덮어쓰기로 처리한다

    }


}
