USE menudb;

select
    *
from tbl_menu
limit 0, 3;

select
    *
from
    tbl_menu
order by
    menu_price desc
limit 5;

select
    *
from
    tbl_menu
order by
    menu_name
limit 0, 5;
select
    *
from
    tbl_menu
order by
    menu_name
limit 5, 5;
select
    *
from
    tbl_menu
order by
    menu_name
limit 10, 5;