use menudb;

select
    ascii('A'),
    char(65);

SELECT
    LENGTH('PIZZA'),
    BIT_LENGTH('PIZZA'),
    CHAR_LENGTH('PIZZA');

SELECT
    menu_name,
    length(menu_name),
    char_length(menu_name)
from
    tbl_menu;

select
    concat('사자', '호랑이', '토끼'),
    concat_ws(',', '사자', '호랑이', '토끼');

select
    concat(menu_code,'. ',menu_name, ' (', menu_price,'원)')
from tbl_menu;

select
    elt(2, '사과', '바나나', '딸기'),
    field('딸기','사과', '바나나', '딸기');

select
    find_in_set('딸기', '사과,딸기,바나나');

select
    *
from
    tbl_menu
order by
    find_in_set(menu_code, '10') desc,
    menu_code;

SELECT
    INSTR('바나나딸기사과키위', '사과');

SELECT
    FORMAT(12345678.1215512, 5);

SELECT
    CONCAT(menu_name,' ', format(menu_price,0),'￦')
FROM tbl_menu;

SELECT
    INSERT('제 이름은 김홍현입니다.', 7,3,'홍길동');

SELECT
    INSERT(menu_name, instr(menu_name, '쥬스'),2,'주우스')
from tbl_menu
where
    menu_name like '%쥬스';

select
    left('hello world', 5),
    right('hello world', 5);

SELECT
    LOWER('hello WORLD'),
    upper('hello WORLD');

SELECT
    LPAD('HELLO', 10, '-'),
    RPAD('HELLO', 10, '@');

SELECT
    LPAD(menu_code, 5, '0')
from tbl_menu;

SELECT
    TRIM('  안 녕  '),
    LTRIM('  안 녕  ');

select
    repeat('ㅎㅎㅎ',10);
select
    replace(menu_name, '쥬스', '주우스')
from tbl_menu
where menu_name like '%쥬스';

SELECT
    REVERSE('STRESSED');

SELECT
    CONCAT('(',SPACE(10),')');

select
    substring('안녕하세요. 김홍현입니다.', 5, 4);

SELECT
    SUBSTRING_INDEX('hong.gd@naver.com', '.', 2),
    SUBSTRING_INDEX('hong.gd@naver.com', '.', -2);

SELECT
    CEILING(1254.63),
    FLOOR(1256.32),
    TRUNCATE(-1254.33, 1),
    FLOOR(-1254.33);

SELECT
    POW(2,8),
    SQRT(2);

SELECT
    SIGN(10),
    SIGN(0),
    SIGN(-4);

SELECT
    FLOOR(RAND()*10+1);

SELECT
    DATEDIFF('2024.04.20', NOW());

SELECT
    CONCAT('D-', DATEDIFF('2024.09.04', NOW()));

SELECT
    LAST_DAY(NOW()),
    LAST_DAY(ADDDATE(LAST_DAY(NOW()), INTERVAL 1 DAY));

SELECT
    QUARTER(NOW());

select
    date_format(localtime(),'%Y년 %m월 %d일 %H:%i:%s %W');

select
    cast(123.12 as signed integer),
    cast(-123 as unsigned int),
    convert(-123, unsigned int);

select
    '1'%'2',
    '1'/'zzz';

select
    menu_name,
    ifnull(category_code, '카테고리 없음')
from
    tbl_menu;

select
    coalesce(null, 'a', 'b',null);

select
    menu_name,
    menu_price,
    if(orderable_status='Y', '주문가능','주문불가능')
from tbl_menu;

select
    menu_name,
    menu_price,
    case
        when menu_price <5000 then '싼거'
        when menu_price between 5000 and 10000 then '적당한 것'
        when menu_price between 10000 and 20000 then '좀 비싼 것'
        else '겁나 비싼 것'
    end as "menu_label"
from
    tbl_menu;

select
    menu_name,
    menu_price,
    case orderable_status
        when 'Y' then '주문가능'
        when 'N' then '주문불가'
    end
from tbl_menu;

select
    menu_name,
    menu_price,
    case
        when isnull(category_code) then '카테고리없음'
        else category_code
    end as "category status"
from tbl_menu;

select
    SUM(menu_price),
    truncate(AVG(menu_price),0),
    count(*)
from tbl_menu;

select
    max(menu_price),
    min(menu_price),
    max(menu_name),
    min(menu_name)
from tbl_menu;