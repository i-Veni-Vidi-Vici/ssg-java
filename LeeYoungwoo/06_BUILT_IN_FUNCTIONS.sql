-- ================================
-- BUILT-IN-FUNCTIONS
-- ================================
-- 함수. 반복적으로 사용되는 작업을 묶어낸 단위
-- 전달된 매개인자를 기반으로 작업을 수행, 반드시 하나의 리턴값을 반환

# 함수 유형
-- 1. 단일행처리 함수 : 행별로 호출, 호출된 만큼 결과를 반환
--      1-a. 문자처리 함수
--      1-b. 숫자처리 함수
--      1-c. 날짜/시간처리 함수
--      1-d. 형변환 함수
--      1-e. 기타 함수
-- 2. 그룹함수 : 지정된 그룹별로 함수를 호출. 그룹당 하나의 결과를 반환

-- ---------------------------------
-- 문자처리함수
-- ---------------------------------
-- ascii(문자) : 문자에 상응하는 아스키코드값 반환
-- char(아스키코드) : 아스키코드에 상응하는 문자반환
select ascii('A'),
       char(65);

-- 문자열길이관련
-- length(문자열) byte수 반환
-- char_length(문자열) 문자열의 길이 반환
-- bit_length(문자열) bit수 반환(byte * 8)
select
    length('pizza'), -- 5 byte
    char_length('pizza'), -- 5개
    bit_length('pizza'); -- 40 bit

select
    length('피자'), -- 6 byte
    char_length('피자'), -- 2개
    bit_length('피자'); -- 48 bit

select
    menu_name,
    length(menu_name),
    char_length(menu_name),
    bit_length(menu_name)
from tbl_menu;

-- 문자열 연결연산
-- concat(값1, 값2, ...) "값1값2"
-- concat_ws(구분자, 값1, 값2, ...) "값1구분자값2"
select
    concat('사자', '호랑이', '토끼'), -- 사자호랑이토끼
    concat_ws(',', '사자', '호랑이', '토끼'); -- 사자,호랑이,토끼

-- 메뉴 조회 : "1. 떡볶이 (3000원)"
select
    concat(menu_code, '. ', menu_name, ' (', menu_price, '원)')
from tbl_menu;

-- 문자열 검색
-- elt(인덱스, 값1, 값2, ...) 해당인덱스의 값을 반환
-- field(문자열, 값1, 값2, ...) 문자열과 일치하는 값의 인덱스를 반환
select
    elt(2, '사과', '딸기', '바나나'), -- 딸기
    field('딸기', '사과', '딸기', '바나나'); -- 2

-- csv데이터에서 값 찾기
-- find_in_set(문자열, csv데이터) 문자열과 일치하는 csv데이터의 인덱스 반환
select
    find_in_set('딸기', '사과,딸기,바나나'), -- 2
    find_in_set('아보카도', '사과,딸기,바나나'); -- 0
-- order by에서 특정 행만 끌어올리기 위한 용도로 사용가능
select *
from tbl_menu
order by
    find_in_set(menu_code, '10') desc, -- find_in_set의 결과가 false이면 0이고 true면 1이기 때문에 오름차순결과 10번이 제일 밑으로 가게 됨 -> desc해야 첫번째로 올라온다.
    find_in_set(menu_code, '20') desc; -- find_in_set의 결과가 false이면 0이고 true면 1이기 때문에 오름차순결과 20번이 제일 밑으로 가게 됨 -> desc해야 첫번째로 올라온다.

-- 문자열 검색
-- instr(대상문자열, 찾는문자열)  : 인덱스 반환
-- locate(찾는문자열, 대상문자열) : 인덱스 반환
select
    instr('사과딸기바나나', '바나나'), -- 5
    locate('바나나', '사과딸기바나나'), -- 5
    instr('사과딸기바나나', '배'), -- 0
    locate('토마토', '사과딸기바나나'); -- 0

-- 숫자포매팅 (세자리마다 콤마찍기, 소수점이하 자리수 보전)
-- format(숫자, 소수점이하 자리수) : 형식지정된 문자열 반환
select
    1234567890.1234567890,
    format(1234567890.1234567890, 3), -- 1,234,567,890.123
    format(1234567890.1234567890, 0); -- 1,234,567,890

-- 메뉴명 가격조회 (살구쥬스 ￦1,200)
select
    menu_name,
    concat('￦', format(menu_price, 0)) menu_price
from tbl_menu;

-- 진수별 숫자표현
select
    bin(10), -- 1010
    oct(10), -- 12
    hex(10); -- A

-- 문자열 삽입
-- insert(대상문자열, 시작인덱스, 삭제할개수, 추가할 문자열) : 변경된 문자열 반환
select
    insert('제이름은 아무개입니다.', 6, 3, '이영우'),
    insert('제이름은 아무개입니다.', 6, 0, '김');

-- 쥬스메뉴를 찾아서 '주우스'로 변경 출력하세요.
-- 파인애플쥬스 -> 파인애플주우스
select insert(menu_name, instr(menu_name, '쥬스'), 2, '주우스')
from tbl_menu
where menu_name like '%쥬스%';

-- 문자열 잘라내기
-- left(대상문자열, 개수)  : 왼쪽부터 지정한 개수만큼 잘라내서 반환
-- right(대상문자열, 개수) : 오른쪽부터 지정한 개수만큼 잘라내서 반환
select
    left('Hello world!',3), -- Hel
    right('Hello world!',3); -- ld!

-- substring(대상문자열, 시작인덱스, 길이): 잘라낸 문자열
select
    substring('안녕하세요, 반갑습니다~', 8, 2), -- 반갑
    substring('안녕하세요, 반갑습니다~', 8); -- 반갑습니다~

-- substring_index(대상문자열, 찾는문자열, 횟수n) : 대상문자열에서 n번째 문자열을 찾고 그 이후를 버림처리 후 반환
select
    substring_index('hong.gd@naver.com', '.', 1), -- hong
    substring_index('hong.gd@naver.com', '.', 2), -- hong.gd@naver
    substring_index('hong.gd@naver.com', '.', -2); -- gd@naver.com 음수인 경우, 끝에서 왼쪽으로 조회

select
    substring('hong.gd@naver.com', 1, instr('hong.gd@naver.com', '@')-1),
    substring_index('hong.gd@naver.com','@',1);


-- 대소문자 변환
select
    lower('HelloWorld'), -- helloworld
    upper('HelloWorld'); -- HELLOWORLD

-- 문자열 채우기
-- lpad(문자열, 길이, 패딩문자) - 지정한 길이의 문자열에 첫번째 문자열과 왼쪽 남은 공간에 패딩문자를 채운다.
-- rpad(문자열, 길이, 패딩문자) - 지정한 길이의 문자열에 첫번째 문자열과 오른쪽 남은 공간에 패딩문자를 채운다.
select
    lpad('abc', 10, '@'), -- @@@@@@@abc
    rpad('abc', 10, '@'); -- abc@@@@@@@

select
    lpad(123, 5, '0');

-- 공백문자열 제거
-- ltrim(공백포함 문자열) : 왼쪽 공백문자 제거 후 반환
-- rtrim(공백포함 문자열) : 오른쪽 공백문자 제거 후 반환
-- trim(공백포함 문자열)  : 양쪽 공백문자 제거 후 반환
-- trim(방향 문자 from 대상 문자열) : leading(좌)/trailing(우)/both 방향지정 후 해당 문자 제거
select
    concat('(', ltrim('    안녕'), ')'),
    concat('(', rtrim('안녕    '), ')'),
    concat('(', trim('    안녕    '), ')');

-- 공백외의 문자도 방향과 함께 제거 가능
select
    concat('(', trim(leading ' ' from '    안녕    '), ')'),
    concat('(', trim(trailing ' ' from '    안녕    '), ')'),
    concat('(', trim(both ' ' from '    안녕    '), ')');

-- 문자열 반복
select
    repeat('잼', 5),
    repeat('-', 15);

-- 문자열 대체
select
    replace('마이SQL', '마이', 'My');

select
    replace(menu_name, '쥬스', '주우스') menu_name
from tbl_menu
where menu_name like '%쥬스%';

-- 문자열 뒤집기
select reverse('stressed'); -- desserts

-- 공란생성
select concat('시작', space(5), '끝');

-- 정규표현식 관련
select
    regexp_replace('123,456,789원', '[^0-9]', ''),
    regexp_substr('제 키는 188cm입니다.', '[0-9]+'); -- + 수량자 1개이상


-- ---------------------------------
-- 숫자처리함수
-- ---------------------------------
-- 절대값 반환
-- abs(숫자) : 부호를 제거한 절대값 반환
select
    abs(123),
    abs(-123);

-- 올림, 내림, 반올림, 버림
-- ceiling(숫자)
-- floor(숫자)
-- round(숫자, 소수점 이하 자리수)
-- truncate(숫자, 소수점 이하 자리수)
select
    ceiling(1234.56), -- 1235
    floor(1234.56), -- 1234
    round(1234.56), -- 1235
    truncate(1234.56, 1); -- 1234.5

-- 내림/버림 비교
-- 1. 내림 : 지정한 수보다 작은 정수 최대값
-- 1. 버림 : 절삭
select
    floor(12.34), -- 12
    truncate(12.34, 0), -- 12
    floor(-0.6), -- -1
    truncate(-0.6, 0); -- 0

-- 나누기/나머지 연산
-- 나누기 /
-- 나누기 div 몫만 구하는 경우
-- 나머지 mod(), %, mod

select
    10 / 3, -- 3.3333
    10 div 3; -- 3

select
    10 % 3,
    10 mod 3,
    mod(10, 3);

-- 거듭제곱, 제곱근
-- pow(밑수, 지수)
-- sqrt(숫자)
select
    pow(2, 3), -- 8
    pow(3, 3); -- 27

select
    sqrt(16), -- 4
    sqrt(10); -- 3.1622776601683795

-- 양수/0/음수 판단
-- sign(숫자) : 1/0/-1 반환
select
    sign(10.12345), -- 1
    sign(0), -- 0
    sign(-1234.56789); -- -1

-- 난수발생
-- rand() : 0.0이상 1.0미만 난수(실수)를 반환
-- 내림(rand() * 경우의수 + 최솟값)
select
    floor(rand() * 10 + 1);-- 1.0 ~ 11.0 미만

-- ---------------------------------
-- 날짜/시간 처리함수
-- ---------------------------------

-- 날짜 연산
-- adddate(날짜, 일수) : 연산된 날짜 반환
-- adddate(날짜, interval n 단위) : 연산된 날짜 반환
-- 지원하는 단위 year month day hour minute second ...

select
    now(), -- 2024-04-16 09:47:11
    adddate(now(), 1), -- 2024-04-17 09:47:11
    adddate(now(), interval 1 day), -- 2024-04-17 09:47:11
    adddate(now(), interval 1 month), -- 2024-04-17 09:47:11
    adddate(now(), interval 1 year); -- 2024-04-17 09:47:11

select
    adddate('2024-01-31', interval 1 month); -- 2024-02-29

select
    subdate(now(), 1),
    subdate(now(), interval  1 day),
    adddate(now(), -1),
    adddate(now(), interval -1 day );

-- addtime(날짜시간, 시간)
-- subtime(날짜시간, 시간)
select
    now(),
    addtime(now(), '1:2:3'),
    subtime(now(), '1:2:3'),
    adddate(now(), interval 2 hour );

-- + - 연산자로 처리하기
select
    now() + interval 1 hour,
    now() + interval 1 month,
    now() - interval 1 hour;

select
    now() + interval 1 hour + interval 2 minute + interval 3 second;

-- 현재 날짜
-- curdate(), current_date(), current_date
select
    curdate(), -- 2024-04-16
    current_date(), -- 2024-04-16
    current_date; -- 2024-04-16

-- 현재 시각
-- curtime(), current_time() , current_time
select
    curtime(), -- 10:16:36
    current_time(), -- 10:16:36
    current_time; -- 10:16:36

-- 현재 날짜/시각
-- now(), sysdate(), localtime(), localtime, localtimestamp(), localtimestamp
select
    now(), -- 2024-04-16 10:18:24
    sysdate(),
    localtime(),
    localtime,
    localtimestamp(),
    localtimestamp;

-- 년월일시분초 단위별로 추출
-- year(날짜)
-- month(날짜)
-- day(날짜) | dayofmonth(날짜)
-- hour(시각)
-- minute(시각)
-- second(시각)

select
    year(now()),
    month(now()),
    day(now()),
    dayofmonth(now());

select
    hour(now()),
    minute(now()),
    second(now());

select
    date(now()), -- 2024-04-16
    time(now()); -- 10:23:27

-- extract(단위 from 날짜시각) : 해당 단위의 숫자 반환
select
    extract(year from now()),
    extract(month from now()),
    extract(day from now()),
    extract(hour from now()),
    extract(minute from now()),
    extract(second from now());

-- 날짜/시간 차이 구하기
-- datediff(미래날짜, 과거날짜)
-- timediff(미래시각, 과거시각)
select
    datediff('2024/04/20', now()), -- 4
    datediff(now(), '2024/04/20'); -- -4

select
    timediff('12:50:00', '10:30:00'); -- 02:20:00

-- 수료일 d-day 계산쿼리
select
    datediff('2024-09-04', now());

-- 날짜정보 관련
-- dayofweek(날짜) : 요일에 해당하는 인덱스 반환(일요일 = 1 ~ 토요일 = 7)
-- monthname(날짜) : 월이름 반환
-- dayofyear(날짜) : 해당년도 몇번째 날인지 반환
select
    dayofweek(now()), -- 3(화요일)
    monthname(now()), -- April
    dayofyear(now()); -- 107

-- 말일계산
-- last_day(날짜) : 말일에 해당하는 날짜 반환
select
    last_day(now()), -- 2024-04-30
    last_day('2024-02-01'); -- 2024-02-29

-- 다음달 말일은?
select
    last_day(now() + interval 1 month ),
    last_day('2024-05-31' + interval 1 month );

-- 날짜/시각 생성하기
-- makedate(년, 일수) : 해당년도 일수번째 날짜 반환
-- maketime(시, 분, 초) : 시각 반환
select
    makedate(2024, 32), -- 2024-02-01
    maketime(10, 12, 13); -- 10:12:13

-- 기간계산
-- period_add(년월, 개월수) : 연산된 년월 반환
-- period_diff(미래년월, 과거년원) : 개월수 차이 반환

select
    period_add(202404, 18), -- 202510
    period_diff(202510, 202404); -- 18

-- 분기 확인
-- quarter(날짜) : 1, 2, 3, 4분기 반환
select
    quarter(now()), -- 2
    quarter('2024-03-03'), -- 1
    quarter('2024-08-03'), -- 3
    quarter('2024-11-03'); -- 4

-- 초 계산
-- time_to_sec(시간) : 초로 반환
select
    time_to_sec('1:0:0'); -- 3600

-- 날짜시각을 특정형식으로 출력하기
-- date_format(날짜/시각, 형식문자열) : 지정된 형식의 문자열 반환
-- 형식
-- %Y %y 연도4자리/연도2자리
-- %m 월
-- %d 일
-- %H 시간(24시간) / %h 시간(12시간)
-- %i 분
-- %s 초
-- %w 요일 숫자반환(일(0) ~ 토(6))

select
    date_format(now(), '%y/%m/%d'),
    date_format(now(), '%H:%i:%s'),
    date_format(now(), '%Y년 %m월 %d일 (%W)');

-- 지역 변경
select @@lc_time_names; -- en_US
set @@lc_time_names = 'ko_KR';

-- ---------------------------------
-- 형변환 함수
-- ---------------------------------
-- mysql에서는 암묵적/명시적 형변환 모두 지원한다.
 # 명시적 형변환
-- cast(값 as 자료형)
-- convert(값 as 자료형)

-- 사용가능 자료형
-- binary, char, date, datetime, time
-- decimal, signed/unsighined integer등을 지원한다.
select
    123,
    cast(123 as char),
    convert(123 , char);


select
    123.456,
    cast(123.456 as signed integer),
    convert(123.456, signed integer);

# 암묵적 형변환
select '1' + '2'; -- 3 숫자 변환 후 1 + 2 = 3 처리됨.
select '1' + 'ㅋㅋㅋ'; -- 1 숫자로 변환 불가한 문자열은 0으로 변환 후 1 + 0 계산
select concat(1, 2, 3, '원'); -- 숫자가 문자열로 자동변환 후 연경 '1' '2' '3' '원'
select adddate('2024-04-01', 1); -- 2024-04-02형 date형을 먼저 변환 후 1일 더하기 처리

select '1' + '3만원'; -- 1 + 3 숫자로 시작되는 문자열은 숫자부분만 변환
select '1' + '내가가진3만원'; -- 1 + 0

select 3 >  '오'; -- 1(true) '오'는 0으로 암묵적변환
select 3 >  '5오오오오'; -- 0(false) '5오오오오'는 5로 변환후 크기비교 false-> 0

-- ---------------------------------
-- 기타함수
-- ---------------------------------
# null 처리함수
-- ifnull(값, null일때 값) : 값이 null이 아니면, 값을 사용. 값이 null이면 null일때 값 사용
select
    ifnull('abc', 'xyz'), -- abc
    ifnull(null, 'xyz'); -- xyz

-- 메뉴테이블에서 메뉴명, 카테고리번호(null일 경우 '카테고리없음') 조회
select
    menu_name,
    ifnull(category_code, '카테고리없음') category_code -- 같은 열은 자료형이 같아야 하기 때문에 category_code(int)에서 ifnull이후 문자형으로 바뀜
from tbl_menu;

# null이 아닌 값 찾기
-- coalesce(값1, 값2, ...) null이 아닌 첫번째 값 반환
select
    coalesce('a','b','c',null), -- a
    coalesce(null,null,'a',null); -- a

# 삼항연산처리
-- if(조건식, 참일때 값, 거짓일때 값)
select
    if(3 > 2, 3, 2), -- 3
    if(3 < 2, 3, 2); -- 2

-- 메뉴테이블에서 메뉴명, 가격, 주문가능여부(주문가능 | 주문불가)
select
    menu_name,
    menu_price,
    if(orderable_status = 'Y', '주문가능', '주문불가') orderable_status
from tbl_menu;

# isnull(값) null여부 반환
select
    isnull('ㅋㅋㅋ'), -- 0(false)
    isnull(null); -- 1(true)

-- if + isnull()
select
    menu_name,
    if(isnull(category_code), '카테고리없음', category_code)
from tbl_menu;

# 선택함수 case
-- 다양한 케이스에 따라 분기처리를 지원하는 함수 (결과값을 반환)
-- (타입1) if..else if랑 비슷함
--  case
--      when 조건1 then 값1
--      when 조건2 then 값2
--      ...
--      else 기본값
--  end

-- (타입2)
--  case 표현식
--      when 값1 then 결과값1
--      when 값2 then 결과값2
--      ...
--      else 기본값
--  end

-- 싼거 5000원 미만
-- 적당한거 5000원 ~ 10000원
-- 비싼거 10000원 ~ 20000원
-- 겁나 비싼거 20000원 초과

select
    menu_name,
    menu_price,
    case
        when menu_price < 5000 then '싼거'
        when menu_price between 5000 and 10000 then '적당한거'
        when menu_price between 10000 and 20000 then '비싼거'
        else '겁나 비싼거'
    end "menu_label"
from tbl_menu;

select
    menu_name,
    menu_price,
    case
        when isnull(category_code) then '카테고리 없음'
        else category_code
    end category_code,
    case orderable_status
        when 'Y' then '주문가능'
#         when 'N' then '주문불가'
        else '주문불가'
    end orderable
from tbl_menu;

select category_code
from tbl_menu;

-- ---------------------------------
-- 그룹함수
-- ---------------------------------
-- 하나 이상의 행을 그룹으로 묶고, 그룹당 하나의 결과값을 반환하는 함수
-- group by를 사용하지 않는다면, 전체(모든 행)를 하나의 그룹으로 간주한다.
-- group by를 사용한다면, group by 그룹별로 하나의 결과를 반환한다.
-- **그룹함수의 결과와 일반 컬럼은 동시에 사용할 수 없다.**

# sum : 특정 컬럼의 합을 계산해서 반환
select
#     menu_name, -- 같이 사용 불가
    sum(menu_price) -- 235500
from tbl_menu;
# avg
-- 특정 컬럼의 평균값 반환
select
    avg(menu_price), -- 10704.5455
    truncate(avg(menu_price), 1) -- 10704.5
from
    tbl_menu;

# count
-- 특정컬럼의 값의 개수를 세어 반환. null값은 처리하지 않는다.
select
    count(*), -- 22 (* : 행의 수)
    count(category_code) -- 21 찰순대쥬스의 category_code는 null이믈 제외.
from tbl_menu;

select
    count(*)
from tbl_menu
where category_code is not null;
# max / min
-- 특정 컬럼의 최소/최대값을 반환
-- 숫자/문자(사전등재순 맨먼저 ~ 맨뒤)/날짜(과거 ~ 미래)에 대해서 적용가능

select
    min(menu_price),
    max(menu_price),
    min(menu_name),
    max(menu_name)
from tbl_menu;
