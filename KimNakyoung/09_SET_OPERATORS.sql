-- ===============================
-- SET OPERATORS
-- ===============================
-- 집합연산자.
-- 테이블의 칼럼을 세로방향으로 연결해서 relation을 생성하는 방식
-- 합집함 union/union all 지원
-- 교집합 intersect, 차집합 minus는 mysql에서 지원하지 않음.

# 집합 연산시 조건
-- 위/아래 테이블의 컬럼수가 동일해야 한다.
-- order by절은 마지막 테이블에서 한번만 사용이 가능하다.
-- 컬럼명이 다르다면, 첫번째 테이블의 컬럼명을 사용한다.
-- 컬럼 타입이 다른 경우, 문자열 타입으로 변환되어 처리된다.

# 구분
-- union all 합집합 ( 연결만 지원)
-- union 합집합 ( 연결후 중복을 제거 처리)

-- 두테이블이 있다고 가정
-- 1. 카테고리 10번인 메뉴 테이블
-- 2. 가격이 9000원 미만인 메뉴 테이블

# union all - 16행
select menu_code 메뉴코드,
       menu_name 메뉴명,
       menu_price 메뉴가격,
       category_code 카테고리코드
from tbl_menu
where category_code = 10 -- 6행
union all
select menu_code,menu_name,menu_price,category_code -- 위에 컬럼명과 다른데 ( 별칭 사용해서 ) 근데 위에껄로 사용
from tbl_menu
where menu_price < 9000
order by 1; -- order by는 맨 마지막에

-- 합칠때 주의할점
-- 위에 칼럼과 밑에 칼럼의 개수가 동일해야한다
-- 합치는 칼럼의 타입은 동일해야한다 다르면 하나로 합쳐짐 문자형이 숫자가 될 순 없으니 문자형으로


# union
select menu_code 메뉴코드,
       menu_name 메뉴명,
       menu_price 메뉴가격,
       category_code 카테고리코드
from tbl_menu
where category_code = 10 -- 6행
union
select menu_code,menu_name,menu_price,category_code -- 위에 컬럼명과 다른데 ( 별칭 사용해서 ) 근데 위에껄로 사용
from tbl_menu
where menu_price < 9000; -- 11행 (중복제거)

# intersect
-- 교집합. 위아래 테이블중 중복된 행만 조회.
-- mysql에서는 지원하지 않는다.
-- 1. inner join으로 우회 구현
-- 2. in연산자 이용해서 우회 구현

select
    c.* -- 왼쪽테이블전체만
from tbl_menu c join (
    select
        *
    from
        tbl_menu
    where
        menu_price < 9000
) p
    on c.menu_code = p.menu_code
where c.category_code = 10;


-- in

select *
from
    tbl_menu
where
    category_code = 10
  and menu_code in (
      select
          menu_code
      from
          tbl_menu
      where
          menu_price < 9000
    );

select *
from
    tbl_menu
where
    category_code = 10
  and menu_code in (
    select
        menu_code
    from
        tbl_menu
    where
        menu_price < 9000
);


# minus
-- 차집합, mysql은 minus 집합연산자 미지원.
-- left join을 이용해서 우회적으로 구현
select a.*
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
            *
        from
            tbl_menu
        where
            menu_price < 9000
    ) b
    on a.menu_code = b.menu_code
where b.menu_code is null;

-- -----------------------------------------
-- 상품 판매데이터 관리
-- -----------------------------------------
-- 편의점 과자 판매 테이블 관리

create table tbl_sales (
  prod_name varchar(100),
  prod_count int,
  sale_date date
);

desc tbl_sales;


-- drop table tbl_sales;


-- 두달전 판매데이터 (2월)

insert into tbl_sales values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH);
insert into tbl_sales values('새우깡', 15, CURDATE() - INTERVAL 2 MONTH + INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 20, CURDATE() - INTERVAL 2 MONTH + INTERVAL 2 DAY);
insert into tbl_sales values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH + INTERVAL 3 DAY);



-- 한달전 판매데이터 (3월)
insert into tbl_sales values('고구마깡', 10, CURDATE() - INTERVAL 1 MONTH);
insert into tbl_sales values('새우깡', 15, CURDATE() - INTERVAL 1 MONTH + INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 20, CURDATE() - INTERVAL 1 MONTH + INTERVAL 2 DAY);
insert into tbl_sales values('감자깡', 10, CURDATE() - INTERVAL 1 MONTH + INTERVAL 3 DAY);

-- 이번달 판매데이터 (4월)

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

-- drop table tbl_sales;

-- 두달전 판매데이터 조회
-- (쿼리는 다음날, 내년, 내후년에 실행해도 똑같이 그때의 두달전 데이터를 조회되어야 한다.)

select *
    from tbl_sales
where
#     year(sale_date) = year(curdate() - interval 2 MONTH)
#     and month(sale_date) = month(curdate() - interval 2 MONTH ); -- 달만 하면 다른년도들도 나옴
extract(year_month from sale_date) = extract(year_month from curdate() - interval 2 month );

# 주의
select
    month('240101') - 2, -- -1 나옴
    extract(year_month from curdate()) ;

-- drop table  tbl_sales_202402;

-- 202402 판매테이블
-- select실행결과를 그대로 테이블 생성가능하다.
create table tbl_sales_202402
as select *
   from tbl_sales
   where
   extract(year_month from sale_date) = extract(year_month from curdate() - interval 2 month );

# select * from tbl_sales_202402_1;
#
# REPLACE into tbl_sales_202402 values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH);
# REPLACE into tbl_sales_202402 values('새우깡', 15, CURDATE() - INTERVAL 2 MONTH + INTERVAL 1 DAY);
# REPLACE into tbl_sales_202402 values('감자깡', 20, CURDATE() - INTERVAL 2 MONTH + INTERVAL 2 DAY);
# REPLACE into tbl_sales_202402 values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH + INTERVAL 3 DAY);

# create table tbl_sales_202402_1 as select distinct * from tbl_sales_202402;




-- 202403 판매데이터 테이블

-- 혹시라도 잘 못 만들었다?
    # 이렇게 삭제 하는 쿼리는 블록잡고 실행하자. 혹시 모르니까
-- drop table tbl_sales_202403;

create table tbl_sales_202403
as select *
   from tbl_sales
   where
       extract(year_month from sale_date) = extract(year_month from curdate() - interval 1 month );

select * from tbl_sales_202403;


-- 이번달 판매데이터 외에는 삭제

select * from tbl_sales;
delete from
    tbl_sales
where
    extract(year_month from sale_date) != extract(year_month  from curdate());

-- 월별 판매 데이터

-- drop table tbl_sales_202402;

select * from tbl_sales_202402;
select * from tbl_sales_202403;
select * from tbl_sales;

-- 지난 3개월간의 판매데이터 조회
-- 중복제거가 아니라면 union all 쓰기 속도상 빠름 ! ( 그냥 붙이기만 해서)
select * from tbl_sales_202402
union all
select * from tbl_sales_202403
union all
select * from tbl_sales;

-- 지난 3개월간 제품별 판매량을 조회 -- 제품별이니까 제품으로 그룸바이 해야된다.
-- 모든 resultset은 테이블로써 참조가 가능하다. from (...) t ( 테이블 별칭 필수)



select 3month.prod_name '제품', sum(3month.prod_count) '3개월간 제품별 판매량'
from (
select * from tbl_sales_202402
union
select * from tbl_sales_202403
union
select * from tbl_sales
                  ) as 3month
group by 3month.prod_name;


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

select
    *
from
    (select '2024-02' as sale_year_month, prod_name, sum(prod_count) from tbl_sales_202402 group by prod_name
     union all
     select '2024-03' as sale_year_month, prod_name, sum(prod_count) from tbl_sales_202403 group by prod_name
     union all
     select '2024-04' as sale_year_month, prod_name, sum(prod_count) from tbl_sales group by prod_name
    ) t;



