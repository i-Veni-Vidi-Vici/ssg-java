-- =====================================
-- INFORMATION_SCHEMA
-- =====================================
-- DB객체에 대한 메타데이터를 제공한다.
-- 데이터사전 또는 시스템 카탈로그라고도 한다.
-- 특정사용자가 접근 가능한 테이블들에 대해 자동으로 접근권한을 부여한다.
-- 모든 테이블은 읽기전용으로 사용할 수 있다. (실제 DB객체의 정보가 바뀌면 자동으로 반영된다.)

-- 스키마 관련
select *
from information_schema.schemata;

-- 테이블
select *
from information_schema.tables;

-- 컬럼
select *
from information_schema.COLUMNS;

-- 파일 (root)
select *
from information_schema.files;

-- 접속현황 (root)
select *
from information_schema.PROCESSLIST;

-- 사용자 권한 (root)
select *
from information_schema.USER_PRIVILEGES
where GRANTEE like "'sh'@'%'";

select *
from information_schema.SCHEMA_PRIVILEGES
where GRANTEE like "'sh'@'%'"