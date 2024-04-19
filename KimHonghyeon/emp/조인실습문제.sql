use empdb;

-- 1.
select
    date_format('2020-12-25', '%W');

-- 2.
select
    EMP_NAME as 사원명,
    EMP_NO as 주민번호,
    dept.DEPT_TITLE as 부서명,
    job.JOB_NAME as 직급명

from (employee as emp join department as dept on emp.DEPT_CODE = dept.DEPT_ID)
    join job on emp.JOB_CODE=job.JOB_CODE
    having (substring(emp.EMP_NO,1,2) between 70 and 79) and (substring(emp.EMP_NO, 8,1)=2)
       and (substring(EMP_NAME,1,1)='전');

-- 3.
select
    EMP_ID as 사번,
    EMP_NAME as 사원명,
    year(curdate())-concat((if(substring(EMP_NO,8,1)=3 or substring(EMP_NO,8,1)=4),20,19), substring(EMP_NO,1,2)),
    dept.DEPT_TITLE as 부서명,
    job.JOB_NAME as 직급명

from (employee as emp join department as dept on emp.DEPT_CODE = dept.DEPT_ID)
    join job on emp.JOB_CODE=job.JOB_CODE
where datediff(now(), concat(if(substring(EMP_NO,8,1)=3 or substring(EMP_NO,8,1)=4,20,19), substring(EMP_NO,1,6))) =
(select min(datediff(now(), concat(if(substring(EMP_NO,8,1)=3 or substring(EMP_NO,8,1)=4,20,19), substring(EMP_NO,1,6)))) from employee);