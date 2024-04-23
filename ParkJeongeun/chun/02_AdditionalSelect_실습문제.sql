use chundb;

# 1.
select
    STUDENT_NO 학번,
    STUDENT_NAME 이름,
    date_format(ENTRANCE_DATE, '%Y-%m-%d') 입학년도
from tb_student
where DEPARTMENT_NO = (select tb_department.DEPARTMENT_NO from tb_department where DEPARTMENT_NAME ='영어영문학과')
order by ENTRANCE_DATE;

# 2.
select
    PROFESSOR_NAME,
    PROFESSOR_SSN
from (select * from tb_professor where PROFESSOR_NAME not like '___') t;

# 3.
select
    PROFESSOR_NAME '교수이름',
    truncate((to_days(now()) - to_days(concat(substr(PROFESSOR_SSN, 1, 2) + 1900,
                                     substr(PROFESSOR_SSN, 3, 2),
                                     substr(PROFESSOR_SSN, 5, 2)
                                      )
                                )
    ) / 365, 0) '나이'
from tb_professor
where substr(PROFESSOR_SSN, 8, 1) = '1';

# 4.
select substr(PROFESSOR_NAME, 2) 이름
from tb_professor;

# 5.
select
    STUDENT_NO,
    STUDENT_NAME
from tb_student
where year(ENTRANCE_DATE) - year(concat(case substr(STUDENT_SSN, 8, 1)
                                 when '1' then 1900
                                 when '2' then 1900
                                 else 2000
                                 end + substr(STUDENT_SSN, 1, 2),
                                 substr(STUDENT_SSN, 3, 2),
                                 substr(STUDENT_SSN, 5, 2)
                            )) > 19;

# 6.
select date_format('2020-12-25', '%a'); -- Fri

# 7.
select str_to_date('99/10/11', '%y/%m/%d'); -- 1999-10-11
select str_to_date('49/10/11', '%y/%m/%d'); -- 2049-10-11 ?!
select str_to_date('70/10/11', '%y/%m/%d'); -- 1970-10-11
select str_to_date('69/10/11', '%y/%m/%d'); -- 2069-10-11 ?!

# 8.
select round(avg(POINT),1) 평점
from tb_grade
where STUDENT_NO = 'A517178';

# 9.
select
    DEPARTMENT_NO 학과번호,
    count(STUDENT_NO) '학생수(명)'
from tb_student
group by DEPARTMENT_NO;

# 10.
select count(*)
from tb_student
where COACH_PROFESSOR_NO is null;

# 11.
select
    substr(TERM_NO, 1, 4) '년도',
    round(avg(POINT), 1) '년도별 평점'
from tb_grade
where STUDENT_NO = 'A112113'
group by 년도;

############ 12.
-- (나) : 53행,,
select
    tb_department.DEPARTMENT_NO 학과코드명,
    count(*)  휴학생수
from tb_student right join tb_department
                           on tb_student.DEPARTMENT_NO = tb_department.DEPARTMENT_NO
where ABSENCE_YN = 'Y'
group by tb_department.DEPARTMENT_NO
order by tb_department.DEPARTMENT_NO;

-- (모범답안)
select
    DEPARTMENT_NO,
    count(STUDENT_NO)
from tb_student
where ABSENCE_YN = 'Y'
group by DEPARTMENT_NO;

select *
from tb_student;

############# 13.


############# 14.
select
    year(TERM_NO),
    month(TERM_NO),
    POINT
from tb_grade
where STUDENT_NO = 'A112113';

select *
from tb_department;