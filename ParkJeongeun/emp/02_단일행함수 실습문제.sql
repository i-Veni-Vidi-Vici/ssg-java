select
    EMP_ID,
    EMP_NAME,
    insert(EMP_NO, 8, 7,'*******'),
    SALARY
from employee
where substring(EMP_NO, 8, 1) = 1 ;

select
    EMP_NAME,
    substring_index(EMAIL, '@', 1)
from employee;

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
    substring_index(file_path, '\\', -1) 파일명
from
    tbl_files;