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
where ref_category_code = (select category_code from tbl_category where category_name='식사'))