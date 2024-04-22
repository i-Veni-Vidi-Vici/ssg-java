-- 1. 부서별 직원 급여의 총합 중 가장 큰 액수를 출력하세요.
select
    max()
from
    employee e
where (
      select
          sum(SALARY) as '총합'
      from
          employee
      where
          DEPT_CODE is not null
      group by
          DEPT_CODE
          ) t;

select
    sum(SALARY)
from
    employee

;