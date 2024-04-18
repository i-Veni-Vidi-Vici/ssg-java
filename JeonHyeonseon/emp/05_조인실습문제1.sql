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
    e.EMP_ID 사번,
    e.EMP_NAME 사원명,
    truncate(
        datediff(
            now(),
            concat(
                if(substring(EMP_NO, 8, 1) in (1, 2), 19, 20),
                left(EMP_NO, 6)
            )
        ) / 365, 0) 나이,
    d.DEPT_TITLE 부서명,
    e.JOB_CODE 직급명
from employee e
    join department d
        on e.DEPT_CODE = d.DEPT_ID
    join job j
        on e.JOB_CODE = j.JOB_CODE
order by
    3
limit 1;

-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
-- inner join 부서코드 미지정된 사원은 제외됨 -> 이름에 '형'자가 들어간 사람이 부서코드가 미지정일 수도 있다.
-- left outer join : 부서코드가 미지정인 사원도 포함됨
-- 따라서 left outer join을 해야한다.
select * from employee;
select * from department;

select
    e.EMP_ID 사번,
    e.EMP_NAME 사원명,
    d.DEPT_TITLE 부서명
from
    employee e left join department d
        on e.DEPT_CODE = d.DEPT_ID
where
    EMP_NAME like '%형%';

-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select * from employee;
select * from job; -- job_code, job_name
select * from department; -- dept_id, dept_title, location_id

select
    e.EMP_NAME 사원명,
    j.JOB_NAME 직급명,
    e.DEPT_CODE 부서코드,
    d.DEPT_TITLE 부서명
from employee e
    join department d
        on e.DEPT_CODE = d.DEPT_ID
    join job j
        on e.JOB_CODE = j.JOB_CODE
where
    DEPT_TITLE like '해외영업%';

-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select * from employee;
select * from department;
select * from location;

select
    e.EMP_NAME 사원명,
    e.BONUS 보너스포인트,
    d.DEPT_TITLE 부서명,
    l.LOCAL_NAME 근무지역명
from employee e
    join department d
        on e.DEPT_CODE = d.DEPT_ID
    join location l
        on d.LOCATION_ID = l.LOCAL_CODE
where
    ifnull(BONUS, 0);

-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select * from employee;
select * from job;
select * from department;
select * from location;

select
    EMP_NAME 사원명,
    JOB_NAME 직급명,
    DEPT_TITLE 부서명,
    LOCAL_NAME 근무지역명
from employee e
    join job j
        on e.JOB_CODE = j.JOB_CODE
    join department d
        on e.DEPT_CODE = d.DEPT_ID
    join location l
        on d.LOCATION_ID = l.LOCAL_CODE
where
    DEPT_CODE = 'D2';

-- 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
--    (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등(등가) 조인할 것)
select * from employee;
select * from job;
select * from sal_grade;
select
    e.EMP_NAME 사원명,
    j.JOB_NAME 직급명,
    e.SALARY 급여,
#     format(SALARY * 12, 3) 기본연봉,
#     bonus * SALARY '월급에 대한 보너스',
    s.MAX_SAL '최대급여',
    format(SALARY + (SALARY * ifnull(BONUS,0)) * 12, 0) '연봉 + 보너스'
from employee e
         join job j
              on e.JOB_CODE = j.JOB_CODE
         join sal_grade s
              on e.SAL_LEVEL = s.SAL_LEVEL
where
    e.SALARY > MAX_SAL;

-- 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select * from employee;
select * from department;
select * from location;
select * from nation;
select
    e.EMP_NAME 사원명,
    d.DEPT_TITLE 부서명,
    l.LOCAL_NAME 지역명,
    n.NATIONAL_NAME 국가명
from employee e
    join department d
        on e.DEPT_CODE = d.DEPT_ID
    join location l
        on d.LOCATION_ID = l.LOCAL_CODE
    join nation n
        using (NATIONAL_CODE)
where
    NATIONAL_NAME in ('한국', '일본');

-- 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
select * from employee;
select * from department;
select
    e1.EMP_NAME 사원명,
    d.DEPT_TITLE 부서명,
    e2.EMP_NAME 동료이름
from employee e1
    join employee e2
        on e1.DEPT_CODE = e2.DEPT_CODE
    left join department d
        on e1.DEPT_CODE = d.DEPT_ID
where
    e1.EMP_NAME != e2.EMP_NAME
order by
    1;

-- 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오.
--     단, join과 in 연산자 사용할 것
select * from employee;
select * from job;
select
    e.EMP_NAME 사원명,
    j.JOB_NAME 직급명,
    format(e.SALARY, 0) 급여,
    e.BONUS 보너스
from employee e
    left join job j
        on e.JOB_CODE = j.JOB_CODE
where
    BONUS is null
    and
    JOB_NAME in ('차장', '사원');

-- 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select * from employee;
select
#     EMP_NAME 사원명,
    if(QUIT_YN = 'N', '재직', '퇴사') '재직/퇴사 여부',
    count(*) 인원수
from
    employee
group by
    QUIT_YN;

