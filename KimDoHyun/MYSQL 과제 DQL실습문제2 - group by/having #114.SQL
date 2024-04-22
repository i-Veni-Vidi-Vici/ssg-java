--1번
select count(EMP_ID) AS 사원수,avg(SALARY) FROM EMPLOYEE
group by JOB_CODE
HAVING JOB_CODE !='J1';
--2번
select count(EMP_ID) AS 사원수,DATE_FORMAT(HIRE_DATE, '%Y') FROM EMPLOYEE
WHERE JOB_CODE NOT IN('J1')
group by DATE_FORMAT(HIRE_DATE, '%Y')
order by DATE_FORMAT(HIRE_DATE, '%Y') ASC
--3번
SELECT
    CASE
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '3') THEN 'Male'
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('2', '4') THEN 'Female'
    END AS Gender,
    AVG(SALARY) AS Average_Salary
FROM
    EMPLOYEE
GROUP BY
    CASE
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '3') THEN 'Male'
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('2', '4') THEN 'Female'
    END;
--4번
SELECT JOB_CODE , count(EMP_ID)
FROM EMPLOYEE
group by JOB_CODE
HAVING count(EMP_ID) > 2