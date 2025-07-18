drop database if exists mydb0718;
create database mydb0718;
use mydb0718;

# 1. 회원테이블
create table member(            # 아이돌 그룹
   mid char(8) not null ,         # 식별키       최대 8자리
    mname varchar(10) not null ,   # 그룹명      최대 10자리
    mnumber int not null ,         # 인원수      정수 +-21억정도
    maddr char(2) not null ,       # 지역      최대 2자리
    mphone1 char(3) ,            # 지역번호   최대 2자리
    mphone2 char(8) ,            # 전화번호    최대 8자리
    mheight smallint ,            # 평균키       정수 +-3만정도
   mdebut date ,               # 데뷔일       yyyy-mm-dd
    constraint primary key ( mid )            # 제약조건
);
# 2. 구매테이블
create table buy(
   bnum int auto_increment ,          # 구매번호   정수    자동번호 부여
    mid char(8),                  # 구매자      FK
    bpname char(6) not null ,         # 제품명      최대 6자리
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,            # 가격       정수
    bamount smallint not null ,         # 구매수량   정수
    constraint primary key(bnum) ,               # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);

# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

# [1] 그룹 : ~별 , ~끼리 , 두개이상의 중복[ 레코드/행/가로 ]되는 속성값들을 묶음
# 주의할점 : 
select * from buy;	-- buy 테이블의 모든 레코드 조회
select bpname from buy group by bpname;	-- buy 테이블의 'bpname' 속성 그룹
select bpname , bprice from buy group by bpname; -- 오류
-- 오류 : bpname 속성값이 동일하더라도 bprice가 다를 수 있기 때문에! 
-- 즉] 다수 속성명 조회시 하나의 그룹으로 불가능하다.

# [2] 집계/통계 함수 , +그룹
select bamount from buy;
select sum( bamount ) from buy;		# sum( 속성명 ) : 합계
select avg( bamount ) from buy; 	# avg( 속성명 ) : 평균
select min( bamount ) from buy; 	# min( 속성명 ) : 최솟값
select max( bamount ) from buy; 	# max( 속성명 ) : 최댓값
select count( bamount ) from buy; 	# count( 속성명 ) : (레코드)개수 , null 제외
select count( * ) from buy; 		# count( * ) : (레코드)개수, null 포함
# (1) 회원아이디 별 구매수량 총합계 조회 , (그룹:mid) , (집계:bamount)
select mid , bamount from buy group by mid;				-- 실행불가능
select mid , sum( bamount ) from buy;					-- 실행불가능
select mid , sum( bamount ) from buy group by mid;		-- 실행가능
# (2) 회원아이디 별 총구매금액(수량*가격) 조회
select mid , sum( bamount * bprice ) from buy group by mid;
# (3) 회원아이디 별 구매가격 평균 조회
select mid , avg( bprice ) from buy group by mid;
# (4) 총 구매횟수 조회
select count(*) from buy;
# (5) 회원아이디 별 구매횟수 조회
select mid , count( * ) from buy group by mid;

# [3] having : 그룹별(후) 조건 : 별칭O vs where 그룹(전) 조건 : 별칭X
# 1. 구매수량이 3 초과하는 회원아이디별 레코드 조회
select * from buy where bamount > 3;
select bamount as 수량 from buy where 수량 > 3; -- where(조건절)에서 별칭 쓰지마세요

# 2. 회원아이디별 총구매금액(집계)이 1000 초과인 레코드 조회
select mid , sum( bamount * bprice ) from buy group by mid having sum( bamount * bprice ) >= 1000;
select mid , sum( bamount * bprice ) as 총구매금액 from buy 
		group by mid having 총구매금액 >= 1000;				-- 별칭 넣어서 계산식을 함수화(간략화)
select mid , sum( bamount * bprice ) as 총구매금액 from buy where 총구매금액 >= 1000
		group by mid;							-- 역시 where절에서 as 사용했기에 실행 불가
select count( * ) from buy;							-- 이거 됨
select count( * ) from buy where count( * ) > 3;	-- 이거 안 됨. where에 집계 넣지 마라

# [*] select 키워드 간의 작성 규칙
# select 속성명 from 테이블명 where 일반조건 group by 그룹속성명 having 그룹조건 order by 정렬속성명 asc/desc limit 개수;
# [*] 처리 순서
# select [3] from [1] where [2] group by [4] having [5] order by [6] limit [7] 














