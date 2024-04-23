-- 1. 영어영문학과(학과코드 002) 학생들의 학번과 이름, 입학 년도를 입학 년도가 빠른순으로 표시하는 SQL 문장을 작성하시오.
select STUDENT_NO 학번, STUDENT_NAME 이름, date_format(ENTRANCE_DATE, '%Y-%m-%d') 입학년도
from tb_student
where DEPARTMENT_NO = (
      select DEPARTMENT_NO
      from tb_department
      where DEPARTMENT_NAME = '영어영문학과')
order by ENTRANCE_DATE;

-- 2. 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 한 명 있다고 한다.
--    그 교수의 이름과 주민번호를 화면에 출력하는 SQL 문장을 작성해 보자.
select PROFESSOR_NAME, PROFESSOR_SSN
from tb_professor
where char_length(PROFESSOR_NAME) != 3;

select PROFESSOR_NAME, PROFESSOR_SSN
from tb_professor
# where (이름이 세글자가 아님)
where PROFESSOR_NO in (select PROFESSOR_NO from tb_professor where char_length(PROFESSOR_NAME) != 3);

-- 3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오.
--    단 이때 나이가 적은 사람에서 많은 사람 순서로 화면에 출력되도록 만드시오.
--   (단, 교수 중 2000 년 이후 출생자는 없으며 출력 헤더는 "교수이름", "나이"로 한다. 나이는 ‘만’으로 계산한다.)
-- 만나이 : 생일기준 truncate(datediff(오늘, 생일) / 365)
select PROFESSOR_NAME,
from tb_professor
where SUBSTRING(PROFESSOR_SSN, 8, 1) in ('1', '3');
-- 나이 = now() - 출생년도 + 1
select truncate(datediff(now(), concat(substring(PROFESSOR_SSN, 1, 2), substring(PROFESSOR_SSN, 3, 2), substring(PROFESSOR_SSN, 5, 2)))/365, 0)
from tb_professor;
select PROFESSOR_SSN
from tb_professor;

-- 4. 교수들의 이름 중 성을 제외한 이름만 출력하는 SQL 문장을 작성하시오.
--    출력 헤더는 '이름’이 찍히도록 한다. (성이 2 자인 경우는 교수는 없다고 가정하시오)
select substring(PROFESSOR_NAME, 2, 2) 이름
from tb_professor
where PROFESSOR_NAME != '__';

-- 5. 춘 기술대학교의 재수생 입학자를 구하려고 한다. 어떻게 찾아낼 것인가?
--    이때, 만 19살이 되는 해에 입학하면 재수를 하지 않은 것으로 간주한다.
select *
from tb_student
where year(ENTRANCE_DATE) = 2019; -- 재수x

-- 6. 2020년 크리스마스는 무슨 요일이었는가?
select date_format('20201225', '%W');
select @@lc_time_names; -- en_US -> ko_KR
set @@lc_time_names = 'ko_KR';

-- 7. STR_TO_DATE('99/10/11', '%y/%m/%d'), STR_TO_DATE('49/10/11', '%y/%m/%d')은 각각 몇 년 몇 월 몇 일을 의미할까?
--    또 STR_TO_DATE('70/10/11', '%y/%m/%d'), STR_TO_DATE('69/10/11', '%y/%m/%d')은 각각 몇 년 몇 월 몇 일을 의미할까?
select str_to_date('99/10/11', '%y/%m/%d'); -- 1999/10/11
select str_to_date('49/10/11', '%y/%m/%d'); -- 1949/10/11
select str_to_date('70/10/11', '%y/%m/%d'); -- 1970/10/11
select str_to_date('69/10/11', '%y/%m/%d'); -- 1969/10/11

-- 8. 학번이 A517178 인 한아름 학생의 학점 총 평점을 구하는 SQL 문을 작성하시오.
--    단, 이때 출력 화면의 헤더는 "평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한자리까지만 표시한다.
select STUDENT_NAME
from tb_student
where STUDENT_NO = 'A517178';
select STUDENT_NO
from tb_grade
where ;
select *
from tb_student;
select sum(POINT) 총학점
from tb_grade
where STUDENT_NO = 'A517178';
select *
from tb_grade
where STUDENT_NO = 'A517178';
-- 평균 = 학점 / 4(과목수)
