-- 1. root계정 chundb생성
-- 2. sh계정이 chundb 접근 가능하도록 권한 부여
-- 3. sh계정으로 chundb.sql 전체 실행
create database chundb;
grant all privileges on chundb.* to 'sh'@'%';
show grants for 'sh'@'%';
use chundb;

select * from TB_DEPARTMENT; --  학과테이블
select * from TB_STUDENT; -- 학생테이블
select * from TB_PROFESSOR; -- 교수테이블
select * from TB_CLASS; -- 수업테이블
select * from TB_CLASS_PROFESSOR; -- 수업교수테이블
select * from TB_GRADE; -- 학점테이블

# 1.
select
    DEPARTMENT_NAME 학과명,
    CATEGORY 계열
from tb_department;

# 2.
select concat(DEPARTMENT_NAME, '의 정원은 ', CAPACITY, ' 명 입니다.') '학과별 정원'
from tb_department;

# 3.
select STUDENT_NAME
from tb_student join tb_department
    using (department_no)
where DEPARTMENT_NAME = '국어국문학과' and
      substr(STUDENT_SSN, 8, 1) in (2, 4) and
      ABSENCE_YN = 'Y';

# 4.
select STUDENT_NAME
from tb_student
where STUDENT_NO in ('A513079', 'A513090', 'A513091', 'A513110', 'A513119');

# 5.
select
    DEPARTMENT_NAME,
    CATEGORY
from tb_department
where CAPACITY between 20 and 30;

# 6.
select PROFESSOR_NAME
from tb_professor
where DEPARTMENT_NO is null;

# 7.
select
    count(*)
from tb_student
where DEPARTMENT_NO is null;

# 8.
select CLASS_NO
from tb_class
where PREATTENDING_CLASS_NO is not null;

# 9.
select distinct CATEGORY
from tb_department;

# 10.
select
    STUDENT_NO,
    STUDENT_NAME,
    STUDENT_SSN
from tb_student
where year(ENTRANCE_DATE) = 2019 and
      STUDENT_ADDRESS like '%전주%' and
      ABSENCE_YN = 'N';