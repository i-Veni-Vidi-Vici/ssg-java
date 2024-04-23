-- ================================
-- DDL
-- ================================
-- Data Definition Language 데이터 정의어
-- DB구조라 할수 있는 여러 DB객체에 대한 CRUD를 제공
-- create, alter, drop, truncate등의 명령어 제공한다.
-- DDL은 TCL을 사용하지 않고, 명령실행 즉시 db에 반영된다.

# DB객체
-- table, user, database(schema), view, index 등
-- Stored Program : stored_function, stored_procedure, event_scheduler 등

-- --------------------------------
-- CREATE
-- --------------------------------
-- 테이블 생성구문

# 테이블 선언
-- create table [if not exists] 테이블명 (...) 옵션...;
-- if not exists 존재하지 않을때만 create table을 수행하는 옵션

# 컬럼선언
-- 컬럼명 자료형 [NOT NULL] [DEFAULT 기본값] [AUTO_INCREMENT] [제약조건(컬럼레벨)] [COMMENT 컬럼코멘트]

# comment 작성

create table if not exists product1
(
    id         int comment '상품식별번호',
    name       varchar(10) comment '상품명',
    created_at datetime comment '등록일시'
) comment = '상품테이블1';

-- 코멘트 확인
-- information_schema DB객체에 대한 메타정보를 제공하는 스키마 (기본 제공)
-- 테이블 코멘트
select table_comment
from information_schema.tables -- 스키마.테이블
where table_schema = 'menudb'
  and table_name = 'product1';

-- 컬럼 코멘트
select column_name,
       column_comment
from information_schema.columns
where table_schema = 'menudb'
  and table_name = 'product1';

select *
from product1;











