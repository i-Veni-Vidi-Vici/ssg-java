-- ---------------------------
-- 조인실습문제1 #131
-- ---------------------------

# 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
SET @@lc_time_names = 'ko_KR';
select dayname('2020-12-25') 요일;
-- 금요일

# 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select * from employee;
select * from department;
select * from job;
-- -----------------------
select
    EMP_NAME 사원명,
    EMP_NO 주민번호,
    DEPT_TITLE 부서명,
    JOB_NAME 직급명
from
    employee e
        join department d
                  on e.DEPT_CODE = d.DEPT_ID
        join job j
                  on e.JOB_CODE = j.JOB_CODE
where
    substring(EMP_NO, 1, 2) between '70' and '79' -- 70년대생
  and substring(EMP_NO, 8, 1) in ('2', '4')       -- 여자 주민번호 뒤에 2 or 4
  and EMP_NAME like '전%'; -- 전으로 시작하는 이름

-- 전지연,770808-2665412,인사관리부,대리

# 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select * from employee;
select * from department;
select * from job;
-- -----------------------
select
    EMP_ID 사번,
    EMP_NAME 사원명,
    year(now()) - (cast(concat('19', substring(EMP_NO, 1, 2)) as unsigned)
        + if(substring(EMP_NO, 8, 1) = '1' or substring(EMP_NO, 8, 1) = '2', 0, 100))
        - (date_format(now(), '%m%d') < concat(substring(EMP_NO, 3, 2), substring(EMP_NO, 5, 2))) 나이,
    DEPT_TITLE 부서명,
    JOB_NAME 직급명
from
    employee e
        join department d
                  on e.DEPT_CODE = d.DEPT_ID
        join job j
                  on e.JOB_CODE = j.JOB_CODE
order by 나이 asc
limit 1;
-- 203,송은희,16,해외영업2부,차장

-- 강사님 코드 시작
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
-- 강사님 코드 끝

# 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
-- inner join
-- left outer join
select * from employee;
select * from department;
select * from job;
-- -----------------------
select
    EMP_ID 사번,
    EMP_NAME 사원명,
    DEPT_TITLE 부서명
from
    employee e
        left join department d
                  on e.DEPT_CODE = d.DEPT_id
where
    EMP_NAME like '%형%';
-- 211,전형돈,기술지원부

# 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select * from employee;
select * from department;
select * from job;
-- -----------------------
select
    EMP_NAME 사원명,
    JOB_NAME 직급명,
    DEPT_ID 부서코드,
    DEPT_TITLE 부서명
from employee e
         join department d
                   on e.DEPT_CODE = d.DEPT_ID
         join job j
                   on e.JOB_CODE = j.JOB_CODE
where
    DEPT_TITLE like '해외영업%';

# 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select * from employee;
select * from department;
select * from job;
select * from location;
-- -----------------------
select
    EMP_NAME 사원명,
    BONUS 보너스포인트,
    DEPT_TITLE 부서명,
    LOCAL_NAME 근무지역명
from employee e
         left join department d
                   on e.DEPT_CODE = d.DEPT_ID
         left join location l
                   on d.LOCATION_ID = l.LOCAL_CODE
where BONUS is not null;

# 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select * from employee;
select * from department;
select * from job;
select * from location;
-- -----------------------
select
    EMP_NAME 사원명,
    JOB_NAME 직급명,
    DEPT_TITLE 부서명,
    LOCAL_NAME 근무지역명
from
    employee e
        join department d
                  on e.DEPT_CODE = d.DEPT_ID
        join location l
                  on d.LOCATION_ID = l.LOCAL_CODE
        join job j
                  on e.JOB_CODE = j.JOB_CODE
where
    DEPT_CODE = 'D2';

# 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
#     (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등(등가) 조인할 것)
select * from employee;
select * from department;
select * from job;
select * from sal_grade;
-- -----------------------
select
    EMP_NAME 사원명,
    JOB_NAME 직급명,
    SALARY 급여,
    (salary + salary * ifnull(bonus, 0)) * 12 연봉
#     ,MAX_SAL 최대급여
from
    employee e
        join job j
                  on e.JOB_CODE = j.JOB_CODE
        join SAL_GRADE sg
                  on e.SAL_LEVEL = sg.SAL_LEVEL
where
    e.SALARY > sg.MAX_SAL;

# 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select * from employee;
select * from department;
select * from job;
select * from location;
select * from NATION;
-- -----------------------
select
    EMP_NAME 사원명,
    DEPT_TITLE 부서명,
    LOCAL_NAME 지역명,
    NATIONAL_NAME 국가명
from
    employee e
        left join department d
                  on e.DEPT_CODE = d.DEPT_ID
        left join location l
                  on d.LOCATION_ID = l.LOCAL_CODE
        left join nation n
                  on l.NATIONAL_CODE = n.NATIONAL_CODE
where
    NATIONAL_NAME in ('한국','일본');   # n.NATIONAL_CODE IN ('KO', 'JP');

# 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
select * from employee;
select * from department;
-- -----------------------
select *
from employee e1
    join employee e2
        on e1.DEPT_CODE = e2.DEPT_CODE;
select
    e1.EMP_NAME 사원명,
    DEPT_TITLE 부서명,
    e2.EMP_NAME 동료사원명
from
    employee e1
        join employee e2
             on (e1.DEPT_CODE = e2.DEPT_CODE)
        left join department d
                  on e1.DEPT_CODE = DEPT_ID
where
    e1.EMP_NAME <> e2.EMP_NAME
order by 1;

# 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 in 연산자 사용할 것
select
    e.EMP_NAME 사원명,
    j.JOB_NAME 직급명,
    e.SALARY 급여
from
    employee e
        left join job j
                  on e.JOB_CODE = j.JOB_CODE
where
    e.BONUS is null and j.JOB_NAME in ('차장', '사원');

# 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select
    sum(if(QUIT_YN = 'N', 1, 0)) 재직중인_직원수,
    sum(if(QUIT_YN = 'Y', 1, 0)) 퇴사한_직원수
from
    employee;

select
    if(quit_yn = 'N','재직','퇴사') 재직여부,
    count(*) 직원수
from
    employee
group by
    quit_yn;