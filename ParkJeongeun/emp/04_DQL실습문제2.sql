use empdb;

select
    JOB_CODE 직급,
    count(*) '직급별 사원수',
    avg(SALARY) 평균급여
from employee
where JOB_CODE != 'J1'
group by JOB_CODE;

select
    year(HIRE_DATE) 입사년월,
    count(*) 인원수
from employee
where JOB_CODE != 'J1'
group by year(HIRE_DATE)
order by year(HIRE_DATE);

select
    if(substring(EMP_NO, 8, 1) in (1, 3), '남성', '여성') 성별,
    round(avg(SALARY)) 급여평균,
    sum(SALARY) 급여합계,
    count(*) 인원수
from employee
group by if(substring(EMP_NO, 8, 1) in (1, 3), '남성', '여성')
order by count(*) desc;

select
    JOB_CODE,
    count(*)
from employee
group by JOB_CODE with rollup
having count(*) >= 3;