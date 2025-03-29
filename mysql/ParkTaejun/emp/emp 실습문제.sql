create database empdb;

grant all privileges on empdb.*to 'sh'@'%';

show grants for 'sh'@'%';

create schema empdb;

show TABLE STATUS ;

-- sh
select * from employee;
select * from job;
select * from department;
select * from location;
select * from nation;
select * from sal_grade;

-- 1 EMPLOYEE 테이블에서 이름 끝이 연으로 끝나는 사원의 이름을 출력.

select
    *
    from
        employee
    where
       EMP_NAME like '연%';

select
    *
    from
        employee
    where
        PHONE not like '010%';


select
    *
    from
        employee
    where
        EMAIL like '____\_%'
        and
        (DEPT_CODE like 'D5'
        or
        DEPT_CODE like 'D9')
        and
        HIRE_DATE BETWEEN '1990- 01 -01' AND  '2002-01-01'
        and
        SALARY >= 2700000;

create table tbl_escape_watch(
                                 watch_name varchar(100)
    ,description varchar(1000)
);
-- drop table tbl_escape_watch;
insert into tbl_escape_watch values('금시계', '순금 99.99% 함유 고급시계');
insert into tbl_escape_watch values('은시계', '고객 만족도 99.99점를 획득한 고급시계');
commit;
select * from tbl_escape_watch;

select
    *
    from
        tbl_escape_watch
    where
        description like '%99.99\%%'; # 기호 찾을때 \~

SELECT #SELECT * FROM 테이블명 ORDER BY id ASC; SELECT * FROM 테이블명 ORDER BY id DESC;
    *
    FROM
        employee
    ORDER BY
        EMP_NAME ASC;

SELECT
    EMP_NAME,
    HIRE_DATE,
    QUIT_DATE,
    QUIT_YN,
    datediff(ifnull(QUIT_DATE, now()),HIRE_DATE) as 근무일
    FROM
        employee;

-- 1. EMPLOYEE 테이블에서 남자만 사원번호, 사원명,주민번호,연봉을 나타내세요

SELECT
    EMP_ID 사원번호,
    EMP_NAME 사원이름,
    SALARY 연봉,
    insert(EMP_NO, 9, 6, '******')
FROM
    employee
where substr(EMP_NO,8,1) = 1 || substr(EMP_NO, 8,1) =3;

-- EMPLOYEE 테이블에서 사원명, 아이디(이메일 @ 앞부분)을 조회하세요
select
    EMP_NAME 사원이름,
    substring_index(EMAIL, '@', 1) 이메일
from
    employee;

-- 3. 파일경로를 제외하고 파일명만 아래와 같이 출력하세요


create table tbl_files (
                           file_no bigint,
                           file_path varchar(500)
);
-- drop table tbl_files
insert into tbl_files values(1, 'c:\\abc\\deft\\salesinfo.xls');
insert into tbl_files values(2, 'c:\\music.mp3');
insert into tbl_files values(3, 'c:\\documents\\resume.hwp');
commit;
select * from tbl_files;

SELECT
    file_no 파일번호,
    substring_index(file_path, '\\', -1) 파일명
FROM
    tbl_files






