-- 1. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
select
#     EMP_NAME,
    JOB_CODE 직급,
    count(*),
    avg(SALARY) 평균급여
from
    employee
group by
    JOB_CODE
having
    JOB_CODE not like 'J1';

-- 2. EMPLOYEE테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
select
    JOB_CODE 직급,
    count(HIRE_DATE)
from
    employee
group by
     HIRE_DATE
order by
    HIRE_DATE;