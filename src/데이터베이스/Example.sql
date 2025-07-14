-- [1] SQL 주석
# 한줄주석
-- 한줄주석
/*
여러줄 주석
*/

-- [2] SQL 명령어 작성 방법
-- 1. SQL 문법을 작성한다. 2. SQL 문법 끝에 ; (세미콜론)으로 마친다.
show databases;

-- [3] SQL 명령어 실행 방법
-- 1. 단위실행(;) : 실행할 명령문에 커서를 두고 ctrl + enter 혹은 상단메뉴 번개(I) 아이콘 클릭
-- 2. 전체실행 : 현재 파일내 모든 명령어(문장) 실행(위에서 아래로) ctrl + shift + enter 혹은 상단메뉴 번개 아이콘 클릭

-- [4] 실행 결과를 보는 법
-- 1. 실행 후 메뉴 하단에 [result grid] 혹은 [output] 창 확인하여 명령문 결과 확인한다.

-- [5] 데이터베이스 관련 주요 명령어
# 1. 데이터베이스가 저장된 DB서버 로컬 경로 확인
show variables like 'datadir'; 	# 마지막에 세미콜론 꼭 넣으셈

# 2. DB서버내 데이터베이스를 생성하기
create database mydb0714;		# 실행할 명령문에 커서 두고 ctrl + enter
-- 에러가 나오면 이미 존재한다는 뜻

# 3. DB서버내 데이터베이스를 삭제하기
drop database mydb0714;

# 4. DB서버내 데이터베이스가 존재하면 삭제하기
# if( 만약에 ) , exists ( 존재하다 ) 
drop database if exists mydb0714; # 여러번 실행해도 오류가 없다.

# 5. DB서버내 데이터베이스 목록 보기
show databases; # 기본값만 보일 거임 [grid result] 창에서 확인

# 6. DB서버내 사용할 데이터베이스 활성화하기 , * 여러 db중에 sql 사용할 db를 반드시 선택해야한다. *
# use(사용하다)
use mydb0714;

# UI에서 데이터베이스 확인 : 워크벤치 왼쪽 메뉴 [ navigator ] -> [ 새로고침 ] 아이콘 클릭
# 진하게 표시된 데이터베이스가 현재 (사용)활성화 된 상태

# 예제1 : 데이터베이스 기본 세팅/준비 
drop database if exists test0714;	# test0714라는 이름의 DB가 존재하면 삭제	경고 표시 뜸. 왜냐면 DB가 아직 존재하지 않으니까!
create database test0714;			# test0714 이름으로 DB 생성하기
show databases;						# DB서버내 모든 데이터베이스 목록 보기
use test0714;						# test0714 DB (사용)활성화하기			시그마 새로고침하면 왼쪽에 활성화된 DB 확인 가능.

# 현재 파일을 저장하는 방법 : ctrl + s , 

/*
[SQL] 실습1 : 데이터베이스 관리
[ 문제 ] 아래 데이터베이스 관리(DDL, DCL) 관련 문제를 해결하시오.
[ 제출방법 ] 각 문제의 요구사항에 맞는 SQL 코드를 작성하여 제출하시오.
*/

/*
[문제 1] 데이터베이스 생성
지시: 'my_db' 라는 이름의 새로운 데이터베이스를 생성하는 SQL 코드를 작성하시오.
*/

create database my_db;

/*
[문제 2] 데이터베이스 목록 확인
지시: 현재 MySQL 서버에 존재하는 모든 데이터베이스의 목록을 확인하는 SQL 코드를 작성하시오.
*/

show databases;

/*
[문제 3] 데이터베이스 사용
지시: 문제 1에서 생성한 'my_db' 데이터베이스를 사용하도록 활성화하는 SQL 코드를 작성하시오.
*/

use my_db;

/*
[문제 4] 데이터베이스 삭제
지시: 'my_db' 데이터베이스를 삭제하는 SQL 코드를 작성하시오.
*/

drop database my_db;

/*
[문제 5] 종합 실습
지시: 아래 순서에 따라 SQL 코드를 작성하고 실행하시오.
'company_db' 라는 이름의 데이터베이스가 존재하면 먼저 삭제하시오.
'company_db' 라는 이름의 데이터베이스를 새로 생성하시오.
'company_db' 데이터베이스를 사용하도록 활성화하시오.
현재 서버의 모든 데이터베이스 목록을 다시 확인하여 'company_db'가 잘 생성되었는지 확인하시오.
*/

drop database company_db;
create database company_db;
use company_db;
show databases;
