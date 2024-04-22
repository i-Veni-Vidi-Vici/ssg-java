create database chundb;
use chundb;
grant all privileges on chundb.* to 'sh'@'%';

select *
from
    tb_class;
select *
from tb_class_professor;
select *
from tb_department;
select *
from tb_grade;
select *
from tb_student;
select *
from tb_professor;

-- 1.
select
    DEPARTMENT_NAME as 학과명,
    CATEGORY as 계열
from tb_department;

-- 2.
select
    concat(DEPARTMENT_NAME, '의 정원은 ', CAPACITY, '명 입니다.')
from
    tb_department;
-- 3.
select
    STUDENT_NAME
from tb_student st
where st.ABSENCE_YN = 'Y' and (substring(st.STUDENT_SSN, 8,1)=2 or substring(st.STUDENT_SSN, 8,1)=4)
  and st.DEPARTMENT_NO = (select DEPARTMENT_NO from tb_department where DEPARTMENT_NAME='국어국문학과');

-- 4.
select
    STUDENT_NAME
from
    tb_student
where STUDENT_NO in ('A513079', 'A513090', 'A513091', 'A513110', 'A513119')
order by STUDENT_NAME desc;

-- 5.
select
    DEPARTMENT_NAME as 학과명,
    CATEGORY as 계열
from tb_department
where
    CAPACITY between 20 and 30;

-- 6.
select
    PROFESSOR_NAME
from
    tb_professor
where
    isnull(DEPARTMENT_NO);

-- 7.
select
    *
from tb_student
where isnull(DEPARTMENT_NO);

-- 8.
select
    CLASS_NO
from tb_class
where PREATTENDING_CLASS_NO is not null;

-- 9.
select
    CATEGORY
from tb_department
group by CATEGORY;

-- 10.
select
    STUDENT_NO as 학번,
    STUDENT_NAME as 이름,
    STUDENT_SSN as 주민등록번호
from tb_student
where year(ENTRANCE_DATE)=2019 and (STUDENT_ADDRESS like '%전주%') and ABSENCE_YN='N';
