show databases ;
create database chundb;
grant all privileges on chundb.* to 'sh'@'%';
show grants for 'sh'@'%';


show tables;
select * from tb_student;
-- 1. 학생이름과 주소지를 표시하시오. 단, 출력 헤더는 "학생 이름", "주소지"로 하고, 정렬은 이름으로 오름차순 표시하도록 한다.
select student_name 학생이름, STUDENT_ADDRESS 주소지
from tb_student
order by STUDENT_NAME;

-- 2. 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오.

select STUDENT_NAME,student_ssn
from tb_student
where Absence_YN = 'Y'
order by STUDENT_SSN;

select * from tb_student;
-- 3.주소지가 강원도나 경기도인 학생들 중 2020년대 학번을 가진 학생들의 이름과 학번, 주소를 이름의 오름차순으로 화면에 출력하시오.
--  단, 출력헤더에는 "학생이름","학번", "거주지 주소" 가 출력되도록 한다.
-- 주소지가 강원도나 경기도 + 2020년대 학번(year(Entrance_Date) >= 2020)
select STUDENT_NAME 학생이름,
       STUDENT_NO 학번,
       STUDENT_ADDRESS '거주지 주소'
from tb_student
where ((STUDENT_ADDRESS like '경기%') or (STUDENT_ADDRESS like '강원%'))
            AND
        year(ENTRANCE_DATE) between 2020 and 2030
order by student_name;

-- 4. 현재 법학과 교수 중 가장 나이가 많은 사람부터 이름을 확인핛 수 있는 SQL 문장을 작성하시오.
-- 법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아 내도록 하자)
show tables;
select * from tb_grade;
select * from tb_department; -- 05
select * from tb_professor;
select * from tb_class_professor;

select PROFESSOR_NAME ,
       PROFESSOR_SSN
from tb_professor
where DEPARTMENT_NO = 05
order by PROFESSOR_SSN

-- 5. 2022 년 2학기에 C3118100 과목을 수강한 학생들의 학점을 조회하려고 핚다. 학점이 높은 학생부터 표시하고,
--    학점이 같으면 학번이 낮은 학생부터 표시하는 구문을 작성해보시오.
select * from tb_department;
desc tb_grade;
select s.student_no,point
from tb_student s join
    (select * from tb_grade where class_no = 'c3118100' and TERM_NO = '202202' ) c
       on s.student_NO = c.STUDENT_NO
order by c.point DESC, s.student_no ASC;

-- 6.학생 번호, 학생 이름, 학과 이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL 문을 작성하시오.
select STUDENT_NO, STUDENT_NAME,DEPARTMENT_NAME
from tb_student s join tb_department d
        on s.DEPARTMENT_NO = d.DEPARTMENT_NO
order by STUDENT_NAME;

-- 7.춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는 SQL 문장을 작성하시오.
select CLASS_NAMe 과목이름 , DEPARTMENT_NAME 과목학과이름
    from tb_department d join tb_class c
        on d.DEPARTMENT_NO = c.DEPARTMENT_NO;

show tables;
select * from tb_department
select * from tb_professor;
select * from tb_class_professor
select * from tb_class

-- 8.과목별 교수 이름을 찾으려고 한다. 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오.
select cp.CLASS_NAME 과목이름,  p.PROFESSOR_NAME 교수이름
from tb_professor p join tb_class cp
        on p.DEPARTMENT_NO = cp.DEPARTMENT_NO
order by CLASS_NAME;

select *
from tb_professor p join tb_class cp
                         on p.DEPARTMENT_NO = cp.DEPARTMENT_NO;
-- 9.8 번의 결과 중 ‘인문사회’ 계열에 속한 과목의 교수 이름을 찾으려고 한다.
-- 이에 해당하는 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오.
select t. 과목이름, t.교수이름
from (select p.DEPARTMENT_NO,cp.CLASS_NAME 과목이름,  p.PROFESSOR_NAME 교수이름
      from tb_professor p join tb_class cp
                               on p.DEPARTMENT_NO = cp.DEPARTMENT_NO) t
      join tb_department d
      on t.DEPARTMENT_NO = d.DEPARTMENT_NO
where d.CATEGORY like '인문사회';

desc tb_department;

-- 10. ‘음악학과’ 학생들의 평점을 구하려고 핚다. 음악학과 학생들의 "학번", "학생 이름", "전체 평점"을 출력하는 SQL 문장을 작성하시오.
 -- (단, 평점은 소수점 1 자리까지만 반올림하여 표시한다.)
-- 음악학과 59
-- 학생들의 전체 평점 구한다음 합하고 음악학과인거 판별할것
select distinct
    STUDENT_NO,
            round(sum(point) over (partition by STUDENT_NO) /
            count(STUDENT_NO) over (partition by STUDENT_NO),1)
                       학점평균
from tb_grade ;


select s.STUDENT_NO 학번,
       STUDENT_NAME 이름,
       a.학점평균
from tb_student s
         join (select distinct STUDENT_NO,
                 round(
                 sum(point) over (partition by STUDENT_NO) /
                 count(STUDENT_NO) over (partition by STUDENT_NO),
                 1) 학점평균
               from tb_grade) a
         on s.STUDENT_NO = a.STUDENT_NO
where s.DEPARTMENT_NO = '059';

-- 11. 9. 학번이 `A313047` 인 학생이 학교에 나오고 있지 않다.
-- 지도 교수에게 내용을 전달하기 위한 학과 이름, 학생 이름과 지도 교수 이름이 필요하다. 이때 사용할 SQL 문을 작성하시오.
-- 단, 출력헤더는 ‚’학과이름‛, ‚학생이름‛, ‚지도교수이름‛으로 출력되도록 한다.
    -- (학과이름 학생이름 조인 교수 조인) 학번 = a313047
select
    s.STUDENT_NO,
    DEPARTMENT_NAME 학과이름,
    STUDENT_NAME 학생이름,
    p.PROFESSOR_NAME 지도교수이름
from tb_student s
    join tb_department d
        on s.DEPARTMENT_NO =  d. DEPARTMENT_NO
    join tb_professor p
        on p.PROFESSOR_NO = s.COACH_PROFESSOR_NO
where STUDENT_no = 'A313047';


-- 12.2022년도에 인간관계론 과목을 수강한 학생을 찾아 학생이름과 수강학기를 표시하는 SQL 문장을 작성하시오
-- 학생이름과 수강학기 표시,
-- Grade, student , class 합치고 거기서 (인간관계론, 2022 and연산자)
SELECT
    s.STUDENT_NAME AS 학생이름,
    g.TERM_NO AS 수강학기
FROM
    tb_grade g
        JOIN
    tb_student s ON g.STUDENT_NO = s.STUDENT_NO
        JOIN
    tb_class c ON g.CLASS_NO = c.CLASS_NO
WHERE
    c.CLASS_NAME = '인간관계론'
  AND g.TERM_NO LIKE '2022%';

-- 13. 예체능 계열 과목 중 과목 담당교수를 한명도 배정받지 못한 과목을 찾아 그 과목 이름과 학과 이름을 출력하는 SQL 문장을 작성하시오.
-- 모르겠어요



-- 14.  춘 기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 핚다. 학생이름과 지도교수 이름을 찾고 맊일 지도 교수가 없는
-- 학생일 경우 "지도교수 미지정”으로 표시하도록 하는 SQL 문을 작성하시오.
-- 단, 출력헤더는 “학생이름”, “지도교수”로 표시하며 고학번 학생이 먼저 표시되도록 한다.
-- 지도 교수 게시 , 서반어학과
select
    STUDENT_NAME 학생이름,
    ifnull(p.PROFESSOR_NAME, '지도교수 미지정') 지도교수

from tb_student s join tb_department d
    on s.DEPARTMENT_NO = d.DEPARTMENT_NO
    left join tb_professor p
    on s.COACH_PROFESSOR_NO = p.PROFESSOR_NO
where d.DEPARTMENT_Name = '서반아어학과';

-- 15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과 이름, 평점을 출력하는 SQL 문을 작성하시오.
-- 일단 휴학생이 아닌 학생
select * from tb_student where ABSENCE_YN = 'N';
-- 평점이 4.0이상
with
Grade
         as (select distinct STUDENT_NO,
                             round(sum(point) over (partition by STUDENT_NO) /
                             count(STUDENT_NO) over (partition by STUDENT_NO), 1)
                             학점평균
             from tb_grade),
NoAbsent
         as (select *
             from tb_student
             where ABSENCE_YN = 'N'
    )
select
    n.STUDENT_NO 학번,
    n.STUDENT_NAME 이름,
    DEPARTMENT_NAME 학과이름,
    g.학점평균

from Grade g
    join NoAbsent n
        on g.STUDENT_NO = n.STUDENT_NO
    join tb_department d
        on d.DEPARTMENT_NO = n.DEPARTMENT_NO
where 학점평균 >= 4.0;




-- 16. 환경조경학과 전공과목들의 과목별 평점을 파악할 수 있는 SQL 문을 작성하시오.
-- 과목별 -> 평점.. 평균-> partition by로
select distinct
    g.class_NO,
    c.class_name,
    avg(point) over(partition by CLASS_NAME ) 과목별평점
from tb_class c join tb_grade g
    on c.CLASS_NO = g.CLASS_NO
where c.DEPARTMENT_NO = '034' and c.class_Type = '전공선택'
order by CLASS_NAME;

-- 17. 춘 기술대학교에 다니고 있는 최경희 학생과 같은 과 학생들의 이름과 주소를 출력하는 SQL 문을 작성하시오.
-- 최경희 학생과 같은과
select DEPARTMENT_NO from tb_student where STUDENT_NAME like '최경희';

select
    STUDENT_NAMe 이름,
    STUDENT_ADDRESS 주소
from tb_student s
         join tb_department d
              on s.DEPARTMENT_NO = d.DEPARTMENT_NO
where s.DEPARTMENT_NO = (select department_no
                            from tb_student
                            where STUDENT_NAME like '최경희')
order by student_name;


-- 18. 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 표시하는 SQL 문을 작성하시오.
-- 점수를 내림차순으로 over()안에서 정렬 못하나요 ?
select
    distinct
    s.STUDENT_NAME,
    g.student_no,
    avg(point) over(partition by g.STUDENT_NO ) 점수
from tb_class c
         join tb_grade g
              on c.CLASS_NO = g.CLASS_NO
         join tb_student s
              on s.STUDENT_NO = g.STUDENT_NO
where c.DEPARTMENT_NO = '001'
order by 점수 desc
limit 1;



-- 19. 춘 기술대학교의 "환경조경학과"가 속한 같은 계열 학과들의 학과 별 전공과목 평점을 파악하기 위한 적절한 SQL 문을 찾아내시오.
-- 단, 출력헤더는 "계열 학과명", "전공평점"으로 표시되도록 하고, 평점은 소수점 한 자리까지만 반올림하여 표시되도록 한다.
-- 같은 계열 ? 자연과학을 말하는거 같음 ,
select * from tb_department where category = '자연과학';

select
    distinct
    d.CATEGORY 계열,
    d.DEPARTMENT_NAME 학과명,
    round(avg(point) over(partition by d.DEPARTMENT_NO),1) 평점

from tb_class c
    join tb_grade g
        on c.CLASS_NO = g.CLASS_NO
    join tb_department d
        on d.DEPARTMENT_NO = c.DEPARTMENT_NO
where d.CATEGORY = '자연과학' ;


show tables;
select * from tb_student;
select * from tb_department where category = '자연과학';
select * from tb_professor;
select * from tb_class_professor;
select * from tb_class ;
select * from tb_grade;



