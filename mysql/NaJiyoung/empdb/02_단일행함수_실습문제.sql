-- 1. EMPLOYEE 테이블에서 남자만 사원번호, 사원명, 주민번호, 연봉을 나타내세요.
-- 단, 주민번호의 뒷6자리는 `*`처리하세요.
select EMP_ID 사원번호, EMP_NAME 사원명, insert(EMP_NO, 8, 7, '*******') 주민번호, format((SALARY + SALARY * ifnull(BONUS, 0))* 12, 0) 연봉
from employee
where EMP_NO like '%-1%' or EMP_NO like '%-3%';

-- 2. EMPLOYEE 테이블에서 사원명, 아이디(이메일 `@` 앞부분)을 조회하세요.
select EMP_NAME, substring_index(EMAIL, '@', 1) ID
from employee;

-- 테이블/데이터 설정
create table tbl_files (
                           file_no bigint,
                           file_path varchar(500)
);
drop table tbl_files;
insert into tbl_files values(1, 'c:\\abc\\deft\\salesinfo.xls');
insert into tbl_files values(2, 'c:\\music.mp3');
insert into tbl_files values(3, 'c:\\documents\\resume.hwp');
commit;
select * from tbl_files;

-- 3. 파일경로를 제외하고 파일명만 아래와 같이 출력하세요.
select file_no 파일번호, substring_index(file_path, '\\', -1) 파일명
from tbl_files;