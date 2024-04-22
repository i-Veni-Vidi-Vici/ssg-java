# 1.
select
    SALARY
from employee e
where not exists(
          select * from employee
          where SALARY > e.SALARY
);

################### 2.
select
    EMP_ID,
    EMP_NAME,
    DEPT_CODE,
    SALARY
from employee join (select DEPT_ID
                    from department
                    where DEPT_TITLE = '%영업%'
                    ) d
    on employee.DEPT_CODE = d.DEPT_ID;

# 3.


select *
from department;
