use menudb;

select
    menu_code,
    menu_name,
    menu_price,
    category_code
from
    tbl_menu
where
    category_code=10 union all
select
    menu_code,
    menu_name,
    menu_price,
    category_code
from
    tbl_menu
where
        menu_price<9000
order by 1;

select
    menu_code,
    menu_name,
    menu_price,
    category_code
from
    tbl_menu
where
        category_code=10
union
select
    menu_code,
    menu_name,
    menu_price,
    category_code
from
    tbl_menu
where
        menu_price<9000;

select *
from (
    tbl_menu m1 join (
        select *
        from tbl_menu
        where menu_price<9000
    ) m2
     )


select a.*
from (select * from tbl_menu where category_code=10) a left join
    (select * from tbl_menu where menu_price<9000) b on a.menu_code=b.menu_code
where b.menu_code is null;

create table tbl_sales(
    prod_name varchar(100),
    prod_count int,
    sale_date date
);
desc tbl_sales;
insert into tbl_sales values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH);
insert into tbl_sales values('새우깡', 15, CURDATE() - INTERVAL 2 MONTH + INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 20, CURDATE() - INTERVAL 2 MONTH + INTERVAL 2 DAY);
insert into tbl_sales values('새우깡', 10, CURDATE() - INTERVAL 2 MONTH + INTERVAL 3 DAY);

insert into tbl_sales values('고구마깡', 10, CURDATE() - INTERVAL 1 MONTH);
insert into tbl_sales values('새우깡', 15, CURDATE() - INTERVAL 1 MONTH + INTERVAL 1 DAY);
insert into tbl_sales values('감자깡', 20, CURDATE() - INTERVAL 1 MONTH + INTERVAL 2 DAY);
insert into tbl_sales values('감자깡', 10, CURDATE() - INTERVAL 1 MONTH + INTERVAL 3 DAY);

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

select *
from tbl_sales
where (year(sale_date)=year(curdate()) and month(curdate())-month(sale_date)=2) or
      (year(curdate())-year(sale_date)=1 and month(sale_date)-month(curdate())=10);

select *
from tbl_sales
where
    /*
    year(sale_date) = year(curdate() - interval 2 month) and
    month(sale_date)= month(curdate()- interval 2 month);
     */
     extract(year_month from (curdate()-interval 0 month ))=extract(year_month  from sale_date);

create table tbl_sales_202402
as select *
   from tbl_sales
   where
       /*
       year(sale_date) = year(curdate() - interval 2 month) and
       month(sale_date)= month(curdate()- interval 2 month);
        */
           extract(year_month from (curdate()-interval 2 month ))=extract(year_month  from sale_date);
select *
from tbl_sales_202402;

create table tbl_sales_202403
as select *
   from tbl_sales
   where
       /*
       year(sale_date) = year(curdate() - interval 2 month) and
       month(sale_date)= month(curdate()- interval 2 month);
        */
           extract(year_month from (curdate()-interval 1 month ))=extract(year_month  from sale_date);

select
    *
from tbl_sales_202403;

-- drop table tbl_sales_202402;
create table tbl_sales_202402
as select *
   from tbl_sales
   where
       /*
       year(sale_date) = year(curdate() - interval 2 month) and
       month(sale_date)= month(curdate()- interval 2 month);
        */
           extract(year_month from (curdate()-interval 2 month ))=extract(year_month  from sale_date);

select
    *
from tbl_sales;

delete from tbl_sales
where extract(year_month from (curdate()))!=extract(year_month  from sale_date);
select
    prod_name,
    sum(prod_count)
from(
select *
from tbl_sales
union
select *
from tbl_sales_202403
union
select *
from tbl_sales_202402) as 3monthSum
group by prod_name;

select
    concat(year(sale_date),'-' ,month(sale_date)) as 월별,
    prod_name as 상품명,
    sum(prod_count) as 총계
from
(select *
from tbl_sales
union
select *
from tbl_sales_202403
union
select *
from tbl_sales_202402) as 3monthSum
group by prod_name, concat(year(sale_date),'-' ,month(sale_date));