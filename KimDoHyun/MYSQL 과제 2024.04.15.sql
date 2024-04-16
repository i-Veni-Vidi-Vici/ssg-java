--1번
select EMP_NAME, EMP_NO, SALARY
from EMPLOYEE
where EMP_NO LIKE '%-1%' or EMP_NO LIKE '%-3%';
--2번
select EMP_NAME, SUBSTRING_INDEX(EMAIL, '@', 1);
--3번
SELECT SUBSTRING_INDEX(file_path, '\\', -1) AS FILE_NM
FROM tbl_files;
