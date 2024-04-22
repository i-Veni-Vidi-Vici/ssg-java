-- 1. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
select JOB_CODE 직급, count(*) "직급별 사원수", format(truncate(avg(SALARY), 0), 0) 평균급여
from employee
where JOB_CODE != 'J1'
group by JOB_CODE;

-- 2. EMPLOYEE테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
select year(HIRE_DATE) 입사년도, count(*) "입사년도별 인원수"
from employee
where JOB_CODE != 'J1'
group by year(HIRE_DATE)
order by 입사년도;

-- 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
select case substring(EMP_NO, 8, 1) when 1 then '남' when 3 then '남' else '여' end 성별, format(truncate(avg(SALARY), 0), 0) "급여의 평균", format(sum(SALARY), 0) "급여의 합계", count(*) 인원수
from employee
group by case substring(EMP_NO, 8, 1)  when 1 then '남' when 3 then '남' else '여' end
order by 인원수 desc;

-- 4. 직급별 인원수가 3명이상인 직급과 총원을 조회
select if(grouping(JOB_CODE) = 0, ifnull(JOB_CODE, null), '총원') 직급, count(*) 인원수
from employee
group by JOB_CODE with rollup
having count(*) >= 3
order by 직급;