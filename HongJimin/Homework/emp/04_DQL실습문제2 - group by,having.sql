-- 1. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
select
    JOB_CODE,
    count(*) 사원수,
    avg(SALARY) 평균급여
from
    employee
where
    JOB_CODE != 'J1'
group by
    JOB_CODE;

-- 2. EMPLOYEE테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
select
    year(HIRE_DATE) 입사년도,
    concat(count(*), '명') 인원수
from employee
where
    JOB_CODE != 'J1'
group by
    year(HIRE_DATE)
order by
    year(HIRE_DATE);

-- 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
select
    floor(avg(SALARY)) 급여평균,
    sum(SALARY) 급여합계,
    concat(count(*), '명') 인원수
from
    employee
group by
    substring(EMP_NO, 8, 1) = '1' || substring(EMP_NO, 8, 1) = '3',
    substring(EMP_NO, 8, 1) = '2' || substring(EMP_NO, 8, 1) = '4';

-- 4. 직급별 인원수가 3명이상인 직급과 총원을 조회
select
    JOB_CODE 직급,
    concat(count(*), '명') 총원
from
    employee
group by
    JOB_CODE
having
    count(*) >= 3;

SELECT
    *
FROM employee

