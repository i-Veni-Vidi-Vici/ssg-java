use empdb;

select
    EMP_NAME 직원명,
    EMAIL 이메일,
    length(EMAIL) '이메일 길이'
from
    employee;

select
    EMP_NAME 직원명,
    substring_index(EMAIL, '@', 1) 아이디
from employee;

select
    EMP_NAME 직원명,
    concat(19, left(EMP_NO, 2)) 년생,
    ifnull(BONUS, 0) 보너스
from employee
where left(EMP_NO, 1) = 6;

select
    concat(count(*), '명')
from employee
where PHONE not like '010%';

select
    EMP_NAME 직원명,
    concat(year(HIRE_DATE),'년',month(HIRE_DATE),'월') 입사년월
from employee;

select
    EMP_NAME 직원명,
    insert(EMP_NO, 9, 6, '******') 주민번호
from employee;

select
    EMP_NAME 직원명,
    JOB_CODE 직급코드,
    concat('￦', format((SALARY + (SALARY * ifnull(BONUS, 0))) * 12 , 0)) '연봉(원)'
from employee;

select
    EMP_ID,
    EMP_NAME,
    DEPT_CODE,
    HIRE_DATE
from employee
where DEPT_CODE in ('D5', 'D9') && year(HIRE_DATE) = 2004;

select
    EMP_NAME,
    HIRE_DATE,
    datediff(if(QUIT_YN = 'Y', QUIT_DATE, now()), HIRE_DATE)
from employee;

select
    EMP_NAME 직원명,
    DEPT_CODE 부서코드,
    concat(if(substring(EMP_NO, 8, 1) in (1, 2),
              concat('19', left(EMP_NO, 2), '년'),
              concat('20', left(EMP_NO, 2), '년')),
           concat(substring(EMP_NO, 3, 2), '월'),
           concat(substring(EMP_NO, 5, 2), '일')
    ) 생년월일,
    truncate(
            datediff(now(),
                     concat(
                             case substr(EMP_NO, 8, 1)
                                 when '1' then 1900
                                 when '2' then 1900
                                 else 2000
                                 end + substr(EMP_NO, 1, 2),
                             substr(EMP_NO, 3, 2),
                             substr(EMP_NO, 5, 2)
                     )
            ) / 365
    , 0) 만나이
from employee;

#select
#    count(if(year(HIRE_DATE) = 1998, 1, 0)) 1998년,
#    count(if(year(HIRE_DATE) = 1999, 1, 0)) 1999년,
#    count(if(year(HIRE_DATE) = 2000, 1, 0)) 2000년
#from employee
#where QUIT_YN = 'N';

select
    count(case year(HIRE_DATE) when 1998 then 1 end) 1998년,
    count(case year(HIRE_DATE) when 1999 then 1 end) 1999년,
    count(case year(HIRE_DATE) when 2000 then 1 end) 2000년,
    count(case year(HIRE_DATE) when 2001 then 1 end) 2001년,
    count(case year(HIRE_DATE) when 2002 then 1 end) 2002년,
    count(case year(HIRE_DATE) when 2003 then 1 end) 2003년,
    count(case year(HIRE_DATE) when 2004 then 1 end) 2004년,
    count(*)
from employee
where QUIT_YN = 'N';

select *
from employee;

select
    DEPT_CODE,
    case DEPT_CODE
        when 'D5' then '총무부'
        when 'D6' then '기획부'
        else '영업부'
    end 부서
from employee
group by DEPT_CODE
having DEPT_CODE in ('D5', 'D6', 'D9');