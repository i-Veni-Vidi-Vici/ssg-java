show databases;
use menudb; -- 특정 db를 선택하고 테이블 작업 가능

SELECT ref_category_code FROM tbl_category;

select distinct
    category_code,
    orderable_status,
    concat(category_code,orderable_status)
from
    tbl_menu;

select
    *
from
    tbl_menu
where
    orderable_status='Y';

select
    menu_code,
    menu_name,
    menu_price
from
    tbl_menu
where
    menu_price=13000;

select
    *
from
    tbl_menu
where
    menu_price>20000;

select
    *
from
    tbl_menu
where
    category_code=10 && orderable_status='Y';

select
    *
from
    tbl_menu
where
            category_code=10 || orderable_status='Y';

select
    *
from
    tbl_menu
where
    category_code=4||(menu_price=9000 && menu_code>10);

select
    *
from
    tbl_menu
where
    menu_price between 10000 and 25000;


select
    *
from
    tbl_menu
where
    menu_price not between 10000 and 25000;

select
    *
from
    tbl_menu
where
    menu_name like '%마늘%';

select
    *
from
    tbl_menu
where
    menu_name like '_마늘%';

select
    *
from
    tbl_menu
where
    menu_name like '%쥬스%';

select
    *
from
    tbl_menu
where
        menu_price>5000 and category_code=10 and menu_name like '%갈치%';

select
    *
from
    tbl_menu
where
        menu_name not like '%마늘%';

select
    *
from
    tbl_menu
where
    category_code is null;

select
    *
from
    tbl_menu
where
    ifnull(category_code, 0) = 0;

select
    *
from
    tbl_menu
where
    category_code in (4,5,6);

select
    *
from
    tbl_menu
where category_code>=4 and category_code<=6;

select
    *
from
    tbl_menu
where
        category_code not in (4,5,6);

select
    *
from
    tbl_menu
where
    category_code !=4
and
    category_code !=5
and
    category_code!=6;


