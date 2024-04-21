use empdb;

# 1.
select
    EMP_ID,
    EMP_NAME,
    PHONE,
    HIRE_DATE,
    QUIT_YN
from employee
where QUIT_YN = 'N' and
      PHONE like '%2'
order by HIRE_DATE desc
limit 3;

# 2.
select
    EMP_NAME,
    JOB_NAME,
    SALARY,
    EMP_ID,
    EMAIL,
    PHONE,
    HIRE_DATE
from employee join job
    on employee.JOB_CODE = job.JOB_CODE
where QUIT_YN = 'N' and JOB_NAME = '대리'
order by SALARY desc;

# 3.
select
    if(grouping(DEPT_TITLE) = 0, ifnull(DEPT_TITLE, '부서없음'), null) 부서명,
    count(EMP_ID) 인원,
    sum(SALARY) 급여합계,
    avg(SALARY) 급여평균
from employee left join department
    on employee.DEPT_CODE = department.DEPT_ID
where QUIT_YN = 'N'
group by DEPT_TITLE with rollup;

# 4.
select
    EMP_NAME,
    EMP_NO,
    PHONE,
    DEPT_TITLE,
    JOB_NAME
from employee left join department
    on employee.DEPT_CODE = department.DEPT_ID
    join job
    on employee.JOB_CODE = job.JOB_CODE
order by HIRE_DATE;

# 5.
select count(*)
from employee e join employee m
    on e.MANAGER_ID = m.EMP_ID;

# 6.
select
    e.EMP_NAME 직원명,
    m.EMP_NAME 관리자
from employee e left join employee m
    on e.MANAGER_ID = m.EMP_ID;

# 7.
select
    e.EMP_NAME,
    ed.DEPT_TITLE,
    m.EMP_NAME,
    md.DEPT_TITLE
from employee e join employee m on e.MANAGER_ID = m.EMP_ID
    join department ed on e.DEPT_CODE = ed.DEPT_ID
    join department md on m.DEPT_CODE = md.DEPT_ID;