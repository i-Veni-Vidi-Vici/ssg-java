select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

-- 1. 재직 중이고 휴대폰 마지막 자리가 2인 직원 중 입사일이 가장 최근인 직원 3명의 사원번호, 직원명, 전화번호, 입사일, 퇴직여부를 출력하세요.

select
    EMP_NO 사원번호,
    EMP_NAME 직원명,
    PHONE 전화번호,
    HIRE_DATE 입사일,
    QUIT_YN 퇴직여부
from
    employee
where
    QUIT_YN = 'N'
    and
    right(PHONE, 1) = '2'
order by
    HIRE_DATE desc
limit
    3;

-- 2. 재직 중인 ‘대리’들의 직원명, 직급명, 급여, 사원번호, 이메일, 전화번호, 입사일을 출력하세요.
-- 단, 급여를 기준으로 내림차순 출력하세요.

select
    e.EMP_NAME 직원명,
    j.JOB_NAME 직급명,
    e.SALARY 급여,
    e.EMP_NO 사원번호,
    e.EMAIL 이메일,
    e.PHONE 전화번호,
    e.HIRE_DATE 입사일
from
    employee e left join job j
    on e.JOB_CODE = j.JOB_CODE
where
    e.QUIT_YN = 'N'
    and
    j.JOB_NAME = '대리'
order by
    SALARY desc;

-- 3. 재직 중인 직원들을 대상으로 부서별 인원, 급여 합계, 급여 평균을 출력하고, 마지막에는 전체 인원과 전체 직원의 급여 합계 및 평균이 출력되도록 하세요.
-- 단, 출력되는 데이터의 헤더는 컬럼명이 아닌 ‘부서명’, ‘인원’, ‘급여합계’, ‘급여평균’으로 출력되도록 하세요
select
    DEPT_TITLE 부서명,
    count(*) 인원,
    sum(SALARY) 급여합계,
    avg(SALARY) 급여평균
from
    employee e left join department d
    on e.DEPT_CODE = d.DEPT_ID
where
    QUIT_YN = 'N'
group by
    d.DEPT_TITLE with rollup ;

-- 4. 전체 직원의 직원명, 주민등록번호, 전화번호, 부서명, 직급명을 출력하세요.
-- 단, 입사일을 기준으로 오름차순 정렬되도록 출력하세요.
