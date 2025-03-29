-- 1. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
select
    job_code 직급코드,
    truncate(avg(salary), 0) 평균급여
from
    employee
where
    job_code <> 'J1'
group by
    job_code
order by
    1;

-- 2. EMPLOYEE테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
-- (select에는 groupby절에 명시한 컬럼만 작성가능)

select
    extract(year from hire_date) 입사년,
    count(*) 인원수
from
    employee
where
    job_code != 'J1'
group by
    extract(year from hire_date)
order by
    1;

-- 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오

select
    case substr(emp_no, 8, 1)
        when 1 then '남'
        when 3 then '남'
        else '여'
        end as 성별,
    format(truncate(avg(salary), 0), 0) as 평균,
    format(sum(salary), 0) as 합계,
    count(*) as 인원수
from
    employee
group by
    case substr(emp_no, 8, 1)
        when 1 then '남'
        when 3 then '남'
        else '여'
        end
order by
    인원수 desc;


-- 4. 직급별 인원수가 3명이상이 직급과 총원을 조회
select
    ifnull(job_code, '총원') 직급,
    count(*) 인원수
from
    employee
group by
    job_code
having
    count(*) >= 3
order by
    1;