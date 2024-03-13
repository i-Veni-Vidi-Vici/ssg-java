package com.ssg.test.operator;

public class App1 {
    public static class Student {
        String name;
        int korScore;
        int engScore;
        int mathScore;
        int sum;
        double avg;

        public Student(String name, int korScore, int engScore, int mathScore) {
            this.name = name;
            this.korScore = korScore;
            this.engScore = engScore;
            this.mathScore = mathScore;
            sum(korScore, engScore, mathScore);
            avg(sum);
        }

        private void sum(int korScore, int engScore, int mathScore) {
            sum = korScore + engScore + mathScore;
        }

        private void avg(int sum) {
            avg = sum / 3.0;
        }

        public void pass() {
            if (korScore >= 40 && engScore >= 40 && mathScore >= 40 && avg >= 60) {
                System.out.println("합격");
            } else System.out.println("불합격");
        }
    }


    public static void main(String[] args) {
        Student student1 = new Student("홍길동", 80, 70, 90);
        Student student2 = new Student("신사임당", 95, 80, 100);
        student1.pass();
        student2.pass();
    }
}
