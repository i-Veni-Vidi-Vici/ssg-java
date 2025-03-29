-- ================
-- DCL
-- ================
-- Data Control Language 데이터 제어어
-- DB에 대한 보안, 권한부여/회수 등의 기능 지원
-- grant(권한부여) / revoke(권한회수)
-- 사용자가 특정 db(schema), 특정 객체에 대한 사용권한 제어

-- root(관리자)로 실행
create user 'qwerty'@'%' identified by 'qwerty';
select * from mysql.user; -- 사용자 목록 확인

-- qwerty 사용자에게 tbl_menu 읽기 권한 부여
-- 권한 : 실행가능한 명령어
grant select on menudb.tbl_menu to 'qwerty'@'%';
show grants for 'qwerty'@'%';

-- 권한 회수
revoke select on menudb.tbl_menu from 'qwerty'@'%';