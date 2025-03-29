-- # Additional SELECT - Option

-- 1. 학생이름과 주소지를 표시하시오.
-- 단, 출력 헤더는 "학생 이름", "주소지"로 하고, 정렬은 이름으로 오름차순 표시하도록 한다.

SELECT
    STUDENT_NAME AS "학생 이름",
    STUDENT_ADDRESS AS "주소지"
FROM
    TB_STUDENT
ORDER BY
    1;

-- 2. 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오.

SELECT
    STUDENT_NAME,
    STUDENT_SSN
FROM
    TB_STUDENT
WHERE
    ABSENCE_YN = 'Y'
ORDER BY
    IF(MID(STUDENT_SSN, 8, 1) IN ('1', '2'), 1900, 2000) + LEFT(STUDENT_SSN, 2) DESC,
    STUDENT_SSN DESC;

-- 3. 주소지가 강원도나 경기도인 학생들 중 
-- 2020년대 학번을 가진 학생들의 이름과 학번, 주소를 이름의 오름차순으로 화면에 출력하시오.
-- 단, 출력헤더에는 "학생이름","학번", "거주지 주소" 가 출력되도록 한다.

SELECT
    STUDENT_NAME AS "학생이름",
    STUDENT_NO AS "학번",
    STUDENT_ADDRESS AS "거주지 주소"
FROM
    TB_STUDENT
WHERE (
    STUDENT_ADDRESS LIKE '%강원%'
    OR STUDENT_ADDRESS LIKE '%경기%' )
    AND YEAR(ENTRANCE_DATE) >= 2020
ORDER BY
    1 ;

-- 4. 현재 법학과 교수 중 가장 나이가 많은 사람부터 이름을 확인할 수 있는 SQL 문장을 작성하시오.
-- (법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아 내도록 하자)
SELECT
    DEPARTMENT_NO
FROM
    TB_DEPARTMENT
WHERE
    DEPARTMENT_NAME = '법학과';

SELECT
    PROFESSOR_NAME,
    PROFESSOR_SSN
FROM
    TB_PROFESSOR
WHERE
    DEPARTMENT_NO = '005'
ORDER BY
    2;

-- 조인사용시
-- 학과가 정해지지 않은 교수도 있지만, 위의 경우에는 해당되지 않기때문에 inner join으로도 가능함.
SELECT * FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

SELECT
    PROFESSOR_NAME,
    PROFESSOR_SSN
FROM
    TB_PROFESSOR JOIN TB_DEPARTMENT
        USING (DEPARTMENT_NO)
WHERE
    DEPARTMENT_NAME = '법학과'
ORDER BY
    2;



-- 5. 2022년 2 학기에 'C3118100' 과목을 수강한 학생들의 학점을 조회하려고 한다.
--  학점이 높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을 작성해보시오.
SELECT
    STUDENT_NO, POINT
FROM
    TB_GRADE
WHERE
    TERM_NO = '202202'
    AND CLASS_NO = 'C3118100'
ORDER BY
    2 DESC, 1;


-- 6. 학생 번호, 학생 이름, 학과 이름을 이름 가나다 순서로 정렬하여 출력하는 SQL 문을 작성하시오.
SELECT
    STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
FROM
    TB_STUDENT JOIN TB_DEPARTMENT
        USING (DEPARTMENT_NO)
ORDER BY
    2;


-- 7. 춘 기술대학교의 과목이름과 과목의 학과 이름을 출력하는 SQL 문장을 작성하시오.
SELECT
    CLASS_NAME, DEPARTMENT_NAME
FROM
    TB_CLASS JOIN TB_DEPARTMENT
        USING(DEPARTMENT_NO)
ORDER BY
    2, 1;


-- 8. 과목별 교수 이름을 찾으려고 한다. 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오.

--  1과목을 n명의 교수가 가르칠 수 있는지, 1명의 교수는  n개의 과목을 가르칠 수 있는지 여부를 확인해 본다.
SELECT CLASS_NO, COUNT(*) FROM TB_CLASS_PROFESSOR GROUP BY CLASS_NO;
SELECT PROFESSOR_NO, COUNT(*) FROM TB_CLASS_PROFESSOR GROUP BY PROFESSOR_NO;

SELECT
    CLASS_NAME, PROFESSOR_NAME
FROM
    TB_CLASS_PROFESSOR
        JOIN TB_CLASS USING (CLASS_NO)
        JOIN TB_PROFESSOR USING (PROFESSOR_NO)
ORDER BY
    1;


-- 9. 8 번의 결과 중 ‘인문사회’계열에 속한 과목의 교수 이름을 찾으려고한다. 
-- 이에 해당하는 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오.
-- category(인문사회계열)은 tb_deparment의 컬럼.
SELECT
    CLASS_NAME, PROFESSOR_NAME
FROM
    TB_CLASS_PROFESSOR CP
        JOIN TB_CLASS C ON (C.CLASS_NO = CP.CLASS_NO)
        JOIN TB_PROFESSOR P ON (P.PROFESSOR_NO = CP.PROFESSOR_NO)
        JOIN TB_DEPARTMENT D ON (D.DEPARTMENT_NO = P.DEPARTMENT_NO)
WHERE
    D.CATEGORY = '인문사회';


-- 10. ‘음악학과’학생들의 평점을 구하려고 한다. 
-- 음악학과 학생들의 "학번", "학생 이름", "전체 평점"을 출력하는 SQL 문장을 작성하시오. 
-- (단, 평점은 소수점 1 자리까지만반올림하여 표시한다.)
SELECT
    STUDENT_NO  AS "학번",
    STUDENT_NAME AS "학생 이름",
    ROUND(AVG(POINT), 1) AS "전체 평점"
FROM
    TB_STUDENT
        JOIN TB_GRADE USING (STUDENT_NO)
        JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE
    DEPARTMENT_NAME = '음악학과'
GROUP BY
    STUDENT_NO, STUDENT_NAME
ORDER BY
    3 DESC, 1;


-- 11. 학번이 A313047 인 학생이 학교에 나오고 있지 않다. 
--  지도 교수에게 내용을 전달하기 위해핚학과 이름, 학생 이름과 지도 교수 이름이 필요하다. 
--  이때 사용할 SQL 문을 작성하시오. 단, 출력헤더는 학과이름, 학생이름, 지도교수이름으로 출력되도록 한다.
SELECT
    DEPARTMENT_NAME 학과이름,
    STUDENT_NAME 학생이름,
    PROFESSOR_NAME 지도교수이름
FROM
    TB_STUDENT S
        JOIN TB_DEPARTMENT D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)
        JOIN TB_PROFESSOR P ON (S.COACH_PROFESSOR_NO = P.PROFESSOR_NO)
WHERE
    STUDENT_NO = 'A313047';


-- 12. 2022년도에 '인간관계론' 과목을 수강한 학생을 찾아 학생이름과 수강학기를 표시하는 SQL 문장을 작성하시오
SELECT
    STUDENT_NAME, TERM_NO
FROM
    TB_STUDENT S
        JOIN TB_GRADE G ON (S.STUDENT_NO = G.STUDENT_NO)
        JOIN TB_CLASS C ON (G.CLASS_NO = C.CLASS_NO)
WHERE
    TERM_NO LIKE '2022%'
    AND C.CLASS_NAME = '인간관계론';


-- 13. 예체능 계열 과목 중 과목 담당교수를 한명도 배정받지 못한 과목을 찾아
-- 그 과목 이름과 학과 이름을 출력하는 SQL 문장을 작성하시오.
SELECT
    C.CLASS_NAME,
    D.DEPARTMENT_NAME
FROM
    TB_CLASS C
    LEFT JOIN TB_DEPARTMENT D ON C.DEPARTMENT_NO = D.DEPARTMENT_NO
    LEFT JOIN TB_CLASS_PROFESSOR CP ON C.CLASS_NO = CP.CLASS_NO
WHERE
    D.CATEGORY = '예체능' AND CP.CLASS_NO IS NULL
ORDER BY
    C.CLASS_NAME;

--  상관서브쿼리 not exists
--  행이 존재하면 false. tb_class.class_no가 tb_class_professor.class_no로 사용되지 않은 경우.
SELECT
    C.CLASS_NAME,
    D.DEPARTMENT_NAME
FROM
    TB_CLASS C
        LEFT JOIN TB_DEPARTMENT D ON C.DEPARTMENT_NO = D.DEPARTMENT_NO
WHERE
    NOT EXISTS (SELECT 1 FROM TB_CLASS_PROFESSOR WHERE CLASS_NO = C.CLASS_NO)
    AND
    D.CATEGORY = '예체능';



-- 14. 춘 기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 한다. 
--  학생이름과 지도교수 이름을 찾고 만일 지도 교수가 없는 학생일 경우 
--  "지도교수 미지정으로 표시하도록 하는 SQL 문을 작성하시오. 
--  단, 출력헤더는 학생이름, 지도교수로 표시하며 고학번 학생이 먼저 표시되도록 한다
SELECT
    STUDENT_NAME 학생이름, IFNULL(P.PROFESSOR_NAME,'지도교수 미지정') 지도교수
FROM
    TB_STUDENT S
        LEFT JOIN TB_PROFESSOR P ON (S.COACH_PROFESSOR_NO = P.PROFESSOR_NO)
        JOIN TB_DEPARTMENT D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE
    DEPARTMENT_NAME = '서반아어학과'
ORDER BY
    S.ENTRANCE_DATE;


-- 15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과 이름, 평점을 출력하는 SQL 문을 작성하시오.
SELECT * FROM TB_STUDENT WHERE ABSENCE_YN = 'N';
SELECT STUDENT_NO, TRUNCATE(AVG(POINT), 1) FROM TB_GRADE GROUP BY STUDENT_NO HAVING AVG(POINT) >= 4.0;

SELECT
    S.STUDENT_NO 학번, S.STUDENT_NAME 이름, D.DEPARTMENT_NAME "학과 이름",
    TRUNCATE(AVG(G.POINT),1) 평점
FROM 
    TB_STUDENT S
        LEFT JOIN TB_DEPARTMENT D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO) 
        JOIN TB_GRADE G ON (S.STUDENT_NO = G.STUDENT_NO)
WHERE 
    S.ABSENCE_YN = 'N'
GROUP BY 
    S.STUDENT_NO, S.STUDENT_NAME, D.DEPARTMENT_NAME
HAVING
    AVG(G.POINT) >= 4.0
ORDER BY
    S.STUDENT_NO;

--  subquery사용
SELECT
    STUDENT_NO 학번,
    STUDENT_NAME 이름,
    (SELECT DEPARTMENT_NAME FROM TB_DEPARTMENT WHERE T.DEPARTMENT_NO = DEPARTMENT_NO) "학과 이름",
    TRUNCATE(AVG_POINT, 1) 평점
FROM (
    SELECT
        S.*,
        (SELECT AVG(POINT) FROM TB_GRADE WHERE S.STUDENT_NO = STUDENT_NO) AVG_POINT
    FROM TB_STUDENT S
) T
WHERE
    ABSENCE_YN = 'N'
  AND
    AVG_POINT >= 4.0
ORDER BY
    STUDENT_NO;



-- 16. 환경조경학과 전공과목들의 과목별 평점을 파악할수 있는 SQL 문을 작성하시오.
--  class_no, class_name, avg(point)

SELECT
    CLASS_NO,
    CLASS_NAME,
    TRUNCATE(AVG(POINT), 8) AS "AVG(POINT)"
FROM
    TB_DEPARTMENT
        JOIN TB_CLASS USING (DEPARTMENT_NO)
        JOIN TB_GRADE USING (CLASS_NO)
WHERE
    DEPARTMENT_NAME = '환경조경학과'
    AND CLASS_TYPE LIKE '%전공%'
GROUP BY
    CLASS_NO, CLASS_NAME
ORDER BY
    1;


-- 17. 춘 기술대학교에 다니고 있는 최경희 학생과 같은 과 학생들의 이름과 주소를 출력하는 SQL 문을 작성하시오.
SELECT
    STUDENT_NAME,
    STUDENT_ADDRESS
FROM
    TB_STUDENT
WHERE
    DEPARTMENT_NO IN (SELECT DEPARTMENT_NO FROM TB_STUDENT WHERE STUDENT_NAME = '최경희')
ORDER BY
    1;

-- 18. 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 표시하는 SQL문을 작성하시오.
-- having 조건절에 all 사용(최대값보다 같거나 큰)
SELECT
    STUDENT_NO, STUDENT_NAME
FROM
    TB_CLASS C
        JOIN TB_GRADE G USING (CLASS_NO)
        JOIN TB_STUDENT S USING (STUDENT_NO)
WHERE
    C.DEPARTMENT_NO = (SELECT DEPARTMENT_NO FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME = '국어국문학과')
GROUP BY 
    STUDENT_NO, STUDENT_NAME
HAVING 
    AVG(POINT) >= ALL(
        SELECT AVG(POINT)
        FROM TB_CLASS C2
         JOIN TB_GRADE G2 USING (CLASS_NO)
         JOIN TB_STUDENT S2 USING (STUDENT_NO)
        WHERE C2.DEPARTMENT_NO = (SELECT DEPARTMENT_NO FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME = '국어국문학과')
        GROUP BY STUDENT_NO, STUDENT_NAME
    );

-- with사용
WITH V_STDT_GRADE 
AS (
    SELECT
        STUDENT_NO,
        (SELECT AVG(POINT) FROM TB_GRADE WHERE STUDENT_NO = S.STUDENT_NO) AVG
    FROM
        TB_STUDENT S)
SELECT
    STUDENT_NO, STUDENT_NAME
FROM(
    SELECT 
        STUDENT_NO, STUDENT_NAME, AVG
    FROM 
        TB_STUDENT S
            JOIN TB_DEPARTMENT D ON S.DEPARTMENT_NO = D.DEPARTMENT_NO                    
            JOIN V_STDT_GRADE USING(STUDENT_NO)
    WHERE 
        D.DEPARTMENT_NAME = '국어국문학과'
    ORDER BY 
        AVG DESC) K
LIMIT 1;


-- 19. 춘 기술대학교의 "환경조경학과"가 속한 같은 계열 학과들의 학과별 전공과목 평점을 파악하기 위해 적절한 SQL 문을 찾아내시오.
-- 단, 출력헤더는 "계열 학과명", "전공평점"으로 표시되도록 하고, 평점은 소수점 한자리까지만 반올림하여 표시되도록 한다.
        
SELECT
    DEPARTMENT_NAME AS "계열 학과명",
    ROUND(AVG(POINT), 1) AS "전공평점"
FROM
    TB_DEPARTMENT
        JOIN TB_CLASS C USING (DEPARTMENT_NO)
        JOIN TB_GRADE USING (CLASS_NO)
WHERE
    CATEGORY = (SELECT CATEGORY FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME = '환경조경학과')
    AND CLASS_TYPE LIKE '%전공%'
GROUP BY
    DEPARTMENT_NAME
ORDER BY 1;



--  단계별로 쿼리만들기
-- 19.1 환경조경학과 계열 구하기
SELECT CATEGORY
FROM TB_DEPARTMENT
WHERE DEPARTMENT_NAME = '환경조경학과';

-- 19.2 같은 계열 학과구하기
SELECT *
FROM TB_DEPARTMENT
WHERE CATEGORY = '자연과학';

-- 19.3 학과별 수업 및 전공과목 구하기
SELECT * FROM TB_DEPARTMENT D WHERE NOT EXISTS(SELECT 1 FROM TB_CLASS WHERE DEPARTMENT_NO = D.DEPARTMENT_NO);
SELECT * FROM TB_CLASS WHERE DEPARTMENT_NO IS NULL;

SELECT
    *
FROM
    TB_DEPARTMENT
        JOIN TB_CLASS USING (DEPARTMENT_NO)
WHERE
    CLASS_TYPE LIKE '전공%';

SELECT
    *
FROM
    TB_DEPARTMENT
        JOIN TB_CLASS USING(DEPARTMENT_NO)
WHERE
    CATEGORY = (SELECT CATEGORY FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME = '환경조경학과')
        AND CLASS_TYPE LIKE '%전공%';

-- 19.4 과목테이블 조인 및 과목별 점수구하기
SELECT
    *
FROM
    TB_DEPARTMENT
        JOIN TB_CLASS USING(DEPARTMENT_NO)
        JOIN TB_GRADE USING(CLASS_NO)
WHERE
    CATEGORY = (SELECT CATEGORY FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME = '환경조경학과')
    AND CLASS_TYPE LIKE '%전공%';

-- 19.5 학과별 전공과목 평점 구하기
SELECT
    DEPARTMENT_NAME 학과명, ROUND(AVG(POINT),1) 평점
FROM
    TB_DEPARTMENT
        JOIN TB_CLASS USING(DEPARTMENT_NO)
        JOIN TB_GRADE USING(CLASS_NO)
WHERE
    CATEGORY = (SELECT CATEGORY FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME = '환경조경학과')
    AND CLASS_TYPE LIKE '%전공%'
GROUP BY
    DEPARTMENT_NAME
ORDER BY
    2 DESC;

