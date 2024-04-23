#1. root계정 chundb생성
#2. sh계정이 chundb 접근 가능하도록 권한 부여
#3. sh계정으로 chundb.sql 전체 실행
#4. 쿼리를 통해 teble구조 파악
create schema chundb;
grant all privileges on chundb.* to 'sh'@'%';
-- sh사용자에게 부여된 권한 확인
show grants for 'sh'@'%';

select * from TB_DEPARTMENT;
select * from TB_STUDENT;
select * from TB_PROFESSOR;
select * from TB_CLASS;
select * from TB_CLASS_PROFESSOR;
select * from TB_GRADE;


# 1. 춘 기술대학교의 학과 이름과 계열을 표시하시오. 단, 출력 헤더는 "학과 명", "계열"으로 표시하도록 한다.
select DEPARTMENT_NAME as 학과명, CATEGORY as 계열
from tb_department;

# 2. 학과의 학과 정원을 다음과 같은 형태로 화면에 출력한다.
select concat(DEPARTMENT_NAME,'의 정원은',CAPACITY,'명 입니다') as 학과별_정원
from tb_department;

# 3. "국어국문학과" 에 다니는 여학생 중 현재 휴학중인 여학생을 찾아달라는 요청이
# 들어왔다. 누구인가? (국문학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서
# 찾아 내도록 하자)
select *
from tb_student
where DEPARTMENT_NO =
      (select DEPARTMENT_NO
       from tb_department
       where DEPARTMENT_NAME='국어국문학과')
  and ABSENCE_YN = 'Y';

# 4. 도서관에서 대출 도서 장기 연체자 들을 찾아 이름을 게시하고자 한다. 그 대상자들의
# 학번이 다음과 같을 때 대상자들을 찾는 적 SQL 구문을 작성하시오.
# A513079, A513090, A513091, A513110, A513119
select STUDENT_NAME as 연체자
from tb_student
where STUDENT_NO in (' A513079', 'A513090', 'A513091', 'A513110', 'A513119');

# 5. 입학정원이 20 명 이상 30 명 이하인 학과들의 학과 이름과 계열을 출력하시오.
select DEPARTMENT_NAME as 학과, CATEGORY as 계열
from tb_department
where CAPACITY>=20 && CAPACITY<=30;

# 6. 춘기술대학교는 총장을 제외하고 모든 교수들이 소속학과를 가지고 있다.
# 춘기술대학교 총장의 이름을 알아낼 수 있는 SQL 문장을 작성하시오.
select PROFESSOR_NAME
from tb_professor
where DEPARTMENT_NO is null;

# 7. 혹시 전산상의 착오로 학과가 지정되어 있지 않은 학생이 있는지 확인하고자 한다.
# 어떠한 SQL 문장을 사용하면 될 것인지 작성하시오.
select *
from tb_student
where DEPARTMENT_NO is null ;

# 8. 수강신청을 하려고 한다. 선수과목 여부를 확인해야 하는데, 선수과목이 존재하는
# 과목들은 어떤 과목인지 과목번호를 조회해보시오.
select CLASS_NO as 과목번호, PREATTENDING_CLASS_NO as 선수과목
from tb_class
where PREATTENDING_CLASS_NO is not null;

# 9. 춘 대학에는 어떤 계열(CATEGORY)들이 있는지 조회해보시오.
select distinct CATEGORY as 계열
from tb_department;

# 10. 19 학번 전주 거주자들의 모임을 만들려고 한다. 휴학한 사람들은 제외하고, 재학중인
# 학생들의 학번, 이름, 주민번호를 출력하는 구문을 작성하시오.
select STUDENT_NO as 학번, STUDENT_NAME as 이름, STUDENT_SSN as 주민번호
from tb_student
where extract( year from ENTRANCE_DATE) = 2019 and
      ABSENCE_YN = 'N' and
      STUDENT_ADDRESS like '%전주%';

select *
from tb_department

select *
from tb_professor;

select *
from tb_professor a
where exists(tb_professor.DEPARTMENT_NO = null);

select *
from tb_student