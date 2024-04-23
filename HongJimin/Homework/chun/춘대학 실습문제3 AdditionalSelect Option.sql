-- 1. 학생이름과 주소지를 표시하시오. 단, 출력 헤더는 "학생 이름", "주소지"로 하고, 정렬은 이름으로 오름차순 표시하도록 한다. - 🆗
select
    STUDENT_NAME 학생이름,
    STUDENT_ADDRESS 주소지
from
    tb_student
order by
    STUDENT_NAME;


-- 2.휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오. - 🆗
select
    STUDENT_NAME,
    STUDENT_SSN
from
    tb_student
where
    ABSENCE_YN = 'Y'
order by
    date(substr(STUDENT_SSN, 1, 6)) desc;


-- 3. 주소지가 강원도나 경기도인 학생들 중 2020년대 학번을 가진 학생들의 이름과 학번, 주소를 이름의 오름차순으로 화면에 출력하시오. 단, 출력헤더에는 "학생이름","학번", "거주지 주소" 가 출력되도록 한다. -♥️♥️♥️♥️ 되긴 하는데 88행으로 나옴!!
select
    *
from
    (select
         STUDENT_NAME 학생이름,
         STUDENT_NO 학번,
         STUDENT_ADDRESS '거주지 주소'
     from
         tb_student
     where
         (STUDENT_ADDRESS like '%강원%'
        or
          STUDENT_ADDRESS like '%경기%')
       and
         substr(ENTRANCE_DATE, 1, 4) >= 2020) S
order by
    학생이름;


-- 4. 현재 법학과 교수 중 가장 나이가 많은 사람부터 이름을 확인할 수 있는 SQL 문장을 작성하시오. (법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아 내도록 하자) - 🆗
select
    *
from
    (select
         PROFESSOR_NAME,
         PROFESSOR_SSN
     from
         tb_professor
     where
         DEPARTMENT_NO  = (select DEPARTMENT_NO
                           from tb_department
                           where DEPARTMENT_NAME = '법학과')
     order by
         substr(PROFESSOR_SSN, 1, 2)) P;


-- 5. 2022 년 2학기에 C3118100 과목을 수강한 학생들의 학점을 조회하려고 한다. 학점이 높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을 작성해보시오. - 🆗
select
    *
from (select
          STUDENT_NO,
          POINT
      from
          tb_grade
      where
          CLASS_NO = 'C3118100'
        and
          TERM_NO = '202202'
      ) G;


-- 6. 학생 번호, 학생 이름, 학과 이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL 문을 작성하시오. - 🆗
select
    S.STUDENT_NO,
    S.STUDENT_NAME,
    D.DEPARTMENT_NAME
from
    tb_student S join tb_department D
         on S.DEPARTMENT_NO = D.DEPARTMENT_NO
order by
    S.STUDENT_NAME;



-- 7. 춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는 SQL 문장을 작성하시오. - 🆗
select
    C.CLASS_NAME,
    D.DEPARTMENT_NAME
from
    tb_class C left join tb_department D
        using (DEPARTMENT_NO)
order by
    D.DEPARTMENT_NAME,
    CLASS_NAME;


-- 8. 과목별 교수 이름을 찾으려고 한다. 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오. - 🆗
select
    CLASS_NAME,
    PROFESSOR_NAME
from
    tb_class
        join tb_class_professor
            using (CLASS_NO)
        join tb_professor
            using (PROFESSOR_NO)
order by
    CLASS_NAME;


-- 9. 8번의 결과 중 ‘인문사회’ 계열에 속한 과목의 교수 이름을 찾으려고 한다. 이에 해당하는 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오. - 🆗
select
    CLASS_NAME,
    PROFESSOR_NAME
from
    tb_class C
        join tb_class_professor CP
             using (CLASS_NO)
        join tb_professor P
             using (PROFESSOR_NO)
where
    C.DEPARTMENT_NO in (select DEPARTMENT_NO from tb_department where CATEGORY = '인문사회')
order by
    CLASS_NAME;


-- 10. ‘음악학과’ 학생들의 평점을 구하려고 핚다. 음악학과 학생들의 "학번", "학생 이름", "전체 평점"을 출력하는 SQL 문장을 작성하시오. (단, 평점은 소수점 1 자리까지만 반올림하여 표시한다.) - 🆗
select
    *
from
    (select
         STUDENT_NO ,
         STUDENT_NAME,
         (select round(avg(POINT), 2) from tb_grade where STUDENT_NO = S.STUDENT_NO) as '전체평점'
     from
         tb_student S
     where
         DEPARTMENT_NO = (select
                              DEPARTMENT_NO
                          from
                              tb_department
                          where
                              DEPARTMENT_NAME = '음악학과')
     order by
         전체평점 desc ) P;


-- 11. 9. 학번이 `A313047` 인 학생이 학교에 나오고 있지 않다. 지도 교수에게 내용을 전달하기 위한 학과 이름, 학생 이름과 지도 교수 이름이 필요하다. 이때 사용할 SQL 문을 작성하시오.
--  단, 출력헤더는 ‚’학과이름‛, ‚학생이름‛, ‚지도교수이름‛으로 출력되도록 한다.
select
    D.DEPARTMENT_NAME 학과이름,
    S.STUDENT_NAME 학생이름,
    P.PROFESSOR_NAME 지도교수이름
from
    tb_student S
        join tb_department D
            using (DEPARTMENT_NO)
        join tb_professor P
            on S.COACH_PROFESSOR_NO = P.PROFESSOR_NO
where
    STUDENT_NO = 'A313047';


-- 12. 2022년도에 인간관계론 과목을 수강한 학생을 찾아 학생이름과 수강학기를 표시하는 SQL 문장을 작성하시오 - 🆗
select
    S.STUDENT_NAME,
    G.TERM_NO
from
    tb_grade G
        join tb_class C
            using (CLASS_NO)
        join tb_student S
            using (STUDENT_NO)
where
    C.CLASS_NAME = '인간관계론'
  and
    substr(TERM_NO, 1, 4) = '2022';

-- 13. 예체능 계열 과목 중 과목 담당교수를 한명도 배정받지 못한 과목을 찾아 그 과목 이름과 학과 이름을 출력하는 SQL 문장을 작성하시오. - 🆗
select
    C.CLASS_NAME,
    D.DEPARTMENT_NAME
from
    tb_department D
        join tb_class C
            using (DEPARTMENT_NO)
        left join tb_class_professor
            using (CLASS_NO)
where
    D.CATEGORY = '예체능' and isnull(PROFESSOR_NO)
order by
    C.CLASS_NAME;
-- 14. 12. 춘 기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 핚다. 학생이름과 지도교수 이름을 찾고 맊일 지도 교수가 없는 학생일 경우 "지도교수 미지정”으로 표시하도록 하는 SQL 문을 작성하시오. - 🆗
--  단, 출력헤더는 “학생이름”, “지도교수”로 표시하며 고학번 학생이 먼저 표시되도록 한다.
select
    S.STUDENT_NAME 학생이름,
    ifnull(P.PROFESSOR_NAME, '지도교수미지정') 지도교수
from
    tb_student S
        left join tb_department D
            using (DEPARTMENT_NO)
        left join tb_professor P
            on S.COACH_PROFESSOR_NO = P.PROFESSOR_NO
where
    D.DEPARTMENT_NAME = '서반아어학과';




-- 💥💥질문하기💥💥15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과 이름, 평점을 출력하는 SQL 문을 작성하시오.
select
    S.STUDENT_NO,
    S.STUDENT_NAME,
    D.DEPARTMENT_NAME,
    round(G.POINT, 1)
from
    tb_student S
        join tb_grade G
            using(STUDENT_NO)
        join tb_department D
            on S.DEPARTMENT_NO = D.DEPARTMENT_NO
where
    S.ABSENCE_YN = 'N';



-- 16. 환경조경학과 전공과목들의 과목 별 평점을 파악할 수 있는 SQL 문을 작성하시오. - 🆗
select
    CLASS_NAME,
    avg(G.POINT)
from
    tb_department D
        join tb_class C
            using (DEPARTMENT_NO)
        join tb_grade G
            using (CLASS_NO)

where
    DEPARTMENT_NAME = '환경조경학과'
  and
    CLASS_NAME not like '%논문%'
group by
    CLASS_NAME;

-- 17. 춘 기술대학교에 다니고 있는 최경희 학생과 같은 과 학생들의 이름과 주소를 출력하는 SQL 문을 작성하시오. - 🆗
select
    STUDENT_NAME,
    STUDENT_ADDRESS
from
    tb_student
where
    DEPARTMENT_NO = (select
                         DEPARTMENT_NO
                     from
                         tb_student
                     where
                         STUDENT_NAME = '최경희')
order by STUDENT_NAME;


-- 💥💥18.💥💥 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 표시하는 SQL 문을 작성하시오.
select
     -- 학번 표시 어떻게 함?
    STUDENT_NAME,
    avg(POINT)
from
    tb_student S
        left join tb_department D
            on S.DEPARTMENT_NO = D.DEPARTMENT_NO
        left join tb_grade G
            on S.STUDENT_NO = G.STUDENT_NO
where
    DEPARTMENT_NAME = '국어국문학과'
group by
    STUDENT_NAME
order by
    avg(POINT) desc
limit 1;

select * from chundb.tb_department;
select * from chundb.tb_professor;
select * from chundb.tb_class;
select * from chundb.tb_class_professor;
select * from chundb.tb_grade;
select * from chundb.tb_student;
-- 💥💥💥19. 춘 기술대학교의 "환경조경학과"가 속한 같은 계열 학과들의 학과 별 전공과목 평점을 파악하기 위한 적절한 SQL 문을 찾아내시오. 단, 출력헤더는 "계열 학과명", "전공평점"으로 표시되도록 하고, 평점은 소수점 한 자리까지만 반올림하여 표시되도록 한다.
select
    *
from
    tb_department
        join tb_grade
            on DEPARTMENT_NO
        join tb_student
            on
where
    CATEGORY in (select
                    CATEGORY
                from
                    tb_department
                where
                    DEPARTMENT_NAME = '환경조경학과')
# group by
#     DEPARTMENT_NAME
order by
    DEPARTMENT_NAME;