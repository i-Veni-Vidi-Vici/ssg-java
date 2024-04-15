-- ===========================
-- BUILT - IN Functions
-- ===========================

-- ------------
-- 문자 처리 함수
-- -------------
-- ascii(문자) : 문자에 상응 하는 아스키 코드 값 반환
select
    ascii('A'),
    char(65);

select
    menu_name,
    length(menu_name),
    char_length(menu_name),
    bit_length(menu_name)
from
    tbl_menu;

-- 문자열 연결
select
    concat('사자', '호랑이', '토끼'),
    concat_ws(',', '사자', '호랑이','토끼');
-- 메뉴 조회: "1. 떡뽁기 (3000원)"

select
     concat(menu_code, '. ', menu_name, '(',menu_price, '원)')
#     concat(row_number() over (), '. ', menu_name, '(',menu_price, '원)')
 from tbl_menu;

-- 문자열 검색
-- elt(인덱스, 값1, 값2, ...) 해당 인덱스의 값을 반환
-- field(문자열, 값1, 값2, ...) 문자열과 일치하는 값의 인덱스를 반환

select
    elt(2, '사과', '딸기', '바나나'), -- 딸기
    field('딸기','사과','바나나'); -- 2

-- csv 데이터에서 값 찾기
-- find_in_set(문자열, csv데이터) 문자열과 일치하는 csv 데이터의 인덱스를 반환
select
    find_in_set('딸기', '사과,딸기,바나나'); -- 2
-- order by에서 특정 행만 끌어올리기 위한 용도로 사용가능

select
    *
from
    tbl_menu
order by
    find_in_set(menu_code, '10');

-- 문자열 검색
-- instr(대상문자열, 찾는 문자열) 인덱스 반환
select
    instr('사과딸기바나나', '배'), -- 0
    locate('토마토', '사과딸기바나나'); -- 0

select
    123456890.1234567890,
    format(1234567890.1234567890,3),
    format(1234567890.1234567890, 0);

-- 메뉴명 가격 조회 (살구쥬스 1200)
select
#     concat(menu_name, ' ￦',tbl_menu.menu_price) as menu_price
    menu_name,
    concat('￦', format(menu_price, 0)) as menu_price
from
    tbl_menu;

-- 진수별 숫자표현
select
    bin(10),
    oct(10),
    hex(10);

-- 문자열 삽입
-- insert(대상문자열, 시작인덱스, 삭제할 갯수, 추가할 문자열) : 변경된 문자열 반환
select
    insert('제이름은 아무개 입니다', 6, 3, '홍길동'),
    insert('제이름은 아무개 입니다', 6, 0, '김');
-- 쥬스메뉴를 찾아서 '주우스'로 변경 출력하세요.
-- 파인애플쥬스 -> 파인애플주우스

select
#      insert(menu_name, char_length(menu_name)-1, 2, '주우스')
     insert(menu_name, instr(menu_name,'쥬스'), 2, '주우스')
from
    tbl_menu
 where
     menu_name like '%쥬스';

-- left / right
select
    left('hello world!', 3),    -- hel
    right('hello world!', 3);   -- ld!

-- 잘라낸 문자열 반환
select
    substring('안녕하세요, 반갑습니다~', 8, 2), -- 반갑
    substring('안녕하세요, 반갑습니다~', 8); -- 반갑습니다~

-- substring_index(대상 문자열, 타겟 문자열, 횟수n) : 대상문자열에서 n번째 타겟 문자열을 찾고, 타겟문자열을 포함한 이후 문자열을 버림
select
    substring_index('hong.gd@naver.com', '.', 1), -- hong
    substring_index('hong.gd@naver.com', '.', 2), -- hong.gd@naver
    substring_index('hong.gd@naver.com', '.', -1);  -- 음수인 경우 오른쪽에서 왼쪽으로 진행함

-- 대소문자 변환
select
    lower('HelloWorld'), -- helloworld
    upper('HelloWorld'); -- HELLOWORLD

-- 문자열 채우기
-- lpad(문자열, 길이, 패딩문자)  - 지정한 길의 문자열에 문자열을 입력하고 남은 왼쪽 공간에 패딩문자를 채움
-- rpad(문자열, 길이, 패딩문자)  - 지정한 길의 문자열에 문자열을 입력하고 남은 오른쪽 공간에 패딩문자를 채움

select
    lpad('abc',10,'@'),
    rpad('abc', 10, '@');

select
    lpad(123,5,'0');


select
    ltrim('         hello world!'),
    rtrim('         hello world!'),
    rtrim('hello world!         '),
    ltrim('hello world!         '),
    trim('    hello world       ');

select
    concat('(',trim(leading ' ' from '      안녕    ') ,')'),
    concat('(',trim(trailing ' ' from '      안녕    ') ,')'),
    concat('(',trim(both ' ' from '      안녕    ') ,')');

select
    repeat('잼', 5);

select
    replace('마이SQL', '마이', 'MY');

-- 문자열 대체
select
    replace(menu_name, '쥬스', '주우스') menu_name
from
    tbl_menu
where
    menu_name like '%쥬스%';

-- 문자열 뒤집기
select reverse('stressed'); -- desserts

-- 공란생성
select
    concat('시작', space(5), '끝');

-- 정규표현식 관련
select
    regexp_replace('123,456,789원12', '[0-9]', '!'),
    regexp_replace('123,456,789원12', '[0-9]', ''),
    regexp_substr('제 키는 188cm입니다.', '[0-9]+'); -- + 수량자 1개 이상

-- 절대값 반환
select
    abs(123),
    abs(-123);

-- 올림 내림
select
    ceiling(1234.56),   -- 1235
    floor(1234.56), -- 1234
    round(1234.56), -- 1235
    round(1234.56, 1);  -- 1234.6

-- 내림 / 버림 비교
-- 1. 내림 : 지정한 수보다 작은 정수 최대 값
-- 2. 버림 : 절삭
select
    floor(12.34), -- 12
    truncate(12.34, 0), -- 12
    floor(-0.6),    -- -1
    truncate(-0.6, 0);  -- 0


select
    10 / 3,
    10 div 3;

select
    10 % 3,
    10 mod 3,
    mod(10, 3);

select
    pow(2,3), -- 2^3
    pow(3,3); -- 3^3

select
    sqrt(16), -- 4
    sqrt(10); -- 3.16227766

-- 양수/ 0 / 음수 판단 하는 sign
select sign(10.1234),   -- 1
       sign(0),
       sign(-1234.1542543); -- -1

-- 난수 발생

select
#     rand()*100 + 1;  -- 1.0~100.0 미만
     floor(rand()*100 + 1);

