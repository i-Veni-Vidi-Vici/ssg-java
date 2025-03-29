select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

select EMP_NAME, DEPT_CODE, SALARY
from employee
where
    DEPT_CODE = (select DEPT_ID from department where DEPT_TITLE = '기술지원부');

select EMP_NAME, DEPT_CODE, SALARY
from employee
where
    DEPT_CODE = (select DEPT_ID from department where DEPT_TITLE = '기술지원부')
order by SALARY desc
limit 1;

select EMP_ID, EMP_NAME, MANAGER_ID, SALARY
from employee
where
    MANAGER_ID != null
and
    salary
