-- 조인실습문제1 #131
use empdb;

-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select date_format('20201225', '%W');

-- 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select
    e.EMP_NAME 사원명,
    e.EMP_NO 주민번호,
    d.DEPT_TITLE 부서명,
    j.JOB_NAME 직급명
from
    employee e
        join department d
            on e.DEPT_CODE = d.DEPT_ID
        join job j
            on e.JOB_CODE = j.JOB_CODE
where
    (left(EMP_NO, 2) between 70 and 79
  and substr(EMP_NO, 8, 1) = 2)
  and left(EMP_NAME, 1) = '전';

-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select
    e.EMP_ID 사번,
    e.EMP_NAME 사원명,
    extract(year from curdate()) - (case
                                        substr(e.EMP_NO, 8, 1)
                                        when 1 then 1900
                                        when 2 then 1900
                                        else 2000
                                   end + substr(e.EMP_NO, 1, 2)) -
                                   if(month(now()) > substr(e.EMP_NO, 3, 2) &&
                                      day(now()) > substr(e.EMP_NO, 5, 2), 0, 1) 나이,
    d.DEPT_TITLE 부서명,
    j.JOB_NAME 직급명
from
    employee e
        join department d
             on e.DEPT_CODE = d.DEPT_ID
        join job j
             on e.JOB_CODE = j.JOB_CODE
order by
    concat(
    case
        substr(e.EMP_NO, 8, 1)
        when 1 then 1900
        when 2 then 1900
        else 2000
    end,
    substr(e.EMP_NO, 3, 2)) desc
limit
    1;

-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
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
select
    e.EMP_NAME 사원명,
    j.JOB_NAME 직급명,
    d.DEPT_ID 부서코드,
    d.DEPT_TITLE 부서명
from
    employee e
        join department d
             on e.DEPT_CODE = d.DEPT_ID
        join job j
             on e.JOB_CODE = j.JOB_CODE
where
    d.DEPT_TITLE like '%해외영업%';

-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select
    e.EMP_NAME 사원명,
    e.BONUS 보너스포인트,
    d.DEPT_TITLE 부서명,
    l.LOCAL_NAME 근무지역명
from
    employee e
        join department d
             on e.DEPT_CODE = d.DEPT_ID
        join location l
             on d.LOCATION_ID = l.LOCAL_CODE
where
    BONUS is not null;

-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select
    e.EMP_NAME 사원명,
    j.JOB_NAME 직급명,
    d.DEPT_TITLE 부서명,
    l.LOCAL_NAME 근무지역명
from
    employee e
        join department d
             on e.DEPT_CODE = d.DEPT_ID
        join job j
            on e.JOB_CODE = j.JOB_CODE
        join location l
             on d.LOCATION_ID = l.LOCAL_CODE
where
    d.DEPT_ID = 'D2';

-- 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
    -- (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등(등가) 조인할 것)
select
    e.EMP_NAME 사원명,
    j.JOB_NAME 직급명,
    e.SALARY 급여,
    (e.SALARY + (e.SALARY * ifnull(e.BONUS, 0))) * 12 연봉
from
    employee e
        join job j
            on e.JOB_CODE = j.JOB_CODE
        join sal_grade s
            on e.SAL_LEVEL = s.SAL_LEVEL
where
    e.SALARY > s.MAX_SAL;

-- 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select
    e.EMP_NAME 사원명,
    d.DEPT_TITLE 부서명,
    l.LOCAL_NAME 지역명,
    n.NATIONAL_NAME 국가명
from
    employee e
        join department d
            on e.DEPT_CODE = d.DEPT_ID
        join location l
            on d.LOCATION_ID = l.LOCAL_CODE
        join nation n
            on l.NATIONAL_CODE = n.NATIONAL_CODE
where
    n.NATIONAL_CODE in ('KO', 'JP');

-- 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
select
    e.EMP_NAME 사원명,
    d.DEPT_TITLE 부서명,
    emps.EMP_NAME 동료이름
from
    employee e
        join department d
             on e.DEPT_CODE = d.DEPT_ID
        join employee emps
             on e.DEPT_CODE = emps.DEPT_CODE
where
    e.EMP_NAME != emps.EMP_NAME;

-- 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 in 연산자 사용할 것
select
    e.EMP_NAME 사원명,
    j.JOB_NAME 직급명,
    e.SALARY 급여
from
    employee e join job j
        on e.JOB_CODE = j.JOB_CODE
where
    BONUS is null
  and
    j.JOB_NAME in ('차장', '사원');

-- 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select
    case QUIT_YN
        when 'Y' then '퇴사 O'
        when 'N' then '퇴사 X'
    end '퇴사 여부',
    count(*) '퇴사한 직원의 수'
from
    employee
group by
    QUIT_YN;