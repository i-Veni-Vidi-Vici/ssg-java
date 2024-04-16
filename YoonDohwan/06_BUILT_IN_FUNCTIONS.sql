-- =========================
-- BUILT-IN FUNCTIONS
-- ========================
-- 함수. 반복적으로 사용되는 작업을 묶어낸 단위.
-- 전달된 매개인자를 기반으로 작업을 수행, 반드시 하나의 리턴값을 반환

#함수 유형
-- 1. 단일행처리 함수 : 행별로 호출, 호출된 만큼 결과를 반환
    -- 1-a. 문자처리함수
    -- 1-b. 숫자처리함수
    -- 1-c. 날짜/시간처리함수
    -- 1-d. 형변환함수
    -- 1-e. 기타함수
-- 2. 그룹함수 : 지정된 그룹별로 함수를 호출 . 그룹당 하나의 결과를 반환

-- 문자처리함수
-- ascii(문자) : 문자에 상응하는 아스키코드값 반환
-- char(아스키코드) : 아스키코드에 상응하는 문자반환
select
    ascii('A'),
    char(65),
    ascii('한');
-- 문자열길이관련
-- length(문자열) byte수 반환
-- char_length(문자열) 문자열의 길이 반환
-- bit_length(문자열) bit수 반환(byte*8)
select
    length('pizza'),
    char_length('pizza'),
    bit_length('pizza');
select
    menu_name,
    length(menu_name),
    char_length(menu_name),
    bit_length(menu_name)
from
    tbl_menu;

-- 문자열 연결연산
-- concat(값1, 값2, ....)"값1값2"
-- concat_ws(구분자,값1,값2,...)"값1구분자값2"
select
    concat('사자','호랑이','토끼'),
    concat_ws(',','사자','호랑이','토끼');

-- 메뉴 조회 : "1. 떡뽁이(3000원) 주문가능"
select
    concat(menu_code,'.',menu_name,'(',menu_price,'won)')메뉴
from
    tbl_menu;

-- 문자열 검색
-- elt(인덱스, 값1, 값2, ...)해당인덱스의 값을 반환
-- field(문자열, 값1, 값2, ...) 문자열과 일치하는 값의 인덱스를 반환
select
    elt(2,'사과','딸기','바나나'),
    field('딸기','사과','딸기','바나나');

-- csv 데이터에서 값 찾기
-- find_in_set(문자열, csv데이터) 문자열과 일치하는 csv데이터의 인덱스를 반환

select
    find_in_set('딸기','사과,딸기,바나나');

-- order by 에서 특정행만 끌어올리기 위한 용도로 사용가능
select
    *

from tbl_menu
order by
find_in_set(menu_code,'10')desc;


-- 문자열 검색
-- instr(대상문자열, 찾는문자열) : 인덱스반환
-- locate(찾는문자열, 대상문자열) : 인덱스반환
select
    instr('사과딸기바나나','딸기'),
    locate('바나나','사과딸기바나나');

-- 숫자포매팅(세자리콤마찍기, 소수점이하 자리수 보전)
-- format(숫자, 소수점이하자리수) : 형식지정된 문자열반환
select
    format(12345567890.1234567890,3);


-- 메뉴명 가격조회 (살구쥬스 ₩1,200)

select
    menu_name,concat('₩',format(menu_price,0))menu_price
    from tbl_menu;

-- 진수별 숫자표현
select
    bin(10),
    oct(10),
    hex(10);

-- 문자열 삽입
-- insert(대상문자열 시작인덱스 삭제할개수 추가할 문자열) : 변경된 문자열 반환
select
    insert('제이름은 아무개입니다.',6,3,'홍길동'),
    insert('제이름은 아무개입니다.',6,0,'김');


-- 쥬스메뉴를 찾아서 주우스로 변경 출력하세요
select
       insert(menu_name,instr(menu_name,'쥬스'),2,'쥬우스')
from tbl_menu
where
    menu_name like '%쥬스%';


-- 문자열잘라내기
-- left(대상문자열, 개수):왼쪽부터 지정한 개수만큼 잘라내서 반환
-- right(대상문자열, 개수):오른쪽부터 지정한 개수만큼 잘라내서 반환

select
    left('hello world!',3),
    right('hello world!',3);

-- substring (대상문자열, 시작인덱스, 길이): 잘라낸 문자열 반환
    select
        substring('안녕하세요, 반갑습니다~',8,2);

-- substring_index(대상문자열, 찾는문자열, 횟수) : 대상문자열에서 n 번째 문자열을 찾고, 그 이후 버림처리후 반환
    select
        substring_index('hong.gd@naver.com','.',2),
        substring_index('hong.gd@naver.com','.',-2);

select
    substring('hong.gd@naver.com',1,instr('hong.gd@naver.com','@')-1),
    substring_index('hong.gd@naver.com','@',1);

-- 정규표현식 관련
    select
        regexp_replace('123,456,789원','[^0-9]',''),
        regexp_substr('제 키는 188cm입니다.','[0-9]+'); -- +수량자 1개이상







-- 대소문자 변환
--  lower  / upper

-- 문자열 채우기
-- lpad(문자열, 길이, 패딩문자) -- 지정한 길이의 문자열에 첫번째 문자열과 왼쪽 남은 공간에 패딩문자를 채운다.
-- rpad(문자열, 길이, 패딩문자) -- 지정한 길이의 문자열에 첫번째 문자열과 오른쪽 남은 공간 패딩문자를 채운다.

select
    lpad('abc',10,'@'),
    rpad('ber',7,'@');


-- 공백문자열 제거
-- ltrim(공백포함문자열) : 왼쪽 공백문자 제거후 반환
-- rtrim(공백포함문자열) : 오른쪽 공백문자 제거후 반환
-- trim(공백포함문자열) : 양쪽 공백문자 제거후 반환
-- trim(방향 문자 from 대상문자열) : leading(좌)/trailing(우)/both 방향지정후 해당문자 제거
select
    ltrim('   안녕    '),
    rtrim('안녕    '),
    trim(' 안녕 ');

select
    concat('(',trim(leading ' 'from' 안녕   '),')'),
    concat('(',trim(trailing ' 'from' 안녕   '),')'),
        concat('(',trim(both ' 'from' 안녕   '),')');

-- 문자열 반복
select
    repeat('잼',5),
    repeat('-',10);
-- 문자열 대체
select
    replace('마이SQL','마이','MY');

-- 문자열 뒤집기
select reverse('stressed');

-- 공란생성
select
    concat('시작',space(5),'끝');

-- 절대값 반환
-- abs(숫자)

-- 올림, 내림, 반올림, 버림
-- ceiling(숫자)
-- floor(숫자)
-- round(숫자,소수점이하자리수)
-- truncate(숫자, 소수점이하자리수)
select
    ceiling(1234.56),
    floor(1234.56),
    round(1234.56),
    round(1234.56,1);

-- 내림/버림 비교
select
    floor(12.34),
    truncate(12.34,0),
    floor(-0.6),
    truncate(-0.6,0);


-- 나누기/나머지 연산
-- 나누기/
-- 나누기 div
-- 나머지 mod(),%,mod

select
    10/3,
    10 div 3;

select
    10%3,
    10 mod 3,
    mod(10,3);

-- 거듭제곱,제곱근
-- pow(밑수, 지수)
-- sqrt(숫자)
select
    pow(2,3),
    pow(3,3);

select
    sqrt(16);

select
    sign(10.1234),
    sign(0),
    sign(-1234.15435);

-- 난수발생
-- rand() : 0.0이상 1.0미만의 난수(실수)를 반환
-- 내림(rand()* 경우의수 + 최소값)
select
    rand()*100 + 1;



