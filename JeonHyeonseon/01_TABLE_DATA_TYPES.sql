show databases;
use menudb; -- 특정 database를 선택하고, 테이블 작업이 가능하다.

-- 테이블 조회
select * from tbl_menu;  -- 메뉴
select * from tbl_category; -- 카테고리
select * from tbl_order; -- 주문내역
select * from tbl_order_menu; -- 주문별 메뉴정보
select * from tbl_payment; -- 결제내역
select * from tbl_payment_order; -- 결제-주문 연동데이터

-- ================================================
-- TABLE 구조
-- ================================================
-- mysql의 table은 항상 특정 database(schema) 하위에 존재한다.
-- 특정 database에 접근권한이 있는 사용자만 table을 관리할 수 있다.

-- RDBMS에서 구분
-- 1. table (entity, relation) 실제 data가 보관되는 주체
-- 2. column 열 (field, attribute) table의 구조, 컬럼별로 자료형을 가질 수 있다.
-- 3. row 행 (record, tuple) 실제 data가 관리되는 단위
-- 4. domain 하나의 속성(attribute, 열)에서 가질 수 있는 값의 집합

-- ================================================
-- DATA TYPES
-- ================================================
-- 테이블의 속성(열)에 대해 부여된다.
desc tbl_menu;

-- 1. 문자형
-- 2. 숫자형(정수/실수)
-- 3. 날짜/시간형

-- ------------------------------------------------
-- 문자형
-- ------------------------------------------------
-- 고정형 문자타입 CHAR : 지정된 크기보다 작은 데이터를 입력해도 지정한 크기로 보관되는 타입
-- 가변형 문자타입 VARCHAR : 지정된 크기보다 작은 데이터를 입력하면, 딱 그 크기만큼 보관되는 타입

-- 대소문자를 구분하지 않는 SQL 특성상 snake case방식으로 단어를 연결해 사용한다.
create table tbl_data_types_char (
    a char(10), -- 10글자
    b varchar(10) -- 10글자
);

select * from tbl_data_types_char;
desc tbl_data_types_char;

-- 데이터 추가 (무조건 행단위로 처리된다)
insert into tbl_data_types_char values ('korea', 'korea');
insert into tbl_data_types_char values ('개구리', '개구리');
insert into tbl_data_types_char values ('1234567890', '1234567890');
insert into tbl_data_types_char values ('12345678901', '12345678901'); -- [22001][1406] Data truncation: Data too long for column 'a' at row 1

select
    a, length(a), char_length(a),
    b, length(b), char_length(b)
from
    tbl_data_types_char;

-- ------------------------------------------------
-- 숫자형
-- ------------------------------------------------
-- int(integer) 정수타입
-- float, double 실수타입 (float - 유효자리수 6개, double - 유효자리수 16개)
-- decimal 고정소수타입 (지정한 소수점이하로 정확한 데이터관리가 필요할 때)
--  - decimal(전체자리수, 소수점이하자리수)

create table tbl_data_types_number (
    a int,
    b float,
    c double,
    d decimal(30, 20)
);

insert into
    tbl_data_types_number
values (
           1234.5678, -- 1235
           1234.567890213456890, -- 1234.57
           1234.567890213456890, -- 1234.5678
           1234.567890213456890  -- 1234.56780 00000 00000 00000
       );

select * from tbl_data_types_number;


-- ------------------------------------------------
-- 날짜시간형
-- ------------------------------------------------
-- DATE YYYY-MM-DD 형식으로 관리
-- TIME HH:MM:SS.SSSSSS 형식으로 관리
-- DATETIME YYYY-MM-DD HH:MM:SS 형식으로 관리
-- TIMESTAMP YYYY-MM-DD HH:MM:SS 형식으로 관리.
--    지역대 정보를 제거하고 UTC(세계협정시)로 관리. 불러올 때는 지역대정보를 적용해서 보여줌.
--    국제화가 필요한 앱에 적합하다.
-- YEAR YYYY형식으로 관리

-- now() 현재 시스템 시각을 DATATIME형식으로 제공
select now(); -- 특정 테이블 참조 없이 사용가능.

create table tbl_data_types_date(
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

-- 지역대 정보가 변경되면, timestamp타입은 그에 알맞게 변환해서 불러온다.
select @@session.time_zone; -- SYSTEM
set time_zone = '+09:00'; -- KST +09:00
set time_zone = '-04:00'; -- NewYork -04:00


-- ================================================
-- DQL
-- ================================================
-- Data Query Language 데이터 질의 언어
-- DML하위로 분류된다. CRUD 중에 Read를 담당.
-- 참조하는 테이블의 데이터를 검색/조회하는 명령.
-- 조회결과로 0행이상의 ResultSet(결과집합)을 반환한다.
-- 조회할 테이블, 특정행, 특정컬럼, 정렬방식 등을 결정할 수 있다.

# DQL 구조
-- (5) select 컬렴명 (필수)
-- (1) from 테이블 (필수)
-- (2) where 조건절 - 행을 필터링
-- (3) group by 그룹핑
-- (4) having 조건절 - 그룹핑한 결과를 필터링
-- (6) order by 컬럼(정렬기준)
-- (7) limit 제한절

## DQL 기본
-- select 출력할 컬럼을 명시
-- from 조회대상이 되는 테이블 명시
-- where 결과집합에 포함될 행의 조건을 기술. (각 행별로 조건검사 후 true인 행만 포함)
-- order by 정렬조건 작성. 특정 컬럼기준 오름차순/내림차순 지원
select
    * -- 모든 컬럼
from
    tbl_menu;

select
    menu_code, menu_name, category_code, menu_price, orderable_status
from
    tbl_menu;

# SELECT 산술연산
-- 부가세 포함 가격
select
    menu_name,
    menu_price,
    menu_price + (menu_price * 0.1) as "부가세 포함 가격" -- 부가세
from
    tbl_menu;

-- 5칙연산
select
    6 + 4,
    6 - 4,
    6 * 4,
    6 / 4, -- 1.5000
    6 div 4, -- 몫만 구하기
    6 % 4, -- 2 나머지 구하기
    6 mod 4; -- 2 나머지 구하기

# SELECT 컬럼별칭
-- 결과집합의 컬럼명을 변경
-- 컬럼 AS "별칭" ('', `` 허용)
-- as 생략 가능, 별칭이 공백/특수문자를 포함하지 않았다면 "" 생략 가능
select
    menu_name as "메뉴명",
    menu_price as "가격",
    category_code '카테고리코드',
    category_code "카테고리코드",
    category_code 카테고리코드,
    category_code '카테고리+코드',
    category_code '카테고리 코드'
from
    tbl_menu;

# SELECT 리터럴
-- 임의의 값을 컬럼처럼 사용.
-- 모든 행에 해당 값을 표현

select
    menu_name,
    menu_price,
    '원' 단위
from
    tbl_menu;