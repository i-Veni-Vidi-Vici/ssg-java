-- =======================================
-- STORED_FUNCTION
-- =======================================
-- STORED 즉시 실행가능한 상태로 서버에 저장되어 있음을 의미
-- 매개인자를 받아, 반드시 하나의 반환값을 돌려주는 함수
-- 일반 SQL문에 내장함수처럼 호출이 가능.

-- (root 계정)  function 등을 타사용자가 생성할 수 있게 허용해주는 옵션
SET GLOBAL log_bin_trust_function_creators = 1; -- ON 설정

-- 메뉴에 이모지를 감싸는 함수
delimiter  $$ -- procedure/function의 선언영역을 지정하는 키워드
create function func_emoji_wrapper(p_menu_name varchar(10))
returns varchar(20)
begin
    -- 지역변수 선언
    declare result varchar(20);
    -- 값대입
    -- 실행부
    set result = concat('🤞', p_menu_name, '🤞');

    return result;
end $$ delimiter ;

-- 함수 사용
select
    func_emoji_wrapper(menu_name)
from
    tbl_menu;

-- 카테고리코드 별로 다른 이모지를 감싸는 함수
delimiter $$
drop function func_emoji_wrapper2 $$
create function func_emoji_wrapper2(
    p_menu_name varchar(10),
    p_category_code int
)
    returns varchar(100)
begin
    -- 지역변수 선언
    declare emoji char(1) ; -- default 기본값지정
    -- 실행부
    -- 카테고리 코드에 따른 분기처리
    case p_category_code
        when 4 then set emoji := '🍚'; -- := 대입연산
        when 5 then set emoji := '🍲';
        when 6 then set emoji := '🍛';
        else set emoji := '🥖';
        end case;
    return concat(emoji, p_menu_name, emoji);
end$$
delimiter ;

select
    category_code,
    func_emoji_wrapper2(menu_name, category_code)
from
    tbl_menu;




