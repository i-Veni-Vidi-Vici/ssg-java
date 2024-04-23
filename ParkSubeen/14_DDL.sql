-- ===============================
-- DDL
-- ===============================
-- Data Definition Language 데이터 정의어
-- DB구조라 할 수 있는 여러 DB객체에 대한 CRUD를 제공
-- create, alter, drop, truncate등의 명령어 제공한다.
-- DDL은 TCL을 사용하지 않고, 명령실행 즉시 db에 반영된다.

# DB객체
-- table, user, database(schema), view, index 등
-- Stored Program : stored_function, stored_procedure, event_scheduler 등

-- ---------------------------------------
-- CREATE
-- ---------------------------------------
-- 테이블 생성구문

# 테이블 선언
-- create table [if not exists] 테이블명 (...) 옵션...;
-- if not exists 존재하지 않을때만 create table을 수행하는 옵션

# 컬럼선언
-- 컬럼명 자료형 [NOT NULL] [DEFAULT 기본값] [AUTO_INCREMENT] [제약조건(컬럼레벨)] [COMMENT 컬럼코멘트] -- 대괄호는 옵션을 의미함(써도 되고 안써도 됨)

create table if not exists product1 (
    id int comment '상품식별번호',
    name varchar(10) comment '상품명',
    created_at datetime comment '등록일시'
) comment = '상품테이블1'; -- 괄호 밖의 comment는 테이블에 대한 comment

-- 코멘트 확인
-- information_schema DB객체에 대한 메타정보를 제공하는 스키마 (기본 제공)
-- 테이블 코멘트
select
    table_comment
from
    information_schema.tables -- 스키마.테이블
where
    TABLE_SCHEMA = 'menudb'
    and TABLE_NAME = 'product1';

-- 컬럼 코멘트
select
    COLUMN_NAME,
    COLUMN_COMMENT
from
    information_schema.columns
where
    TABLE_SCHEMA = 'menudb'
    and TABLE_NAME = 'product1';

select * from product1;

# default
-- 컬럼값이 주어지지 않았을 경우 대입되는 기본값
-- date타입 : 기본값 current_date
-- time타입 : 기본값 current_time
-- datetime타입 : 기본값 current_timestamp, now() 사용
-- 날짜/시간 관련 default는 괄호를 꼭 감싸준다.
create table tbl_rent (
    rent_id int auto_increment primary key,
    contractor_name varchar(50) default '익명',
    car_name varchar(50),
    rent_date date default (current_date),
    rent_time time default (current_time),
    created_at datetime default (current_timestamp)
);
desc tbl_rent;

insert into
    tbl_rent(car_name)
values (
        '그랜져'
);

insert into
    tbl_rent
values(
    null, '홍길동', '소나타', default, default, default
);

select * from tbl_rent;

# auto_increment
-- primary key가 지정된 정수형컬럼에서 사용할 수 있다. ([42000][1075] Incorrect table definition; there can be only one auto column and it must be defined as a key)
-- 중복되지 않는 숫자를 발급.
-- 특정숫자값을 직접 지정가능하다. 해당 숫자는 auto_increment는 건너뛰게 된다.
-- truncate table을 통해서 reset할 수 있다.
create table if not exists product2 (
#     id int auto_increment comment '상품식별번호', -- [42000][1075] Incorrect table definition; there can be only one auto column and it must be defined as a key
    id int auto_increment primary key comment '상품식별번호',
    name varchar(10) not null comment '상품명',
    created_at datetime default (current_timestamp) comment '등록일시'
) comment = '상품테이블2';
desc product2;

insert into
    product2(name)
values (
        '일양전구'
       );

select * from product2;
delete from product2 where id = 3; -- 3번을 삭제하면, 다시는 3번을 발행하지 않는다.

-- 마지막 발급된 번호 가져오기
select
    last_insert_id(); -- 4

-- --------------------------------------
-- ALTER
-- --------------------------------------
-- 테이블객체를 수정하는 DDL문
-- 컬럼을 추가/수정/삭제/이름변경 할 수 있다.
-- 제약조건을 추가/삭제 할 수 있다.

# 서브 명령어 구분
-- add : 컬럼/제약조건 추가
-- drop : 컬럼/제약조건 삭제
-- modify : 컬럼 자료형/not null/auto_increment/순서 변경
-- change : 컬럼명 변경
-- rename : 테이블명 변경

create table product3 (
    id int,
    name varchar(10),
    created_at datetime
);
desc product3;

-- 컬럼 추가
alter table product3
add price int default 1000 not null comment '가격' after name; -- 자료형 기본값 not null comment 순서(first | after 컬럼명)

-- 컬럼 삭제
alter table product3
drop price;

-- 컬럼명 변경 (자료형 필수)
alter table product3
change name prod_name varchar(10);

-- 컬럼 자료형/기본값/NOT NULL/순서 변경
-- NULL 작성시 NOT NULL -> NULLABLE 변경가능하다.
alter table product3
modify prod_name varchar(100) default '상품명 없음' not null after price;

-- 제약조건 추가
alter table product3
add primary key (id);

-- auto_increment추가는 modify 사용
alter table product3
modify id int auto_increment;

-- 제약조건 제거
-- [42000][1075] Incorrect table definition; there can be only one auto column and it must be defined as a key
-- auto_increment가 적용되어있을 때, PK는 제거할 수 없다.
alter table product3
drop primary key;

alter table product3
modify id int; -- auto increment 제거

-- alter문은 여러개 서브명령어를 동시에 사용가능
alter table product3
add point tinyint not null,
add expires_at date not null;

desc product3;

-- 테이블명 변경
alter table product3
rename product333;

desc product333;

-- -------------------------------------
-- DROP
-- -------------------------------------
-- db객체를 삭제하기 위한 DDL
-- DDL 특성상 rollback 불가하므로, 주의해서 실행해야 한다.
-- if exists 옵션을 통해 객체가 존재할때만 삭제할 수 있다.

create table if not exists product4 (
    id int,
    name varchar(10),
    created_at datetime
);

drop table if exists product4;

-- -----------------------------------
-- TRUNCATE
-- -----------------------------------
-- 테이블의 모든 행을 잘라내는 DDL
-- where 없는 delete(DML)대비 속도 빠르다. (DML의 before image작업이 없기 때문)
-- auto_increment컬럼도 초기화된다.
create table product5(
    id int auto_increment primary key key,
    name varchar(100) not null,
    created_at datetime default (current_timestamp)
);

insert into
    product5 (name)
values
    ('한증막투어'), ('아쿠아리움투어'), ('맛집투어');

select * from product5;

truncate table product5;

