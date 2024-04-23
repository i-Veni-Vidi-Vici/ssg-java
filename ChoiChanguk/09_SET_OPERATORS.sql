-- ====================================
-- SET OPERATORS
-- ====================================
-- 집함연산자
-- 테이블의 컬럼의 세로방향으로 연결해서 relation을 생성하는 방식
-- 합집합 union/union all 지원
-- 교집합 intersect, 차집합 minus는 mysql에서 지원하지 않음.

# 집합 연산지 조건
-- 위/아래 테이블의 컬럼수가 동일해야 한다
-- order by절은 마지막 테이블에서 한 번만 사용이 가능하다.
-- 컬럼명이 다르다면, 첫 번째 테이블의 컬럼명을 사용한다.
-- 컬럼 타입이 다른 경우, 문자열타입으로 변환되어 처리된다

# 구분
# union all 합집합(연결만 지원) 중복제거 안함
# union all 합집합(연결만 지원) 중복제거 지원

-- 두 테이블이 있다고 가정
-- 1. 카테고리 10번인 메뉴 테이블
-- 2. 가격이 9000원 미만인 테이블


select menu_code as 메뉴코드, menu_name as 메뉴이름, category_code as 카테고리코드
from tbl_menu
where category_code=10; -- 6행

select menu_code, menu_name, category_code
from tbl_menu
where menu_price<9000; -- 10행

# union all
select menu_code as 메뉴코드, menu_name as 메뉴이름, category_code as 카테고리코드
from tbl_menu
where category_code=10 -- 6행

union all

select menu_code, menu_name, category_code
from tbl_menu
where menu_price<9000 -- 10행
order by 1;

# union
-- 연결 후 레코드의 모든 컬럼값이 동일하다면, 중복으로 간주해서 제거한다
select menu_code as 메뉴코드, menu_name as 메뉴이름, category_code as 카테고리코드
from tbl_menu
where category_code=10 -- 6행

union

select menu_code, menu_name, category_code
from tbl_menu
where menu_price<9000 -- 10행
order by 1;

# INTERSECT
-- 교집합, 위아래 테이블 중 중복된 행만 조회.
-- MYSQL에서는 지원하지 않는다.
-- 1. inner join으로 우회 구현
-- 2. in연산자 이용해서 우회 구현

select *
from tbl_menu c
         join
     (select *
      from tbl_menu
      where menu_price <9000) p
     on c.menu_code = p.menu_code
where c.category_code = 10;


-- in
select *
from tbl_menu
where category_code = 10
  and menu_code
    in (
    # sub query
    select menu_code
        from tbl_menu
        where menu_price < 9000);

# minus
-- 차집합. minus mysql에서 지원하지 않음
-- left join을 이용해서 우회적으로 구현
select a.*
from (select *
      from tbl_menu
      where category_code = 10) a
         left join
     (select *
      from tbl_menu
      where menu_price < 9000) b
     on a.menu_code = b.menu_code
where b.menu_code is null;


-- -------------------------------------
-- 상품 판매데이터 관리
-- -------------------------------------
-- 편의점 과자 판매 테이블;

create table tbl_sales (
    prod_name varchar(100),
    prod_count int,
    sale_date date
);

desc tbl_sales;

select *
from tbl_sales;

-- 두 달전 판매데이터 (2월)
insert into tbl_sales values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH);
insert into tbl_sales values('새우깡', 15, CURDATE() - INTERVAL 2 MONTH + INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 20, CURDATE() - INTERVAL 2 MONTH + INTERVAL 2 DAY);
insert into tbl_sales values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH + INTERVAL 3 DAY);

-- 한 달전 판매데이터 (3월)
insert into tbl_sales values('고구마깡', 10, CURDATE() - INTERVAL 1 MONTH);
insert into tbl_sales values('새우깡', 15, CURDATE() - INTERVAL 1 MONTH + INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 20, CURDATE() - INTERVAL 1 MONTH + INTERVAL 2 DAY);
insert into tbl_sales values('감자깡', 10, CURDATE() - INTERVAL 1 MONTH + INTERVAL 3 DAY);

-- 이번달  판매데이터 (4월)
insert into tbl_sales values('허니버터칩', 30, CURDATE() - INTERVAL 4 DAY);
insert into tbl_sales values('고구마깡', 15, CURDATE() - INTERVAL 3 DAY);
insert into tbl_sales values('고구마깡', 10, CURDATE() - INTERVAL 2 DAY);
insert into tbl_sales values('허니버터칩', 20, CURDATE() - INTERVAL 2 DAY);
insert into tbl_sales values('새우깡', 5, CURDATE() - INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 7, CURDATE() - INTERVAL 1 DAY);

insert into tbl_sales values('새우깡', 15, CURDATE());
insert into tbl_sales values('고구마깡', 10, CURDATE());
insert into tbl_sales values('허니버터칩', 15, CURDATE());

select *
from tbl_sales;

-- 두달전 판매데이터 조회 지금이 4월 이니깐, 2월달 것만 나와야 한다
select*
from tbl_sales
where extract(year_month from sale_date) =extract(year_month from curdate() - interval 2 month ); -- 한번에

-- 이번달 것만
select*
from tbl_sales
where extract(year_month from sale_date) = extract(year_month from curdate());

-- 202402 판매테이블
create table tbl_sales_202402 as
select*
from
    tbl_sales
where
    extract(year_month from sale_date) =extract(year_month from curdate() - interval 2 month ); -- 한번에

select *
from tbl_sales_202402;

-- 202403 판매테이블
create table tbl_sales_202403 as
select*
from
    tbl_sales
where
    extract(year_month from sale_date) =extract(year_month from curdate() - interval 1 month ); -- 한번에

select *
from tbl_sales_202403;

delete from tbl_sales where extract(year_month from sale_date)!=extract(year_month from curdate());

select *
from tbl_sales;

-- 월별 판매데이터
SELECT * FROM tbl_sales_202402;
SELECT * FROM tbl_sales_202403;
SELECT * FROM tbl_sales;

# CREATE TABLE tbl_ as 이렇게 유니온 한 걸 테이블로도 만들 수 있다
SELECT *
FROM tbl_sales_202402
UNION all
SELECT *
FROM tbl_sales_202403
UNION all
SELECT *
FROM tbl_sales
ORDER BY sale_date DESC;

-- 지난 3개월간 제품별 판매량을 조회
-- 모든 resultset은 테이블로써 참조가 가능하다. from(...) t (테이블 별칭 필수)
select prod_name,sum(prod_count)
from (SELECT *
      FROM tbl_sales_202402
      UNION ALL
      SELECT *
      FROM tbl_sales_202403
      UNION ALL
      SELECT *
      FROM tbl_sales) as l
group by prod_name;

-- 지난 3개월간 월별 제품별 판매량을 조회


select extract(year_month from sale_date) as 월별,
       prod_name as 이름,
       sum(prod_count) as 판매량
from (SELECT *
      FROM tbl_sales_202402
      UNION ALL
      SELECT *
      FROM tbl_sales_202403
      UNION ALL
      SELECT *
      FROM tbl_sales) as l
group by extract(year_month from sale_date),prod_name
order by 1;

select month(sale_date)
from tbl_sales
