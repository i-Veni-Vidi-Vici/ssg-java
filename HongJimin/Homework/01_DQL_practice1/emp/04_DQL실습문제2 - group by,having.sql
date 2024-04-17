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
    extract(year from HIRE_DATE) ,
    count(*)
from
    employee
where
    JOB_CODE != 'J1'
group by
    extract(year from HIRE_DATE);
-- ⛳⛳⛳오름차순 정렬 기능 해야함!!

-- 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
select
    case
        when
            substring(EMP_NO, 8, 1) = '1' or substring(EMP_NO, 8, 1) = '3'
            then avg(SALARY)
        when
            substring(EMP_NO, 8, 1) = '2' or substring(EMP_NO, 8, 1) = '4'
            then avg(SALARY)
    end as '얼'
from
    employee;


-- 4. 직급별 인원수가 3명이상이 직급과 총원을 조회

select
    *
from
    employee

