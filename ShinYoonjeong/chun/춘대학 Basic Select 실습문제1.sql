show databases;
use chundb;
select * from TB_DEPARTMENT; --  학과테이블
select * from TB_STUDENT; -- 학생테이블
select * from TB_PROFESSOR; -- 교수테이블
select * from TB_CLASS; -- 수업테이블
select * from TB_CLASS_PROFESSOR; -- 수업교수테이블
select * from TB_GRADE; -- 학점테이블

select DEPARTMENT_NAME 학과명,
       CATEGORY 계열
from tb_department;

select DEPARTMENT_NAME,
       count(distinct DEPARTMENT_NO)
from tb_department
where DEPARTMENT_NO in (
    select DEPARTMENT_NO
    from tb_student

    )
group by DEPARTMENT_NO;

select STUDENT_NAME
from tb_student
where '국어국문학과' in (
    select DEPARTMENT_NAME
    from tb_department
    )
and
    substring(STUDENT_SSN, 8, 1) in(2,4)
and 'Y' = ABSENCE_YN;

select STUDENT_NAME
from tb_student
where
    case STUDENT_NO
    when 'A513079' then STUDENT_NAME
    when 'A513090' then STUDENT_NAME
    when 'A513091' then STUDENT_NAME
    when 'A513110' then STUDENT_NAME
    when 'A513119' then STUDENT_NAME
end;