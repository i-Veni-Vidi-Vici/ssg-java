create database empdb;
grant all privileges on empdb.* to 'sh'@'%';
show grants for 'sh'@'%';
use empdb;

select * from employee;
select * from job;
select * from nation;
select * from sal_grade;
select * from location;
select * from department;

select
    EMP_NAME
from
    employee
where
    EMP_NAME like '%연';

select
    EMP_NAME,
    PHONE
from employee
where PHONE not like '010%';

select
    *
from
    employee
where
    (EMAIL like '____\_%') &&
    (DEPT_CODE = 'D9' || DEPT_CODE = 'D5') &&
    (HIRE_DATE between '1990-01-01' and '2001-12-01') &&
    SALARY >= 2700000;

create table tbl_escape_watch (
    watch_name varchar(100),
    description varchar(1000)
);

insert into tbl_escape_watch values ('금시계', '순금 99.99% 함유 고급시계');
insert into tbl_escape_watch values ('은시계', '고객 만족도 99.99점을 획득한 고급시계');
commit; -- Transaction 저장 명령 (Tx: Auto일때는 실행하지 않아도 된다.)
select * from tbl_escape_watch;

select
    *
from
    tbl_escape_watch
where description like '%99.99\%%';

select *
from employee
where QUIT_YN = 'N'
order by EMP_NAME;

select
    EMP_NAME,
    HIRE_DATE,
    QUIT_DATE,
    datediff(ifnull(QUIT_DATE, now()), HIRE_DATE),
    QUIT_YN
from employee;