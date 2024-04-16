-- ======================================큰제목
-- DQL 엄청 중요함!!!!!!!!!!!!!!!!!!
-- ======================================큰제목
-- Data Query Language 데이터 질의 언어
-- DML 하위로 분류된다. CRUD 중에 Read를 담당.
-- 참조하는 테이블에 데이터를 검색/조회하는 명령.
-- 조회결과로 0행 이상의 ResultSet(결과집합)을 반환한다.
-- 조회할 테이블, 특정행, 특정컬럼, 정렬방식등을 결정할 수 있다.

-- ======================================소제목
-- # DQL 구조
-- ======================================소제족
-- (5) select - 컬럼열(필수)
-- (1) from - 테이블(필수)
-- (2) where - 조건절 - 행을 필터링
-- (3) group by - 그룹핑
-- (4) having by - 그룹핑한 결과를 필터링
-- (6) order by - 컬럼(정렬) - 기본값 = 오름차순(ASC)
-- (7) limit 제한절

# DQL 기본
-- select 출력할 컬럼 명시
-- from 조회대상이 되는 테이블
-- where 결과집함에 포함될 행의 조건을 기술. 각 행별로 조건검사후 true인 행만 포함
-- order by 정렬조건 특정 컬럼기준 오름차순asc/내림차순desc


select
    * -- 모든 컬럼
from
    tbl_menu;

select
    menu_code, menu_name, category_code, orderable_status
from
    tbl_menu;

-- ======================================소제목
-- SELECT 문
-- ======================================소제목
# select 산술연산 가능하다
select
    menu_name as 메뉴,menu_price + (menu_price*0.1) as "부가세 포함 가격", menu_price
from
    tbl_menu;

# 5칙연산
select
    6+4,
    6-4, -- 1.500
    6*4, -- 몫만
    6/4,-- 나머지
    6%4,
6 mod 4;

# select 컬럼 별칭
-- 결과집합의 컬럼명을 변경
-- 컬럼 AS "별칭" ('',``허용)
-- 컬럼 AS 생략 가능, 별칭이 공백/특수문자를 포함하지 않았다면 "" 생략 가능
select
    menu_name "메뉴명",
    menu_price as "가격",
    category_code /*카테고리*//*"카테고리+코드"*/ as "카테고리 코드"

from
    tbl_menu;

# select 리터럴
             # 임의의 값을 컬럼처럼 사용.
# 모든 행에 해당 값을 표현
select
    menu_name,
    menu_price,
    '원' 단위
from
    tbl_menu;

# SELECT DISTINCT
      # 컬럼에 중복값을 제거하고 한 번 씩만 표시되도록 하는 기능
# 결과집합의 행의 수가 기존 행의 수 대비 줄어들 수 있다.
# select절에 한 번만 사용이 가능하다.
# 여러 컬럼에 대해서 DISTINCT를 적용하면, 컬럼값을 묶어 중복값을 제거 한다.

select distinct
    category_code
  from
      tbl_menu;

# null 도 하나의 값처럼 취급해 중복을 제거한다.(null null null ->null 된다)
select
    ref_category_code
from
    tbl_category;

# n개의 컴럼에 대해 distinct
select distinct
    category_code,
    orderable_status
from
    tbl_menu;

# SELECT 문자열 연결
      # concat(v1,v1...)함수;

select
    menu_name,
    concat('한국 돈 : ',menu_price,'원')-- +는 항상 산술연산을 의미, 숫자로 변경불가한 문자열은 0으로 처리됨
-- 숫자 -> 문자가 되서, 위치가 오른쪽정렬에서 왼쪽 정렬로 갔다
from tbl_menu;