show databases;
use menudb; -- 특정 database 를 선택하고, 테이블 작업이 가능하다.

select * from tbl_menu; -- 메튜
select * from tbl_category; -- 카테고리
select * from tbl_order; -- 주문내역
select * from tbl_order_menu; -- 주문별 메뉴정보
select * from tbl_payment; -- 결제
select * from tbl_payment_order; -- 결제-주문 연동데이터

-- ==================================
-- TABLE 구조
-- ==================================
-- mysql 의 table 은 항상 특정 database(schema) 하위에 존재한다.
-- 특정 database 에 접근권한이 있는 사용자만 table 을 관리할 수 있다.

-- RDBMS 에서 구분
-- 1. table (entity, relation) 실제 data 가 보관되는 주체
-- 2. column 열 (field, attribute) table 의 구조, 컬럼별로 자료형 가질수 있다.
-- 3. row 행 (record, tuple) 실제 data 가 관리되는 단위
-- 4. domain 하나의 속성(열)에서 가질수 있는 값의 집합

-- ==================================
-- DATA TYPES
-- ==================================
-- 테이블의 속성(열)에 대해 부여된다.
desc tbl_menu;

-- 1. 문자형
-- 2. 숫자형 (정수/실수)
-- 3. 날짜/시간형
-- -----------------------------------
-- 문자형
-- -----------------------------------
-- 고정형 문자타입 CHAR : 지정한 크기보다 작은 데이터를 입력해도 지정한 크기로 보관되는 타입
-- 가변형 문자타입 VARCHAR : 지정된 크기보다 작은 데이터를 입력하면, 딱 그 크기만큼 보관되는 타입

-- 대소문자를 구분하지 않는 SQL 특성상 snake case 방식으로 단어를 연결해 사용한다.
create table tbl_data_types_char (
    a char(10), -- 10글자
    b varchar(10) -- 10글자
);

select * from tbl_data_types_char;
desc tbl_data_types_char;

-- 데이터 추가 (행단위로 처리된다)
insert into tbl_data_types_char values ('korea', 'korea');
insert into tbl_data_types_char values ('개구리', '개구리');
insert into tbl_data_types_char values ('1234567890', '1234567890');
insert into tbl_data_types_char values ('12345678901', '12345678901'); -- [22001][1406] Data truncation: Data too long for column 'a' at row 1


select
    a, length(a), char_length(a),
    b, length(b), char_length(b)
from
    tbl_data_types_char;

-- -----------------------------------
-- 숫자형
-- -----------------------------------
-- int(integer) 정수형
-- float, double 실수타입 - 유효자리수 6개, double - 유효자리수 16개)
-- decimal 고정소수타입 (지정한 소수점 이하로 정확한 데이터관리가 필요할때)

create table tbl_data_types_number (
    a int,
    b float,
    c double,
    d decimal(30, 20)
);

insert into
    tbl_data_types_number
values (
    1234.5678,
    1234.5678,
    1234.5678,
    1234.5678
);

select * from tbl_data_types_number;

-- -----------------------------------
-- 날짜/시간형
-- -----------------------------------
-- DATE YYYY-MM-DD 형식으로 관리
-- TIME HH:MM:SS.SSSSSS 형식으로 관리
-- DATETIME YYYY-MM-DD HH:MM:SS 형식으로 관리
-- TIMESTAMP YYYY-MM-DD HH:MM:SS 형식으로 관리.
--      지역대정보를 제거하고 UTC 로 관리. 불러올떄는 지역대정보를 적용해서 보여줌.
--      국제화가 필요한 앱에 적합하다.
-- YEAR YYYY 형식으로 관리

-- now() 현재 시스템시각을 DATETIME 형식으로 제공
select now(); -- 특정테이블 참조없이 사용 가능

create  table tbl_data_types_date (
    a date,
    b time,
    c datetime,
    d timestamp,
    e year
);
insert into
    tbl_data_types_date
values(
       now(),
       now(),
       now(),
       now(),
       now()
);
select * from tbl_data_types_date;

-- 지역대 정보가 변경되면, timestamp 타입은 그에 알맞게 변환해서 불러온다.
select @@session.time_zone; -- SYSTEM
set time_zone = '+09:00'; -- KST +09:00
set time_zone = '-04:00'; -- NewYork -04:00

-- -----------------------------------
-- DQL
-- -----------------------------------
-- Data Query Language 데이터 질의 언어
-- DML 하위로 분류된다. CRUD 중에 READ 를 담당.
-- 참조하는 테이블의 데이터를 검색/조회하는 명령.
-- 조회결과로 0행이상의 ResultSet(결과집합)을 반환한다.
-- 조회할 테이블, 특정행, 특정컬럼, 정렬방식등을 결정할 수 있다.

# DQL 구조
-- (5) select 컬럼명 (필수)
-- (1) from 테이블 (필수)
-- (2) where 조건절 - 행을 필터링
-- (3) group by 그룹핑
-- (4) having 조건절 - 그룹핑 결과를 필터링
-- (6) order by 컬럼(정렬기준)
-- (7) Limit 제한절

# DQL 기본
-- select 출력할 컬럼 명시
-- from 조회대상이 되는 테이블
-- where 결과집합에 포함될 행의 조건을 기술. (각행별로 조건심사후 true 인 행만 포함)
-- order by 정렬조건 특정 정렬기준 오름차순/내림차순 지원
select
    * -- 모든 컬럼
from
    tbl_menu;

select
    menu_code, menu_name, category_code, menu_price, orderable_status
from
    tbl_menu;

-- SELECT 산술연산
select
    menu_name,
    menu_price,
    menu_price + (menu_price * 0.1) as "부가세포함가격"
from
    tbl_menu;

-- 5칙연산
select
    6 + 4,
    6 - 4,
    6 * 4,
    6 / 4,
    6 div 4,
    6 % 4;

# SELECT 컬럼별칭
-- 결과집합의 컬럼명을 변경
-- 컬럼 AS "별칭" ('', `` 허용)
-- as 생략 가능, 별칭이 공백/특수문자를 포함하지 않았다면 "" 생략 가능
select
    menu_name as "메뉴명",
    menu_price as "가격",
    category_code '카테고리코드+코드'
from
    tbl_menu;

# SELECT 리터럴
-- 임의의 값을 컬럼처럼 사용,
-- 모든 행에 해당 값을 표현
select
    menu_name,
    menu_price,
    '원' 단위
from
    tbl_menu;

# SELECT DISTINCT
-- 컬럼에 중복값을 제거하고 한번씩만 표시되도록 하는 기능
-- 결과집합의 행의 수가 기존 행의수 대비 줄어들수 있다.
-- SELECT 절에 한번만 사용이 가능하다.
-- 여러 컬럼에 DISTINCT 를 적용하면, 컬럼값을 묶어 중복값을 제거한다.
select
    category_code
from
    tbl_menu;

-- null도 하나의 값처럼 취급해 중복을 제거한다,
select distinct
    ref_category_code
from
    tbl_category;

-- n 개의 컬럼에 대해 distinct
select distinct
    category_code,
    orderable_status
from tbl_menu;

# SELECT 문자열 연결
-- concat(v1, v2, ...) 함수를 통해 문자열 연결

select
    menu_name,
--  menu_price + '원' -- +는 항상 산술연산을 의미. 숫자로 변경불가한 문자열은 0으로 처리됨.
    menu_price,
    concat('₩', menu_price, '원')
from tbl_menu;