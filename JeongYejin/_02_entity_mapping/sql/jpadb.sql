-- jpadb
-- root

create database jpadb;

grant all privileges on jpadb.* to 'sh'@'%';

-- sh

use jpadb;

select *
from tbl_member01;

select *
from tbl_member02;

select *
from tbl_member0301;

select *
from tbl_member0302;

select *
from tbl_sequence;

select *
from tbl_member04;

select *
from tbl_role_permission_0301;

select *
from jpadb.tbl_user_setting_0302;

select *
from tbl_user_setting_map_0302;