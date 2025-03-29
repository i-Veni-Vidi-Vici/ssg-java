use empdb;
-- 1. 부서별 직원 급여의 총합 중 가장 큰 액수를 출력하세요.
select
    max(sal_sum)
from (
         select
             dept_code, sum(salary) as sal_sum
         from
             employee
         where
             dept_code is not null
         group by
             dept_code) as tbl_dept_sal;

-- 2. 서브쿼리를 이용하여 영업부인 직원들의 사원번호, 직원명, 부서코드, 급여를 출력하세요.
-- 참고. 영업부인 직원은 부서명에 ‘영업’이 포함된 직원임
select
    emp_id, emp_name, dept_code, salary
from
    employee
where
    dept_code in (
        select
            dept_id
        from
            department
        where
            dept_title like '%영업%');

-- 3. 서브쿼리와 join을 이용하여 영업부인 직원들의 사원번호, 직원명, 부서명, 급여를 출력하세요.
select
    e.emp_id, e.emp_name, d.dept_title, e.salary
from
    employee e join department d
                    on e.dept_code = d.dept_id
where
    dept_code in (
        select
            dept_id
        from
            department
        where
            dept_title like '%영업%');

-- 4-1. join을 이용하여 부서의 부서코드, 부서명, 해당 부서가 위치한 지역명, 국가명을 추출 하는 쿼리를 작성하세요.
-- 4-2. 위 1에서 작성한 쿼리를 서브쿼리로 활용하여 모든 직원의 사원번호, 직원명, 급여, 부서명, (부서의) 국가명을 출력하세요.
-- 단, 국가명 내림차순으로 출력되도록 하세요.

select
    e.emp_id, e.emp_name, e.salary, dln.dept_title, dln.national_name
from
    employee e left join (
        select
            d.dept_id, d.dept_title, n.national_name
        from
            department d
                join location l on (d.location_id = l.local_code)
                join nation n on (l.national_code = n.national_code)
    ) dln
                         on e.dept_code = dln.dept_id
order by
    dln.national_name desc;

-- 5. 러시아에서 발발한 전쟁으로 인해 정신적 피해를 입은 직원들에게 위로금을 전달하려고 합니다.
-- 위로금은 각자의 급여에 해당 직원의 급여 등급에 해당하는 최소 금액을 더한 금액으로 정했습니다.
-- 4번에서 작성한 쿼리를 활용하여 해당 부서의 국가가 ‘러시아’인 직원들을 대상으로,
-- 직원의 사원번호, 직원명, 급여, 부서명, 국가명, 위로금을 출력하세요.
-- 단, 위로금의 결과 집합 헤더는 ‘위로금’으로 출력되도록 하고, 위로금 내림차순으로 출력되도록 하세요.
select
    e.emp_id,
    e.emp_name,
    format(e.salary, 0) salary,
    dln.dept_title,
    dln.national_name,
    format(e.salary + (select min_sal from sal_grade where sal_level = e.sal_level), 0) 위로금
from
    employee e left join (
        select
            d.dept_id, d.dept_title, n.national_name
        from
            department d
                join location l on (d.location_id = l.local_code)
                join nation n on (l.national_code = n.national_code)
    ) dln
                         on e.dept_code = dln.dept_id
where
    dln.national_name = '러시아'
order by
    위로금 desc;