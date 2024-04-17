# 1.
select date_format('2020-12-25', '%W'); -- Friday

# 2.
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

# 4.
select
    EMP_ID,
    EMP_NAME,
    DEPT_TITLE
from employee join department
     on employee.DEPT_CODE = department.DEPT_ID
where EMP_NAME like '%형%';

# 5.
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

# 6.
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

# 7.
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

# 8.
select
    EMP_NAME,
    JOB_NAME,
    SALARY,
    SALARY * 12
from employee join sal_grade
    on employee.SAL_LEVEL = sal_grade.SAL_LEVEL
    join job
    on employee.JOB_CODE = job.JOB_CODE
where SALARY > MAX_SAL;

# 9.
select
    EMP_NAME,
    DEPT_TITLE,
    LOCAL_NAME,
    NATIONAL_NAME
from employee join department
    on employee.DEPT_CODE = department.DEPT_ID
    join location
    on department.LOCATION_ID = location.LOCAL_CODE
    join nation
    on location.NATIONAL_CODE = nation.NATIONAL_CODE
where location.NATIONAL_CODE in ('KO', 'JP');

# 10.
select
    a.EMP_NAME 사원명,
    DEPT_TITLE 부서명,
    b.EMP_NAME 동료이름
from employee a join employee b
    on a.DEPT_CODE = b.DEPT_CODE
    join department
    on a.DEPT_CODE = department.DEPT_ID
where a.EMP_NAME != b.EMP_NAME;

# 11.
select
    EMP_NAME,
    JOB_NAME,
    SALARY
from employee join job
    on employee.JOB_CODE = job.JOB_CODE
where BONUS is null &&
      JOB_NAME in ('차장', '사원');

# 12.
select
    count(if(QUIT_YN = 'N', 1, null)) 재직자,
    count(if(QUIT_YN = 'Y', 1, null)) 퇴사자
from employee;