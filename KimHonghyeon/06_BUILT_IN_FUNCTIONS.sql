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