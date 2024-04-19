-- 1
select EMP_ID, EMP_NAME, PHONE, HIRE_DATE, QUIT_YN
from employee
where QUIT_YN = 'N'
  and substr(PHONE, -1, 1) = 2
order by HIRE_DATE desc
limit 3;

-- 2
select e.EMP_NAME, j.JOB_NAME, format(e.SALARY, 0) 급여, e.EMP_ID, e.EMAIL, e.PHONE, e.HIRE_DATE
from employee e left join job j on e.JOB_CODE = j.JOB_CODE
where QUIT_YN = 'N' and j.JOB_NAME = '대리'
order by SALARY desc;

-- 3
select dept_title 부서명, count(*) 인원, sum(SALARY) 급여합계, avg(SALARY) 급여평균
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
where QUIT_YN = 'N'
group by DEPT_TITLE with rollup
order by d.DEPT_TITLE is null;

-- 4
select e.EMP_NAME, e.EMP_NO, e.PHONE, d.DEPT_TITLE, j.JOB_NAME
from employee e left join department d on e.DEPT_CODE = d.DEPT_ID
left join job j using(job_code)
order by HIRE_DATE asc;

-- 5
select count(*)
from employee
where MANAGER_ID is not null;

-- 6
select e1.EMP_NAME 직원명, e2.EMP_NAME 관리자
from employee e1 left join employee e2
on e1.MANAGER_ID = e2.EMP_ID;

-- 7
select e1.EMP_NAME 직원명, d1.DEPT_TITLE 부서명, e2.EMP_NAME 관리자명, d2.DEPT_TITLE 관리자의부서명
from employee e1 join employee e2 on e1.MANAGER_ID = e2.EMP_ID
left join department d1 on e1.DEPT_CODE = d1.DEPT_ID
left join department d2 on e2.DEPT_CODE = d2.DEPT_ID
where e1.MANAGER_ID is not null;