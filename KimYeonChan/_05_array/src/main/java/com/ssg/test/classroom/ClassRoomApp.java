package com.ssg.test.classroom;

public class ClassRoomApp {
    public static void main(String[] args) {
        String[] attendanceBook = new String[] {
                "홍길동", "이순신",
                "유관순", "윤봉길",
                "장영실", "임꺽정",
                "장보고", "이태백",
                "김정희", "대조영",
                "김유신", "이사부"
        };
        System.out.println("== 1분단 ==");
        for (int i = 0; i < attendanceBook.length / 2; i += 2) {
            System.out.print(attendanceBook[i] + " ");
            System.out.print(attendanceBook[i + 1] + " ");
            System.out.println();
        }
        System.out.println("== 2분단 ==");
        for (int i = attendanceBook.length / 2; i < attendanceBook.length; i += 2) {
            System.out.print(attendanceBook[i] + " ");
            System.out.print(attendanceBook[i + 1] + " ");
            System.out.println();
        }
    }
}
