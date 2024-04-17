select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select
    case
        when dayofweek('2020-12-25') = 1 then '일요일'
        when dayofweek('2020-12-25') = 2 then '월요일'
        when dayofweek('2020-12-25') = 3 then '화요일'
        when dayofweek('2020-12-25') = 4 then '수요일'
        when dayofweek('2020-12-25') = 5 then '목요일'
        when dayofweek('2020-12-25') = 6 then '금요일'
        else '토요일'
    end;

-- 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select e.EMP_NAME 사원명,
       e.EMP_NO 주민번호,
       d.DEPT_TITLE,
       j.JOB_NAME
from employee e left join department d
    on e.DEPT_CODE = d.DEPT_ID
    left join job j
        on e.JOB_CODE = j.JOB_CODE
where (substring(EMP_NO, 1, 2) between 70 and 79)
  and substring(EMP_NO, 8, 1) = 2
  and EMP_NAME like '전%';

-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select
    e.EMP_ID 사번,
    e.EMP_NAME 사원명,
    truncate(datediff(now(),
            case
                when substring(EMP_NO, 8, 1) <= 2 then concat('19', substring(EMP_NO, 1, 6))
                else concat('20', substring(EMP_NO, 1, 6))
            end) / 365, 0) 나이,
    d.DEPT_TITLE 부서명,
    j.JOB_NAME 직급명
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
    join job j on e.JOB_CODE = j.JOB_CODE
order by datediff(now(),
                  case
                      when substring(EMP_NO, 8, 1) <= 2 then concat('19', substring(EMP_NO, 1, 6))
                      else concat('20', substring(EMP_NO, 1, 6))
                      end)
limit 1;

-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select e.EMP_ID 사번,
       e.EMP_NAME 사원명,
       d.DEPT_TITLE 부서명
from employee e join department d on e.DEPT_CODE = d.DEPT_ID

where EMP_NAME like '%형%';

-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select e.EMP_NAME 사원명,
       j.JOB_NAME 직급명,
       d.DEPT_ID 부서코드,
       d.DEPT_TITLE 부서명
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
    join job j on e.JOB_CODE = j.JOB_CODE
where d.DEPT_TITLE like '%해외영업%';

-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select e.EMP_NAME 사원명,
       e.BONUS 보너스포인트,
       d.DEPT_TITLE 부서명,
       l.LOCAL_NAME 근무지역
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
    join location l on d.LOCATION_ID = l.LOCAL_CODE
where not isnull(BONUS);

-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select e.EMP_NAME 사원명,
       j.JOB_NAME 직급명,
       d.DEPT_TITLE 부서명,
       l.LOCAL_NAME 근무지역
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
    join job j on e.JOB_CODE = j.JOB_CODE
    join location l on d.LOCATION_ID = l.LOCAL_CODE
where DEPT_CODE = 'D2';

-- 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
--     (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등(등가) 조인할 것)
select e.EMP_NAME 사원명,
       j.JOB_NAME 직급명,
       format(e.SALARY, 0) 급여,
       format(e.SALARY * 12, 0) 연봉
from employee e join sal_grade s on e.SAL_LEVEL = s.SAL_LEVEL
    join job j on e.JOB_CODE = j.JOB_CODE
where e.SALARY > s.MAX_SAL;

-- 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select e.EMP_NAME 사원명,
       d.DEPT_TITLE 부서명,
       l.LOCAL_NAME 지역명,
       n.NATIONAL_NAME 국가명
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
    join location l on d.LOCATION_ID = l.LOCAL_CODE
    join nation n on l.NATIONAL_CODE = n.NATIONAL_CODE
where l.NATIONAL_CODE = 'KO' or l.NATIONAL_CODE = 'JP';

-- 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
select *
from employee e1 left join employee e2 on e1.EMP_ID = e2.MANAGER_ID;

select DEPT_CODE
from employee
group by DEPT_CODE;

-- 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 in 연산자 사용할 것
select e.EMP_NAME 사원명,
       j.JOB_NAME 직급명,
       format(e.SALARY, 0) 급여
from employee e join job j on e.JOB_CODE = j.JOB_CODE
where isnull(BONUS) and (j.JOB_NAME in ('차장' ,'사원'));

-- 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select
    case
        when isnull(QUIT_DATE) then '재직중인 직원'
        else '퇴사한 직원'
        end 직원분류,
    count(*) 명
from employee
group by
    case
        when isnull(QUIT_DATE) then '재직중인 직원'
        else '퇴사한 직원'
    end;