package com.ssg.test.loop;

import java.util.Scanner;

/**
 * - 요구사항
 *     - 3명의 회원정보를 입력 받아 저장하고 출력하는
 *     프로그램을 만드세요.
 *     - 입력값 : **이름, 나이, 주소, 키, 몸무게, 연락처**
 *     - 마지막에 평균나이, 평균키, 평균몸무게 출력하세요.
 *         - 평균계산에 필요한 변수를 만들어 사용할수 있습니다.
 * - 출력예시
 */
public class Test5 {
    public static void main(String[] args) {
        Info [] info = new Info[3];

        int avgA = 0;
        int avgH = 0;
        int avgW = 0;

        for(int i =0 ; i<3; i++){
            info[i] = new Info();
        }

        for(int i = 0; i<3; i++){
            info[i].input();
        }



        System.out.println("=========회원목록==========");
        for(int i=0; i<3; i++){
            System.out.print(i+1);
            info[i].output();
        }
        System.out.println("=======================");



        for(int i=0; i<3; i++){
            avgA += info[i].old;
            avgH += info[i].height;
            avgW += info[i].weight;
        }
        avgA = avgA/3;
        avgH = avgH/3;
        avgW = avgW/3;

        System.out.printf("평균나이 : %d세 / 평균키 : %dcm / 평균 몸무게 : %dkg\n", avgA, avgH, avgW);


    }
}
class Info{
    String name;
    int old;
    String addr;
    int height;
    int weight;
    String phone;

    public void Info(){}


    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println(">이름 : ");
        this.name = sc.next();
        System.out.println(">나이 : ");
        this.old = sc.nextInt();
        System.out.println(">주소 : ");
        sc.nextLine();
        this.addr = sc.nextLine();
        System.out.println(">신장 : ");
        height = sc.nextInt();
        System.out.println(">체중 : ");
        weight = sc.nextInt();
        System.out.println(">전화번호 : ");
        phone = sc.next();

    }


    public void output(){
        System.out.println(this.name +" "+ this.old +"세 "+ this.addr +" "+ this.height +"cm "+ this.weight +"kg "+ this.phone);
    }

}