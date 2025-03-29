use menudb;

select
    category_code,
    menu_price,
    count(*)
from
    tbl_menu
group by
    category_code,
    menu_price;

SELECT
    category_code,
    count(*) cnt_by_category
from
    tbl_menu
group by
    category_code
having
    count(*)>1
order by
    cnt_by_category desc;

select
    category_code,
    menu_price,
    count(*)
from
    tbl_menu
group by
    category_code,
    menu_price with rollup ;

select
    if(grouping(category_code)=0, category_code, ''),
    count(*)
from
    tbl_menu
group by
    category_code with rollup ;