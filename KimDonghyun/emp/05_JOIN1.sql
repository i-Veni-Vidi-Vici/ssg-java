-- @조인실습문제1

-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
SET @@lc_time_names = 'ko_KR';
select
    date_format(date('20201225'),'%W') 요일; -- %W 요일명, %w 요일번호,

-- 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select
    emp_name 사원명,
    emp_no 주민번호,
    dept_title 부서명,
    job_name 직급명
from
    employee e
        left join department d on e.dept_code = d.dept_id
        left join job j using(job_code)
where
    substr(emp_no, 8, 1) in ('2', '4')
  and substr(emp_no, 1, 1) = 7
  and emp_name like '전%';

-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
--  나이가 가장 적은 사원 조회 쿼리
select
    min(
            truncate(
                    datediff(
                            now(),
                            concat(
                                    if(substr(emp_no, 8, 1) in (1, 2), 19, 20),
                                    left(emp_no, 6)
                            )
                    ) / 365
                , 0)
    ) min_age
from
    employee;

select
    emp_id 사번,
    emp_name 사원명,
    truncate(
            datediff(
                    now(),
                    concat(
                            if(substr(emp_no, 8, 1) in (1, 2), 19, 20),
                            left(emp_no, 6)
                    )
            ) / 365, 0) 나이,
    dept_title 부서명,
    job_name 직급명
from
    employee
        left join department on dept_code = dept_id
        left join job  using(job_code)
order by
    나이
limit 1;


-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select
    emp_id, emp_name, dept_title
from
    employee e
        left join department d
                  on(e.dept_code = d.dept_id)
where
    emp_name like '%형%';


-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select
    emp_name 사원명,
    job_name 직급명,
    dept_code 부서코드,
    dept_title 부서명
from
    employee
        join department on dept_code = dept_id
        join job using(job_code)
where
    dept_title like '해외영업%';

-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select
    emp_name 사원명, bonus 보너스포인트, dept_title 부서명, local_name 근무지역명
from
    employee e
        left join department d on dept_code = dept_id
        left join location l on d.location_id = l.local_code
where
    bonus is not null;


-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select
    emp_name 사원명,
    job_name 직급명,
    dept_title 부서명,
    local_name 근무지역명
from
    employee e
        join job using(job_code)
        join department d on e.dept_code = d.dept_id
        join location l on d.location_id = l.local_code
where
    dept_code = 'D2';


-- 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
--  (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등 조인할 것)
select
    emp_name,
    job_name,
    salary,
    (salary + salary * ifnull(bonus, 0)) * 12 annual_sal,
    max_sal
from
    employee e
        join job j on(e.job_code = j.job_code)
        join sal_grade s using(sal_level)
where
    e.salary > s.max_sal;



-- 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select
    emp_name 사원명,
    dept_title 부서명,
    local_name 지역명,
    national_name 국가명
from
    employee e
        left join department d on e.dept_code = d.dept_id
        left join location l on d.location_id = l.local_code
        left join nation n using(national_code)
where
    national_name in ('한국','일본');


-- 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
select
    e.emp_name 사원명,
    dept_title 부서명,
    e2.emp_name 동료사원명
from
    employee e
        join employee e2 on (e.dept_code = e2.dept_code)
        left join department d on e.dept_code = dept_id
where
    e.emp_name != e2.emp_name
order by 1;

-- 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 in 연산자 사용할 것
select
    emp_name 사원명,
    job_name 직급명,
    format(salary, 0) 급여
from
    employee e left join job
                         using(job_code)
where
    bonus is null and job_name in ('차장','사원');


-- 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select
    if(quit_yn = 'N','재직','퇴사') 재직여부,
    count(*) 인원수
from
    employee
group by
    quit_yn;