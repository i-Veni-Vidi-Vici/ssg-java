use menudb;

/*
==============================================================================
DQL
==============================================================================
- Data Query Language 데이터 질의 언어
- DML하위로 분류된다. CRUD중에 Read를 담당
- 참조하는 테이블의 데이터를 검색/조회하는 명령
- 조회결과로 0행이상의 ResultSet(결과집합)을 반환한다.
- 조회할 테이블, 특정 Row, 특정 Column, 정렬방식 등을 결정할 수 있다.
*/

/*
# DQL 구조 (작성순)
- (5) select 컬럼명 (필수)
- (1) from 테이블 (필수)
- (2) where 조건절 - 행을 필터링
- (3) group by 그룹핑
- (4) having 조건절 - 그룹핑 결과를 필터링
- (6) order by 컬럼명(정렬기준)
- (7) limit 제한절
** (n) n 순서에 따라 쿼리가 처리됨

## DQL 기본
- select 출력할 컬럼 명시
- from 조회대상이 되는 테이블
- where 결과 집합에 포함될 행의 조건을 기술. 각 행별로 조건검사 후 true인 행만 포함
- order by 정렬조건 특정 컬럼기준 오름차순/내림차순 지원
*/

select
    * -- 모든 컬럼
from tbl_menu;

select
    menu_code, menu_name, menu_name -- 중복 조회, 순서 바꿔 가져오기 가능
from tbl_menu;

# SELECT 산술연산
-- 부가세 포함 가격
-- 존재하는 컬럼을 그대로 조회, 가공된 값 조회 가능
select menu_name,
       menu_price,
       menu_price * 1.1 '부가세 포함 가격'
from tbl_menu;


-- 5칙 연산
select
    6 + 4,
    6 - 4,
    6 * 4,
    6 / 4, -- 1.5000
    6 div 4, -- 1 몫만
    6 % 4, -- 2
    6 mod 4; -- 2

# SELECT 컬럼별칭
-- 결과 집합의 컬럼명을 변경
-- 컬럼 AS "별칭" ('별칭', `별칭`)
-- as 생략 가능, 별칭이 공백/특수문자를 포함하지 않았다면 "" 생략 가능
select
    menu_name as "메뉴명",
    menu_price as "가격"
from
    tbl_menu;

select menu_name     메뉴명,
       menu_price    가격,
       category_code '카테고리 코드',
        menu_code     "메뉴*코드+#"
from tbl_menu;

# SELECT 리터럴
-- 임의의 값을 컬럼처럼 사용
-- 모든 행에 해당 값을 표현
select
    menu_name,
    menu_price,
    '원' 단위
from
    tbl_menu;

/*
# SELECT DISTINCT
- 컬럼에 중복값을 제거하고 한번씩만 표시되도록 하는 기능
- 결과집합의 행의 수가 기존 행의 수 대비 줄어들 수 있다.
- SELECT절에 한번만 사용이 가능하다.
- 여러 컬럼에 대해 DISTINCT를 적용하면, 컬럼값을 묶어 중복값을 제거한다.
*/
select distinct
    category_code
from
    tbl_menu;

-- null도 하나의 값처럼 취급해 중복을 제거한다.
select /*distinct*/
    *
from
    tbl_category;

select distinct
    ref_category_code
from
    tbl_category;

-- n개의 컬럼에 대해 distinct
select distinct
    category_code,
    orderable_status -- 주문 가능/불가
-- 두개를 묶어서 하나의 값으로 취급을 하고, 중복을 제거한다.
from
    tbl_menu;

# SELECT 문자열 연결
-- concat(v1, v2, ...) 함수를 통해 문자열 연결
select
    menu_name,
    #     menu_price + '원' -- +는 항상 산술연산을 의미, 숫자로 변경불가한 문자열은 0으로 처리됨
    concat(menu_price, '원') as menu_price -- 문자열로 변환, 왼쪽정렬 cf.숫자는 오른쪽 정렬
from tbl_menu;
