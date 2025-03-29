# 1.
select
    SALARY
from employee e
where not exists(
          select * from employee
          where SALARY > e.SALARY
);

# 2.
select
    EMP_ID,
    EMP_NAME,
    DEPT_CODE,
    SALARY
from employee
where DEPT_CODE in (select DEPT_ID from department where DEPT_TITLE like '%영업%');

# 3.
select
    EMP_ID,
    EMP_NAME,
    DEPT_TITLE,
    SALARY
from employee join department
    on employee.DEPT_CODE = department.DEPT_ID
where DEPT_CODE in (select DEPT_ID from department where DEPT_TITLE like '%영업%');

# 4-a.
select
    DEPT_ID,
    DEPT_TITLE,
    LOCAL_NAME,
    NATIONAL_NAME
from department join location
    on department.LOCATION_ID = location.LOCAL_CODE
    join nation
    on location.NATIONAL_CODE = nation.NATIONAL_CODE;

# 4-b.
select
    EMP_ID,
    EMP_NAME,
    SALARY,
    DEPT_TITLE,
    NATIONAL_NAME
from employee left join (select
                        DEPT_ID,
                        DEPT_TITLE,
                        LOCAL_NAME,
                        NATIONAL_NAME
                    from department join location
                                         on department.LOCATION_ID = location.LOCAL_CODE
                                    join nation
                                         on location.NATIONAL_CODE = nation.NATIONAL_CODE) t
    on employee.DEPT_CODE = t.DEPT_ID
order by NATIONAL_NAME desc;

# 5.
select
    EMP_ID,
    EMP_NAME,
    SALARY,
    DEPT_TITLE,
    NATIONAL_NAME,
    SALARY + (select MIN_SAL from sal_grade where employee.SAL_LEVEL = sal_grade.SAL_LEVEL) 위로금
from employee left join (select
                             DEPT_ID,
                             DEPT_TITLE,
                             LOCAL_NAME,
                             NATIONAL_NAME
                         from department join location
                                              on department.LOCATION_ID = location.LOCAL_CODE
                                         join nation
                                              on location.NATIONAL_CODE = nation.NATIONAL_CODE) t
                        on employee.DEPT_CODE = t.DEPT_ID
where NATIONAL_NAME = '러시아'
order by 위로금 desc;