use menudb;

select
    category_code
from tbl_menu
where
    menu_name='열무김치라떼';

select
    category_name
from tbl_category
where (select
           category_code
       from tbl_menu
       where
               menu_name='열무김치라떼')=category_code;

select
    menu_name,
    category_code
from tbl_menu
where
    category_code = (select category_code from tbl_menu where menu_name='민트미역국');

select
    *
from tbl_menu
where category_code in
(select
    category_code
from tbl_category
where ref_category_code = (select category_code from tbl_category where category_name='식사'));

use menudb;
select
    m.*
from tbl_menu m join (select category_code, max(menu_price) max_price from tbl_menu group by category_code) c
    on m.category_code=c.category_code
where m.menu_price= max_price
order by m.category_code;

select
    m.*
from tbl_menu m join (select category_code, max(menu_price) max_price from tbl_menu group by category_code) c
                     on m.category_code=c.category_code
where m.menu_price= max_price
order by m.category_code;

select
    m.*
from tbl_menu m left join (select category_code, max(menu_price) max_price from tbl_menu group by category_code) c
                     on m.category_code=c.category_code or(isnull(m.category_code) and isnull(c.category_code))
where m.menu_price= max_price
order by m.category_code;

select
    m.*
from tbl_menu m left join (select category_code, max(menu_price) max_price from tbl_menu group by category_code) c
                          on ifnull(m.category_code,0)=ifnull(c.category_code,0)
where m.menu_price= max_price
order by m.category_code;

select *
from tbl_menu m
where m.menu_price = (select max(menu_price) from tbl_menu where category_code = m.category_code);

select *
from tbl_menu m
where m.menu_price>(select avg(menu_price) from tbl_menu avg where avg.category_code=m.category_code);

select *
from tbl_menu
where exists(select  * from tbl_menu);

select *
from tbl_category c
where exists (select * from tbl_menu where category_code = c.category_code);

use empdb;

select *
from department d
where exists(select * from employee emp where emp.DEPT_CODE=d.DEPT_ID);

select *
from department d
where not exists(select * from employee emp where emp.DEPT_CODE=d.DEPT_ID);

use menudb;

select
    menu_name,
    menu_price
from tbl_menu m
where not exists(select * from tbl_menu where menu_price>m.menu_price);

select
    menu_name,
    (select category_name from tbl_category c where m.category_code= c.category_code) category_name
from tbl_menu m;

select
    category_name,
    (select category_name from tbl_category upperCat where lowerCat.ref_category_code = upperCat.category_code) ref_category_code
from tbl_category lowerCat;

select
    category_code,
    category_name,
    ref_category_name
from (select
         category_name,
         (select category_name from tbl_category upperCat where lowerCat.ref_category_code = upperCat.category_code) ref_category_name,
         category_code
     from tbl_category lowerCat ) t ;


select
    max(count) 최대값,
    min(count) 최소값
from (select count(*) count from tbl_menu m1 group by category_code) m2;

with menu
as (select *
    from tbl_menu)

select *
from menu;

with cnt_category
as (select count(*) count from tbl_menu group by category_code)
select
    max(count),
    min(count)
from cnt_category;