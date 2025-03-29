package com.ssg.test.loop;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        Scanner scanner = new Scanner(System.in);
        for(int i =0; i<people.length; i++){
            System.out.printf("이름: ");
            String name = scanner.nextLine();
            System.out.printf("나이: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("주소: ");
            String address = scanner.nextLine();
            System.out.printf("키: ");
            int height = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("몸무게: ");
            int weight = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("연락처: ");
            String phoneNumber = scanner.nextLine();
            people[i] = new Person(name, age, address,height, weight, phoneNumber);
        }
        System.out.println("========회원목록========");
        for(int i = 0; i< people.length; i++){
            System.out.println(people[i]);
        }
        int avgAge = (people[0].age + people[1].age + people[2].age)/3;
        int avgHeight = (people[0].height + people[1].height + people[2].height)/3;
        int avgWeight = (people[0].weight + people[1].weight + people[2].weight)/3;
        System.out.println("====================");
        System.out.println("평균나이: "+avgAge+"세 / 평균키: "+avgHeight+"cm / 평균몸무게: "+avgWeight + "kg");
    }
}

class Person{
    String name;
    int age;
    String address;
    int height;
    int weight;
    String phoneNumber;

    Person(String name, int age, String address, int height, int weight, String phoneNumber){
        this.name = name;
        this.age = age;
        this.address = address;
        this.height = height;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
    }
    public String toString(){
        return "이름: " + this.name + " 나이: " + this.age + " 주소: "+this.address + " 키: "
                + this.height + " 몸무게: "+this.weight + " 연락처: " + this.phoneNumber;
    }
}
