show databases;
use menudb;
-- 특정 database를 선택하고, 테이블작업이 가능하다.

-- 테이블 조회
# 메뉴
select *
from tbl_menu;

# 카테고리
select *
from tbl_category;

# 주문내역
select *
from tbl_order;

# 주문별 메뉴정보
select *
from tbl_order_menu;

# 결제
select *
from tbl_payment;

# 결제-주문 연동데이터
select *
from tbl_payment_order;

-- =================
-- TABLE 구조
-- =================
-- mysql의 table은 항상 특정 database(schema) 하위에 존재한다.
-- 특정 database에 접근권한이 있는 사용자만 table을 관리할 수 있다.

-- RDBMS에서 구분
-- 1. table (entity, relation) 실제 data가 보관되는 주체
-- 2. column 열 (field, attribute) table의 구조, 컬럼별로 자료형 가질수 있다.
-- 3. row 행 (record, tuple) 실제 data가 관리되는 단위
-- 4. domain 하나의 속성(열)에서 가질수 있는 값의 집합

-- ================================
-- DATA TYPES
-- ================================
-- 테이블의 속성(열)에 대해 부여된다.
desc tbl_menu;

-- 1. 문자형
-- 2. 숫자형 (정수/실수)
-- 3. 날짜/시간형

-- ------------------------
-- 문자형
-- ------------------------
-- 고정형 문자타입 CHAR : 지정된 크기보다 작은 데이터를 입력해도 지정한 크기로 보관되는 타입
-- 가변형 문자타입 VARCHAR : 지정된 크기보다 작은 데이터를 입력하면, 딱 그 크기만큼 보관되는 타입

-- 대소문자를 구분하지 않는 SQL 특성상 snake case방식으로 단어를 연결해 샤앙한다.
create table tbl_data_types_char
(
    a char(10),
    b varchar(10)
);

select *
from tbl_data_types_char;

desc tbl_data_types_char;

-- 데이터 추가(행단위로 처리된다)
insert into tbl_data_types_char
values ('korea', 'korea');

insert into tbl_data_types_char
values ('개구리', '개구리');

insert into tbl_data_types_char
values ('1234567890', '1234567890');

-- [22001][1406] Data truncation: Data too long for column 'a' at row 1
insert into tbl_data_types_char
values ('12345678901', '12345678901');


-- length() 한글은 3바이트로 처리되어 1글자당 3길이
-- char_length 실제 길이
select a,
       length(a),
       char_length(a),
       b,
       length(b),
       char_length(b)
from tbl_data_types_char;


-- ------------------------
-- 숫자형
-- ------------------------
-- int(integer) 정수타입
-- float, double 실수타입 (float - 유효자리수6개, double - 유효자리수 16개)
-- decimal 고정소수타입 (지정한 소수점이하로 정확한 데이터 관리가 필요할때)\
-- - decimal(전체자리수, 소수점이하자리수)

create table tbl_data_types_number
(
    a int,
    b float,
    c double,
    d decimal(30, 20)
);

insert into tbl_data_types_number
values (1234.5678, -- 반올림 1235
        1234.5678, -- 1234.57
        1234.5678, -- 1234.5678
        1234.5678); -- 1234.56780 00000 00000 00000

insert into tbl_data_types_number
values (1234.5678, -- 반올림 1235
        1234.567890123454690, -- 1234.57
        1234.567890123454690, -- 1234.5678901234546 반올림x
        1234.567890123454690); -- 1234.56780 00000 00000 00000

select *
from tbl_data_types_number;

-- ------------------------
-- 날짜시간형
-- ------------------------
-- DATE YYYY-MM-DD형식으로 관리
-- TIME HH:MM:SS.SSSSSS 형식으로 관리
-- DATETIME YYYY-MM-DD HH:MM:SS 형식으로 관리
-- TIMESTAMP YYYY-MM-DD HH:MM:SS 형식으로 관리
    -- 지역대정보를 제거하고 UTC로 관리, 불러올때는 지역대정보를 적용해서 보여줌
    -- 국제화가 필요한 앱에 적합하다.
-- YEAR YYYY형식으로 관리

-- now() 현재 시스템시각을 DATETIME형식으로 제공
select now(); -- 특정테이블 참조없이 사용 가능

create table tbl_data_types_date
(
    a        date,
    b        time,
    datetime datetime,
    d        timestamp,
    e        year
);

insert into tbl_data_types_date
values (now(),
        now(),
        now(),
        now(),
        now());

select *
from tbl_data_types_date;

-- 지역대 정보가 변경되면, timestamp타입은 그에 알맞게 변환해서 불러온다.
select @@session.time_zone; -- SYSTEM
set time_zone = '+09:00'; -- KST +09:00
set time_zone = '-04:00'; -- NewYork -04:00

-- ================================
-- DQL
-- ================================
