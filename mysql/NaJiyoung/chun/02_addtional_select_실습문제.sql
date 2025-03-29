use chundb;
select * from TB_DEPARTMENT; --  학과테이블
select * from TB_STUDENT; -- 학생테이블
select * from TB_PROFESSOR; -- 교수테이블
select * from TB_CLASS; -- 수업테이블
select * from TB_CLASS_PROFESSOR; -- 수업교수테이블
select * from TB_GRADE; -- 학점테이블

-- 1. 영어영문학과(학과코드 `002`) 학생들의 학번과 이름, 입학 년도를 입학 년도가 빠른순으로 표시하는 SQL 문장을 작성하시오.
-- 단, 헤더는 "학번", "이름", "입학년도" 가 표시되도록 한다.
select STUDENT_NO 학번, STUDENT_NAME 이름, date(ENTRANCE_DATE) 입학년도
from tb_student
where DEPARTMENT_NO = '002'
order by 입학년도;

-- 2. 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 한 명 있다고 한다. 그 교수의 이름과 주민번호를 화면에 출력하는 SQL 문장을 작성해 보자.
select PROFESSOR_NAME, PROFESSOR_SSN
from tb_professor
where PROFESSOR_NAME not like '___';

-- 3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오. 단 이때 나이가 적은 사람에서 많은 사람 순서로 화면에 출력되도록 만드시오.
-- 단, 교수 중 2000 년 이후 출생자는 없으며 출력 헤더는 "교수이름", "나이"로 한다. 나이는 ‘만’으로 계산한다.
select PROFESSOR_NAME 교수이름,
       year(now()) - concat('19', left(PROFESSOR_SSN, 2))
           - if(substring(PROFESSOR_SSN, 3, 2) <= month(now()) and substring(PROFESSOR_SSN, 5, 2) <= day(now()), 0, 1) 나이
from tb_professor
where substring(PROFESSOR_SSN, 8, 1) = 1
order by 나이;

-- 4. 교수들의 이름 중 성을 제외한 이름만 출력하는 SQL 문장을 작성하시오. 출력 헤더는’이름’ 이 찍히도록 핚다. (성이 2 자인 경우는 교수는 없다고 가정하시오)
select substring(PROFESSOR_NAME, 2) 이름
from tb_professor;

-- 5. 춘 기술대학교의 재수생 입학자를 구하려고 한다. 어떻게 찾아낼 것인가? 이때, 만 19살이 되는 해에 입학하면 재수를 하지 않은 것으로 간주한다.
select STUDENT_NO, STUDENT_NAME
from tb_student
where year(ENTRANCE_DATE) - concat(if(substring(STUDENT_SSN, 8, 1) in ('1', '2'), '19', '20'), left(STUDENT_SSN, 2)) > 19;

-- 6. 2020년 크리스마스는 무슨 요일이었는가?
select date_format('2020-12-25', '%Y-%m-%d (%W)');

-- 7. STR_TO_DATE('99/10/11', '%y/%m/%d'), STR_TO_DATE('49/10/11', '%y/%m/%d')은 각각 몇 년 몇 월 몇 일을 의미할까?
-- 또 STR_TO_DATE('70/10/11', '%y/%m/%d'), STR_TO_DATE('69/10/11', '%y/%m/%d') 은 각각 몇 년 몇 월 몇 일을 의미할까?
select STR_TO_DATE('99/10/11', '%y/%m/%d'); -- 1999년 10월 11일
select STR_TO_DATE('49/10/11', '%y/%m/%d'); -- 2049년 10월 11일
select STR_TO_DATE('70/10/11', '%y/%m/%d'); -- 1970년 10월 11일
select STR_TO_DATE('69/10/11', '%y/%m/%d'); -- 2069년 10월 11일

-- 8. 학번이 `A517178` 인 한아름 학생의 학점 총 평점을 구하는 SQL 문을 작성하시오. 단, 이때 출력 화면의 헤더는 "평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한자리까지만 표시한다.
select round(avg(POINT), 1) 평점
from tb_grade
where STUDENT_NO = 'A517178';

-- 9. 학과별 학생수를 구하여 "학과번호", "학생수(명)" 의 형태로 헤더를 만들어 결과값이 출력되도록 하시오.
select DEPARTMENT_NO 학과번호, count(*) "학생수(명)"
from tb_student
group by DEPARTMENT_NO;

-- 10. 지도 교수를 배정받지 못한 학생의 수는 몇 명 정도 되는 알아내는 SQL 문을 작성하시오.
select count(*)
from tb_student
where COACH_PROFESSOR_NO is null;

-- 11. 학번이 A112113 인 김고운 학생의 년도 별 평점을 구하는 SQL 문을 작성하시오. 단, 이때 출력 화면의 헤더는 "년도", "년도 별 평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한자리까지만 표시한다.
select left(TERM_NO, 4) 년도, round(avg(POINT), 1) 평점
from tb_grade
where STUDENT_NO = 'A112113'
group by left(TERM_NO, 4);

-- 12. 학과 별 휴학생 수를 파악하고자 한다. 학과 번호와 휴학생 수를 표시하는 SQL 문장을 작성하시오.
select DEPARTMENT_NO 학과코드명, sum(ABSENCE_YN = 'Y') "휴학생 수"
from tb_student
group by DEPARTMENT_NO;

-- 13. 춘 대학교에 다니는 동명이인(同名異人) 학생들의 이름을 찾고자 한다. 어떤 SQL 문장을 사용하면 가능하겠는가?
select STUDENT_NAME 동일이름, count(*) "동명인 수"
from tb_student
group by STUDENT_NAME
having count(*) > 1
order by 동일이름;

-- 14. 학번이 A112113 인 김고운 학생의 년도, 학기 별 평점과 년도 별 누적 평점 , 총평점을 구하는 SQL 문을 작성하시오.
-- 단, 평점은 소수점 1 자리까지만 반올림하여 표시한다.

-- group by + with roll up -> select grouping
select distinct
-- 정상 작동, 집계 데이터 <null>로 뜬다
#   left(TERM_NO, 4) 년도,
#   substring(TERM_NO, 5, 2) 학기,
-- 그룹핑
    if(grouping(left(TERM_NO, 4)) = 0, left(TERM_NO, 4), '총 평점') 년도,
    if(grouping(substring(TERM_NO, 5, 2)) = 0, substring(TERM_NO, 5, 2), '학기 별 평점') 학기,
    round(avg(POINT), 1) 평점
from tb_grade
where STUDENT_NO = 'A112113'
group by left(TERM_NO, 4), substring(TERM_NO, 5, 2), TERM_NO with rollup;