
-- 1
select max(dept_salary) 급여합계가가장큰부서
from (
         select sum(salary) dept_salary
         from employee
         group by dept_code
     ) t;

-- 2
select emp_id, emp_name, dept_code, salary
from employee
where dept_code in (
    select dept_id
    from department
    where dept_title like '%영업%'
    );

-- 3
select emp_id 사원번호,
       emp_name 직원명,
       (select dept_title from department where dept_id = e.dept_code) 부서명,
       salary 급여
from employee e
where dept_code in (
    select dept_id
    from department
    where dept_title like '%영업%'
    );

-- 4.
-- a. JOIN을 이용하여 부서의 부서코드, 부서명, 해당 부서가 위치한 지역명, 국가명을 추출하는 쿼리를 작성하세요.
select dept_id, dept_title, local_name, national_name
from department d left join location l on d.location_id = l.local_code
left join nation n using(national_code);
-- b. 위 a에서 작성한 쿼리를 서브쿼리로 활용하여 모든 직원의 사원번호, 직원명, 급여, 부서명, (부서의) 국가명을 출력하세요.
--    단, 국가명 내림차순으로 출력되도록 하세요.
select emp_id, emp_name, salary, dept_title, national_name
from employee join (
    select dept_id, dept_title, local_name, national_name
    from department d left join location l on d.location_id = l.local_code
                      left join nation n using(national_code)
) t on dept_code = dept_id;

-- 5. 러시아에서 발발한 전쟁으로 인해 정신적 피해를 입은 직원들에게 위로금을 전달하려고 합니다.
-- 위로금은 각자의 급여에 해당 직원의 급여 등급에 해당하는 최소 금액을 더한 금액으로 정했습니다.
-- 4에서 작성한 쿼리를 활용하여 해당 부서의 국가가 ‘러시아’인 직원들을 대상으로,
-- 직원의 사원번호, 직원명, 급여, 부서명, 국가명, 위로금을 출력하세요.
-- 단, 위로금의 결과 집합 헤더는 ‘위로금’으로 출력되도록 하고, 위로금 내림차순으로 출력되도록 하세요.
select emp_id 사원번호, emp_name 직원명, salary 급여, dept_title 부서명, national_name 국가명, salary + (
    select min_sal
    from sal_grade
    where sal_level = e.sal_level
) 위로금
from employee e join (
    select dept_id, dept_title, local_name, national_name
    from department d left join location l on d.location_id = l.local_code
                      left join nation n using(national_code)
) t on dept_code = dept_id
where national_name = '러시아'
order by 위로금 desc;