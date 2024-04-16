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
    ) 생년월일
#    year(if(substring(EMP_NO, 8, 1) in (1, 2),
#                 concat('19', left(EMP_NO, 2), '년'),
#                 concat('20', left(EMP_NO, 2), '년'),
#              concat(substring(EMP_NO, 3, 2), '월')))
from employee;

select
    if(year(HIRE_DATE) = 1998, count(*))
from employee
group by year(HIRE_DATE);

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
