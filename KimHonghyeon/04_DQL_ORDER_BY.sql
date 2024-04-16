use menudb;

select
    *
from
    tbl_menu
order by
    menu_code desc;

select
    *
from tbl_menu
order by
    category_code asc,
    menu_price desc;

select
    *
from
    tbl_menu
order by
    1;

select
    menu_name,
    orderable_status
from tbl_menu
order by
    field(orderable_status, 'Y', 'N');

select
    *
from tbl_menu
order by
    category_code;

select
    *
from
    tbl_menu
order by
    category_code is null desc,
    category_code;