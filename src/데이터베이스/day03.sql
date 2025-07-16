# 데이터베이스(이하 *DB*) 조작어
# 1. DB 생성
drop database if exists mydb0716;
create database mydb0716;
use mydb0716;

# 2. 테이블 생성
create table test(
	mno int auto_increment , # 속성명 타입 제약조건
    mname varchar(30) not null unique , # 속성명 타입 제약조건1 제약조건2
    mcount int default 2 , # 속성명 타입 제약조건
    constraint primary key(mno) # 식별키 설정 # 마지막 속성명 뒤 ,(쉼표) 생략
);

# [*] DML : DB 조작어
# 1. insert 2. select 3. update 4. delete
# 	 [C:저장]   [R:조회]   [U:수정]    [D:삭제]

# [1] INSERT : 레코드 삽입 , *레코드란? 테이블내 행(가로) 단위의 데이터들 , 1줄 vs 1레코드 vs 1행
# 주의할점 : 테이블내 데이터 삽입시 레코드 단위 , 한칸한칸에 데이터삽입이 아닌 줄/행/레코드 
# (1) insert into 테이블명( 속성명1 , 속성명2 ) values( 값1 , 값2 )
insert into test ( mno , mname , mcount ) values( 1 , "유재석" , 30 ); # 세미콜론 마침
# 작성한 속성명에 대응하는 값을 삽입한다. 
insert into test ( mcount , mno , mname) values ( 40 , 2 , "강호동" );
# (2) auto_increment 제약조건의 속성은 생략할 경우 자동번호 (1씩증가된) 할당		# PK에서 주로 사용
insert into test ( mcount, mname ) values ( 50, "신동엽" );
# (3) default 제약조건의 속성은 값 생략할경우 정의된 기본값이 할당					# 가입일
insert into test ( mname ) value ("서장훈");
# (4) not null 제약조건의 속성은 값이 *꼭* 삽입되어야한다.
# insert into test( mno , mcount ) value ( 5, 40 );
# (5) unique 제약조건의 속성은 중복값일 경우 삽입 불가능.
# insert into test ( mname ) value ("유재석");
# (6) 모든 속성명을 *순서대로 *작성할 경우는 속성명 생략 가능하다.
insert into test values (5, "하하" , 10);
# (7) 하나의 insert에서 여러개 레코드 삽입할경우 , values( ) , ( ) , ( );
insert into test values (6 , "박명수" , 50) , (7, "정준하" , 45) , (8, "정형돈" , 35);

select * from test; # 확인차 조회

# [2] SELECT : 레코드 조회 
# 주의할점 : 조회 결과는 기존 테이블과 상관없다. select만 result table 존재한다.
# (1) select * from 테이블명 : 전체속성(*)의 모든 레코드 조회
select * from test;
# (2) select 속성명1 , 속성명2 from 테이블명 : 특정 속성의 모든 레코드 조회
select mname from test; # 이름 속성만 조회
select mname , mcount , mno from test;
# (3) select 속성명 from 테이블명 where 조건절;
# 'test' 테이블에서 'mname' 속성값이 "유재석"과 같은 레코드를 조회
select * from test where mname = "유재석"; # = (대입이 아닌 같다라는 뜻)
select * from test where mno = 3;		 # 'mno'속성 값이 3과 같은 레코드 조회

# [3] UPDATE : 레코드 수정
# MySQL Workbench에서는 수정/삭제를 safe mode이므로 불가능
# safe mode 해제 : set SQL_SAFE_UPDATES = 0 VS 1은 세이프모드 구동
set SQL_SAFE_UPDATES = 0;
# 1. update 테이블명 set 속성명 = 새로운값; 						: 전체 레코드의 속성값 수정
update test set mcount = 0;
# 2. update 테이블명 set 속성명 = 새로운값 where 조건절 				: 조건에 충족하는 레코드의 속성값 수정
update test set mcount = 10 where mname = "유재석";
# 3. update 테이블명 set 속성명1 = 값1, 속성명2 = 값2 where 조건절; 	: 다수의 속성값 수정
update test set mcount = 20 , mname = "강호동2" where mno = 2;

# [4] DELETE : 레코드 삭제
# 1. delete from 테이블명; 				: 전체 레코드 삭제
delete from test;
# 2. delete from 테이블명 where 조건절;		: 조건에 충족하는 레코드 삭제
delete from test where mno = 2;

/*
[SQL] 실습2 : SQL 실습 문제 ( DML )
[ 문제 ] 아래 SQL 실습 문제 ( DML ) 관련 문제를 해결하시오.
[ 제출방법 ] 각 문제의 요구사항에 맞는 SQL 코드를 작성하여 제출하시오.
*/

/*
[문제 1] 아래 조건에 맞는 members 테이블을 생성하는 SQL을 작성하세요.
테이블명: members
컬럼 정보:
member_id (회원 아이디): 문자열(20), 기본 키(Primary Key), NULL 허용 안함
member_name (회원 이름): 문자열(50), NULL 허용 안함
email (이메일): 문자열(100), 고유 키(Unique), NULL 허용 안함
join_date (가입일): 날짜/시간, **기본값(Default)**은 현재 날짜/시간
points (포인트): 정수, **기본값(Default)**은 0
*/

drop database if exists signUp;
create database signUp;
use signUp;

create table members(
	member_id varchar(20) not null,
    constraint primary key(member_id),
    member_name varchar(50) not null,
    email varchar(100) unique not null,
    join_date datetime default now(),
    points int default 0
);

select * from members;


/*
[문제 2] members 테이블에 아래 정보를 가진 새로운 회원을 추가하는 SQL을 작성하세요.
member_id: 'user01'
member_name: '김철수'
email: 'chulsoo@example.com'
points: 1000
*/

insert into members (member_id, member_name , email, points) values ("user01" , "김철수" , "chulsoo@example.com" , 1000 );

# [문제 3]members 테이블에서 모든 회원의 member_id와 email을 조회하는 SQL을 작성하세요.

select member_id , email from members; 

# [문제 4]members 테이블에서 member_id가 'user01'인 회원의 points를 1500으로 업데이트하는 SQL을 작성하세요.

update members set points = 1500 where member_id = "user01";

# [문제 5]members 테이블에서 member_id가 'user01'인 회원을 삭제하는 SQL을 작성하세요.

delete from members where member_id = "user01";

/*
[문제 6] 아래 조건에 맞는 products 테이블을 생성하는 SQL을 작성하세요.
테이블명: products
컬럼 정보:
product_code (상품 코드): 정수, 기본 키(Primary Key), 1씩 자동 증가
product_name (상품명): 문자열(100), NULL 허용 안함
price (가격): 정수, unsigned, NULL 허용 안함
stock_quantity (재고 수량): 정수, NULL 허용 안함, **기본값(Default)**은 0
category (카테고리): 문자열(50)
*/

drop database if exists factory;
create database factory;
use factory;

create table products(
	product_code int auto_increment,
	constraint primary key (product_code),
	product_name varchar(100) not null,
    price int unsigned not null,
    stock_quantity int not null default 0,
	category varchar(50)
);

select * from products;


/*
[문제 7] products 테이블에 아래 정보를 가진 새로운 상품을 추가하는 SQL을 작성하세요.
product_name: '프리미엄 키보드'
price: 120000
stock_quantity: 50
category: '컴퓨터 주변기기'
*/

insert into products (product_name , price , stock_quantity, category) values ("프리미엄 키보드" , 120000, 50 , "컴퓨터 주변기기");

# [문제 8] products 테이블에서 category가 '컴퓨터 주변기기'인 상품의 product_name과 price를 조회하는 SQL을 작성하세요.

select product_name , price from products where category = "컴퓨터 주변기기";

# [문제 9] products 테이블에서 product_name이 '프리미엄 키보드'인 상품의 stock_quantity를 45로 업데이트하는 SQL을 작성하세요.

update products set stock_quantity = 45 where product_name = "프리미엄 키보드";

# [문제 10] products 테이블에서 product_name이 '프리미엄 키보드'인 상품을 삭제하는 SQL을 작성하세요.

delete from products where product_name = "프리미엄 키보드";
