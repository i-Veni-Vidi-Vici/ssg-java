# 1.
select
    EMP_NAME,
    DEPT_CODE,
    SALARY
from employee
where DEPT_CODE = (select DEPT_ID from department where DEPT_TITLE = '기술지원부');

# 2.
select
    EMP_NAME,
    DEPT_CODE,
    max(SALARY) over (order by SALARY desc) salary
from employee join department on employee.DEPT_CODE = department.DEPT_ID
where DEPT_TITLE = '기술지원부'
limit 1;

# 3-a.
select
    e.EMP_ID,
    e.EMP_NAME,
    m.EMP_NAME,
    e.SALARY
from employee e join employee m
    on e.MANAGER_ID = m.EMP_ID
where e.SALARY > (select avg(SALARY) from employee);

# 3-b.
select
    EMP_ID,
    EMP_NAME,
    (select employee.EMP_NAME from employee where e.MANAGER_ID = employee.EMP_ID) mgr_name,
    SALARY
from employee e
where e.SALARY > (select avg(SALARY) from employee) and
      MANAGER_ID is not null;

# 4.


select *
from employee;