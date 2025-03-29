package com.ohgiraffers.hw2.run;

import com.ohgiraffers.hw2.model.dto.StudentDTO;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        StudentDTO[] stu = new StudentDTO[10];
        String str =
             """
             ======================
             학생 정보를 입력하시겠습니까 ?
             Y : 학생 정보를 추가한다.
             N : 학생 정보 출력
             x : 종료
             ======================
             선택: """;
            while(true)
            {
                System.out.println(str);
                char ch = sc.next().charAt(0);
                switch(ch)
                {
                    case 'y':
                        if(index < 10)
                        {
                            //학생 정보 입력
                            stu[index] = new StudentDTO();
                            stu[index].input();
                            index++;
                        }
                        else{
                            System.out.println("학생 정보가 가득차있습니다.");
                        }
                        break;
                    case 'n':
                        //학생 정보 출력

                        for(StudentDTO student : stu)
                        {
                            if(student != null) {
                                String str1 = student.information();
                                System.out.print(str1);
                                System.out.printf("%d\t  %d\t  %s\t  %d\t  %d\t  %d\t  %d",
                                        student.getGrade(), student.getClassromm(), student.getName(),
                                        student.getKor(), student.getEng(), student.getKor(), student.getMath(),student.getAverage());
                                System.out.println();
                            }
                        }
                        break;

                    case 'x': return;
                }


            }

            }








    }



