# 1. 영어영문학과(학과코드 `002`) 학생들의 학번과 이름, 입학 년도를 입학 년도가 빠른순으로 표시하는 SQL 문장을 작성하시오.
#     ( 단, 헤더는 "학번", "이름", "입학년도" 가 표시되도록 한다.)
select
    STUDENT_NO 학번,
    STUDENT_NAME 이름,
    ENTRANCE_DATE
from
    tb_student
where DEPARTMENT_NO = '002'
order by ENTRANCE_DATE;

# 2. 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 한 명 있다고 한다. 그 교수의 이름과 주민번호를 화면에 출력하는 SQL 문장을 작성해 보자.
select
    PROFESSOR_NAME,
    PROFESSOR_SSN
from
    tb_professor
where char_length(PROFESSOR_NAME) != 3;

# 3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오. 단 이때 나이가 적은 사람에서 많은 사람 순서로 화면에 출력되도록 만드시오.
# (단, 교수 중 2000 년 이후 출생자는 없으며 출력 헤더는 "교수이름", "나이"로 한다. 나이는 ‘만’으로 계산한다.)
select
    PROFESSOR_NAME 교수이름,
        floor(datediff(now(),
                       concat(if(substring(PROFESSOR_SSN, 8,1) in (1, 2), '19', '20'), left(PROFESSOR_SSN, 2),
                              '-', substring(PROFESSOR_SSN, 3,2),
                              '-', substring(PROFESSOR_SSN, 5,2)))  /365) as 나이
from
    tb_professor;

# 4. 교수들의 이름 중 성을 제외한 이름만 출력하는 SQL 문장을 작성하시오. 출력 헤더는’이름’ 이 찍히도록 한다. (성이 2 자인 경우는 교수는 없다고 가정하시오)
select
    substring(PROFESSOR_NAME, 2, char_length(PROFESSOR_NAME)-1) as 이름
from
    tb_professor;

# 5. 춘 기술대학교의 재수생 입학자를 구하려고 한다. 어떻게 찾아낼 것인가? 이때, 만 19살이 되는 해에 입학하면 재수를 하지 않은 것으로 간주한다.
select
    STUDENT_NO,
    STUDENT_NAME
from
    tb_student
where
    concat (if(substring(student_ssn, 8,1) in (1, 2), '19', '20'),
            left(student_ssn, 2)) + 19 < substring(ENTRANCE_DATE, 1, 4);

# 6. 2020년 크리스마스는 무슨 요일이었는가?
select
    case
        when dayofweek('2020-12-25') = 0 then '일요일'
        when dayofweek('2020-12-25') = 1 then '월요일'
        when dayofweek('2020-12-25') = 2 then '화요일'
        when dayofweek('2020-12-25') = 3 then '수요일'
        when dayofweek('2020-12-25') = 4 then '목요일'
        when dayofweek('2020-12-25') = 5 then '금요일'
        when dayofweek('2020-12-25') = 6 then '토요일'
    end 크리스마스요일;

# 7. *`STR_TO_DATE*('99/10/11', '%y/%m/%d')` *`STR_TO_DATE*('49/10/11', '%y/%m/%d')`은 각각 몇 년 몇 월 몇 일을 의미할까?
#     또 *`STR_TO_DATE*('70/10/11', '%y/%m/%d')` *`STR_TO_DATE*('69/10/11', '%y/%m/%d')` 은 각각 몇 년 몇 월 몇 일을 의미할까?
select
    STR_TO_DATE('99/10/11', '%y/%m/%d'), -- 1999-01-11
    STR_TO_DATE('49/10/11', '%y/%m/%d'), -- 2049-10-11
    STR_TO_DATE('70/10/11', '%y/%m/%d'), -- 1970-10-11
    STR_TO_DATE('69/10/11', '%y/%m/%d');  -- 2069-10-11
# 00에서 69 사이의 연도는 2000년에서 2069년으로 해석됩니다.
# 70에서 99 사이의 연도는 1970년에서 1999년으로 해석됩니다.

# 8. 학번이 `A517178` 인 한아름 학생의 학점 총 평점을 구하는 SQL 문을 작성하시오.
# 단, 이때 출력 화면의 헤더는 "평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한자리까지만 표시한다.
select
    truncate(avg(tb_grade.POINT), 1) as 평점
from
    tb_student join tb_grade on  tb_student.STUDENT_NO = tb_grade.STUDENT_NO
where tb_student.STUDENT_NO = 'A517178';

# 9. 학과별 학생수를 구하여 "학과번호", "학생수(명)" 의 형태로 헤더를 만들어 결과값이 출력되도록 하시오.
select
    tb_department.DEPARTMENT_NO 학과번호,
    count(*) '학생수(명)'
from
    tb_department left join tb_student on tb_department.DEPARTMENT_NO = tb_student.DEPARTMENT_NO
group by
    tb_department.DEPARTMENT_NO;

# 10. 지도 교수를 배정받지 못핚 학생의 수는 몇 명 정도 되는 알아내는 SQL 문을 작성하시오.
select
    count(*)
from
    tb_student
where
    COACH_PROFESSOR_NO is null;

# 11. 학번이 A112113 인 김고운 학생의 년도 별 평점을 구하는 SQL 문을 작성하시오. 단, 이때 출력 화면의 헤더는 "년도", "년도 별 평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한자리까지만 표시핚다.
select
    left(g.TERM_NO, 4) 년도,
    round(avg(g.POINT),1) 년도별평점
from
    tb_student s join tb_grade g on s.STUDENT_NO = g.STUDENT_NO
where
    s.STUDENT_NO = 'A112113'
group by
    left(g.TERM_NO, 4);

# 12. 학과 별 휴학생 수를 파악하고자 핚다. 학과 번호와 휴학생 수를 표시하는 SQL 문장을 작성하시오.
select
    tb_department.DEPARTMENT_NO 학과코드명,
    sum(if(ABSENCE_YN='Y', 1, 0)) 휴학생수
from
    tb_department left join tb_student on tb_department.DEPARTMENT_NO = tb_student.DEPARTMENT_NO
group by
    tb_department.DEPARTMENT_NO
order by
    1;

# 13. 춘 대학교에 다니는 동명이인(同名異人) 학생들의 이름을 찾고자 한다. 어떤 SQL 문장을 사용하면 가능하겠는가?
select
    STUDENT_NAME 동일이름,
    count(STUDENT_NAME) 동명인수
from
    tb_student
group by STUDENT_NAME
having count(STUDENT_NAME)>1
order by 1;

# 14. 학번이 A112113 인 김고운 학생의 년도, 학기 별 평점과 년도 별 누적 평점 , 총평점을 구하는 SQL 문을 작성하시오. (단, 평점은 소수점 1 자리까지만 반올림하여 표시한다.
select
    left(TERM_NO, 4) 년도,
    right(TERM_NO, 2) 학기,
    round(avg(POINT),1) 평점
from tb_grade
where STUDENT_NO = 'A112113'
group by left(TERM_NO, 4), right(TERM_NO, 2) with rollup
