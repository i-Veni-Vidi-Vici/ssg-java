-- 1. root계정 chundb생성
CREATE DATABASE chundb;
-- 2. sh계정이 chundb 접근 가능하도록 권한 부여
GRANT ALL PRIVILEGES ON chundb.* TO 'sh'@'%';
-- 3. sh계정으로 스키마 chundb선택후 chundb.sql 전체실행
-- 4. 쿼리를 통해 table구조 파악
use chundb;
select * from TB_DEPARTMENT; --  학과테이블
select * from TB_STUDENT; -- 학생테이블
select * from TB_PROFESSOR; -- 교수테이블
select * from TB_CLASS; -- 수업테이블
select * from TB_CLASS_PROFESSOR; -- 수업교수테이블
select * from TB_GRADE; -- 학점테이블


--  1번
SELECT
    DEPARTMENT_NAME AS "학과 명",
    CATEGORY AS 계열
FROM
    TB_DEPARTMENT;

--  2번
SELECT
    concat(DEPARTMENT_NAME, '의 정원은 ', CAPACITY, '명 입니다.') AS "학과별 정원"
FROM
    TB_DEPARTMENT;

--  3번
--  국어국문학과 학과코드 구하기 --001
SELECT
    DEPARTMENT_NO
FROM
    TB_DEPARTMENT
WHERE
    DEPARTMENT_NAME = '국어국문학과';

-- 국어국문학과, 휴학생, 여학생(주민번호에서 확인)
SELECT
    STUDENT_NAME
FROM
    TB_STUDENT
WHERE
    DEPARTMENT_NO='001'
  AND
    ABSENCE_YN      ='Y'
  AND
    SUBSTR(STUDENT_SSN, 8, 1) in (2, 4);
-- AND    STUDENT_SSN  LIKE '______-2%';


-- 4번
SELECT
    STUDENT_NAME
FROM
    TB_STUDENT
WHERE
    STUDENT_NO IN ('A513079','A513090','A513091','A513110','A513119');


-- 5번
SELECT
    DEPARTMENT_NAME,
    CATEGORY
FROM
    TB_DEPARTMENT
WHERE
    CAPACITY > 20 AND CAPACITY < 30;
-- WHERE  CAPACITY BETWEEN 20 AND 30;

-- 6번
SELECT
    PROFESSOR_NAME
FROM
    TB_PROFESSOR
WHERE
    DEPARTMENT_NO IS NULL;


-- 7번
-- 검색되는 학생 없음.
SELECT
    *
FROM
    TB_STUDENT
WHERE
    DEPARTMENT_NO IS NULL;

SELECT
    STUDENT_NAME
FROM
    TB_STUDENT
WHERE
    IFNULL(DEPARTMENT_NO, 0) = 0;



-- 8번
SELECT
    CLASS_NO
FROM
    TB_CLASS
WHERE
    PREATTENDING_CLASS_NO IS NOT NULL;

SELECT
    CLASS_NO
FROM
    TB_CLASS
WHERE
    IFNULL(PREATTENDING_CLASS_NO, '0')  != '0'; -- 0이 아닌 '0'으로 문자 자료형으로 매칭해야 한다.

-- 9번
SELECT
    DISTINCT CATEGORY
FROM
    TB_DEPARTMENT;

-- 10번
SELECT
    STUDENT_NO,
    STUDENT_NAME,
    STUDENT_SSN
FROM
    TB_STUDENT
WHERE
    YEAR(ENTRANCE_DATE) = 2019
  AND
    ABSENCE_YN = 'N'
  AND
    STUDENT_ADDRESS LIKE '%전주%'
ORDER BY
    STUDENT_NAME;

