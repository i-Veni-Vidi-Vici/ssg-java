package operator;

public class App1 {
    public static void main(String[] args){
        //홍길동
            int koreanScore1 = 80, englishScore1 = 70, mathScore1 = 90; // 홍길동의 국어, 영어, 수학 점수
            int sum1 = 0; // 총 합을 구하기 위한 누산기로 사용하기 위함
        sum1 = koreanScore1 + mathScore1 + englishScore1;
        double avg1 = sum1/3.0;

        System.out.println(sum1); // 홍길동의 과목 합 점수
        System.out.println(avg1); // 홍길동의 평균 점수

        String result1 = (koreanScore1 >= 40 && mathScore1 >= 40 && englishScore1 >= 40 && avg1 >= 60) ? "합격" : "불합격";
        // 세 과목의 점수가 각각 40점 이상이면서, 평균이 60점 이상이면 합격 아니면 불합격
        System.out.println(result1);

        System.out.println();

        // 신사임당
            int koreanScore2 = 95, englishScore2 = 70, mathScore2 = 90;
            int sum2 = 0;
            sum2 = englishScore2 + koreanScore2 + mathScore2;
            double avg2 = sum2/3.0;

        System.out.println(sum2);
        System.out.println(avg2);

        String result2 = (koreanScore2 >= 40 && englishScore2 >= 40 && mathScore2 >= 40 && avg2 >=60 ? "합격": "불합격" );
        System.out.println(result2);





    }
}
