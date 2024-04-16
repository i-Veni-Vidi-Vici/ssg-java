
use empdb;

select * from employee;

-- 1. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
-- 직급 : JOB_CODE,
select JOB_CODE '직급',count(JOB_CODE) '직급별 사원수',avg(SALARY) '평균급여'
from employee
group by
    JOB_CODE
having
    JOB_CODE != 'J1';

-- 2. EMPLOYEE테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
select
     date_format(HIRE_DATE,'%Y') "입사년도",count(*) '입사년도별 인원수'
    from employee
    where JOB_CODE != 'J1'
group by date_format(HIRE_DATE,'%Y')
order by 입사년도 asc

-- 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
-- 4. 직급별 인원수가 3명이상이 직급과 총원을 조회
