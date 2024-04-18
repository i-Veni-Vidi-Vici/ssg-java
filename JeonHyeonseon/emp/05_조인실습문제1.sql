-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select
    date_format('20201225', '%Y년 %m월 %d일 (%W)');
set @@lc_time_names = 'ko_KR';


-- 2. 주민번호가 1970년대생이면서 성별이 여자이고,
--    성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select * from employee;
select * from department;
select * from job;

select
    EMP_NAME 사원명,
    EMP_NO 주민번호,
    DEPT_CODE 부서명,
    JOB_CODE 직급명
from
    employee e join department d
        on e.DEPT_CODE = d.DEPT_ID
where
    substring(EMP_NO, 1, 1) = 7
  and
    substring(EMP_NO, 8, 1) = 2
  and
    substring(EMP_NAME, 1, 1) like '전%';

-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select * from employee;
select * from department;
select * from job;

select
    e.EMP_ID,
    e.EMP_NAME,
    -- 나이
    d.DEPT_TITLE,
    e.JOB_CODE
from
    employee e join department d

-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select * from employee;
select * from department;

select
    e.EMP_ID 사번,
    e.EMP_NAME 사원명,
    d.DEPT_TITLE 부서명
from
    employee e join department d
        on e.DEPT_CODE = d.DEPT_ID
where
    EMP_NAME like '%형%';

-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select * from nation; -- national_code, national_name
select * from employee;
select * from job; -- job_code, job_name
select * from department; -- dept_id, dept_title, location_id

select

from
    employee


