select * from employee;
# 1
select '홍길동 hong@kh.or.kr 13';

# 2
select EMP_NAME as 사원명,
       substring_index(EMAIL,'@','1') as 아이디
from employee;

# 3
select
    EMP_NAME as 사원명,
    EMP_NO as 연도,
    ifnull(BONUS,'0')
from employee
where EMP_NO like '6%';

#4
SELECT
    concat(count(PHONE) , '명')
FROM employee
WHERE PHONE not like '%010%';

#5
select
    EMP_NAME 직원명,
    date_format(HIRE_DATE, '%Y년 %m월') 입사년월
from
    employee;

#6
select
    EMP_NAME as 사원명,
    concat(SUBSTRING(EMP_NO,1,8),'******') as 주민번호
from employee;

#7
select
    EMP_NAME,
    JOB_CODE,
    concat('￦',IFNULL(FORMAT((SALARY + (SALARY*BONUS)),0),SALARY))
from employee;

#8
SELECT
    EMP_ID,
    EMP_NAME,
    DEPT_CODE,
    HIRE_DATE
FROM employee
WHERE
    (DEPT_CODE = 'D5' OR 'D9')
    AND YEAR(HIRE_DATE) = 2004;

#9
SELECT
    EMP_NAME,
    HIRE_DATE,
    datediff(NOW(),HIRE_DATE)
FROM employee;
