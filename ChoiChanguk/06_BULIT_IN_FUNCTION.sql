-- ================================
-- BULIT_IN FUNCTION
-- ================================
-- 함수. 반복적으로 사용되는 작업을 묶어낸 단위.
-- 전달된 매개인자를 기반으로 작업을 수행, 반드시 하나의 리턴 값을 반환한다

#함수 유형
    /*
# 1. 단일행처리 함수 : 행별로 호출, 호출된 만큼 결과를 반환
    1-1. 문자처리함수
    1-2. 숫자처리함수
    1-3. 날짜/시간처리함수
    1-4. 형변환함수
    1-5. 기타함수
# 2. 그룹함수 : 지정된 그룹별로 함수를 호출. 그룹 당 하나의 결과를 반환
     */

-- -----------------------------------
-- 문자처리 함수
-- -----------------------------------

/*
1. ascii(문자) : 문자에 상응하는 아스키코드값 반환
2. char(아스키코드) : 아스키코드에 상응하는 문자반환
*/
select ascii('A'),
       char(65);

-- 문자열 길이관련
-- length() byte수 반환
-- char_length() 문자열의 길이를 반환
-- bit_length() bit수 반환 (byte * 8)
select length('asdf'),
       char_length('asdf'),
       bit_length('asdf');

select length('피자'),
       char_length('피자'),
       bit_length('피자');

select menu_name,
       length(menu_name),
       char_length(menu_name),
       bit_length(menu_name)
from tbl_menu;

-- 문자열 연결연산
-- concat(값1, 값2, ...) 값1값2
-- concat_ws(구분자, 값1, 값2,....)값1 구분자 값2 구분자 ...
select concat('가격입니다',menu_price),
           concat_ws('/',menu_price,'원입니다')
from tbl_menu;

select *
from tbl_menu;
-- 메뉴 조회 : "1. 떡볶이(3000원)"
select concat(row_number() over (),'. ' ,menu_name,'(', menu_price,'원)') as 메뉴
from tbl_menu
order by menu_price;

-- 문자열 검색
-- elt(인덱스, 값1, 값2, ....) 해당인덱스의 값을 반환
-- field(문자열, 값1, 값2, ...) 문자열과 일치하는 값의 인덱스를 반환
select elt(2,'사과','딸기','바나나'),# 2번지에 있는 요소 반환
field('바나나','딸기','바나나');# sql에서는 시작이 1번부터 시작

-- csv데이터에서 값 찾기
-- find_in_set(문자열, scv데이터) 문자열과 일치하는 csv데이터의 인덱스를 반환
select
    find_in_set('사과','사과,딸기,바나나');-- 지금 여기는 1번째가 일치하니 1이 나온다

-- order by에서 특정행만 끌어올리기 위한 용도로 사용가능
-- 조건으로 순서를 정렬하는데 n번째 있는 놈을 올리고 싶어요
select *
from tbl_menu
order by
    find_in_set(menu_code,10) desc ;
# find_in_set(a,b) a값이 b가 맞니?? 그럼 1 반환, 아니면 0반환
# 그러므로 오름차순으로 정렬하면 맨 아래로 간다

-- 문자열 검색
-- instr(대상문자열, 찾는 문자열) : 인덱스 반환
-- locate(찾는 문자열, 대상문자열) : 인덱스반환
select
    instr('사과딸기바나나','바나나'),# 5번째부터 바나나가 있다
    locate('토마토','사과딸기배토마토'); # 6번째부터 토마토가 있다

-- 숫자포매팅 (세자리콤마찍기, 소수점이하 자리수 보전)
-- format(숫자, 소수점이하자리수) : 형식지정된 문자열반환
select
    321321.654687654654 이놈은_숫자,
    format(321123321.654687654654,2) 이놈은_문자;

-- 메뉴명 가격조회 (살구쥬스 \1,200)
select menu_name 메뉴,concat('￦',format(menu_price,0))가격
from tbl_menu;


select menu_name 메뉴,concat('이진수',bin(menu_price))가격
from tbl_menu;

select menu_name 메뉴,concat('10진수',oct(menu_price))가격
from tbl_menu;

select menu_name 메뉴,concat('16',hex(menu_price))가격
from tbl_menu;

-- 문자열 삽입
-- insert(대상문자열, 시작인덱스, 삭제할 개수, 추가할 문자열) : 변경된 문자열 반환
select
    insert('저는 대한민국 서울에서 살고 있습니다',9,2,'경기도'),
    insert('제 이름은 최창욱입니다',7,3,'홍길동');

-- 쥬스메뉴를 찾아서 '주우스'로 변경 출력하세요
-- 파인애플쥬스 -> 파일애플주우스
select menu_name,
       insert(menu_name,char_length(menu_name)-1,2,'주우스') as 바뀐이름
# insert(menu_name,instr(mane_name,'주스'),2,'주우스') as 바뀐이름
from tbl_menu
where menu_name like '%쥬스%';

-- 문자열 잘라내기
-- left(대상문자열, 개수) : 왼쪽부터 지장한 개수만큼 잘라내서 반환
-- right(대상문자열, 개수) : 오른쪽부터 지장한 개수만큼 잘라내서 반환

select left('hello world',3), # n개만큼 자른다
       right('hello world',3);

-- 대소문자 변환
select LOWER(orderable_status),
       UPPER('hello world')
from tbl_menu;

-- 문자열 채우기
-- lpad(문자열, 길이, 패딩문자) - 지정한 길이의 문자열에 첫번째 문자열과 왼쪽 남은 공간에 패딩문자를 채운다
-- rpad(문자열, 길이, 패딩문자) - 지정한 길이의 문자열에 첫번째 문자열과 오른쪽 남은 공간에 패딩문자를 채운다
select lpad('abc',10,'asdf'),
       right('asdfasdfasdf',20,'efefefefef'); -- 남은건 왼쪽에 다 채워주세요\

select lpad(123,5,'0');

-- 공백 특정문자열 제거
-- ltrim(공백포함문자열)  - 왼쪽 공백문자 제거 후 반환
-- rtrim(공백포함문자열) - 오른쪽 공백문자 제거 후 반환
-- trim(양쪽공백포함문자열) - 양쪽 공백문자 제거 후 반환
-- trim(방향 from 대상문자열) : leading(좌)trailing(우)both 방향지정 후 해당문자

select concat('(',ltrim('     안녕')''),
       rtrim('안녕       '),
       rtrim('        안녕       '),
       concat('(',trim(leading ''from ' 안녕'),')');

-- 문자열 반복
select repeat('잼',5)
from
    menudb.tbl_menu;

-- 문자열 대채 (마이sql,'마이,'mT);

select

where

    -- 문자열 뒤집기
    select tbl_menu.menu_name
    from tbl_menu;

-- subString(대상문자열, 지작엑스, 길이) : 잘라낸 문자열 바환
select ('안녕하세요ㅡ 반갑습니다~,',8,2);

-- 변환
# g(대상문자여를, 찾는문자여열, 횟수n) 대상줌나열에서 n번찌
select substring_index('hong@naver.com'),''.,1,2,11);

-- 공란생성
select concat('시작',space(5),'끝');

-- 정규표현식
select regexp_replace('1232,123,123');

-- 절대값 표현
select
    abs(123),
    abs(1.245);

-- 올림, 내림, 반올림, 버림
-- ceiling(숫자)
-- floor(숫자)
-- round(숫자, 소수점이하 자리수)
-- truncate(숫자, 소수점이하자리수)
select
    ceiling(123.5456),
    floor(123.5456),
    round(123.5456),
    round(123.5456,1);

-- 내림/버림 비교
select
    floor(123.34),
    truncate(123.34,1),
    floor(-0.6),
    truncate(-0.6,0);

-- 나누기/나머지 연산
-- 나누기 /
-- 나누기 div 몫만 구하기
-- 나머지 mod(), %, mod
select
    10/3,
    round(10/3,2),
    10 div 3;

select
    #다 같다
    10%3,
    10 mod 3,
    mod(10,3);

-- 거듭제곰, 제곱근
-- pow(밑수, 지수)
-- sqrt(숫자)

select
    pow(3,2),
    sqrt(4);# = 투트4 =

-- 양수/0/음수 판단
-- sign(숫자) : 1/0/-1 반환
select
    sign(10.1234),
    sign(0),
    sign(-10.1234);

-- 난수발행
-- rand() : 0.0이상 1.0미만의 난수(실수)를 반환
-- 내림(rand() * 경우의 수 + 최소값)
select
    rand()*3+1; # 이건 자바랑 같다