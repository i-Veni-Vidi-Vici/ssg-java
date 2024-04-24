-- ============================
-- DCL
-- ============================
-- Data Control Language 데이터제어어
-- DB에 대한 보안, 권한부여/회수 등 기능 지원
-- grant(권한부여)/ revoke 권한회수

-- root(관리자)로 실행
create user 'qwerty'@'%' identified by 'qwerty';

select * from mysql.user;

-- qwerty사용자에게 tbl_menu 읽기 권한 부여
-- 실행가능한 명령어가 바로 권한
grant select on menudb.tbl_menu to 'qwerty'@'%';
show grants for 'qwerty'@'%';

-- 권한 회수
revoke select on menudb.tbl_menu from 'qwerty'@'%';


