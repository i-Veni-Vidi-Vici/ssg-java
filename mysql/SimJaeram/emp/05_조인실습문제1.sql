use empdb;

-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select
    date_format('2020-12-25', '%W');

-- 요일명이 영어로 나와 지역 변경
select @@lc_time_names; -- en_US -> ko_KR
set @@lc_time_names = 'ko_KR';;

-- 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.

select
    EMP_NAME,
    EMP_NO,
    d.DEPT_TITLE,
    j.JOB_NAME
from
    employee e
        inner join department d
            on e.DEPT_CODE = d.DEPT_ID
        inner join job j
            on e.JOB_CODE = j.JOB_CODE
where
    EMP_NO like '7%' and EMP_NO like '_______2%' and EMP_NAME like '전%';

-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.

-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select
    e.EMP_NO,
    e.EMP_NAME,
    d.DEPT_TITLE
from
    employee e
#         inner join department d -- -- 이름에 '형'자가 들어가는 직원 중에서 부서가 없는 직원이 있을 수 있으므로 inner 조인은 사용하면 안된다.
        left join department d
            on e.dept_code = d.dept_id
where
    e.EMP_NAME like '%형%';

-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오
select *
from
    employee
        e inner join department d
            on e.DEPT_CODE = d.DEPT_ID
where d.DEPT_TITLE like '해외영업%';
