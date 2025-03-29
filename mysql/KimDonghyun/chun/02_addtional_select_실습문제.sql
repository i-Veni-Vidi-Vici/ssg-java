-- # Additional SELECT - 함수

-- 1.
SELECT 
    STUDENT_NO AS 학번,
    STUDENT_NAME AS 이름,
    DATE_FORMAT(ENTRANCE_DATE, '%Y-%m-%d') AS 입학년도
FROM
    TB_STUDENT
WHERE  
    DEPARTMENT_NO = (SELECT DEPARTMENT_NO FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME = '영어영문학과') 
ORDER BY 
    ENTRANCE_DATE;

-- 2.
SELECT 
    PROFESSOR_NAME, 
    PROFESSOR_SSN
FROM   
    TB_PROFESSOR
WHERE 
    PROFESSOR_NAME NOT LIKE '___';
--  문자패턴조건을 언더바 ___3개가  아닌(not like) 이름들 가져왔으므로
--  이름이 한 자인 이름도 출력, 이름이 2 자인 이름도 출력(강혁), 이름이 4자인 이름도 출력(박강아름), 이름이 5자인 이름도 출력.....할수 있다.

-- 3.
-- 한국나이 구하기 : 현재년도 - 출생년도 + 1
-- 만나이 : 버림((오늘 - 생일) / 365)

-- 한국나이 구하기
SELECT
    PROFESSOR_NAME,
    YEAR(NOW()) - (IF(MID(PROFESSOR_SSN, 8, 1) = '1' OR MID(PROFESSOR_SSN, 8, 1) = '2', 1900, 2000) + LEFT(PROFESSOR_SSN, 2)) + 1 AS 한국나이
FROM
    TB_PROFESSOR;

-- to_days(date) : 1년1월1일부터 누적된 일수
SELECT TRUNCATE((TO_DAYS(NOW()) - TO_DAYS('19990909')) / 365, 0);

-- 만나이 구하기
SELECT 
    PROFESSOR_NAME AS 교수이름,
    TRUNCATE((TO_DAYS(NOW()) - TO_DAYS(CONCAT('19', LEFT(PROFESSOR_SSN, 6)))) / 365, 0) 나이
FROM   
    TB_PROFESSOR
WHERE  
    SUBSTR(PROFESSOR_SSN, 8, 1) = '1'
ORDER BY 
    2, 1;

-- 4.
-- 이름이 3글자인 교수도 있으므로, end index를 작성하지 않고, 문자열 끝까지 가져와야 한다.
SELECT
    SUBSTR(PROFESSOR_NAME, 2) AS 이름,
    MID(PROFESSOR_NAME, 2) AS 이름
FROM
    TB_PROFESSOR;

-- 5.
SELECT * FROM tb_student;
SELECT
    STUDENT_NO,
    STUDENT_NAME,
    YEAR(ENTRANCE_DATE)
        - (IF(MID(STUDENT_SSN, 8, 1) IN ('1', '2'), 1900, 2000) + LEFT(STUDENT_SSN, 2)) "입학당시 만나이"
FROM
    TB_STUDENT
WHERE
    -- 입학년도 - 출생년도(yymmdd -> yyyymmdd (주민번호 뒷 첫자리 유추))
    YEAR(ENTRANCE_DATE)
        - (IF(MID(STUDENT_SSN, 8, 1) IN ('1', '2'), 1900, 2000) + LEFT(STUDENT_SSN, 2))
            > 19
ORDER BY
    1;

-- 6.
SELECT 
    DATE_FORMAT('2020-12-25', '%y-%m-%d(%a)');

-- 7.
-- %y 2자리로 년도를 유추하면 1970년 ~ 2069년사이에서 유추한다.
SELECT STR_TO_DATE('99/10/11', '%y/%m/%d'); -- 1999-10-11
SELECT STR_TO_DATE('49/10/11', '%y/%m/%d'); -- 2049-10-11
SELECT STR_TO_DATE('70/10/11', '%y/%m/%d'); -- 1970-10-11
SELECT STR_TO_DATE('69/10/11', '%y/%m/%d'); -- 2069-10-11

-- 8.
SELECT
    ROUND(AVG(POINT), 1) AS 평점 
FROM
    TB_GRADE
WHERE
    STUDENT_NO = 'A517178';

-- 9.
SELECT 
    DEPARTMENT_NO AS 학과번호,
    COUNT(*) AS "학생수(명)"
FROM
    TB_STUDENT
GROUP BY 
    DEPARTMENT_NO
ORDER BY 
    1;

-- 학생이 없는 학과도 조회
SELECT 
    D.DEPARTMENT_NO AS 학과번호,
    COUNT(S.STUDENT_NO) AS "학생수(명)"
FROM   
    TB_STUDENT S RIGHT JOIN TB_DEPARTMENT D
        ON S.DEPARTMENT_NO = D.DEPARTMENT_NO
GROUP BY 
    D.DEPARTMENT_NO
ORDER BY 
    1;
    
-- 10.
SELECT 
    COUNT(*)
FROM
    TB_STUDENT
WHERE 
    COACH_PROFESSOR_NO IS NULL;



-- 11.
SELECT
    SUBSTR(TERM_NO, 1 ,4) AS 년도,
    ROUND(AVG(POINT), 1) AS "년도 별 평점" 
FROM  
    TB_GRADE
WHERE  
    STUDENT_NO = 'A112113'
GROUP BY 
    SUBSTR(TERM_NO, 1, 4);

-- 12.
SELECT 
    DEPARTMENT_NO AS 학과코드명,
    SUM(CASE  WHEN ABSENCE_YN = 'Y' THEN 1  ELSE 0 END) AS "휴학생 수"
FROM 
    TB_STUDENT
GROUP BY 
    DEPARTMENT_NO
ORDER BY
    1;

--  체육학과(063)포함
--  체육학과에는 배정된 학생이 없다.
SELECT 
    D.DEPARTMENT_NO AS 학과코드명,
    SUM(CASE  WHEN ABSENCE_YN = 'Y' THEN 1  ELSE 0 END) AS "휴학생 수"
FROM   
    TB_STUDENT S RIGHT JOIN TB_DEPARTMENT D
        ON S.DEPARTMENT_NO = D.DEPARTMENT_NO
GROUP BY 
    D.DEPARTMENT_NO;

-- 13.
SELECT 
    STUDENT_NAME AS 동일이름,
    COUNT(*)     AS "동명인 수"
FROM
    TB_STUDENT
GROUP BY 
    STUDENT_NAME
HAVING 
    COUNT(*) > 1;

-- 14.
SELECT
    SUBSTR(TERM_NO, 1, 4) 년도,
    SUBSTR(TERM_NO, 5, 2) 학기,
    ROUND(AVG(POINT), 1) 평점
FROM 
    TB_GRADE
WHERE  
    STUDENT_NO = 'A112113'
GROUP BY 
    SUBSTR(TERM_NO, 1, 4), -- 연도
    SUBSTR(TERM_NO, 5, 2)  -- 학기
    WITH ROLLUP
ORDER BY
    1 IS NULL ASC, 2 IS NULL ASC;

-- group by + with roll up-> select grouping
SELECT DISTINCT
#     SUBSTR(TERM_NO, 1, 4) 년도,
#     SUBSTR(TERM_NO, 5, 2) 학기,
    IF(GROUPING(SUBSTR(TERM_NO, 1, 4)) = 0, SUBSTR(TERM_NO, 1, 4), '전체') 년도,
    IF(GROUPING(SUBSTR(TERM_NO, 5, 2)) = 0, SUBSTR(TERM_NO, 5, 2), '소계') 학기,
    ROUND(AVG(POINT), 1) 평점
FROM
    TB_GRADE
WHERE
    STUDENT_NO = 'A112113'
GROUP BY
    SUBSTR(TERM_NO, 1, 4), -- 연도
    SUBSTR(TERM_NO, 5, 2),  -- 학기
    TERM_NO
WITH ROLLUP
ORDER BY
    1 IS NULL ASC, 2 IS NULL ASC;