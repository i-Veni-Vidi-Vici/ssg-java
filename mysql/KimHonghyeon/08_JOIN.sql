use menudb;

select
    category_code
from tbl_menu
where
    menu_name='한우딸기국밥';

select
    menu_name,
    category_name
from
    tbl_menu menu join tbl_category category on menu.category_code = category.category_code
where
    menu_name='한우딸기국밥';

select *
from tbl_menu as menu inner join tbl_category as category on menu.category_code = category.category_code;

select *
from tbl_menu as menu left outer join tbl_category as category on menu.category_code = category.category_code;

select *
from tbl_menu as menu right outer join tbl_category as category on menu.category_code = category.category_code;

USE empdb;

select *
from employee join department on employee.DEPT_CODE = department.DEPT_ID;

select *
from employee left join department on employee.DEPT_CODE = department.DEPT_ID;

select *
from employee right join department on employee.DEPT_CODE = department.DEPT_ID;

select distinct
    d.DEPT_ID,
    d.DEPT_TITLE
from employee e join department d on e.DEPT_CODE = d.DEPT_ID;

use menudb;
select *
from tbl_menu cross join tbl_category;

select
    upper_c.category_name,
    lower_c.category_name
from tbl_category as upper_c right join tbl_category as lower_c on lower_c.ref_category_code = upper_c.category_code;

use empdb;

select
    emp.EMP_ID,
    emp.EMP_NAME,
    mng.EMP_ID,
    mng.EMP_NAME
from employee as mng right join employee as emp on emp.MANAGER_ID=mng.EMP_ID;

select
    *
from employee join department on employee.DEPT_CODE = department.DEPT_ID
    join location on LOCATION_ID=location.LOCAL_CODE;

select
    *
from employee left join department on employee.DEPT_CODE = department.DEPT_ID
             left join location on LOCATION_ID=location.LOCAL_CODE;