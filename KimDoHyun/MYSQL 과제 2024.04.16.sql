--1번
select EMP_NAME,EMAIL,LENGTH(EMAIL) FROM EMPLOYEE;
--2번
select EMP_NAME,substring_INDEX(EMAIL,'@',1) FROM EMPLOYEE;
--3번
select EMP_NAME,LEFT(EMP_NO,4), IFNULL(BONUS,0)  FROM EMPLOYEE
WHERE EMP_NO LIKE '6%';
--4번
select count((CASE
WHEN PHONE NOT IN (SELECT PHONE FROM EMPLOYEE WHERE PHONE LIKE '010%') THEN 'Leaf'
END)) AS A
FROM EMPLOYEE;
--5번
 SELECT EMP_NAME, DATE_FORMAT(HIRE_DATE, '%Y년 %m월') FROM EMPLOYEE;
--6번
SELECT EMP_NAME
    ,concat(substr(EMP_NO, 1, 8), '*****')	AS concat

FROM EMPLOYEE;
--7
 SELECT EMP_NAME, Concat('\\','',SALARY) FROM EMPLOYEE;
--8번
SELECT EMP_ID,EMP_NAME,DEPT_CODE,HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'AND
HIRE_DATE LIKE '2004%' OR DEPT_CODE = 'D9' AND
HIRE_DATE LIKE '2004%';
--9번
SELECT EMP_NAME,IF(isnull(QUIT_DATE) , TIMESTAMPDIFF(DAY, HIRE_DATE, curdate()), TIMESTAMPDIFF(DAY, HIRE_DATE,QUIT_DATE) )
FROM EMPLOYEE

--10번
SELECT
    EMP_NAME,
    DEPT_CODE,
    DATE_FORMAT(
        CASE
            WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '2')
            THEN STR_TO_DATE(CONCAT('19', SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d')
            WHEN SUBSTRING(EMP_NO, 8, 1) IN ('3', '4')
            THEN STR_TO_DATE(CONCAT('20', SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d')
        END,
    '%Y년 %m월 %d일') AS FORMATTED_BIRTHDATE,

    TIMESTAMPDIFF(YEAR,
        CASE
            WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '2')
            THEN STR_TO_DATE(CONCAT('19', SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d')
            WHEN SUBSTRING(EMP_NO, 8, 1) IN ('3', '4')
            THEN STR_TO_DATE(CONCAT('20', SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d')
        END,
    CURDATE()) AS AGE
FROM
    EMPLOYEE


--11번
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

--12번
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
    ELSE NULL
  END AS DEPT_NAME
FROM
  EMPLOYEE
WHERE
  DEPT_CODE IN ('D5', 'D6', 'D9')
ORDER BY
  DEPT_CODE ASC;

