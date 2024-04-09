package com.sh.io.member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberObjectIOTest {
    public static void main(String[] args) {
        MemberManager memberManager=new MemberManager();
        //1, 파일을 읽고
        System.out.printf("작성전 ");
        memberManager.readMember();

        //2. 파일에 자료를 넣고
        Member member=new Member("3","1234","욱창최","cstangga@naver.com",33,'M',1.0);
        memberManager.addMember(member);

        //3. 파일을 다시 읽는다
        System.out.printf("수정 후");
        memberManager.readMember();

        //4. 이건 혼자 해본 내용, 자료 지우기
       //memberManager.deleteMember();

        //5. 전부 지우기
        //memberManager.deleteAllMember();
    }
}
