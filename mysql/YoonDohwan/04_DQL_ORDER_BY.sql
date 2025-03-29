-- ----------------------------
-- ORDER BY
-- ----------------------------
-- ResultSet 행에 대한 정렬을 지정하는 구문
-- DQL에 Select 구문 다음에 실행
-- 문자/숫자/날짜시간에 대해 오름차순(ASC)/내림차순(DESC) 정렬 작성
-- 컬럼몀ㅇ, 컬럼순서, 별칭으로 지정 가능

select
    *
    from tbl_menu
order by
    #asc 오름차순 기본값
    #desc 내림차순
category_code asc,menu_price desc;

-- 두개이상의 컬럼에 대해서 정렬 지원
-- 카테고리코드 오름차순, 가격 내림차순
-- 우선 카테고리코드 오름차순 적용, 카테고리코드가 같은 경우 두번째 가격 내림차순


select
    menu_code 메뉴코드,
    menu_name 메뉴명,
    menu_price 메뉴가격,
    category_code 카테고리번호,
    orderable_status 주문가능여부
from
    tbl_menu
order by
    메뉴가격 desc;

-- 특정값을 변환해서 기준으로 사용
-- field(src,val1,val2,val3,....) : 일치하는 값의 인덱스 반환
select field('A','A','B','C'), -- 1
    field('X','A','B','C'); -- 0 (mysql에서는 존재하지 않는 인덱스)

select
    menu_name,orderable_status,field(orderable_status,'Y','N')
    from tbl_menu
order by
    field(orderable_status,'Y','N');




select *
from tbl_menu
order by
    category_code is null desc, -- is null desc에서는 null값이 가장 먼저 나온다.
    category_code desc;