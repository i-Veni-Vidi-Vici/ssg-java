package com.ssg.operator;

public class App2 {
    public static void main(String[] args) {
        String user1Name = "홍길동";
        String user1PhoneNumber = "01012341234";
        char user1Gender = 'M';
        String user1Address = "서울시 서초구 방배동";
        System.out.println(user1Name + " " + user1PhoneNumber + " " + (user1Gender == 'M' ? '남' : '여') + " " + user1Address);

        String user2Name = "심사임당";
        String user2PhoneNumber = "01044443333";
        char user2Gender = 'F';
        String user2Address = "경기도 남양주시 별내면";
        System.out.println(user2Name + " " + user2PhoneNumber + " " + (user2Gender == 'M' ? '남' : '여') + " " + user2Address);
    }
}
