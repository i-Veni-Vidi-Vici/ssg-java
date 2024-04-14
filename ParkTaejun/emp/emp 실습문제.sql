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






