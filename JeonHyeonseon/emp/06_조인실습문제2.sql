use empdb;
-- 1. 재직 중이고 휴대폰 마지막 자리가 2인 직원 중 입사일이
--    가장 최근인 직원 3명의 사원번호, 직원명, 전화번호, 입사일, 퇴직여부를 출력하세요.
select * from employee;
select
    EMP_ID 사원번호,
    EMP_NAME 직원명,
    PHONE 전화번호,
    HIRE_DATE 입사일,
    QUIT_YN 퇴직여부
from
    employee
where
    QUIT_YN = 'N'
  and
    right(PHONE, 1) = 2
limit
    3;

-- 2. 재직 중인 ‘대리’들의 직원명, 직급명, 급여, 사원번호, 이메일, 전화번호, 입사일을 출력하세요.
--    단, 급여를 기준으로 내림차순 출력하세요.
select * from employee;
select * from job;
select
    e.EMP_NAME 직원명,
    j.JOB_NAME 직급명,
    e.SALARY 급여,
    e.EMP_ID 사원번호,
    e.EMAIL 이메일,
    e.PHONE 전화번호,
    e.HIRE_DATE 입사일
from employee e
    left join job j
        on e.JOB_CODE = j.JOB_CODE
where
    e.QUIT_YN = 'N'
  and
    j.JOB_NAME = '대리'
order by
    3;

-- 3. 재직 중인 직원들을 대상으로 부서별 인원, 급여 합계, 급여 평균을 출력하고,
--    마지막에는 전체 인원과 전체 직원의 급여 합계 및 평균이 출력되도록 하세요.
--    단, 출력되는 데이터의 헤더는 컬럼명이 아닌 ‘부서명’, ‘인원’, ‘급여합계’, ‘급여평균’으로 출력되도록 하세요
select * from employee;
select * from department;
select
    d.DEPT_TITLE '부서명',
    count(*) '부서별인원',
    format(sum(e.SALARY), 0) 급여합계,
    format(avg(e.SALARY), 0) 급여평균
from employee e
    join department d
        on e.DEPT_CODE = d.DEPT_ID
where
    QUIT_YN = 'N'
group by
    e.DEPT_CODE
union
select
    '전체',
    count(*) '전체 인원',
    format(sum(SALARY), 0) '전체 직원의 급여 합계',
    format(avg(SALARY), 0) '전체 직원의 급여 평균'
from
    employee;

-- 4. 전체 직원의 직원명, 주민등록번호, 전화번호, 부서명, 직급명을 출력하세요.
--    단, 입사일을 기준으로 오름차순 정렬되도록 출력하세요.
select * from employee;
select * from department;
select * from job;
select
    e.EMP_NAME 직원명,
    e.EMP_NO 주민등록번호,
    e.PHONE 전화번호,
    d.DEPT_TITLE 부서명,
    j.JOB_NAME 직급명
from employee e
    join department d
        on e.DEPT_CODE = d.DEPT_ID
    left join job j
        on e.JOB_CODE = j.JOB_CODE
order by
    e.HIRE_DATE;

-- 5. 전체 직원 중 연결된 관리자가 있는 직원의 인원을 출력하세요.
select * from employee;
select
    count(*) '관리자와 연결된 인원수'
from
    employee
where
    MANAGER_ID is not null
order by
    1;

-- 6. 모든 직원의 직원명과 관리자의 직원명을 출력하세요.
--    참고. ‘모든 직원’이므로 관리자가 존재하지 않는 직원도 출력되어야 합니다.
select * from employee;
select
    e1.EMP_NAME 직원명,
    ifnull(e2.EMP_NAME, '관리자 없음') '관리자의 직원명'
from employee e1
    left join employee e2
        on e1.MANAGER_ID = e2.EMP_ID
order by
    e1.EMP_NAME;

-- 7. 관리자가 존재하는 직원의 직원명, 부서명, 관리자의 직원명, 관리자의 부서명을 출력하세요.
-- EMPLOYEE E1 JOIN EMPLOYEE E2 내부조인
-- EMPLOYEE E1 LEFT JOIN DEPARTMENT D1 외부조인(E1.DEPT_CODE가 null인 레코드가 없으므로 내부조인과 똑같다)
-- EMPLOYEE E2 LEFT JOIN DEPARTMENT D2 외부조인(E2.DEPT_CODE가 null인 레코드가 없으므로 내부조인과 똑같다)
select * from employee;
select * from department;
select
    e1.EMP_NAME 직원명,
    d1.DEPT_TITLE 부서명,
    e2.EMP_NAME '관리자의 직원명',
    d2.DEPT_TITLE '관리자의 부서명'
from employee e1
    join employee e2
        on e1.MANAGER_ID = e2.EMP_ID
    left join department d1
        on e1.DEPT_CODE = d1.DEPT_ID
    left join department d2
        on e2.DEPT_CODE = d2.DEPT_ID
order by
    e1.EMP_NAME;