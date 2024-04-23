# 1.학생이름과 주소지를 표시하시오. 단, 출력 헤더는 "학생 이름", "주소지"로 하고, 정렬은 이름으로 오름차순 표시하도록 한다.
select
    STUDENT_NAME 학생이름,
    STUDENT_ADDRESS 주소지
from
    tb_student
order by STUDENT_NAME;

# 2.휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오.
select
    STUDENT_NAME 이름,
    STUDENT_SSN 주민번호
from
    tb_student
where
    ABSENCE_YN = 'Y'
order by if(substring(STUDENT_SSN, 8,1) in (1,2),
            concat(19, left(STUDENT_SSN,2)),
            concat(20, left(STUDENT_SSN,2))
           ) desc;

# 3. 주소지가 강원도나 경기도인 학생들 중 2020년대 학번을 가진 학생들의 이름과 학번, 주소를 이름의 오름차순으로 화면에 출력하시오. 단, 출력헤더에는 "학생이름","학번", "거주지 주소" 가 출력되도록 한다.
select
    STUDENT_NAME 이름,
    STUDENT_NO 학번,
    STUDENT_ADDRESS 주소
from
    tb_student
where
    (STUDENT_ADDRESS like '%강원%'
         or STUDENT_ADDRESS like '%경기%'
         or STUDENT_ADDRESS like '%부천%'
         or STUDENT_ADDRESS like '%수원%'
         or STUDENT_ADDRESS like '%성남%')
     and ENTRANCE_DATE like '202%'
order by STUDENT_NAME;

# 4. 현재 법학과 교수 중 가장 나이가 많은 사람부터 이름을 확인핛 수 있는 SQL 문장을 작성하시오. (법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아 내도록 하자)
select
    PROFESSOR_NAME,
    PROFESSOR_SSN
from
    tb_professor p
where
    p.DEPARTMENT_NO = (select DEPARTMENT_NO from tb_department where DEPARTMENT_NAME = '법학과')
order by 2;

# 5. 2022 년 2학기에 C3118100 과목을 수강한 학생들의 학점을 조회하려고 핚다. 학점이 높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을 작성해보시오.
select
    s.STUDENT_NO 학번,
    g.POINT 학점
from
    tb_student s join tb_grade g on s.STUDENT_NO = g.STUDENT_NO
where
    g.CLASS_NO = 'C3118100' and g.TERM_NO = '202202'
order by g.POINT desc, s.STUDENT_NO;


# 6. 학생 번호, 학생 이름, 학과 이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL 문을 작성하시오.
select
    STUDENT_NO 학번,
    STUDENT_NAME 이름,
    (select DEPARTMENT_NAME from tb_department where s.DEPARTMENT_NO = DEPARTMENT_NO) as 학과명
from
    tb_student s;

# 7. 춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는 SQL 문장을 작성하시오.
select
    CLASS_NAME 과목명,
    (select DEPARTMENT_NAME from tb_department where c.DEPARTMENT_NO = DEPARTMENT_NO) 학과명
from
    tb_class c
order by 2, 1;

# 8. 과목별 교수 이름을 찾으려고 한다. 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오.
select
    (select CLASS_NAME from tb_class where cp.CLASS_NO = CLASS_NO) 과목명,
    (select PROFESSOR_NAME from tb_professor where cp.PROFESSOR_NO = PROFESSOR_NO) 교수
from
    tb_class_professor cp
order by
    1, 2 desc;

# 9. 8 번의 결과 중 ‘인문사회’ 계열에 속한 과목의 교수 이름을 찾으려고 한다. 이에 해당하는 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오.
select
    (select CLASS_NAME from tb_class where cp.CLASS_NO = CLASS_NO) 과목명,
    (select PROFESSOR_NAME from tb_professor where cp.PROFESSOR_NO = PROFESSOR_NO) 교수
from
    tb_class_professor cp
where
    cp.PROFESSOR_NO in (select PROFESSOR_NO
                        from tb_professor
                        where DEPARTMENT_NO in (select DEPARTMENT_NO
                                                from tb_department
                                                where CATEGORY = '인문사회'
                                                )
                        );

# 10. ‘음악학과’ 학생들의 평점을 구하려고 핚다. 음악학과 학생들의 "학번", "학생 이름", "전체 평점"을 출력하는 SQL 문장을 작성하시오. (단, 평점은 소수점 1 자리까지만 반올림하여 표시한다.)
select
    s.STUDENT_NO 학번,
    s.STUDENT_NAME 이름,
    truncate(avg(tg.POINT),1) 전체평점
from
    tb_student s join tb_grade tg on s.STUDENT_NO = tg.STUDENT_NO
where
    DEPARTMENT_NO = (select DEPARTMENT_NO from tb_department where DEPARTMENT_NAME = '음악학과')
group by s.STUDENT_NO
order by 3 desc;

# 11. 학번이 A313047 인 학생이 학교에 나오고 있지 않다. 지도 교수에게 내용을 전달하기 위한 학과 이름, 학생 이름과 지도 교수 이름이 필요하다. 이때 사용할 SQL 문을 작성하시오.
#     단, 출력헤더는 ‚’학과이름‛, ‚학생이름‛, ‚지도교수이름‛으로 출력되도록 한다.
select
    d.DEPARTMENT_NAME 학과이름,
    s.STUDENT_NAME 학생이름,
    p.PROFESSOR_NAME 지도교수이름
from
    tb_student s join tb_professor p on s.COACH_PROFESSOR_NO = p.PROFESSOR_NO
    join tb_department d on s.DEPARTMENT_NO = d.DEPARTMENT_NO
where
    STUDENT_NO = 'A313047'

# 12. 2022년도에 인간관계론 과목을 수강한 학생을 찾아 학생이름과 수강학기를 표시하는 SQL 문장을 작성하시오
select
    STUDENT_NAME 학생이름,
    g.TERM_NO 수강학기
from
    tb_student s join tb_grade g on s.STUDENT_NO = g.STUDENT_NO
where
     g.CLASS_NO = (select CLASS_NO from tb_class where CLASS_NAME = '인간관계론')
    and left(g.TERM_NO, 4) = '2022';

# 13. 예체능 계열 과목 중 과목 담당교수를 한명도 배정받지 못한 과목을 찾아 그 과목 이름과 학과 이름을 출력하는 SQL 문장을 작성하시오.
select
    t1.CLASS_NAME 과목명,
    (select DEPARTMENT_NAME from tb_department where DEPARTMENT_NO = t1.DEPARTMENT_NO) 학과명
from
    (select
         CLASS_NAME,
         DEPARTMENT_NO
     from tb_class c left join tb_class_professor p on c.CLASS_NO = p.CLASS_NO
     where DEPARTMENT_NO in (select DEPARTMENT_NO
                             from tb_department
                             where CATEGORY = '예체능')
     and p.PROFESSOR_NO is null) t1;

# 14. 춘 기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 핚다. 학생이름과 지도교수 이름을 찾고 맊일 지도 교수가 없는 학생일 경우 "지도교수 미지정”으로 표시하도록 하는 SQL 문을 작성하시오.
#     단, 출력헤더는 “학생이름”, “지도교수”로 표시하며 고학번 학생이 먼저 표시되도록 한다.
select
    STUDENT_NAME 학생이름,
    ifnull((select PROFESSOR_NAME from tb_professor where s.COACH_PROFESSOR_NO = PROFESSOR_NO), '지도교수미지정')
from
    tb_student s
where
    DEPARTMENT_NO = (select DEPARTMENT_NO from tb_department where DEPARTMENT_NAME = '서반아어학과');

# 15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과 이름, 평점을 출력하는 SQL 문을 작성하시오.
select
    s.STUDENT_NO 학번,
    s.STUDENT_NAME 이름,
    (select d.DEPARTMENT_NAME from tb_department d where s.DEPARTMENT_NO = d.DEPARTMENT_NO) 학과이름,
    truncate((select avg(point) from tb_grade where s.STUDENT_NO = STUDENT_NO group by STUDENT_NO),1) 평점
from
    tb_student s
where
    ABSENCE_YN = 'N'
    and STUDENT_NO in (select STUDENT_NO from tb_grade group by STUDENT_NO having avg(POINT)>=4.0);

# 16.환경조경학과 전공과목들의 과목 별 평점을 파악할 수 있는 SQL 문을 작성하시오.
select
    CLASS_NO 학과번호,
    CLASS_NAME 학과명,
    (select avg(POINT)from tb_grade g where c.CLASS_NO = g.CLASS_NO group by g.CLASS_NO) 평점
from
    tb_class c
where
    DEPARTMENT_NO = (select DEPARTMENT_NO from tb_department where DEPARTMENT_NAME = '환경조경학과')
     and CLASS_TYPE like '전공%'
order by 1;

# 17. 춘 기술대학교에 다니고 있는 최경희 학생과 같은 과 학생들의 이름과 주소를 출력하는 SQL 문을 작성하시오.
select
    STUDENT_NAME 이름,
    STUDENT_ADDRESS 주소
from
    tb_student
where
    DEPARTMENT_NO = (select DEPARTMENT_NO from tb_student where STUDENT_NAME = '최경희');

# 18. 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 표시하는 SQL 문을 작성하시오.
select
     s.STUDENT_NO 학번,
     s.STUDENT_NAME 이름
from
    tb_student s join chundb.tb_grade tg on s.STUDENT_NO = tg.STUDENT_NO
where
    DEPARTMENT_NO = (select DEPARTMENT_NO from tb_department where DEPARTMENT_NAME = '국어국문학과')
group by
    s.STUDENT_NO
order by avg(point) desc
limit 1;

# 19. 춘 기술대학교의 "환경조경학과"가 속한 같은 계열 학과들의 학과 별 전공과목 평점을 파악하기 위한 적절한 SQL 문을 찾아내시오. 단, 출력헤더는 "계열 학과명", "전공평점"으로 표시되도록 하고, 평점은 소수점 한 자리까지만 반올림하여 표시되도록 한다.
select
    d.DEPARTMENT_NAME 계열학과명,
    round(avg((select avg(POINT)
            from tb_grade g
            where g.CLASS_NO =c.CLASS_NO
            group by c.CLASS_NO )
            ),
          1) 전공평점
from
    tb_department d join tb_class c on d.DEPARTMENT_NO = c.DEPARTMENT_NO
where d.CATEGORY = (select CATEGORY from tb_department where DEPARTMENT_NAME = '환경조경학과')
    and c.CLASS_TYPE like '전공%'
group by
    DEPARTMENT_NAME
order by 1;
