package com.sh.operator.operator;

public class App1 {

    public static void main(String[] args) {
        Member member = new Member("홍길동",80,70,90);
        Member member2 = new Member("신사임당", 95,80,100);
        
        int memberTotal = member.total();
        System.out.println("memberTotal = " + memberTotal);
        
        double memberAverage = member.average(memberTotal);
        System.out.println("memberAverage = " + memberAverage);
    }

    static class Member
    {
        String name;
        int korean, english ,math, sum ;
        double avg;
        
        
        public Member(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
        public int total()
        {
            sum = korean + english + math;
            return sum;
        }
        
        public double average(int memberTotal) {
            avg = sum / 3.0;
            return avg;
        }
    }
}
