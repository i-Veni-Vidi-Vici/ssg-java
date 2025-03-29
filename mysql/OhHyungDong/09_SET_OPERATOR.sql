-- =======================
-- SET OPERATORS
-- =======================
-- 집합 연산자
-- 테이블의 컬럼을 세로 방향으로 연결해서 relation을 생성하는 방식
-- 합집합 union / union all 지원
-- 교집합 intersect, 차집합 minus는 mysql에서 지원하지 않음.

# 집합연산시 조건
-- 위 / 아래 테이블의 컬럼수가 동일 해야한다.
-- order by 절은 마지막 테이블에서 한번만 사용이 가능하다
-- 컬럼명이 다르다면, 첫번째 테이블의 컬럼며을 사용한다.
-- 컬럼타입이 다른 경우, 문자열 타입으로 변환되어 처리된다

#구분
-- union all 합집합(연결만 지원)
-- union 합집합(연결 후 중복을 제거 처리)

-- 두 테이블이 있다고 가정
-- 1. 카테고리 10번인 메뉴 테이블
-- 2. 가격이 9000원 미만인 메뉴 테이블

#union all : 중복 제거를 하지 않음 -> 연결만
select
    menu_code 메뉴코드,
    menu_name 메뉴명,
    menu_price 메뉴가격,
    category_code 카테고리코드
--  orderable_status 주문가능여부
from tbl_menu
where category_code = 10
union all
select
    menu_code, menu_name, menu_price, category_code
from tbl_menu
where menu_price < 9000; -- 16행

# union
-- 연결 후 레코드의 모든 컬럼값이 동일하다면, 중복으로 간주해서 제거한다.
-- 11행 (6 + 10 - 5(중복행)
select
    menu_code 메뉴코드,
    menu_name 메뉴명,
    menu_price 메뉴가격,
    category_code 카테고리코드
--  orderable_status 주문가능여부
from tbl_menu
where category_code = 10
union
select
    menu_code, menu_name, menu_price, category_code
from tbl_menu
where menu_price < 9000; -- 11행

# intersect
-- 교집합. 위아래 테이블중 중복된 행만 조회
-- mysql에서는 지원하지 않는다.
-- 교집합 구현 방법
-- 1. inner join으로 구현
-- 2. in 연산자 이용해서 구현

-- inner join
select *
from
    tbl_menu c join (
        select *
        from tbl_menu
        where menu_price < 9000
    ) p
        on c.menu_code = p.menu_code
where c.category_code = 10;

-- 연산되어서 나오는 것도 결국 테이블로 처리 될 수 있기 떄문에 연산 쿼리를 다른테이블과 join할 수 있따.
select *
from tbl_menu
where menu_price < 9000;

-- in
select
    *
from tbl_menu
where category_code = 10
      and menu_code in (
    -- subquery
    select menu_code
    from tbl_menu
    where menu_price < 9000
);

# minus
-- 차집합. mysql minus 집합연산자 미지원
-- left join을 이용해서 우회적으로 구현 가능
select
    a.*
from
    (select
         *
        from tbl_menu
     where category_code = 10
     ) a left join
    (select *
        from tbl_menu
        where menu_price < 9000
    ) b
    on a.menu_code = b.menu_code
where
    b.menu_code is null;


-- -----------------------
-- 상품 판매 데이터 관리
-- -----------------------
-- 편의점 과자 판매 테이블 관리

create table tbl_sales(
    prod_name varchar(100),
    prod_count int,
    sale_date date
);

desc tbl_sales;

-- 두달 전 판매데이터 (2월)
insert into tbl_sales values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH);
insert into tbl_sales values('새우깡', 15, CURDATE() - INTERVAL 2 MONTH + INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 20, CURDATE() - INTERVAL 2 MONTH + INTERVAL 2 DAY);
insert into tbl_sales values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH + INTERVAL 3 DAY);

-- 한달 전 판매데이터 (3월)
insert into tbl_sales values('고구마깡', 10, CURDATE() - INTERVAL 1 MONTH);
insert into tbl_sales values('새우깡', 15, CURDATE() - INTERVAL 1 MONTH + INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 20, CURDATE() - INTERVAL 1 MONTH + INTERVAL 2 DAY);
insert into tbl_sales values('감자깡', 10, CURDATE() - INTERVAL 1 MONTH + INTERVAL 3 DAY);

-- 이번 달 판매데이터 (4월)
insert into tbl_sales values('허니버터칩', 30, CURDATE() - INTERVAL 4 DAY);
insert into tbl_sales values('고구마깡', 15, CURDATE() - INTERVAL 3 DAY);
insert into tbl_sales values('고구마깡', 10, CURDATE() - INTERVAL 2 DAY);
insert into tbl_sales values('허니버터칩', 20, CURDATE() - INTERVAL 2 DAY);
insert into tbl_sales values('새우깡', 5, CURDATE() - INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 7, CURDATE() - INTERVAL 1 DAY);

insert into tbl_sales values('새우깡', 15, CURDATE());
insert into tbl_sales values('고구마깡', 10, CURDATE());
insert into tbl_sales values('허니버터칩', 15, CURDATE());

select * from tbl_sales;

-- 두달전 판매 데이터
-- 쿼리는 다음달, 내년, 내후년에 실행해도 똑같이 그때의 두달전 데이터가 조회되어야한다.
-- 현재 날짜에서 2달 전 조회
select *
from tbl_sales
where
    #   (year(sale_date) = year(curdate()))
    #       and
    #   (month(sale_date) = month(curdate()-interval 2 month))
    extract(year_month from sale_date) = extract(year_month from curdate() - interval 2 month);

-- 현재 날짜에서 1달전 조회
select *
from tbl_sales
where
    extract(year_month from sale_date) = extract(year_month from curdate() - interval 1 month);

-- 이번 달 데이터 조회
select *
from tbl_sales
where

    extract(year_month from sale_date) = extract(year_month from curdate());

-- 2020402 판매 테이블
-- select실행 결과를 그대로 테이블로 생성이 가능하다
create table tbl_sales_202402
as
    select *
    from tbl_sales
    where
        extract(year_month from sale_date) = extract(year_month from curdate() - interval 2 month);

-- 202403 판매테이블 생성
create table tbl_sales_202403
as
    select *
    from tbl_sales
    where extract(year_month from sale_date) = extract(year_month from curdate() - interval 1 month);

select * from tbl_sales_202402;
select * from tbl_sales_202403;

-- 이번달 판매데이터 외에는 삭제
delete from
        tbl_sales
where extract(year_month from sale_date) != extract(year_month from curdate())


-- 월별 판매 데이터
select * from tbl_sales_202402;
select * from tbl_sales_202403;
select * from tbl_sales;

-- 지난 3개월 간의 판매 데이터 조회
-- 중복 제거 기능이 없는 union all 속도상 빠르다
select * from tbl_sales_202402
union all
select * from tbl_sales_202403
union all
select * from tbl_sales
order by 3;

-- 지난 3개월 간 제품별 판매량 조회
-- resultset은 테이블로써 참조가 가능하다. from(...) t t와 같은 명칭 필수
select prod_name,
       sum(prod_count) as '3개월간 제품 판매량'
From
    (select * from tbl_sales_202402
     union all
     select * from tbl_sales_202403
     union all
     select * from tbl_sales) as tb_count
group by prod_name;

-- 월별 제품별 판매 데이터
select
    extract(year_month from sale_date) 월별,
    prod_name,
    sum(prod_count)
From(
        select * from tbl_sales_202402
        union all
        select * from tbl_sales_202403
        union all
        select * from tbl_sales
    ) t
group by extract(year_month from sale_date),prod_name;
