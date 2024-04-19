use empdb;

-- 1.
select
    JOB_CODE as 직급,
    count(*) as 사원수,
    avg(SALARY) as 평균급여
from employee
group by JOB_CODE having JOB_CODE != 'J1';

-- 2.
select
    year(HIRE_DATE) as 입사년도,
    count(*) as 인원수
from employee
group by year(HIRE_DATE)
order by year(HIRE_DATE);

-- 3.
select
    substring(EMP_NAME, 1, 1) as 성,
    avg(SALARY) as 평균급여,
    sum(SALARY) as 급여합계,
    count(*) as 인원수
from employee
group by substring(EMP_NAME, 1, 1)
order by 인원수 desc;

-- 4.
select
    JOB_CODE as 직급,
    count(*) as 인원수
from employee
group by JOB_CODE having 인원수 >=3;