use empdb;

-- DQL실습문제2 - group by/having #114
-- 1. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
select
    JOB_CODE,
    count(*),
    truncate(avg(SALARY), 0)
from
    employee
where
    not JOB_CODE = 'J1'
group by
    JOB_CODE;

-- 2. EMPLOYEE테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
select
    left(HIRE_DATE, 4),
    count(*)
from
    employee
where
    not JOB_CODE = 'J1'
group by
    left(HIRE_DATE, 4)
order by
    1;

-- 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
select
    case substr(EMP_NO, 8, 1)
        when 1 then '남'
        when 3 then '남'
        else '여'
    end 성별,
    truncate(avg(SALARY), 0) '성별 급여의 평균',
    sum(SALARY) '급여의 합계',
    count(*) 인원수
from
    employee
group by
    case substr(EMP_NO, 8, 1)
        when 1 then '남'
        when 3 then '남'
        else '여'
    end
order by
    4;

-- 4. 직급별 인원수가 3명이상이 직급과 총원을 조회
select
    JOB_CODE 직급,
    count(*) 총원
from
    employee
group by
    JOB_CODE
having
    count(*) >= 3;
