select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

-- 1. EMPLOYEE 테이블에서 남자만 사원번호, 사원명, 주민번호, 연봉을 나타내세요.
-- 단, 주민번호의 뒷6자리는 *처리하세요.
select
    EMP_ID,
    EMP_NAME,
    insert(EMP_NO, 9, 6, '******') EMP_NO,
    SALARY
from employee
where EMP_NO like '%-1%' or EMP_NO like '%-3%';

-- 2. EMPLOYEE 테이블에서 사원명, 아이디(이메일 @ 앞부분)을 조회하세요.
select
    EMP_NAME,
    left(EMAIL, instr(EMAIL, '@') - 1)

from employee;

-- 3. 파일경로를 제외하고 파일명만 아래와 같이 출력하세요.
-- 테이블/데이터 설정
create table tbl_files (
    file_no bigint,
    file_path varchar(500)
);
-- drop table tbl_files
insert into tbl_files values(1, 'c:\\abc\\deft\\salesinfo.xls');
insert into tbl_files values(2, 'c:\\music.mp3');
insert into tbl_files values(3, 'c:\\documents\\resume.hwp');
commit;
select * from tbl_files;

select
    file_no 파일번호,
    substring_index(file_path, '\\', -1)  파일명
from tbl_files;