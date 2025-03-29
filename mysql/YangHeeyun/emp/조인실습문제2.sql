select * from employee;
select * from department;
select * from job;
select * from location;
select * from nation;
select * from sal_grade;

-- 1. 재직 중이고 휴대폰 마지막 자리가 2인 직원 중 입사일이 가장 최근인 직원 3명의 사원번호, 직원명, 전화번호, 입사일, 퇴직여부를 출력하세요.
select
    emp_id,emp_name,phone,HIRE_DATE,QUIT_YN
from
    employee
where
    QUIT_YN = 'N' and right(phone,1) = 2
order by
    HIRE_DATE desc
    limit 3;

-- 2. 재직 중인 ‘대리’들의 직원명, 직급명, 급여, 사원번호, 이메일, 전화번호, 입사일을 출력하세요.
-- 단, 급여를 기준으로 내림차순 출력하세요.
select
    emp_name 직원명, j.job_name 직급명, salary 급여,emp_id 사원번호, EMAIL 이메일,phone 전화번호, HIRE_DATE 입사일
from
    employee e left join job j using(JOB_CODE)
where
    QUIT_YN = 'N' and j.job_name = '대리'
order by
    salary desc;

-- 3. 재직 중인 직원들을 대상으로 부서별 인원, 급여 합계, 급여 평균을 출력하고, 마지막에는 전체 인원과 전체 직원의 급여 합계 및 평균이 출력되도록 하세요.
-- 단, 출력되는 데이터의 헤더는 컬럼명이 아닌 ‘부서명’, ‘인원’, ‘급여합계’, ‘급여평균’으로 출력되도록 하세요
select
    DEPT_TITLE 부서명, count(*) 인원, format(sum(salary),0) 급여합계, format(avg(SALARY),0) 급여평균
from
    employee e left join department d on e.DEPT_CODE = d.DEPT_ID
where
    QUIT_YN = 'N'
group by
    d.DEPT_TITLE
    with rollup;

-- 4. 전체 직원의 직원명, 주민등록번호, 전화번호, 부서명, 직급명을 출력하세요.
-- 단, 입사일을 기준으로 오름차순 정렬되도록 출력하세요.
select
    e.emp_name, e.EMP_NO, e.phone, d.DEPT_TITLE,j.JOB_NAME,e.HIRE_DATE
from
    employee e left join department d on e.DEPT_CODE = d.DEPT_ID
               left join job j using(job_code)
order by e.HIRE_DATE;

-- 5. 전체 직원 중 연결된 관리자가 있는 직원의 인원을 출력하세요.
select
    count(*) '관리자가 있는 직원수'
from
    employee
where
    MANAGER_ID is not null;

-- 6. 모든 직원의 직원명과 관리자의 직원명을 출력하세요.
-- 참고. ‘모든 직원’이므로 관리자가 존재하지 않는 직원도 출력되어야 합니다.
select
    e.emp_name 직원명, e2.emp_name 관리자명
from
    employee e
    left join employee e2
        on e.manager_ID = e2.emp_ID;

-- 7. 관리자가 존재하는 직원의 직원명, 부서명, 관리자의 직원명, 관리자의 부서명을 출력하세요.
select
    e.emp_name 직원명, d1.DEPT_TITLE 직원부서명, e2.emp_name 관리자명, d2.DEPT_TITLE 관리자부서명
from
    employee e
        join employee e2 on e.manager_ID = e2.emp_ID
        left join department d1 on e.DEPT_CODE = d1.dept_id
        left join department d2 on e2.DEPT_CODE = d2.dept_id
where
    e.MANAGER_ID is not null;