-- ==========================================
-- DDL
-- ==========================================
-- Data Definition Language 데이터 정의어
-- DB 구조라 할 수 있는 여러 DB객체에 대한 CRUD를 지원합니다
-- create, alter, drop, truncate등의 명령어를 제공합니다
-- DDL은 TCL을 사용하지 않고, 명령실행 즉시 db에 반영된다

# DB객체
-- table, user, database(schema), view, index 등
-- Stored Program : stored_function, stored_procedure, event_scheduler

-- ---------------------------------------
-- CREATE
-- ---------------------------------------
-- 테이블 생성구문

# 테이블 선언
-- create table [if not exists] 테이블명 (컬럼들....) 옵션...;
-- if not exists 존재하지 않을때만 create table을 수행하는 옵션

# 컬럼 선언
# []= 옵션이다, 써도 되고, 안썯 된다
-- 컬럼명 자료형 [NOT NULL] [DEFAULT 기본값] [AUTO_INCREMENT] [제약조건(컬럼레벨)][COMMENT]

create table if not exists product1(
    id int comment '상품식별번호',
    name varchar(10) comment '상품명',
    create_at datetime comment '등록일시'
) comment = '상품테이블1';


-- 코멘트 확인
select TABLE_COMMENT
from information_schema.TABLES
where TABLE_SCHEMA = 'menudb'
  and TABLE_NAME = 'product1';

select COLUMN_COMMENT
from information_schema.COLUMNS
where TABLE_SCHEMA = 'menudb'
  and TABLE_NAME = 'product1';

show tables;
desc product1;