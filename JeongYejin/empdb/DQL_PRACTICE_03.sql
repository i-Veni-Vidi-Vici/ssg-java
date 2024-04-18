use empdb;

-- 함수 실습문제 #113
select *
from employee;
# 1
select EMP_NAME, EMAIL, char_length(EMAIL)
from employee;
# 2
select EMP_NAME, substring_index(EMAIL, '@', 1) EMAIL_ID
from employee;
# 3
select EMP_NAME, substr(EMP_NO, 1, 2) BIRTH_YEAR, ifnull(BONUS, 0) BONUS
from employee
where substr(EMP_NO, 1, 1) = 6;
# 4
select concat(count(*), '명') '010이 아닌 사람 수'
from employee
where substr(PHONE, 1, 3) != 010;
# 5
select EMP_NAME,
       IF(substr(DATE_FORMAT(HIRE_DATE, '%Y년%m월'), 6, 1) = 0, CONCAT(YEAR(HIRE_DATE), '년 ', MONTH(HIRE_DATE), '월'), DATE_FORMAT(HIRE_DATE, '%Y년%m월'))
as HIRE_DATE_YM
from employee;
# 6
select EMP_NAME, rpad(substr(emp_no, 1, 8), 14, '*') 주민번호
from employee;
# 7
select EMP_NAME, JOB_CODE, concat('￦' , format((salary + (ifnull(bonus, 0) * salary)) * 12, 0)) '연봉(원)'
from employee;
# 8
select EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
from employee
where DEPT_CODE in ('D5', 'D9') and extract(year from HIRE_DATE) = 2004;
# where (DEPT_CODE = 'D5' or DEPT_CODE = 'D9') and year(HIRE_DATE) = 2004;
# 9
select EMP_NAME, HIRE_DATE, IF(QUIT_DATE is null, DATEDIFF(now(),HIRE_DATE), DATEDIFF(QUIT_DATE,HIRE_DATE)) AS WORK_DAYS
#     truncate(datediff(ifnull(quit_date, now()), hire_date), 0) as 근무일수
from employee;
# 10
-- select EMP_NAME, DEPT_CODE, date_format(substring_index(EMP_NO, '-', 1), '%Y년%m월%d일') BIRTHDAY, 2024 - year(substring_index(EMP_NO, '-', 1)) AGE
-- date(substr()) -> 'yymmdd' -> 'yyyymmdd' 1970~2069 년 중 유추함
select
    concat(
            case
                substr(emp_no, 8, 1)
                when '1' then 1900
                when '2' then 1900
                else 2000
                end + substr(emp_no, 1, 2), '년 ',
            substr(emp_no, 3, 2), '월 ',
            substr(emp_no, 5, 2), '일 ') 생년월일,
-- 한국나이 : 현재년도 - 출생년도 + 1
-- 만나이 : 생일기준  truncate(datediff(오늘, 생일) / 365) -- 윤년무시
    truncate(
            datediff( -- 살아온 날수
                    now(), -- 오늘
                    concat( -- 8자리 생년월일
                            case
                                substr(emp_no, 8, 1)
                                when '1' then 1900
                                when '2' then 1900
                                else 2000
                                end + substr(emp_no, 1, 2),
                            substr(emp_no, 3, 2),
                            substr(emp_no, 5, 2)
                    )
            ) / 365 -- 살아온 햇수
        , 0) 만나이,
-- (올해 - 생년) - if(생일이 지났는가?, 0, 1) -- 더 정확
    year(curdate()) - (if (substr(EMP_NO, 8, 1) in (1, 2), 1900, 2000) + substr(EMP_NO, 1, 2))
- if (month(curdate()) >= substr(EMP_NO, 3, 2) &&  day(curdate()) >= substr(EMP_NO, 5, 2), 0, 1) 만나이

from employee;
# 11
select year(HIRE_DATE) year, count(*)
from employee
group by year(HIRE_DATE) with rollup;

select
    emp_name,
    hire_date,
    case extract(year from hire_date) when 1998 then 1 end "1998",
    case extract(year from hire_date) when 1999 then 1 end "1999",
    case extract(year from hire_date) when 2000 then 1 end "2000",
    case extract(year from hire_date) when 2001 then 1 end "2001",
    case extract(year from hire_date) when 2002 then 1 end "2002",
    case extract(year from hire_date) when 2003 then 1 end "2003",
    case extract(year from hire_date) when 2004 then 1 end "2004"
from
    employee;

select
    count(case extract(year from hire_date) when 1998 then 1 end) "1998",
    count(case extract(year from hire_date) when 1999 then 1 end) "1999",
    count(case extract(year from hire_date) when 2000 then 1 end) "2000",
    count(case extract(year from hire_date) when 2001 then 1 end) "2001",
    count(case extract(year from hire_date) when 2002 then 1 end) "2002",
    count(case extract(year from hire_date) when 2003 then 1 end) "2003",
    count(case extract(year from hire_date) when 2004 then 1 end) "2004",
    count(*) 전체직원수
from
    employee
where
    quit_yn = 'N';

# 12
select EMP_ID, EMP_NAME, EMP_NO, email, PHONE,
    case
        when DEPT_CODE = 'D5' then '총무부'
        when DEPT_CODE = 'D6' then '기획부'
        when DEPT_CODE = 'D9' then '영업부'
    end DEPT_CODE,
    JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE, QUIT_DATE, QUIT_YN
from employee
where DEPT_CODE = 'D5' or DEPT_CODE = 'D6' or DEPT_CODE = 'D9'
order by DEPT_CODE asc;