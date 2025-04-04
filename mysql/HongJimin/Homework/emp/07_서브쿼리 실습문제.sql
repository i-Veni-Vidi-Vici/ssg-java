-- 1. 부서별 직원 급여의 총합 중 가장 큰 액수를 출력하세요. - 🆗
select
    sum(SALARY)
from
    employee E
group by
    DEPT_CODE
order by
    sum(SALARY) desc
limit 1;

-- 2. 서브쿼리를 이용하여 영업부인 직원들의 사원번호, 직원명, 부서코드, 급여를 출력하세요. - 🆗
-- 참고. 영업부인 직원은 부서명에 ‘영업’이 포함된 직원임
select
    EMP_ID,
    EMP_NAME,
    DEPT_CODE,
    SALARY
from
    employee
where
    DEPT_CODE in (
        select
            DEPT_ID
        from
            (select DEPT_ID
             from department
             where DEPT_TITLE like '%영업%') u
        );

-- 3. 서브쿼리와 JOIN을 이용하여 영업부인 직원들의 사원번호, 직원명, 부서명, 급여를 출력하세요. - 🆗
select
    E.EMP_ID,
    E.EMP_NAME,
    D.DEPT_TITLE,
    E.SALARY
from employee E join department D
    on E.DEPT_CODE = D.DEPT_ID
where
    DEPT_TITLE in (select DEPT_TITLE from department where DEPT_TITLE like '%영업%');

-- 4.
-- a. JOIN을 이용하여 부서의 부서코드, 부서명, 해당 부서가 위치한 지역명, 국가명을 추출하는 쿼리를 작성하세요. - 🆗
select
    D.DEPT_ID,
    D.DEPT_TITLE,
    L.LOCAL_NAME,
    N.NATIONAL_NAME
from
    department D
        join location L
            on D.LOCATION_ID = L.LOCAL_CODE
        join nation N
            using (NATIONAL_CODE)
group by
    D.DEPT_ID;

-- b. 위 a에서 작성한 쿼리를 서브쿼리로 활용하여 모든 직원의 사원번호, 직원명, 급여, 부서명, (부서의) 국가명을 출력하세요.
-- 단, 국가명 내림차순으로 출력되도록 하세요. - 🆗
select
    E.EMP_ID,
    E.EMP_NAME,
    E.SALARY,
    D.DEPT_TITLE,
    N.NATIONAL_NAME
from employee E
    join (
        department D
            join location L
                on D.LOCATION_ID = L.LOCAL_CODE
            join nation N
                using (NATIONAL_CODE)
        )
order by
    N.NATIONAL_NAME desc;

-- 5. 러시아에서 발발한 전쟁으로 인해 정신적 피해를 입은 직원들에게 위로금을 전달하려고 합니다.
-- 위로금은 각자의 급여에 해당 직원의 급여 등급에 해당하는 최소 금액을 더한 금액으로 정했습니다.
-- 4에서 작성한 쿼리를 활용하여 해당 부서의 국가가 ‘러시아’인 직원들을 대상으로,
-- 직원의 사원번호, 직원명, 급여, 부서명, 국가명, 위로금을 출력하세요.
-- 단, 위로금의 결과 집합 헤더는 ‘위로금’으로 출력되도록 하고, 위로금 내림차순으로 출력되도록 하세요.
select
    E.EMP_ID,
    E.EMP_NAME,
    E.SALARY,
    D.DEPT_TITLE,
    N.NATIONAL_NAME,
    E.SALARY + (select
                    min(SALARY)
                from employee
                where
                    DEPT_CODE = 'D8'
                ) 위로금
from
    employee E
        left join department D
            on E.DEPT_CODE = D.DEPT_ID
        join location L
            on D.LOCATION_ID = L.LOCAL_CODE
        join nation N
            using (NATIONAL_CODE)
where N.NATIONAL_NAME = '러시아';