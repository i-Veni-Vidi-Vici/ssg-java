show databases;

-- 1. EMPLOYEE 테이블에서 남자만 사원번호, 사원명, 주민번호, 연봉을 나타내세요.
-- 단, 주민번호의 뒷6자리는 *처리하세요.
select
    EMP_ID,
    EMP_NAME,
    insert(EMP_NO, 8, 7, '*******'),
    SALARY
from employee
where
    substring(EMP_NO, 8,1) = 1
   or
    substring(EMP_NO, 8,1) = 3;

-- 2. EMPLOYEE 테이블에서 사원명, 아이디(이메일 @ 앞부분)을 조회하세요.
select *
    from employee;
select
    EMP_NAME,
    SUBSTRING_INDEX(EMAIL, '@', 1) ID
from employee;

-- 3. 파일경로를 제외하고 파일명만 아래와 같이 출력하세요.
select
    tbl_files.file_no 파일번호,
    substring_index(tbl_files.file_path, '\\', -1) 파일명
from tbl_files