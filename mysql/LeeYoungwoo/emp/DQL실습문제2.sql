select *
from employee; -- 사원테이블
select *
from job; -- 직급테이블
select *
from department; -- 부서테이블
select *
from location; -- 지역테이블
select *
from nation; -- 국가테이블
select *
from sal_grade;
-- 급여등급테이블

-- 1. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
select concat(count(*), '명')                            '직급별 사원수',
       concat(format(truncate(avg(SALARY), 0), 0), '원') 평균급여
from employee
group by JOB_CODE
having not JOB_CODE = 'J1';

-- 2. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
select year(HIRE_DATE)       입사년도,
       concat(count(*), '명') 인원수
from employee
group by year(HIRE_DATE)
order by year(HIRE_DATE);

-- 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
select
#     if(substring(EMP_NO, 8, 1) % 2 = 0, '남자', '여자'),
    substring(EMP_NO, 8, 1) % 2 = 0 "성별(남자=0, 여자=1)",
    format(truncate(avg(SALARY),0), 0) 급여평균,
    format(sum(SALARY), 0) 급여합계,
    count(*) 인원수
from employee
group by substring(EMP_NO, 8, 1) % 2 = 0
order by 인원수 desc ;

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
select JOB_CODE 직급,
       count(*) 총원
from employee
group by JOB_CODE
having count(JOB_CODE) >= 3;

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