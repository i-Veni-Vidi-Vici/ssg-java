-- 1. 재직 중이고 휴대폰 마지막 자리가 2인 직원 중 입사일이 가장 최근인 직원 3명의 사원번호, 직원명, 전화번호, 입사일, 퇴직여부를 출력하세요.
select
    EMP_NO,
    EMP_NAME,
    PHONE,
    HIRE_DATE 입사일,
    QUIT_YN 퇴직여부
from
    employee
where
    substring(PHONE, -1, 1) = '2'
order by
    HIRE_DATE desc
limit 3;

-- 2. 재직 중인 ‘대리’들의 직원명, 직급명, 급여, 사원번호, 이메일, 전화번호, 입사일을 출력하세요.
-- 단, 급여를 기준으로 내림차순 출력하세요.
select
    E.EMP_NAME,
    J.JOB_NAME,
    E.SALARY,
    E.EMP_NO,
    E.EMAIL,
    E.HIRE_DATE
from
    employee E
        join job J
            using(JOB_CODE)
where
    J.JOB_NAME = '대리'
order by
    E.SALARY desc ;

-- 3. 재직 중인 직원들을 대상으로 부서별 인원, 급여 합계, 급여 평균을 출력하고, 마지막에는 전체 인원과 전체 직원의 급여 합계 및 평균이 출력되도록 하세요.
-- 단, 출력되는 데이터의 헤더는 컬럼명이 아닌 ‘부서명’, ‘인원’, ‘급여합계’, ‘급여평균’으로 출력되도록 하세요
select
    D.DEPT_ID 부서명,
    count(*) 인원,
    format(sum(E.SALARY),0) 급여합계,
    format(avg(E.SALARY), 0) 급여평균

from
    employee E join department D
        on E.DEPT_CODE = D.DEPT_ID
where
    QUIT_YN = 'N'
group by
    D.DEPT_ID with rollup;

-- 4. 전체 직원의 직원명, 주민등록번호, 전화번호, 부서명, 직급명을 출력하세요.
-- 단, 입사일을 기준으로 오름차순 정렬되도록 출력하세요.
select
    E.EMP_NAME,
    E.EMP_NO,
    E.PHONE,
    D.DEPT_TITLE,
    J.JOB_NAME
from employee E right join job J
    using(JOB_CODE)
        left join department D
        on E.DEPT_CODE = D.DEPT_ID
order by
    date(HIRE_DATE);

-- 5. 전체 직원 중 연결된 관리자가 있는 직원의 인원을 출력하세요.
select count(*)
from employee
where !isnull(MANAGER_ID);

-- 6. 모든 직원의 직원명과 관리자의 직원명을 출력하세요.
-- 참고. ‘모든 직원’이므로 관리자가 존재하지 않는 직원도 출력되어야 합니다.
select
    E1.EMP_NAME,
    E2.EMP_NAME
from employee E1
    left join employee E2
        on E1.MANAGER_ID = E2.MANAGER_ID
order by E1.EMP_NAME;

-- 7. 관리자가 존재하는 직원의 직원명, 부서명, 관리자의 직원명, 관리자의 부서명을 출력하세요.
select
    E.EMP_NAME,
    D1.DEPT_TITLE,
    M.EMP_NAME,
    D2.DEPT_TITLE
from employee E
    join employee M
        on E.MANAGER_ID = M.EMP_ID
    join department D1
        on E.DEPT_CODE = D1.DEPT_ID
    join department D2
        on E.DEPT_CODE = D2.DEPT_ID;