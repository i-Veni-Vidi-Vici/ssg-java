select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

# 1
select emp_name
from employee
where emp_name like '%연';

# 2
select emp_name,phone
from employee
where phone not like '010%';

#3
SELECT
    *
FROM employee
WHERE EMAIL like '____\_%'
AND DEPT_CODE = 'D9' OR 'D5'
AND HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/12/31'
AND SALARY >= 2700000;

#4
SELECT
    *
FROM tbl_escape_watch
WHERE description LIKE '%99.99\%%';

#5
SELECT
    *
FROM employee
WHERE QUIT_YN = 'N'
ORDER BY EMP_NAME ASC;

#6
SELECT
    EMP_NAME,
    HIRE_DATE,
    QUIT_DATE,
    datediff(ifnull(QUIT_DATE, now()), HIRE_DATE) as 근무일
FROM employee



