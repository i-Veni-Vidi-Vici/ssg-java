package com.ssg.test.operator;

public class App2 {

    public static class Student {
        String name;
        String phoneNumber;
        char gender;
        String address;

        public Student(String name, String phoneNumber, char gender, String address) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.gender = gender;
            this.address = address;
        }

        private char setGender(char gender) {
            if (gender == 'M') {
                return '남';
            }
            if (gender == 'F') {
                return '여';
            }

            return ' ';
        }

        @Override
        public String toString() {
            return name + " " + phoneNumber + " " + setGender(gender) + " " + address;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("홍길동","01012341234", 'M', "서울시 서초구 방배동");
        Student student2 = new Student("신사임당","01044443333", 'F', "경기도 남양주시 별내면");

        System.out.println("이 름  전화번호   성별  주소");
        System.out.println("----------------------------------------");
        System.out.println(student1.toString());
        System.out.println(student2.toString());
    }
}
