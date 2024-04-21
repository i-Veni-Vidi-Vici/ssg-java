-- ---------------------------
-- 춘대학 Additional SELECT 함수 실습문제2 #165
-- ---------------------------
# 1. 영어영문학과(학과코드 `002`) 학생들의 학번과 이름, 입학 년도를 입학 년도가 빠른순으로 표시하는 SQL 문장을 작성하시오.
#     ( 단, 헤더는 "학번", "이름", "입학년도" 가 표시되도록 한다.)
#     학번 이름 입학년도
#     ---------- -------------------- -----------
#
#     A9973003 김용근  2016-03-01
#     A473015 배용원  2021-03-01
#     A517105 이신열  2022-03-01
select STUDENT_NO 학번,
       STUDENT_NAME 이름,
       date_format(ENTRANCE_DATE, '%Y-%m-%d') 입학년도
from tb_student
where DEPARTMENT_NO = (select DEPARTMENT_NO
                       from tb_department
                       where DEPARTMENT_NAME = '영어영문학과')
order by ENTRANCE_DATE;

# 2. 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 한 명 있다고 한다.
# 그 교수의 이름과 주민번호를 화면에 출력하는 SQL 문장을 작성해 보자.
#     PROFESSOR_NAME PROFESSOR_SSN
#     -------------------- --------------
#     강혁 601004-1100528
#     박강아름 681201-2134896
select PROFESSOR_NAME,
       PROFESSOR_SSN
from tb_professor
where PROFESSOR_NAME not like '___';

# 3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오.
# 단 이때 나이가 적은 사람에서 많은 사람 순서로 화면에 출력되도록 만드시오.
# (단, 교수 중 2000 년 이후 출생자는 없으며 출력 헤더는 "교수이름", "나이"로 한다. 나이는 ‘만’으로 계산한다.)
#     교수이름 나이
#     -------------------- ----------
#     주영상 43
#     제상철 44
#     김명석 45
#     신영호 45
#     김태봉 47
#     ...
#     --------------------------------
#     75 rows selected
select PROFESSOR_NAME 교수이름,
       floor(datediff(now(), concat('19', substring(PROFESSOR_SSN, 1, 6))) / 365) 나이
from tb_professor
where substring(PROFESSOR_SSN, 8, 1) = '1'
order by 2, 1;

# 4. 교수들의 이름 중 성을 제외한 이름만 출력하는 SQL 문장을 작성하시오. 출력 헤더는`’이름’` 이 찍히도록 한다.
# (성이 2 자인 경우는 교수는 없다고 가정하시오)
#     이름
#     --------------------------------------
#     진영
#     윤필
#     ...
#     ...
#     해원
#     혁호
#     ---------------------------------------
#     114 rows selected
select substr(professor_name, 2) 이름
from tb_professor;

# 5. 춘 기술대학교의 재수생 입학자를 구하려고 한다. 어떻게 찾아낼 것인가?
# 이때, 만 19살이 되는 해에 입학하면 재수를 하지 않은 것으로 간주한다.
#     STUDENT_NO STUDENT_NAME
#     ---------- --------------------
#     A011032,김태광
#     A011113,박태규
#     ...
#     ...
#     A9931311,조기현
#     A9931312,조기환
#     --------------------------------
#     204 rows selected
-- 방법1
select STUDENT_NO,
       STUDENT_NAME
from tb_student
where
    year(ENTRANCE_DATE) - (left(STUDENT_SSN, 2) + if(mid(STUDENT_SSN, 8, 1) in ('1', '2'), 1900, 2000)) > 19
order by 1;

-- 방법2 (case when then else end 사용)
select STUDENT_NO,
       STUDENT_NAME
from tb_student
where
    year(ENTRANCE_DATE) - (case when mid(STUDENT_SSN, 8, 1) in ('1', '2') then 1900 else 2000 end
                               + cast(left(STUDENT_SSN, 2) as unsigned)) > 19
order by 1;

# 6. 2020년 크리스마스는 무슨 요일이었는가?
set @@lc_time_names = 'ko_KR';
select dayname('2020-12-25');

# 7. *`STR_TO_DATE*('99/10/11', '%y/%m/%d')` *`STR_TO_DATE*('49/10/11', '%y/%m/%d')`은 각각 몇 년 몇 월 몇 일을 의미할까?
# 또 *`STR_TO_DATE*('70/10/11', '%y/%m/%d')` *`STR_TO_DATE*('69/10/11', '%y/%m/%d')` 은 각각 몇 년 몇 월 몇 일을 의미할까?
select str_to_date('99/10/11', '%y/%m/%d'); -- 1999-10-11
select str_to_date('49/10/11', '%y/%m/%d'); -- 2049-10-11
select str_to_date('70/10/11', '%y/%m/%d'); -- 1970-10-11
select str_to_date('69/10/11', '%y/%m/%d'); -- 2069-10-11

# 8. 학번이 `A517178` 인 한아름 학생의 학점 총 평점을 구하는 SQL 문을 작성하시오.
# 단, 이때 출력 화면의 헤더는 "평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한자리까지만 표시한다.
#     평점
#     ----------
#     3.6
#     ----------
#     1 개의 행이 선택되었습니다.
select round(avg(POINT), 1) 평점
from tb_grade
where STUDENT_NO = 'A517178';

# 9. 학과별 학생수를 구하여 "학과번호", "학생수(명)" 의 형태로 헤더를 만들어 결과값이 출력되도록 하시오.
#     학과번호 학생수(명)
#     ---------- ----------
#     001 14
#     002 3
#     ...
#     ...
#     061 7
#     062 8
#     --------------------
#     62 rows selected
select DEPARTMENT_NO 학과번호,
       count(*) "학생수(명)"
from tb_student
group by 1
order by 1;

# 10. 지도 교수를 배정받지 못한 학생의 수는 몇 명 정도 되는 알아내는 SQL 문을 작성하시오.
#     COUNT(*)
#     ----------
#              9
select COUNT(*)
from tb_student
where COACH_PROFESSOR_NO is null;

# 11. 학번이 `A112113` 인 김고운 학생의 년도 별 평점을 구하는 SQL 문을 작성하시오.
# 단, 이때 출력 화면의 헤더는 "년도", "년도 별 평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한자리까지만 표시한다.
#     년도 년도별 평점
#     -------- ------------
#     2018	2.8
#     2019	2.3
#     2020	4.0
#     2021	3.5
select substring(TERM_NO, 1 ,4) 년도,
       round(avg(POINT), 1) "년도 별 평점"
from tb_grade
where STUDENT_NO = 'A112113'
group by 1;

# 12. 학과 별 휴학생 수를 파악하고자 한다.
# 학과 번호와 휴학생 수를 표시하는 SQL 문장을 작성하시오.
#     학과코드명 휴학생 수
#     ------------- ------------------------------
#     001 2
#     002 0
#     003 1
#     061 2
#     062 2
#     ...62 rows selected
#     -------------------------------------------
select d.DEPARTMENT_NO 학과코드명,
       COUNT(s.STUDENT_NO) "휴학생 수"
from tb_department d
    left join tb_student s
        on d.DEPARTMENT_NO = s.DEPARTMENT_NO
               and s.ABSENCE_YN = 'Y'
group by 1
order by 1; -- 063 체육학과 포함해서 63행 나옴

# 13. 춘 대학교에 다니는 동명이인(同名異人) 학생들의 이름을 찾고자 한다. 어떤 SQL 문장을 사용하면 가능하겠는가?
#     동일이름 동명인 수
#     -------------------- ----------
#     김경민 2
#     김명철 2
#     ...
#     조기현 2
#     최효정 2
#     -------------------------------------------
#     20 rows selected
select STUDENT_NAME 동일이름,
       count(*) "동명인 수"
from tb_student
group by STUDENT_NAME
having count(*) > 1
order by 1 asc;

# 14. 학번이 `A112113` 인 김고운 학생의 년도, 학기 별 평점과 년도 별 누적 평점 , 총평점을 구하는 SQL 문을 작성하시오. (단, 평점은 소수점 1 자리까지만 반올림하여 표시한다.
#     년도 학기 평점
#     -------- ---- ------------
#     2018	01	2.5
#     2018	02	3.0
#     2018		  2.8
#     2019	01	2.0
#     2019	02	2.5
#     2019		  2.3
#     2020	01	3.5
#     2020	02	4.5
#     2020	03	4.0
#     2020		  4.0
#     2021	01	4.0
#     2021	02	3.0
#     2021		  3.5
#     					3.2
#     -------------------------------------------
#     14 rows selected
select left(TERM_NO, 4) 년도,
       substring(TERM_NO, 5, 2) 학기,
       round(avg(POINT), 1) 평점
from tb_grade
where STUDENT_NO = 'A112113'
group by 1,2 with rollup;

-- 나지영님의 ISSUE에 대해 해보기--

# 1.group by에 TERM_NO 추가(결과: 출력값이 중복으로 나옴..)
select
    if(grouping(left(TERM_NO, 4)) = 0, left(TERM_NO, 4), '총 평점') 년도,
    if(grouping(substring(TERM_NO, 5, 2)) = 0, substring(TERM_NO, 5, 2), '학기 별 평점') 학기,
    round(avg(POINT), 1) 평점
from tb_grade
where STUDENT_NO = 'A112113'
group by left(TERM_NO, 4), substring(TERM_NO, 5, 2), TERM_NO with rollup;

# 2.case 사용 (되긴 된다.)
select
    case
        when 년도 is null then '총평점'
        else 년도
        end as 년도,
    case
        when 학기 is null then '학기 별 평점'
        else 학기
        end as 학기,
    round(평점, 1) as 평점
from (
         select
             left(TERM_NO, 4) as 년도,
             substring(TERM_NO, 5, 2) as 학기,
             round(avg(POINT), 1) as 평점
         from tb_grade
         where STUDENT_NO = 'A112113'
         group by 년도, 학기 with rollup
     ) as z
order by
    case
        when 년도 = '총평점' then 1
        else 0
        end asc,
    년도,
    학기;
