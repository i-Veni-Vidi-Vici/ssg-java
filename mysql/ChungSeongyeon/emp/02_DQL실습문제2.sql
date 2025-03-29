# 1. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
select
    JOB_CODE 직급,
    count(*) 사원수,
    avg(SALARY) 평균급여 -- round(avg(SALARY),1) 평균급여 --> 소수첫번쨰자리까지
from
    employee
where
    JOB_CODE != 'J1'
group by
    JOB_CODE;

# 2. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
select
    year(HIRE_DATE) 입사년도,
    count(*) 인원수
from
    employee
where
    JOB_CODE != 'J1'
group by
    year(HIRE_DATE)
order by
    year(HIRE_DATE) asc;

# 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
select
    case when substring(EMP_NO, 8, 1) in ('1', '3') then '남성' else '여성' end 성별,
    cast(avg(SALARY) as unsigned) 평균급여,
    sum(SALARY) 급여합계,
    count(*) 인원수
from
    employee
group by
    case when substring(EMP_NO, 8, 1) in ('1', '3') then '남성' else '여성' end
order by
    count(*) desc;

# 4. 직급별 인원수가 3명이상이 직급과 총원을 조회
select
    JOB_CODE 직급,
    count(*) 총원
from
    employee
group by
    JOB_CODE
having
    count(*) >= 3;