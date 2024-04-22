-- root 계정 chundb 생성
-- sh 계정이 chundb 접근 가능하도록 권한 부여
-- sh계정으로 chundb.sql을 전체 실행
-- 쿼리를 통해 table 구조 파악
create database chundb;

grant all privileges on chundb.* to 'sh'@'%';

-- 1. 춘 기술대학교의 학과 이름과 계열을 표시하시오. 단, 출력 헤더는 "학과 명", "계열"으로 표시하도록 한다. 🆗
select
    DEPARTMENT_NAME 학과명,
    CATEGORY 계열
from tb_department;

-- 2. 학과의 학과 정원을 다음과 같은 형태로 화면에 출력한다.🆗
select
    concat(DEPARTMENT_NAME, '의 정원은 ' ) 학과별,
    concat(CAPACITY, '명 입니다.') 정원
from tb_department;

-- 3. "국어국문학과" 에 다니는 여학생 중 현재 휴학중인 여학생을 찾아달라는 요청이 들어왔다. 🆗
-- 누구인가? (국문학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서찾아 내도록 하자)
select
    S.STUDENT_NAME
from tb_department D
    join tb_student S
        using(DEPARTMENT_NO)
where
    DEPARTMENT_NO = '001'
  and
    ABSENCE_YN = 'Y'
  and
    (substring(STUDENT_SSN, 8, 1) = '2' or substring(STUDENT_SSN, 8, 1) = '4');

-- 4. 도서관에서 대출 도서 장기 연체자들을 찾아 이름을 게시하고자 한다. 그 대상자들의 학번이 다음과 같을 때 대상자들을 찾는 적절한 SQL 구문을 작성하시오.🆗
select
    S.STUDENT_NAME
from
    tb_department D join tb_student S
        on D.DEPARTMENT_NO = S.DEPARTMENT_NO
where
    STUDENT_NO in ('A513079', 'A513090', 'A513091', 'A513110', 'A513119')
order by
    S.STUDENT_NAME desc ;

-- 5. 입학정원이 20 명 이상 30 명 이하인 학과들의 학과 이름과 계열을 출력하시오.🆗
select
    D.DEPARTMENT_NAME,
    D.CATEGORY
from
    tb_department D
where
    CAPACITY between 20 and 30;

-- 6.춘기술대학교는 총장을 제외하고 모든교수들이 소속학과를 가지고있다. 그럼춘기술대학교 총장의 이름을 알아낼 수 있는 SQL 문장을 작성하시오.🆗
select
    PROFESSOR_NAME 총장
from tb_professor
where
    isnull(DEPARTMENT_NO);

-- 7. 혹시 전산상의 착오로 학과가 지정되어 있지 않은 학생이 있는지 확인하고자 한다. 어떠한 SQL 문장을 사용하면 될 것인지 작성하시오.🆗
select
    S.STUDENT_NAME
from
    tb_student S join tb_department D
        using (DEPARTMENT_NO)
where
    isnull(DEPARTMENT_NO);

-- 8. 수강신청을 하려고 한다. 선수과목 여부를 확인해야 하는데, 선수과목이 존재하는 과목들은 어떤 과목인지 과목번호를 조회해보시오.🆗
select
    CLASS_NO
from
    TB_CLASS
where
    !isnull(PREATTENDING_CLASS_NO);

-- 9. 춘 대학에는 어떤 계열(CATEGORY)들이 있는지 조회해보시오.🆗
select
    CATEGORY
from
    TB_DEPARTMENT
group by
    CATEGORY
order by
    CATEGORY;

-- 10. 19 학번 전주 거주자들의 모임을 만들려고 핚다. 휴학한 사람들은 제외하고, 재학중인 학생들의 학번, 이름, 주민번호를 출력하는 구문을 작성하시오🆗
select
    STUDENT_NO,
    STUDENT_NAME,
    STUDENT_SSN
from
    tb_student
where
    extract(year from ENTRANCE_DATE) = '2019'
  and
    STUDENT_ADDRESS like '%전주%'
  and
    ABSENCE_YN = 'N'
order by
    STUDENT_NAME;