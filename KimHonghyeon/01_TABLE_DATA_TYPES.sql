show databases;
use menudb; -- 특정 db를 선택하고 테이블 작업 가능

SELECT ref_category_code FROM tbl_category;

select distinct
    category_code,
    orderable_status,
    concat(category_code,orderable_status)
from
    tbl_menu;