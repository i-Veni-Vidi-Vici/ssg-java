
-- ================================
-- DQL
-- ================================
-- Data Query Language 데이터 질의 언어
-- DML 하위로 분류된다. CRUD 중에 Read를 담당.
-- 참조하는 테이블의 데이터를 검색/조회하는 명령.
-- 조회결과로 0행이상의 ResultSet (결과집합)을 반환한다.
-- 조회할 테이블, 특정행, 특정컬럼, 정렬방식등을 결정할 수 있다.



# 소제목은 #으로 합니다~

# DQL 구조
-- (5) select 컬럼명 (필수)
-- (1) from 테이블 (필수)
-- (2) where 조건절 - 행을 필터링
-- (3) group by 그룹핑
-- (4) having 조건절 - 그룸핑 결과를 필터링
-- (6) order by 컬럼명(정렬기준)
-- (7) limit 제한절


## DQL 기본
-- select 출력할 컬럼 명시
-- from 조회 대상이 되는 테이블
-- where 결과집합에 포함될 행의 조건을 기술. (각 행별로 조건검사후 true인 행만 포함)
-- order by 정렬조건 특정 컬럼기준 오름차순/내림차순 지원

select
    * -- 모든 컬럼
from
    tbl_menu;

select
    menu_code,menu_name,menu_name -- 두번 쓰면 두번 조회
from
    tbl_menu;

select
    menu_code,menu_name,category_code,menu_price,orderable_status
from
    tbl_menu;


-- ----------------------------------------
-- SELECT
-- ----------------------------------------

select
    menu_name,
    menu_price,
    menu_price + (menu_price * 0.1) "부가세 포함 가격" -- 산술연산 얼마든지 가능
from
    tbl_menu;


-- 5칙연산
select
    6 + 4,
    6 - 4,
    6 * 4,
    6 / 4, -- 1.5000
    6 div 4, -- 몫만 보여줌
        6 % 4, -- 2
    6 mod 4; -- 2


# SELECT 컬럼별칭

-- 결과집합의 컬럼명을 변경
-- 컴럼 AS "별칭 ('', `` 허용)
-- as 생략 가능, 별칭이 공백/ 특수문자를 포함하지 않았다면 "" 생략가능 근데 $ㅇ얘는 된다? 왜지?
select
    menu_name as "메뉴명",
    menu_price as "가격",
    category_code 카테고리코드
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

# SELECT DISTINCT
-- 컬럼에 중복값을 제거하고 한번씩만 표시되도록 하는 기능
-- 결과집합의 행의수가 기존 행의수 대비 줄어들수 있다.
-- SELECT절에 한번만 사용이 가능하다.
-- 여러 컬럼에 DISTINCT를 적용하면, 컬럼값을 묶어 중복값을 제거한다.

select
    category_code
from
    tbl_menu;

-- null도 하나의 값처럼 취급해 중복을 제거한다.
select distinct
    ref_category_code
from
    tbl_category;

-- n개의 컬럼에 대해 distinct 한번만 쓰셈 디스틴트
select distinct
    category_code,
    orderable_status
from
    tbl_menu;

# SELECT 문자열 연결
-- concat(v1,v2, ... )함수를 통해 문자열 연결
select
    menu_name,
--    menu_price + '원' -- +는 항상 산술연산을 의미. 숫자로 변경불가한 문자열은 0으로 처리됨.
    menu_price, -- 숫자는 왼쪽정렬
    concat('￦',menu_price, '원') -- 문자열로 바뀌면 오른쪽정렬
from
    tbl_menu;
