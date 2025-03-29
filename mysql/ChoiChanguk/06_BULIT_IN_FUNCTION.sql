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
;
#0416 화요일
-- -----------------------------------
-- 문자처리 함수
-- -----------------------------------
-- 날짜 연산
-- adddate(날짜, 일수) : 연산된 날짜 반환
-- adddate(날짜, interval n 단위) : 연산된 날짜 반환
-- 지원하는 단위 year, month, day, hour, minute, seconds ....
-- subdate(날짜, 일수) : 연산된 날짜 반환
-- subdate(날짜, interval n 단위) : 연산된 날짜 반환

select
    now() as 현재,
    adddate(now(),10) as 10일_후,
adddate(now(), interval 10 day ) as 10일_후,
adddate(now(), interval 1 month ) as 10개월_후,
adddate(now(), interval 10 year ) as 10년_후;

select adddate('2024-01-31', interval 1 month ) as 1월에서_한달_후;

select
    subdate(now(),1),
    adddate(now(),-1);# 이렇게 해도 같다

-- addtime(날짜, 시간) : 연산된 날짜 반환
-- subtime(날짜, 일수) : 연산된 날짜 반환

select
    now(),
    addtime(now(),'1:2:3'),
    adddate(now(),interval 1 day );

select now()-interval 1 day as 내일 ;

select now() + interval 1 hour +interval 10 minute +interval 3 second;

-- 현재 날짜
-- curdate(), current_date(), current_date
select
    curdate(),
    current_date(),
    current_date;

-- 현재 시각
-- curtime(), current_time(), current_time
select
    curtime(),
    current_time(),
    current_time;

-- 현재 날짜/시각
-- now(), sysdate(), localtime(), localtime, localtimestamp
select
    now(),
    sysdate(),
    localtime(6),
    localtimestamp(6), # 백만분의 1초
    localtimestamp;

-- 각 년도, 월, 일, 요소 뽑느다
select
    year(now()),
    month(now()),
    day(now()),
    dayofmonth(now());

select
    now(),
    hour(now()),
    minute(now()),
    second(now());

select
    date(now()),
    time(now());

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

# 흔히 쓰는 날짜 문자열은 알아서 처리 해준다
# yyyy-mm-dd = yyyy/mm/dd = yyyy$mm$dd

select
    datediff('2024-04-20',now()),
    datediff('2024$04$20',now()),
    datediff('2024/04/20',now()),
    datediff('2024/04/20',now());

-- 날짜정보 관련
-- dayofweek(날짜) : 요일에 해당하는 인덱스 반환(일요일 -1~토요일-7)
-- monthname(날짜) : 월이름 반환
-- dayofyear(날짜) : 해당년도 몇번째 날인지 반환

select
    dayofweek(now()),
    monthname(now()),
    dayofyear(now());

-- 말일계산
-- last_day
select
    last_day(now());

-- 다음달 말일은?
select
    last_day(now()+interval 1 month ) 다음달_말일,
    last_day('2024-05-31' +interval 1 month ) 30일_더하기_1달은;

-- 날짜/시각 생성하기
-- makedate(년, 일수) : 해당년도 일수번째 날짜 반환
-- maketime(시, 분, 초) : 시각 반환
select
    makedate(2024,80),# 2024년도에 80일은 언제야??
    maketime(16,12,13); # 이걸 시간으로 반환

-- 시간계산
-- period_add(년월, 개월 수)
-- period_diff(미래 년월, 과거 년월) 개월 수 차이
select
    period_add(202404,18), # 년월에서 +개월수 = 년월
    period_diff(202510,202404); # 미래년월 - 과거년월 = 몇개월
;
-- 분기 확인
-- quarter(날짜) : 1,2,3,4분기 반환
select
    quarter(now()),
    quarter('2024-03-03');

-- 초계산
-- time_to_sec(시간) : 초로 반환
select time_to_sec(now());

-- 날짜시각을 특정형식으로 출력하기
-- date_format(날짜/시각, 형식문자열) : 지정된 형식의 문자열 반환
/*
%Y/%y 년도4자리/년도2자리
%m 일
%d 일
%H/%h 시간(24시간)/시간(12시간)
%i 분
%s 초
%w 요일 숫자반환
*/
select
    now(),
    date_format(now(),'%y-%m-%d-%h:%i:%s-%w');

-- 지역 변경
select @@lc_time_names;
set @@lc_time_names='ko_KR';

-- -----------------------------------
-- 형변환 함수
-- -----------------------------------
-- mysql에서는 암묵적/명시적 형변환 모두 지원한다

# 명시적 형변환
-- cast(값 as 자료형)
-- convert(값, 자료형)

-- 사용가능 자료형
-- binary, char, date, datetime, time
-- decimal,

select 123,
       cast(123 as char),
       convert(123, char);

select
    123.456,
    cast(123.456 as signed integer ),
    convert(123.456 , signed),
    convert(-123.456 , signed);

# 암묵적 형변환
select
    '1'+'2'; -- 숫자 변환 후 1+2+3+4 처리됨
select '1'+'zzzz'; -- 숫자로 변환불가 문자열은 0으로 처리
select concat(1,2,3,'원'); -- 문자열로 자동변환
select adddate('2024-04-04',1);-- date형 먼저 변환 후 1일 더하기 처리

select '1'+'3만원'; -- 숫자로 시작되는 문자열은 숫자부분만 변환
select '1'+'내가가진3만원';

select 3>'오'; -- 숫자로 변환 불가이니 0으로 처리

;
-- -----------------------------------
-- 기타 함수
-- -----------------------------------
# null 처리 함수
-- ifnull(값, null 일떄 값) : 값이 null이 아니면, 값을 사용, 값이 null이면 null일 때 값 사용
select
    ifnull('abc','asdf'),
    ifnull(null,'asdf');

-- 메뉴테이블에서 메뉴명, 카테고리번호(null = 카테고리 없음) 조회
select menu_name as 메뉴이름, ifnull(category_code,'카테고리없음') as 카테고리
from tbl_menu;

-- null이 아닌 값 찾기
-- coalesce(값1, 값2, ...)null이 아닌 첫번째 값 반환
select
    coalesce('a','b',null),
    coalesce(null,null,'a');

-- 삼항연산자
-- if(조건식, 참일떄, 거짓일떄)
select
    if(3>2,'a','b');

-- 메뉴테이블에서 메뉴명, 가격, 주문가능여부(가능\불가) 조회
select menu_name as 메뉴명, menu_price as 가격, if(orderable_status='Y','가능','불가능') as 주문_가능여부
from tbl_menu;

-- isnull(값) null이네?? 그럼 트루1, 값이 있네??  그럼 펄스0
select
    isnull('zzzzz'),
    isnull(null);

select if(isnull(category_code),'카테고리 없음','카테고리 있음') as category_code
from tbl_menu;

# 선택함수 case
-- 다양한 케이스에 따라 분기처리를 지원하는 함수 (결과값을 반환)
/*
(타입1)
case
    when 조건1 then 값1
    when 조건2 then 값2
    ...
    else 기본값
end


(타입2)
case 표현식
    when 값1 then 결과값1
    when 값2 then 결과값2
    ....
    else 기본값
end
*/

-- 싼거, 적당한거, 좀 비싼거, 겁나비산
-- 5000미만, 5000~10000, 10000이상~20000미만, 20000이상
select
    menu_name,
    menu_price,
    case
        when menu_price<5000 then '싼거'
        when menu_price>=5000 && menu_price<=10000 then '적당'
        when menu_price>=10000 && menu_price<20000 then '좀 비싼'
        else '겁나 비싼'
end as 'menu_label'
from tbl_menu;

select menu_name,
       menu_price,
       case orderable_status
           when 'Y' then '주문가능'
#            when 'N' then '주문준가'
           else '주문불가'
           end
from tbl_menu;

-- -----------------------------------
-- 그룹함수
-- -----------------------------------
-- 하나이상의 행을 그룹으로 묶는다, 그룹당 한 번의 하나의 결과값을 반환하는 함수
-- group by를 사용하지 않는다면, 전체(모든 행)를 하나의 그룹으로 간주한다
-- group by를 사용한다면, group by 그룹별로 하나의 결과를 반환한다.
-- 중요!!!!!!!!@~!@~!@ 그룹함수의 결과와 일반컬럼은 동시에 사용할 수 없다
#sum
-- 특정 컬럼의 합을 계산해서 반환
    #이거 에러남
# select menu_name,
#        sum(menu_price)
# from tbl_menu;

#avg
-- 특정 컬럼의 평균값
select
    avg(menu_price),
    truncate(avg(menu_price),1)
from
    tbl_menu;

#count
-- 특정컬럼의 값의 개수를 세어 반환, null값은 처리하지 않는다
select
    count(category_code),
    count(*)
from tbl_menu;

-- max/min
-- 특정 컬럼의 최소/최대값을 반환
-- 숫자/문자(사전등새준 맨먼저~ 맨뒤)/날싸(과거~미래)에 대해서 적용가능

select
    min(menu_price) min,
    max(menu_price) max,
    max(menu_name) max,
    min(menu_name) min
from tbl_menu;