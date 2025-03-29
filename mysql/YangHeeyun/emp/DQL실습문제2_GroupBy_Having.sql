# 1. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
select
    SAL_LEVEL 직급,
    count(*) 사원수,
    concat(format(avg(SALARY),0),'원') 평균급여
from
    employee
where
    SAL_LEVEL != 'J1'
group by
    SAL_LEVEL;

# 2. EMPLOYEE테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
select
    extract(year from HIRE_DATE) 입사년도,
    count(*) 인원수
from
    employee
where
    SAL_LEVEL != 'J1'
group by
    extract(year from HIRE_DATE)
order by
    extract(year from HIRE_DATE);

select * from employee
# 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
select
    case substring(emp_no,8,1)
        when 1 then '남'
        when 3 then '남'
        else '여'
    end as '성별',
    format(avg(salary),0) 평균,
    format(sum(salary),0) 급여합계,
    count(*) 인원수
from
    employee
group by
    case substring(emp_no,8,1)
        when 1 then '남'
        when 3 then '남'
        else '여'
    end
order by
    인원수 desc;

# 4. 직급별 인원수가 3명이상인 직급과 총원을 조회
select
    SAL_LEVEL 직급,
    count(SAL_LEVEL) 총원
from
    employee
group by
    SAL_LEVEL
having
    count(SAL_LEVEL) >= 3
order by
    count(SAL_LEVEL) desc;


