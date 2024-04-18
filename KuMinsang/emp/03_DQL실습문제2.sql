
-- 1.EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
select
    concat(count(*), '명') as 사원수,
    format(avg(SALARY), 0) as 평균급여
from
    employee
where
    JOB_CODE != 'J1';

-- 2. EMPLOYEE테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
select
    substring(HIRE_DATE,1,4) as 입사년도,
    count(substring(HIRE_DATE,1,4)) as 입사인원
from
    employee
where
    JOB_CODE != 'J1'
group by
    substring(HIRE_DATE, 1, 4)
order by
    1;

-- 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
select
    if((substring(EMP_NO, 8, 1) = 1 or substring(EMP_NO, 8, 1) = 3), '남성', '여성') as 성별,
    format(avg(SALARY + SALARY * ifnull(BONUS, 0)),0) as 평균급여,
    format(sum(SALARY + SALARY * ifnull(BONUS, 0)),0) as 급여합계,
    count(*) as 인원수
from
    employee
group by
    if((substring(EMP_NO, 8, 1) = 1 or substring(EMP_NO, 8, 1) = 3), '남성', '여성')
order by
    인원수;

-- 4. 직급별 인원수가 3명이상이 직급과 총원을 조회
select
    JOB_CODE,
    count(JOB_CODE)
from
    employee
group by
    JOB_CODE
having
    count(JOB_CODE)>=3;
