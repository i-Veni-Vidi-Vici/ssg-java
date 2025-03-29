-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.🆗
-- 지역 변경
select @@lc_time_names; -- en_US -> ko_KR -> ⛳위의 %W의 출력값인 Tuesday도 화요일로 바뀜!
set @@lc_time_names = 'ko_KR';

select
    date_format('2020-12-25', '%a요일'); -- 금요일

-- 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.🆗
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
    (substring(EMP_NO, 8, 1) = 2 or substring(EMP_NO, 8, 1) = 4)
  and
    E.EMP_NAME like '전%';

-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.🆗
select
    E.EMP_ID 사번,
    E.EMP_NAME 사원명,
    concat(year(now()) - (substring(E.EMP_NO, 1, 2) + 2000), '세') 나이,
    D.DEPT_TITLE 부서명,
    JOB_NAME 직급명
from
    employee E
        left join department D
             on E.DEPT_CODE = D.DEPT_ID
        join job J using (JOB_CODE)
where
    (substring(EMP_NO, 8, 1) = 3 or substring(EMP_NO, 8, 1) = 4)
limit 1;

-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.🆗
select
    E.EMP_ID 사번,
    E.EMP_NAME 사원명,
    D.DEPT_TITLE 부서명
from
    employee E join department D
        on E.DEPT_CODE = D.DEPT_ID
where
    E.EMP_NAME like '%형%';

-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.🆗
select
    E.EMP_NAME,
    J.JOB_NAME,
    D.DEPT_ID,
    D.DEPT_TITLE
from
    employee E
        join department D
            on E.DEPT_CODE = D.DEPT_ID
        join job J
            on E.JOB_CODE = J.JOB_CODE
where
    D.DEPT_TITLE like '해외%';

-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.🆗
select
    E.EMP_NAME 사원명,
    E.BONUS 보너스포인트,
    D.DEPT_TITLE 부서명,
    L.LOCAL_NAME 근무지역명
from
    employee E
        left join department D
             on E.DEPT_CODE = D.DEPT_ID
        left join location L
             on D.LOCATION_ID = L.LOCAL_CODE
where
    E.BONUS is not null;

-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.🆗
select
    E.EMP_NAME 사원명,
    J.JOB_NAME 직급명,
    D.DEPT_TITLE 부서명,
    L.LOCAL_NAME 근무지역명
from
    employee E join job J using(JOB_CODE)
        join department D
            on E.DEPT_CODE = D.DEPT_ID
        join location L
            on D.LOCATION_ID = L.LOCAL_CODE
where
    E.DEPT_CODE = 'D2';

-- 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.🆗
-- (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등(등가) 조인할 것)
select
    E.EMP_NAME 사원명,
    J.JOB_NAME 직급명,
    format(E.SALARY, 0) 급여,
    format(E.SALARY * 12, 0) 연봉
from
    employee E
        join job J using(JOB_CODE)
        join sal_grade S
            on E.SAL_LEVEL = S.SAL_LEVEL
where
    E.SALARY > S.MAX_SAL;

-- 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.🆗
select
    E.EMP_NAME 사원명,
    D.DEPT_TITLE 부서명,
    L.LOCAL_NAME 지역명,
    case
        when L.LOCAL_CODE = 'L1' then '한국'
        when L.LOCAL_CODE = 'L2' then '일본'
    end 국가명
from
    employee E
        left join department D
            on E.DEPT_CODE = D.DEPT_ID
        join location L
            on D.LOCATION_ID = L.LOCAL_CODE
where
    L.LOCAL_CODE in('L1', 'L2');


-- 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)🆗
select
    E2.EMP_NAME 사원명,
    D.DEPT_TITLE 부서명,
    E1.EMP_NAME 동료이름
from
    employee E1 join employee E2
        on E1.DEPT_CODE = E2.DEPT_CODE
    join department D
        on E1.DEPT_CODE = D.DEPT_ID
order by
    D.DEPT_TITLE,
    E2.EMP_NAME,
    E1.EMP_NAME;

-- 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 in 연산자 사용할 것 🆗
select
    E.EMP_NAME 사원명,
    J.JOB_NAME 직급명,
    format(E.SALARY, 0) 급여
from
    employee E join job J
        using(JOB_CODE)
where
    J.JOB_NAME in ('차장', '사원');

-- 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.🆗
select
    if(QUIT_YN = 'N', '재직 중', '퇴사') 재직여부,
    concat(count(*), '명') 직원수
from employee
group by
    QUIT_YN;

-- 💖12번 문제 다른 풀이 : 전체를 하나의 그룹으로 처리
select
    count(if(QUIT_YN = 'N', 1, null)) 재직자,  -- ⛳null값이 아닌 레코드 수 센다.
    count(if(QUIT_YN = 'Y', 1, null)) 퇴사자,
    sum(if(QUIT_YN = 'N', 1, null)) 재직자, -- ⛳null값이 컬럼값을 합계를 구한다.
    sum(if(QUIT_YN = 'Y', 1, null)) 퇴사자
from employee;