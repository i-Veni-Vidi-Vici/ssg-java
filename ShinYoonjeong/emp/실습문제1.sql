show databases;
use empdb;


select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

select EMP_NAME
from employee
where
    EMP_NAME like '%연';

select EMP_NAME,
       PHONE
from employee
where
    PHONE not like '010%';

select employee.EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE, QUIT_DATE, QUIT_YN
from employee
where
    EMAIL like '____\_%'
and
    DEPT_CODE = 'D9' or 'D5'
and
    SALARY >= 2700000
and
    HIRE_DATE <=  '01/12/31'
and
    HIRE_DATE >= '90/01/01';

-- 테이블 및 데이터 등록후 문제풀이
create table tbl_escape_watch (
                                  watch_name varchar(100)
    ,description varchar(1000)
);
-- drop table tbl_escape_watch;
insert into tbl_escape_watch values('금시계', '순금 99.99% 함유 고급시계');
insert into tbl_escape_watch values('은시계', '고객 만족도 99.99점를 획득한 고급시계');
commit;
select * from tbl_escape_watch;

select *
from tbl_escape_watch
where tbl_escape_watch.description like '%99.99\%%';

select *
from employee
order by EMP_NAME desc;

select HIRE_DATE,
       QUIT_DATE,
       QUIT_DATE-HIRE_DATE
from employee;