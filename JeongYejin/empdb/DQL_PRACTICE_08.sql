-- 1
select emp_name, dept_code, salary
from employee
where dept_code = (select dept_id from department where dept_title = '기술지원부');

-- 2
select emp_name, dept_code, salary
from employee
where dept_code = (select dept_id from department where dept_title = '기술지원부')
order by salary desc
limit 1;

-- 3
-- a.
select e1.emp_id, e1.emp_name, e2.emp_name, e1.salary
from employee e1 join employee e2 on e1.manager_id = e2.emp_id
where e1.manager_id is not null
  and
    e1.salary > (
    select avg(salary)
    from employee
    );

-- b.
select emp_id, emp_name, (select emp_name from employee where emp_id = e.manager_id), salary
from employee e
where manager_id is not null
  and
    salary > (
        select avg(salary)
        from employee
    );

-- 4
select emp_name, dept_code, salary, sal_level
from employee e
where salary >= (
    select avg(salary)
    from employee
    group by e.dept_code
    );

-- 5
