-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
-- 지역 변경
select @@lc_time_names; -- en_US -> ko_KR -> ⛳위의 %W의 출력값인 Tuesday도 화요일로 바뀜!
set @@lc_time_names = 'ko_KR';

select
    date_format('2020-12-25', '%a요일'); -- 금요일

-- 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select
    E.EMP_NAME 사원명,
    E.EMP_NO 주민번호,
    D.DEPT_TITLE 부서명,
    JOB_NAME 직급명
from
    employee E
        join department D
            on E.DEPT_CODE = D.DEPT_ID
        join job J using (JOB_CODE)
where
    (substring(EMP_NO, 1, 2) between 70 and 79)
  and
    (substring(EMP_NO, 8, 1) = 2 or substring(EMP_NO, 8, 1) = 4);

-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select
    E.EMP_ID 사번,
    E.EMP_NAME 사원명,
    E.EMP_NO 나이,
    D.DEPT_TITLE 부서명,
    JOB_NAME 직급명
from
    employee E
        join department D
             on E.DEPT_CODE = D.DEPT_ID
        join job J using (JOB_CODE)
where
    (substring(EMP_NO, 8, 1) = 3 or substring(EMP_NO, 8, 1) = 4)
limit 1;



select *
from employee;

select *
from department;

select *
from job;

-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.

-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.

-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.

-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.

-- 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
-- (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등(등가) 조인할 것)

-- 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.

-- 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)

-- 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 in 연산자 사용할 것

-- 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.