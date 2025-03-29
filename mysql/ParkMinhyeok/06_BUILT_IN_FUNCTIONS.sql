-- ==============================
-- BUILT-IN FUNCTIONS
-- ==============================
-- 함수. 반복적으로 사용되는 작업을 묶어낸 단위.
-- 전달된 매개인자를 기반으로 작업을 수행, 반드시 하나의 리턴값을 반환

# 함수 유형
-- 1. 단일행처리 함수 : 행별로 호출, 호출된 만큼 결과를 반환
--      1-a. 문자처리함수
--      1-b. 숫자처리함수
--      1-c. 날짜/시간처리함수
--      1-d. 형변환함수
--      1-e. 기타함수
-- 2. 그룹함수 : 지정된 그룹별로 함수를 호출. 그룹당 하나의 결과를 반환

-- -----------------------------
-- 문자처리함수
-- -----------------------------
-- ascii(문자) : 문자에 상응하는 아스키코드값 반환
-- char(아스키코드) : 아스키코드에 상응하는 문자반환
select
    ascii('A'),
    char(65);

-- 문자열길이관련
-- length (문자열) byte 수 반환
-- char_length (문자열) 문자열의 길이 반환
-- bit_length (문자열) bit 수 반환 (byte * 8)
select
    length('pizza'), -- 5 byte
    char_length('pizza'), -- 5개
    bit_length('pizza'); -- 40 bitselect

select
    length('피자'), -- 6 byte
    char_length('피자'), -- 2개
    bit_length('피자'); -- 48 bitselect

select
    length(menu_name),
    char_length(menu_name),
    bit_length(menu_name)
from
    tbl_menu;

-- 문자열 연결연산
-- concat(값1, 갑2, ...) "값1값2"
-- concat_ws(구분자, 값1, 갑2, ...) "값1구분자값2"

select
    concat('사자', '호랑이', '토끼'),
    concat_ws(',', '사자', '호랑이', '토끼');

-- 메뉴 조회 : "1. 떡뽂기 (3000원)"
select
    concat(menu_code, '. ', menu_name, ' (', menu_price, '원)')
from
    tbl_menu;

-- 문자열 검색
-- elt(인덱스, 값1, 값2, ...) 해당 인덱스의 값을 반환
-- field(문자열, 값1, 값2, ...) 문자열과 일치하는 값의 인덱스를 반환
select
    elt(2, '사과', '딸기', '바나나'), -- 딸기
    field('딸기', '사과', '딸기', '바나나'); -- 2

-- csv 데이터에서 값 찾기
-- fine_in_set(문자열, csv 데이터) 문자열과 일치하는 csv 데이터의 인덱스를 반환
select
    find_in_set('딸기', '사과,딸기,바나나'); -- 2
-- order by 에서 특정행만 끌어올리기 위한 용도로 사용가능
select
    *
from
    tbl_menu
order by
    find_in_set(menu_code, '10') desc,
    find_in_set(menu_code, '20') desc;

-- 문자열 검색
-- instr(대상문자열, 찾는문자열) : 인덱스반환
-- locate(찾는문자열, 대상문자열) : 인덱스반환
select
    instr('사과딸기바나나', '바나나'), -- 5
    locate('바나나', '사과딸기바나나'); -- 5

-- 숫자포매팅 ( 세자리콤마찍기, 소수점이하 자리수 보전)
-- format(숫자, 소수점이하자리수) : 형식지정된 문자열반환
select
    1234567890.1234567890,
    format(1234567890.1234567890, 3),
    format(1234567890.1234567890, 0);

-- 메뉴명 가격조회 (살구쥬스 ₩1,200)
select
    concat(menu_name,' ₩', format(menu_price, 0))
from
    tbl_menu;

-- 진수별 숫자표현
select
    bin(10), -- 1010
    oct(10), -- 12
    hex(10); -- A







-- 말일계산
-- last_day(날짜) : 말일에 해당하는 날짜 반환
select
    last_day(now()), -- 2024-04-30
    last_day('2024-02-01'); -- 2024-02-29

-- 다음달 말일은?
select
    last_day(now() + interval  1 month);

-- 날짜/시각 생성하기
-- makedate(년, 일수) : 해당년도 일수번째 날짜 반환
-- maketime(시, 분, 초) : 시각 반환
select
    makedate(2024, 32),
    maketime(10, 12, 13);

-- 기간계산
-- period_odd(년월, 개월수) : 연산된 년월 반환
-- period_diff(미래년월, 과거년월) : 개월수 차이 반환
select
    period_add(202404, 18),
    period_diff(202510, 202404);

-- 분기 확인
-- quarter(날짜) : 1, 2, 3, 4분기 반환
select
    quarter(now()), -- 2
    quarter('2024-03-03'),
    quarter('2024-08-03'),
    quarter('2024-11-03');

-- 초계산
-- time_to_sec(시간) : 초로 변환
select
    time_to_sec('1:0:0'); -- 3600

-- 날짜시각을 특정형식으로 출력하기
-- date_format(날짜/시각, 형식문자열) : 지정된 형식의 문자열 반환
-- 형식
-- %Y/%y 연도 4자리/ 연도2자리
-- %m 월
-- %d 일
-- %H/%h 시간(24시간)/시간(12시간)
-- %i 분
-- %s 초
-- %W/%w 요일명 / 요일 숫자반환 (일(0) ~ 토(6))
select
    date_format(now(), '%y/%m/%d'),
    date_format(now(), '%H/%i/%s'),
    date_format(now(), '%y년 %m월 %d일 (%W)');

-- 지역 변경
select @@lc_time_names; -- en_US
set @@lc_time_names = 'ko_KR'; -- en_US -> ko_KR

-- ------------------------------------
-- 형변환 함수
-- ------------------------------------
-- mysql 에서는 암묵석/명시적 형변환 모두 지원한다.

# 명시적 형변환
-- cast(값 as 자료형)
-- convert(값, 자료형)
-- 사용가능 자료형
-- binary, char, date, datetime
-- decimal, signed/unsigned integer 등을 지원한다.

select
    123,
    cast(123 as char);

select
    123.456,
    cast(123.456 as signed integer),
    convert(123.456, signed integer);

# 암묵적 형변환
select '1' + '2'; -- 숫자 변환후 1 + 2 = 3 처리됨.
select  '1' + 'ㅋㅋㅋ'; -- 1 -> 숫자로 변환 불가한 문자열은 -으로 변환후 1 + 0 으로 계산.
select concat(1, 2, 3, '원'); -- 숫자가 문자열로 자동 변환후 연결 '1' '2' '3' '원'
select adddate('2024-04-01', 1); -- 2024-04-02 date 형 먼저 변환후 1일 더하기 처리
select '1' + '3만원'; -- 4 -> 1 + 3 숫자로 시작되는 문자열은 숫자 부분만 변환
select '1' + '내가가진3만원'; -- 1 + 0

select 3 > '오'; -- 1(true) -> '오'는 0으로 암묵적 변환
select 3 > '5오오오오오'; -- 0(false) '5오오오오오'는 5로 변환후 크기비교, false --> 0

-- -------------------------------
-- 기타 함수
-- -------------------------------
# null 처리함수
-- ifnull(값, null일때 값) : 값이 null 이 아니면, 값을 사용. 값이 null 이면 null 일 때 값을 사용
select
    ifnull('abc', 'xyz'),
    ifnull(null, 'xyz');

-- 메뉴테이블에서 메뉴명, 카테고리번호(null일 경우 '카테고리없음') 조회
select
    menu_name,
    category_code,
    ifnull(category_code, '카테고리없음') -- 문자형
from
    tbl_menu;

-- null 이 아닌 값 찾기
-- coalesce(값1, 값2, ...) null 이 아닌 첫번째 값 반환
select
    coalesce('a', 'b', 'c', null),
    coalesce(null, null, 'a', 'b', 'c', null);

-- 삼항연산처리
-- if(조건식, 참일때값, 거짓일때값)
select
    if(3 > 2, 3, 2),
    if(3 < 2, 3, 2);

-- 메뉴테이블에서 메뉴명, 가격, 주문가능여부
select
    menu_name,
    menu_price,
    if (orderable_status = 'Y', '주문가능', '주문불가')
from
    tbl_menu;

-- isnull(값) null 여부 반환
select
    isnull('ㅋㅋㅋ'), -- 0(false)
    isnull(null); -- 1(true)

-- if + isnull()
select
    menu_name,
    if(isnull(category_code), '카테고리없음', category_code) category_code
from
    tbl_menu;

# 선택함수 case
-- 다양한 케이스에 따라 분기처리를 지원하는 함수
-- (타입1)
-- case
--      when 조건1 then 값1
--      when 조건2 then 값2
--      ...
--      else 기본값
-- end

-- 싼거 5000원 미만
-- 적당한거 5000원 ~ 10000원
-- 좀비싼거 10000원 ~ 20000원
-- 겁나비싼거 20000원 이상

select
    menu_name,
    menu_price,
    case
        when menu_price < 5000 then '싼거'
        when menu_price between 5000 and 10000 then '적당한거'
        when menu_price between 10000 and 20000 then '좀비싼거'
        else '겁나비싼거'
        end as menu_label
from
    tbl_menu;


-- (타입2)
-- case 표현식
--      when 값1 then 결과값1
--      when 값2 then 결과값2
--      ...
--      else 기본값
-- end

select
    menu_name,
    menu_price,
    case
       when category_code is null then '카테고리 없음'
        else category_code
    end category_code,
    case orderable_status
        when 'Y' then '주문가능'
        when 'N' then '주문불가'
    end orderable
from
    tbl_menu;

-- -----------------------------------
-- 그룹 함수
-- -----------------------------------
-- 하나 이상의 행을 그룹으로 묶고, 그룹당 하나의 결과값을 반환하는 함수
-- group by를 사용하지 않는다면, 전체(모든 행)를 하나의 그룹으로 간주한다.
-- group by를 사용한다면, group by 그룹별로 하나의 결과를 반환한다.
-- **그룹함수의 결과와 일반컬럼은 동시에 사용할 수 없다.**

# sum
-- 특정 컬럼의 합을 계산해서 반환
select
    sum(menu_price)
from
    tbl_menu;

# avg
select
    avg(menu_price),
    truncate(avg(menu_price), 1)
from
    tbl_menu;

# count
-- 특정컬럼의 값의 개수를 세어 반환. null 값은 처리하지 않는다.
select
    count(*), -- 22 * 행(모든 컬럼)의 수
    count(category_code) -- 21 찰순대쥬스의 category_code 는 null 이므로 제외.
from
    tbl_menu;

select
    count(*)
from
    tbl_menu
where category_code is not null;

# max / min
-- 특정 컬럼의 최소/최대값을 반환
-- 숫자/문자(사전등재순 맨먼저 ~ 맨뒤)/날짜(과거~ 미래)에 대해서 적용가능
select
    max(menu_price),
    min(menu_price),
    min(menu_name),
    max(menu_name)

from
    tbl_menu;

