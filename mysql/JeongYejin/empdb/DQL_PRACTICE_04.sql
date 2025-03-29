# 1
select
    JOB_CODE,
    count(*) 사원수,
    avg(SALARY) 평균급여
from employee
where JOB_CODE != 'J1'
group by JOB_CODE;

# 2
select year(HIRE_DATE) 입사년,
       count(*)
from employee
where JOB_CODE != 'J1'
group by year(HIRE_DATE)
order by 입사년;

# 3
select *
from employee;
select
    case substr(EMP_NO, 8, 1)
        when 1 then '남'
        when 3 then '남'
        else '여'
    end 성별, cast(avg(SALARY) as signed integer)평균, sum(SALARY) 급여합계, count(*) 인원수
from employee
group by
    case substr(EMP_NO, 8, 1)
        when 1 then '남'
        when 3 then '남'
        else '여'
    end
order by 인원수 desc;

# 4
select JOB_CODE 직급, count(*) 총원
from employee
group by JOB_CODE
having count(*) >= 3;