#db day02
#데이터베이스(이하 *DB*)는 여러개의 테이블(표)

# [1] DB 생성
create database mydb0715;

# [2] DB 사용/활성화
use mydb0715;

# [3] 현재 활성화된 데이터베이스 안에 테이블/표 생성
# create: 생성, table: 표, test1: 표이름
# (: 정의시작, ): 정의끝, fieldName: 속성명, int: 속성타입
create table test1( fieldName int );
# 2개 이상의 속성을 정의할 때 : ,쉼표로 구분.
create table test2( fieldName1 int , fieldName2 double);

# [4] 현재 활성화된 DB의 테이블 목록 조회
show tables;

# [5] 현재 활성화된 DB내 테이블 삭제
drop table test1;				# ctrl + enter
# 만약에 테이블이 존재하면 삭제
drop table if exists test1;

# [6] MySQL 데이터 타입
# 다양한 데이터 타입 이용한 테이블 생성
create table test3(	# 테이블 정의 시작
# 속성명 타입 , 속성명 타입
intField1 tinyint	, intField2 smallint	, intField3 mediumint,
intField4 int 		, intField5 bigint		, intField6 int unsigned,
doubleField1 float	, doubleField2 double	, doubleField3 decimal,
dateField1 date		, timeField2 time		, dateTimeField3 datetime,
charField1 char(3)	, charField2 varchar(3)	, 
charField3 text		, charField4 longtext	,
boolField1 bool
    
); # 테이블 정의 끝
show tables;
# select * from 테이블명;
select * from test3; 

# 예1] 방문록을 기록하는 테이블 설계
create table board(
	content longtext	, # 게시물의 내용 	# private String content
	writer varchar(30)	  # 게시물의 작성자 	# private String writer
);

select * from board;		# select * from 테이블명; 테이블 조회

# 예2] 대기번호발급 기록하는 테이블 설계
create table waiting(
	phone char(13)		,	# 핸드폰 번호 고정길이 13글자					# private String phone
	count tinyint			# 대기인원수 # 최대 100명이라면 tinyint써도 됨.	# private byte count
);

select * from waiting;

# [7] 제약조건을 이용한 테이블 설계
# 제약조건 목적 : 데이터들 간의 문제와 결함이 되는 입력 방지/해결
create table test4(
	# 필드명 타입 제약조건
	fieldName1 tinyint not null 		, -- 지정한 속성에는 null 대입할 수 없도록 조건 설정
    fieldName2 smallint unique			, -- 지정한 속성에는 중복값을 저장할 수 없도록 조건 설정
    fieldName3 int default 10			, -- 지정한 속성에는 값이 생략될 때 자동으로 10 기본값으로 설정
	fieldName4 bigint auto_increment	, -- 지정한 속성에는 값이 생략될 때 자동으로 순서번호 설정
    -- pkFieldName5 double					, -- 지정한 속성 선언
    constraint primary key(fieldName4) -- 'fieldName4' 속성을 PK 필드로 설정
); 

select * from test4;

# [7]
create table test5(
	fieldName1 bigint ,	-- 지정한 속성 선언
    constraint foreign key(fieldName1) references test4(fieldName4) -- test5의 'fieldName1' 속성을 FK 필드로 설정, test4의 'fieldName4' 속성의 PK를 참조.
);

select * from test5;

# 예3] 회원제 게시판 DB 설계하시오.
drop database if exists boardService0715; 	-- 새로만들 DB가 존재하면 삭제
create database boardService0715;			-- DB 생성
use boardService0715;						-- DB 활성화
create table member(						-- [1] 회원테이블
	mno int auto_increment , 				-- 회원번호: 정수 , 자동번호 , *PK 사용할 예정
    mid varchar(30) not null unique , 		-- 회원ID: 문자최대30 , 공백x, 중복x
    mpwd varchar(30) not null ,				-- 회원PW: 문자최대30 , 공백X
    mname varchar(10) not null,				-- 회원닉네임: 문자최대10 , 공백X
    constraint primary key(mno)				-- 위에서 선언된 '회원번호' 속성을 PK필드로 설정
);

select * from member;						-- 확인차 회원테이블 조회

create table board(							-- [2] 게시물 테이블
	bno int auto_increment	,				-- 게시물번호 : 정수 , 자동번호 , *PK 사용할 예정
    btitle varchar(100) not null ,			-- 게시물제목 : 문자최대100 , 공백x
	bcontent longtext ,						-- 게시물내용 : 4GB 대용량(사진/긴글)
    bdate datetime default now() ,			-- 게시물작성일 : 날짜/시간 , 기본값 , now() : 현재 날짜/시간 반환함수
    bview int default 0 , 					-- 게시물조회수 : 정수 , 기본값 , 0
    constraint primary key(bno) ,		 	-- 위에서 선언된 '게시물번호'속성을 *PK필드로 설정
    mno int ,								-- 게시물작성자 : *FK로 사용할 예정 -> PK필드 타입과 일치
    constraint foreign key(mno) references member(mno)
);

select * from board;
# 여럿 테이블 간의 관계 확인( 다이어그램 )
# workbench 상단메뉴 -> [Database] -> [Reverse Engineer] -> stored connection : local
# -> 비번 입력 -> DB 선택 -> finish





