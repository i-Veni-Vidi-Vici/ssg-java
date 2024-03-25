package com.ssg.test.problem2;

import java.util.Scanner;

public class Application {
    static final int MAX_STUDENT = 10;
    static final String menu= """
            =====================
            1. 학생 추가
            2. 학생 목록
            0. 종료하기
            =====================
            입력: """;
    static Scanner scanner = new Scanner(System.in);
    static StudentDTO[] students = new StudentDTO[MAX_STUDENT];
    static int index = 0;


    public static void main(String[] args) {

        while(true){
            System.out.print(menu);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    saveStudent();
                    break;
                case 2:
                    printStudents();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }

        }


    }

    public static void saveStudent(){

        if(index>=MAX_STUDENT){
            System.out.println("학생 정원 초과!");
        }
        else {
            System.out.print("학년 입력: ");
            int grade = scanner.nextInt();
            System.out.print("반 입력: ");
            int classroom = scanner.nextInt();
            scanner.nextLine();
            System.out.print("이름 입력: ");
            String name = scanner.nextLine();
            System.out.print("국어 점수 입력: ");
            int kor = scanner.nextInt();
            System.out.print("영어 점수 입력: ");
            int eng = scanner.nextInt();
            System.out.print("수학 점수 입력: ");
            int math = scanner.nextInt();

            students[index++] = new StudentDTO(grade, classroom, name, kor, eng, math);
        }
    }

    public static void printStudents(){
        if(index<1){
            System.out.println("저장된 학생이 없습니다.");
        }
        else{
            System.out.println("학년 / 반 / 이름 / 국어 / 영어 / 수학");
            for(int i =0; i<index; i++){
                System.out.print(students[i].info());
            }
            System.out.println();
        }
    }



}
