-- union all (6+10)
select
    menu_code 메뉴코드,
    menu_name 메뉴명,
    menu_price 메뉴가격,
    category_code 카테고리코드
from
    tbl_menu
where
    category_code = 10 -- 6행
union all
select
    menu_code,
    menu_name,
    menu_price,
    category_code
from
    tbl_menu
where
    menu_price < 9000
order by 메뉴코드;  -- 10행
-- 연결되어 16행 출력

-- union (6 + 10 -5)
select
    menu_code 메뉴코드,
    menu_name 메뉴명,
    menu_price 메뉴가격,
    category_code 카테고리코드
from
    tbl_menu
where
    category_code = 10 -- 6행
union
select
    menu_code,
    menu_name,
    menu_price,
    category_code
from
    tbl_menu
where
    menu_price < 9000; -- 10행
-- 연결되어 11행 출력

#intersect
select
    c.*
from
    tbl_menu c
        join (select *
                     from
                         tbl_menu
                     where
                         menu_price<9000
        ) p
        on c.menu_code = p.menu_code
where
    c.category_code = 10;

select *
from
    tbl_menu
where
    menu_price<9000;

-- in
select
    *
from
    tbl_menu
where
    category_code = 10
    and menu_code in (
    -- sub-query
    select
        menu_code
    from
        tbl_menu
    where
        menu_price < 9000
    );

-- minus

select
    a.*
from
    (
        select
            *
        from
            tbl_menu
        where
            category_code = 10
    ) a left join (
        select
            menu_code
        from
            tbl_menu
        where
            menu_price < 9000
    ) b on a.menu_code = b.menu_code
where
    b.menu_code is null;

-- 상품 판매 데이터 관리
-- 편의점 과자 팬매 테이블 관리

drop table tbl_sales;

create table tbl_sales (
  prod_name varchar(100),
  prod_count int,
  sale_date date
);

desc tbl_sales;

-- 두달전 판매데이터
insert into tbl_sales values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH);
insert into tbl_sales values('새우깡', 15, CURDATE() - INTERVAL 2 MONTH + INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 20, CURDATE() - INTERVAL 2 MONTH + INTERVAL 2 DAY);
insert into tbl_sales values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH + INTERVAL 3 DAY);

-- 한달 전 판매 데이터
insert into tbl_sales values('고구마깡', 10, CURDATE() - INTERVAL 1 MONTH);
insert into tbl_sales values('새우깡', 15, CURDATE() - INTERVAL 1 MONTH + INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 20, CURDATE() - INTERVAL 1 MONTH + INTERVAL 2 DAY);
insert into tbl_sales values('감자깡', 10, CURDATE() - INTERVAL 1 MONTH + INTERVAL 3 DAY);

-- 이번 달 판매 데이터
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

-- 두 달전 판매데이터 조회
-- 쿼리는 다음달, 내년, 내후년에 실행해도 똑같이 그떄의 두달전 데이터가 조회되어야 한다

select
    *
from
    tbl_sales
where
#     year(sale_date) = year(curdate() - interval 2 month)
#     and month(sale_date) = month(curdate() - interval 2 month);
    extract(year_month from sale_date) = extract(year_month from curdate() - interval 2 month );

-- 지난 달 데이터
select
    *
from
    tbl_sales
where
    extract(year_month from sale_date) = extract(year_month from curdate() - interval 1 month );

-- 이번 달 데이터
select
    *
from
    tbl_sales
where
    extract(year_month from sale_date) = extract(year_month from curdate());

-- 두 달전 판매 데이터 테이블
create table tbl_sales_202402
as
select
    *
from
    tbl_sales
where
    extract(year_month from sale_date) = extract(year_month from curdate() - interval 2 month );

select * from tbl_sales_202402;

-- 지난 달 판매데이터 테이블 생성
create table tbl_sales_202403
as
select
    *
from
    tbl_sales
where
    extract(year_month from sale_date) = extract(year_month from curdate() - interval 1 month );

select * from tbl_sales_202403;

-- 이번달 판매데이터 외에는 삭제
select * from tbl_sales;
delete from
    tbl_sales
where
    extract(year_month from sale_date) != extract(year_month  from curdate());

select * from tbl_sales;



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
    select *
     from
         tbl_sales;

-- 지난 3개월간 제품별 판매량을 조회
-- 모든 resultset은 테이블로써 참조가 가능하다. from (...) t (테이블 별칭 필수)

select
    prod_name,
    sum(prod_count)
from
(select * from tbl_sales_202402
 union all
 select * from tbl_sales_202403
 union all select * from tbl_sales
) t
group by prod_name;

-- 지난 3개월 월별 제품별 판매량 조회

select
    *
from
    (select '2024-02' as sale_year_month, prod_name, sum(prod_count) from tbl_sales_202402 group by prod_name
     union all
     select '2024-03' as sale_year_month, prod_name, sum(prod_count) from tbl_sales_202403 group by prod_name
     union all
     select '2024-04' as sale_year_month, prod_name, sum(prod_count) from tbl_sales group by prod_name
    ) t;

