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
    if(isnull(QUIT_DATE),timestampdiff(day,HIRE_DATE,curdate()),timestampdiff(day,HIRE_DATE,QUIT_DATE)) 근무일수
FROM employee;

#10
SELECT
    EMP_NAME 직원명,
    DEPT_CODE 부서코드,
    DATE_FORMAT(
            CASE
                WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '2')
                    THEN STR_TO_DATE(CONCAT('19', SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d')
                WHEN SUBSTRING(EMP_NO, 8, 1) IN ('3', '4')
                    THEN STR_TO_DATE(CONCAT('20', SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d')
                END,
            '%Y년 %m월 %d일') 생년월일,

    TIMESTAMPDIFF(YEAR,
                  CASE
                      WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '2')
                          THEN STR_TO_DATE(CONCAT('19', SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d')
                      WHEN SUBSTRING(EMP_NO, 8, 1) IN ('3', '4')
                          THEN STR_TO_DATE(CONCAT('20', SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d')
                      END,
                  CURDATE()) AS 나이
FROM
    EMPLOYEE;

#11
SELECT
    Concat(YEAR(HIRE_DATE),'년') AS Year,
    COUNT(EMP_ID) AS Total_Employees
FROM
    EMPLOYEE
WHERE
    QUIT_YN = 'N'
GROUP BY
    YEAR(HIRE_DATE)
ORDER BY
    Year;

#12
SELECT
    EMP_ID,
    EMP_NAME,
    EMP_NO,
    EMAIL,
    PHONE,
    DEPT_CODE,
    JOB_CODE,
    SAL_LEVEL,
    SALARY,
    BONUS,
    MANAGER_ID,
    HIRE_DATE,
    QUIT_DATE,
    QUIT_YN,
    CASE DEPT_CODE
        WHEN 'D5' THEN '총무부'
        WHEN 'D6' THEN '기획부'
        WHEN 'D9' THEN '영업부'
        END 부서명
FROM
    EMPLOYEE
WHERE
    DEPT_CODE IN ('D5', 'D6', 'D9')
order by
    DEPT_CODE asc;