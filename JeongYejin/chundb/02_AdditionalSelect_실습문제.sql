# 165
use chundb;

-- 1
select student_no 학번, student_name 이름, date_format(entrance_date, '%y-%m-%d') 입학년도
from tb_student
where department_no = 2
order by entrance_date;

-- 2
desc chundb.tb_professor;

select professor_name, professor_ssn
from tb_professor
where professor_name not like '___';

-- 3
select PROFESSOR_NAME 교수이름,
       year(curdate()) - concat(19, substr(PROFESSOR_SSN, 1, 2)) +
       (case
        when substr(PROFESSOR_SSN, 3, 4) < date_format(curdate(), '%m%d') then 0
        else -1
        end) 나이
from tb_professor
where substr(PROFESSOR_SSN, 8, 1) = 1
order by 나이;

-- 4
select
    case
        when PROFESSOR_NAME like '__' then substr(PROFESSOR_NAME, 2, 1)
        when PROFESSOR_NAME like '___' then substr(PROFESSOR_NAME, 2, 2)
        when PROFESSOR_NAME like '____' then substr(PROFESSOR_NAME, 3, 4)
    end
from tb_professor;

-- 5
-- 2019년도 2000, 2018년도 1999, 2017년도 1998, 2016년도 1997 .. 19차이!
select STUDENT_NO, STUDENT_NAME
from tb_student;

select STUDENT_NO, STUDENT_NAME
from tb_student s join (
    select STUDENT_NO,
        case
            when substr(STUDENT_SSN, 8, 1) in (3, 4) then concat(20, left(STUDENT_SSN, 2))
            -- substr, substring, mid의 사용법이 같다!
            when substr(STUDENT_SSN, 8, 1) in (1, 2) then concat(19, left(STUDENT_SSN, 2))
            -- left써보기!
            end birth_year
    from tb_student
) t using(student_no)
where year(ENTRANCE_DATE) - 19 > t.birth_year; -- (입학년도-19(살))했을 때 기준연도(현역)가 출생연도보다 큰가(어린가)?

-- 6
-- 지역 변경
select @@lc_time_names; -- en_US -> ko_KR
set @@lc_time_names = 'ko_KR';

select dayname('20201225');
select date_format('2020-12-25', '%W');

-- 7
select STR_TO_DATE('99/10/11', '%y/%m/%d'); -- 1999
select STR_TO_DATE('70/10/11', '%y/%m/%d'); -- 1970
-- Y < 70 : 20XX
-- Y >= 70 : 19XX
select STR_TO_DATE('69/10/11', '%y/%m/%d'); -- 2069
select STR_TO_DATE('49/10/11', '%y/%m/%d'); -- 2049

-- 8
select round(avg(point), 1) 평점
from tb_grade
where STUDENT_NO = 'A517178';

-- 9
select department_no 학과번호, count(*) '학생수(명)'
from tb_student
group by DEPARTMENT_NO;

-- 10
select count(*)
from tb_student
where COACH_PROFESSOR_NO is null;

-- 11
select substr(TERM_NO, 1, 4) 년도, round(avg(POINT), 1) '년도별 평점'
from tb_grade
where STUDENT_NO = 'A112113'
group by substr(TERM_NO, 1, 4);

-- 12
select DEPARTMENT_NO 학과코드명, count(if(ABSENCE_YN= 'Y', 1, null)) '휴학생 수'
from tb_student
group by DEPARTMENT_NO;

-- 13
select student_name, count(*)
from tb_student
group by STUDENT_NAME
having count(*)>=2
order by 1;

-- 14
# select substr(TERM_NO, 1, 4) 년도,
#        substr(TERM_NO, 5,2) 학기,
#        round(avg(point),1) 평점
select if(grouping(substr(TERM_NO, 1, 4)) = 0, substr(TERM_NO, 1, 4), '전체')  년도,
       if(grouping(substr(TERM_NO, 5,2)) = 0, substr(TERM_NO, 5,2), '소계') 학기,
       round(avg(point),1) 평점
from tb_grade
where STUDENT_NO = 'A112113'
group by substr(TERM_NO, 1, 4), substr(TERM_NO, 5,2), TERM_NO with rollup;

select grouping(substr(TERM_NO, 1, 4)), -- with rollup과 함께 사용하는 grouping, 묶으면 1!
       grouping(substr(TERM_NO, 5,2)),
       round(avg(point),1)
from tb_grade
where STUDENT_NO = 'A112113'
group by substr(TERM_NO, 1, 4), substr(TERM_NO, 5,2), TERM_NO with rollup ;