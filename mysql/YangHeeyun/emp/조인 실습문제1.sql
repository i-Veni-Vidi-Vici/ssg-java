조인실습문제1
use empdb;

select * from employee;
select * from department;
select * from job;
select * from location;
select * from nation;
select * from sal_grade;

-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select date_format('2020-12-25','%W');

-- 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select
    e.EMP_NAME,e.EMP_NO,d.DEPT_TITLE, j.JOB_NAME
from
    employee e
        left join department d
                  on e.DEPT_CODE = d.DEPT_ID
        join job j
             using (JOB_CODE)
where
    left(e.emp_no,1) = 7
  and substr(e.EMP_NO,8,1) in ('2','4')
  and e.emp_name like '전%'


-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select
    e.EMP_id,e.EMP_Name,d.DEPT_TITLE,
    year(now()) - (if(mid(EMP_NO,8,1) in (1,2),1900,2000) + substring(emp_no,1,2))
    - if(date_format(now(),'%m%d') < mid(emp_no,3,4),1,0) 나이,
    j.JOB_NAME
from
    employee e
    left join department d
on e.DEPT_CODE = d.DEPT_ID
    join job j
    using (JOB_CODE)
order by 나이
    limit 1;

-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select
    e.emp_id, e.emp_name, d.DEPT_TITLE
from
    employee e join department d
                    on e.DEPT_CODE = d.DEPT_ID
where
    EMP_NAME like '%형%'

-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
-- 해외영업3부 사원없음
select
    e.EMP_NAME,j.JOB_NAME,d.DEPT_ID, d.DEPT_TITLE
from
    employee e
        left join department d
                  on e.DEPT_CODE = d.DEPT_ID
        left join job j
                  using (JOB_CODE)
where
    d.DEPT_TITLE LIKE '해외영업%';

-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select
    emp_name,bonus,d.DEPT_TITLE,l.LOCAL_NAME
from
    employee e
        left join department d on e.DEPT_CODE = d.DEPT_ID
        left join location l on d.LOCATION_ID = LOCAL_CODE
where
    BONUS is not null;

-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select
    emp_name,JOB_NAME,DEPT_TITLE,LOCAL_NAME,DEPT_CODE
from
    employee e
        left join department d on e.DEPT_CODE = d.DEPT_ID
        left join job j using(job_code)
        left join location l on d.LOCATION_ID = LOCAL_CODE
where
    DEPT_CODE = 'D2';

-- 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
-- (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등(등가) 조인할 것)
select
    e.EMP_NAME,j.JOB_NAME, e.SALARY,
    (e.SALARY + e.salary * ifnull(bonus,0)) * 12 연봉,
    sg.MAX_SAL
from
    employee e
        left join job j using(job_code)
        left join sal_grade sg using(sal_level)
where e.salary > sg.max_sal;

-- 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select
    e.EMP_NAME, d.DEPT_TITLE, l.LOCAL_NAME,n.NATIONAL_NAME
from
    employee e
        left join department d on e.DEPT_CODE = d.DEPT_ID
        left join location l on d.LOCATION_ID = l.LOCAL_CODE
        left join nation n using(national_code)
where
    n.NATIONAL_NAME in ('한국','일본');

-- 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
select
    e.EMP_NAME, d.DEPT_TITLE, e2.EMP_NAME
from
    employee e join employee e2 using(dept_code)
               left join department d on e.DEPT_CODE = d.DEPT_ID
where
    e.EMP_NAME != e2.EMP_NAME
order by
    1;

-- 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오.
-- 단, join과 in 연산자 사용할 것
select
    e.EMP_NAME, j.JOB_NAME, e.SALARY
from
    employee e
        left join job j using(job_code)
where
    e.bonus is null
  and
    j.JOB_NAME in ('차장','사원');

-- 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select
    sum(if(QUIT_YN = 'N',1,0)) 재직직원수,
    sum(if(QUIT_YN = 'Y',1,0)) 퇴사직원수
from
    employee;

select
    if(quit_yn = 'N','재직','퇴사') 재직여부,
    count(*) 직원수
from
    employee
group by
    quit_yn;
