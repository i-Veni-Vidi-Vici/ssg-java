select count(JOB_CODE),
       JOB_CODE,
       avg(SALARY)
from employee
where
    JOB_CODE not like 'J1'
group by
    JOB_CODE;

select count(HIRE_DATE),
       year(HIRE_DATE)
from employee
where
    JOB_CODE not like 'J1'
group by
    year(HIRE_DATE)
order by year(HIRE_DATE) desc;
