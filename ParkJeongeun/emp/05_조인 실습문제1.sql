select date_format('2020-12-25', '%W'); -- Friday

select
    EMP_NAME,
    EMP_NO,
    DEPT_TITLE,
    JOB_NAME
from employee join department
     on employee.DEPT_CODE = department.DEPT_ID
     join job
     on employee.JOB_CODE = job.JOB_CODE
where substr(EMP_NO, 1, 1) in (7) &&
      substr(EMP_NO, 8, 1) in (2, 4) &&
      EMP_NAME like '전%';

################ 3.
select
    case substr(EMP_NO, 8, 1)
        when 1 then 1900
        when 2 then 1900
        else 2000
        end
        + substr(EMP_NO, 1, 2) EMP_NO,
    EMP_NAME,
    DEPT_TITLE
from employee join department
     on employee.DEPT_CODE = department.DEPT_ID;

select
    EMP_ID,
    EMP_NAME,
    DEPT_TITLE
from employee join department
     on employee.DEPT_CODE = department.DEPT_ID
where EMP_NAME like '%형%';

select
    EMP_NAME,
    JOB_NAME,
    DEPT_CODE,
    DEPT_TITLE
from employee join job
     on employee.JOB_CODE = job.JOB_CODE
     join department
     on employee.DEPT_CODE = department.DEPT_ID
where DEPT_TITLE like '%해외영업%';

select
    EMP_NAME,
    BONUS,
    ifnull(DEPT_TITLE, null),
    LOCAL_NAME
from employee left join department
    on employee.DEPT_CODE = department.DEPT_ID
    left join location
    on department.LOCATION_ID = location.LOCAL_CODE
where BONUS is not null;

select
    EMP_NAME,
    JOB_NAME,
    DEPT_TITLE,
    LOCAL_NAME
from employee join job
    on employee.JOB_CODE = job.JOB_CODE
    join department
    on employee.DEPT_CODE = department.DEPT_ID
    join location
    on department.LOCATION_ID = location.LOCAL_CODE
where DEPT_CODE = 'D2';

######### 8.


select *
from employee;