use empdb;

-- 1.
select
    EMP_NAME,
    EMAIL,
    char_length(EMAIL)

from employee;

-- 2.
select
    EMP_NAME,
    substring_index(EMAIL, '@', 1)
from employee;

-- 3.
select
    EMP_NAME,
    substring(EMP_NO,1,2),
    ifnull(BONUS, 0)
from
    employee
where
    substring(EMP_NO,1,2) between 60 and 69;

-- 4.
select
    concat(count(PHONE),'명')
from
    employee
where
    substring(PHONE,1,3) != '010';

-- 5.
select
    EMP_NAME,
    date_format(HIRE_DATE, '%Y년%m월')
from
    employee;

-- 6.
select
    EMP_NAME,
    insert(EMP_NO, 9,6,repeat('*',6))
from employee;

-- 7.
select
    EMP_NAME,
    SAL_LEVEL,
    concat('￦',format(SALARY*12*(ifnull(BONUS,0)+1), 0))
from
    employee;

-- 8.
select
    EMP_ID,
    EMP_NAME,
    DEPT_CODE,
    HIRE_DATE
from
    employee
where
    (DEPT_CODE='D5' or DEPT_CODE='D9') and (datediff(HIRE_DATE, makedate(2004,1))>=0);

-- 9.
select
    EMP_NAME,
    HIRE_DATE,
    datediff(ifnull(QUIT_DATE,now()), HIRE_DATE)
from employee;

-- 10.
select
    EMP_NAME as "이름",
    DEPT_CODE as "부서번호",
    truncate(datediff(now(), concat(concat(if((substring(EMP_NO,8,1)=3 or substring(EMP_NO,8,1)=4),20,19),
                                  substring(EMP_NO,1,2)),'-',substring(EMP_NO,3,2),'-',substring(EMP_NO,5,2)))/365,0) as "만나이",
    (year(now()) - concat(if((substring(EMP_NO,8,1)=3 or substring(EMP_NO,8,1)=4),20,19), substring(EMP_NO,1,2)) )+ if(month(curdate())>=substring(EMP_NO,3,2) and day(curdate())>=substring(EMP_NO,5,2), 0,-1),
    date_format(concat(concat(if((substring(EMP_NO,8,1)=3 or substring(EMP_NO,8,1)=4),20,19),
        substring(EMP_NO,1,2)),'-',substring(EMP_NO,3,2),'-',substring(EMP_NO,5,2)), '%Y년 %m월 %d일')
from
    employee;

-- 11.
select
    year(HIRE_DATE) as 입사년도,
    count(*) as "인원"
from
    employee
where isnull(QUIT_DATE)
group by
    year(HIRE_DATE) with rollup
order by
    입사년도 is null,
    입사년도;

select
    count(case extract(year from HIRE_DATE) when 1998 then 1 end) '1998',
    count(case extract(year from HIRE_DATE) when 1999 then 1 end) '1999',
    count(case extract(year from HIRE_DATE) when 2000 then 1 end) '2000',
    count(case extract(year from HIRE_DATE) when 2001 then 1 end) '2001',
    count(case extract(year from HIRE_DATE) when 2002 then 1 end) '2002',
    count(case extract(year from HIRE_DATE) when 2003 then 1 end) '2003',
    count(case extract(year from HIRE_DATE) when 2004 then 1 end) '2004',
    count(*) '전체직원수'
from
    employee
where
    QUIT_YN='N';