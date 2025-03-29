#1
select
    JOB_CODE,

    count(EMP_ID) 사원수,
    avg(SALARY) 평균급여
from
    employee
where JOB_CODE != 'J1'
GROUP BY JOB_CODE;

#2

