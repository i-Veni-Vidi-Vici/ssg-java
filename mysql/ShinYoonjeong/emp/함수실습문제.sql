select * from employee;
select EMP_NAME,
       EMAIL,
       length(EMAIL)
from employee;
select EMP_NAME,
       substring_index(EMAIL, '@',1)
from employee;

select
    EMP_NAME,
    concat('19', substring(EMP_NO,1,2)),
    ifnull(BONUS, '0')
from employee
where
    EMP_NO like '6%';

select concat(count(PHONE), '명')
from employee
where
    PHONE not like '010%';

select EMP_NAME,
       concat(year(HIRE_DATE), '년', month(HIRE_DATE), '월')
from employee;

select
    concat(substring(EMP_NO, 1,8), '******'),
    EMP_NAME
from
    employee;

select EMP_NAME,
       JOB_CODE,
       concat('￦',ifnull(format(SALARY+SALARY*BONUS,0), format(SALARY,0)))
from employee;

select
    EMP_ID,
    EMP_NAME,
    DEPT_CODE,
    HIRE_DATE
from employee
where
    (DEPT_CODE = 'D5' or DEPT_CODE = 'D9')
    and
    year(HIRE_DATE) = 2004;

select EMP_NAME,
       HIRE_DATE,
       truncate(if(QUIT_YN = 'N',datediff(now(), HIRE_DATE) ,datediff(QUIT_DATE, HIRE_DATE)), 0)

from employee;

select EMP_NO,
       DEPT_CODE,
       concat(if(substring(EMP_NO, 8,1)=1 or substring(EMP_NO, 8,1)=2, concat('19', substring(EMP_NO,1,2), '년'), concat('20', substring(EMP_NO,1,2), '년')),substring(EMP_NO,3,2),'월',substring(EMP_NO,5,2 ),'일') 생년월일,
       if(substring(EMP_NO, 8,1)=1 or substring(EMP_NO, 8,1)=2, year(now())-1900-substring(EMP_NO,1,2),year(now())-2000-substring(EMP_NO,1,2))
from employee;

select year(HIRE_DATE)
from employee;

select
    count(*)

from employee
where
    year(HIRE_DATE) between 1998 and 2004
;

select
    *,
    case DEPT_CODE
        when 'D5' then '총무부'
        when 'D6' then '기획부'
        when 'D9' then '영업부'
        end

from employee
where DEPT_CODE IN ('D5', 'D6', 'D9')
order by
    DEPT_CODE desc;