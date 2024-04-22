-- ---------------------------------------
-- SET OPERATORS
-- ---------------------------------------
-- 집합 연산자
-- 테이블의 컬럼을 세로 방향으로 연결해 relation을 생성하는 방식
-- 합집합 union / union all 지원
-- 교집합 intersect, 차집합 minus 는 mysql에서 지원하지 않음
-- 집합 연산 시 조건
-- 위, 아래 테이블의 컬럼 수가 동일해야 함
-- oder by절은 마지막 테이블에서 한번만 사용이 가능함
-- 컬럼명이 다르다면, 첫번째 테이블의 컬럼명을 사용함
-- 컬럼 타입이 다른 경우, 문자열 타입으로 변환되어 처리됨
-- 구분
-- union all 합집합 (연결만 지원)
-- union 합집합(연결 후 중복을 제거)

--  두 테이블이 있다고 가정
-- 1. 카테고리 10번인 메뉴 테이블
-- 2. 가격이 9000원 미만인 메뉴 테이블

# union all
-- 16행 ( 6 + 10)
select -- 별칭이 컬럼 명으로 사용이 됨!
       menu_code     메뉴코드,
       menu_name     메뉴명,
       menu_price    메뉴가격,
       category_code 카테고리코드
#     orderable_status 주문가능여부 -- ⛔위와 컬럼수가 같지 않으면, 오류남!
from tbl_menu
where category_code = 10 -- 6행
# order by
#     1 -- ⛔ 아래 테이블에 한번만 사용 가능!
union all
-- ⛳위아래를 연결해줌!!
select menu_code,
       menu_name,
       menu_price,
       category_code
from tbl_menu
where menu_price < 9000;
-- 10행


# union
-- 연결 후 레코드의 모든 컬럼 값이 동일하다면, 중복으로 간주해서 제거한다
-- 11행 (6 + 10 -5)
select menu_code     메뉴코드,
       menu_name     메뉴명,
       menu_price    메뉴가격,
       category_code 카테고리코드
from tbl_menu
where category_code = 10 -- 6행
union
select menu_code,
       menu_name,
       menu_price,
       category_code
from tbl_menu
where menu_price < 9000;
-- 11행

# intersect
-- 교집합. 위아래 테이블 중 중복된 행만 조회
-- mysql에서는 지원하지 않음
-- 1. inner join으로 우회 구현
-- 2. in 연산자 이용해 우회 구현

-- inner join
-- category_code = 10 이면서 menu_price < 9000인 메뉴 출력
select c.* -- c 테이블의 모든 것을 출력
from tbl_menu c
         join ( -- 괄호 안이 하나의 테이블처럼 적용됨!
    select *
    from tbl_menu
    where menu_price < 9000) p
              on c.menu_code = p.menu_code
where c.category_code = 10;

-- in
select *
from tbl_menu
where category_code = 10
  and menu_code in (select menu_code
                    from tbl_menu
                    where menu_price < 9000);

# minus
-- 차집합. mysql은 minus 집합 연산자 미지원
-- left join을 이용해 우회적으로 구현
select a.*
from (select *
      from tbl_menu
      where category_code = 10) a
         left join (select *
                    from tbl_menu
                    where menu_price < 9000) b
                   on a.menu_code = b.menu_code
where b.menu_code is null;

-- ---------------------------------------
-- 상품 판매 데이터 관리
-- ---------------------------------------
-- 편의점 과자 판매 테이블 관리
create table tbl_sales
(
    prod_name  varchar(100),
    prod_count int,
    sale_date  date
);

desc tbl_sales;

-- 두달전 판매데이터(2월)
insert into tbl_sales
values ('새우깡', 10, CURDATE() - INTERVAL 2 MONTH);
insert into tbl_sales
values ('새우깡', 15, CURDATE() - INTERVAL 2 MONTH + INTERVAL 1 DAY);
insert into tbl_sales
values ('감자깡', 20, CURDATE() - INTERVAL 2 MONTH + INTERVAL 2 DAY);
insert into tbl_sales
values ('새우깡', 10, CURDATE() - INTERVAL 2 MONTH + INTERVAL 3 DAY);

-- 한달전 판매데이터(3월)
insert into tbl_sales
values ('고구마깡', 10, CURDATE() - INTERVAL 1 MONTH);
insert into tbl_sales
values ('새우깡', 15, CURDATE() - INTERVAL 1 MONTH + INTERVAL 1 DAY);
insert into tbl_sales
values ('감자깡', 20, CURDATE() - INTERVAL 1 MONTH + INTERVAL 2 DAY);
insert into tbl_sales
values ('감자깡', 10, CURDATE() - INTERVAL 1 MONTH + INTERVAL 3 DAY);

-- 이번달 판매데이터(4월)
insert into tbl_sales
values ('허니버터칩', 30, CURDATE() - INTERVAL 4 DAY);
insert into tbl_sales
values ('고구마깡', 15, CURDATE() - INTERVAL 3 DAY);
insert into tbl_sales
values ('고구마깡', 10, CURDATE() - INTERVAL 2 DAY);
insert into tbl_sales
values ('허니버터칩', 20, CURDATE() - INTERVAL 2 DAY);
insert into tbl_sales
values ('새우깡', 5, CURDATE() - INTERVAL 1 DAY);
insert into tbl_sales
values ('감자깡', 7, CURDATE() - INTERVAL 1 DAY);

insert into tbl_sales
values ('새우깡', 15, CURDATE());
insert into tbl_sales
values ('고구마깡', 10, CURDATE());
insert into tbl_sales
values ('허니버터칩', 15, CURDATE());

select *
from tbl_sales;

-- 두달전 판매 데이터 조회
-- (쿼리는 다음달, 내년, 내후년에 실행해도 똑같이 그때의 두달 전 데이터가 조회되어야 함)

select *
from tbl_sales
where
#     year(sale_date) = year(curdate() - interval 2 month )
#   and
#     month(sale_date) = month(curdate() - interval 2 month
extract(year_month from sale_date) = extract(year_month from curdate() - interval 2 month);

select month('240101') - 2,                -- -1
       month('240101' - interval 2 month), -- 11 ⛳ 두개 차이조심하기!!
       extract(year_month from curdate());
-- 202404

-- 지난달 데이터
select *
from tbl_sales
where extract(year_month from sale_date) = extract(year_month from curdate() - interval 1 month);

-- 이번달 데이터
select *
from tbl_sales
where extract(year_month from sale_date) = extract(year_month from curdate());

-- 202402 판매 테이블
-- select 실행 결과를 그대로 테이블 생성 가능하다
create table tbl_sales_202402
as
select *
from tbl_sales
where extract(year_month from sale_date) = extract(year_month from curdate() - interval 2 month);

select *
from tbl_sales_202402;
-- table을 잘라낸 것이 아님!

-- 202403 판매 테이블 생성
-- drop table tbl_sales_202403;
create table tbl_sales_202403
as
select *
from tbl_sales
where extract(year_month from sale_date) = extract(year_month from curdate() - interval 1 month);

select *
from tbl_sales_202403;

-- 이번달 판매 데이터 외에는 삭제
select *
from tbl_sales;
delete
from tbl_sales
where extract(year_month from sale_date) != extract(year_month from curdate());

-- 월별 판매 데이터
select *
from tbl_sales_202402;
select *
from tbl_sales_202403;
select *
from tbl_sales;

-- 지난 3개월 간의 판매 데이터 조회
-- 중복제거 기능이 없는 union all 속도상 빠름
select
    *
from
    tbl_sales_202402
union all
select
    *
from
    tbl_sales_202403
union all
select
    *
from
    tbl_sales;

-- 지난 3개월 간 제품별 판매량을 조회
-- 모든 resultset은 테이블로써 참조가 가능. from (...) t (테이블 별칭 필수)
select prod_name       제품명,
       sum(prod_count) 판매량
from (
    select * from tbl_sales_202402
      union all
    select * from tbl_sales_202403
      union all
    select * from tbl_sales) t
group by prod_name;

-- 지난 3개월간 월별 제품별 판매량 조회
select
    extract(year_month from sale_date) 월별,
    prod_name 제품명,
    sum(prod_count) 판매량
from (
         select * from tbl_sales_202402
         union all
         select * from tbl_sales_202403
         union all
         select * from tbl_sales) t
group by
    extract(year_month from sale_date),
    prod_name;
