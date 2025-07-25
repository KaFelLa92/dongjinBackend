-- [SQL] 실습4 : SQL 실습 문제 ( 집계 )
-- [ 문제 ] 아래 SQL 실습 문제 ( 집계 ) 관련 문제를 해결하시오.
-- [ 제출방법 ] 각 문제의 요구사항에 맞는 SQL 코드를 작성하여 제출하시오.

-- [ 샘플 ] 문제 혹은 카카오톡방에 샘플코드를 실행후 아래 문제들의 SQL 작성하여 실행하시오.

-- 아래 샘플 SQL 전체 실행 : ctrl+shift+enter
DROP DATABASE IF EXISTS exam4;
CREATE DATABASE exam4;
USE exam4;

-- 1. 도서 테이블
CREATE TABLE books (
    book_id      INT NOT NULL,                   -- 도서번호
    title        VARCHAR(50) NOT NULL,           -- 제목
    author       VARCHAR(20) NOT NULL,           -- 저자
    genre        VARCHAR(10) NOT NULL,           -- 장르
    price        INT NOT NULL,                   -- 가격
    stock        INT,                            -- 재고
    pub_date     DATE,                           -- 출판일
    CONSTRAINT PRIMARY KEY (book_id)           -- 기본키 제약조건
);

-- 2. 주문 테이블
CREATE TABLE orders (
    order_id     INT AUTO_INCREMENT,             -- 주문번호
    book_id      INT NOT NULL,                   -- 도서번호 (FK)
    customer     VARCHAR(20) NOT NULL,           -- 고객명
    order_qty    INT NOT NULL,                   -- 주문수량
    order_date   DATE,                           -- 주문일
    CONSTRAINT PRIMARY KEY (order_id),         -- 기본키 제약조건
    CONSTRAINT FOREIGN KEY (book_id) REFERENCES books(book_id) -- 외래키 제약조건
);

-- 샘플 데이터 삽입
INSERT INTO books VALUES(1001, '혼공 SQL', '우재남', '컴퓨터', 22000, 15, '2020-01-01');
INSERT INTO books VALUES(1002, '이것이 자바다', '신용권', '컴퓨터', 30000, 30, '2018-05-20');
INSERT INTO books VALUES(1003, '불편한 편의점', '김호연', '소설', 14000, 5, '2021-04-20');
INSERT INTO books VALUES(1004, '달러구트 꿈 백화점', '이미예', '소설', 13800, 25, '2020-07-08');
INSERT INTO books VALUES(1005, '트렌드 코리아 2023', '김난도', '경제', 19000, 50, '2022-10-05');
INSERT INTO books VALUES(1006, '원씽(The One Thing)', '게리 켈러', '자기계발', 14000, 12, '2013-08-20');
INSERT INTO books VALUES(1007, '역사의 쓸모', '최태성', '역사', 16000, 0, '2018-11-26');
INSERT INTO books VALUES(1008, '파친코', '이민진', '소설', 15800, 3, '2022-07-14');
INSERT INTO books VALUES(1009, 'Do it! 점프 투 파이썬', '우재남', '컴퓨터', 18800, NULL, '2019-06-20'); -- 저자 정보 수정
INSERT INTO books VALUES(1010, '코스모스', '칼 세이건', '과학', 19500, 8, '2006-12-20');

INSERT INTO orders VALUES(NULL, 1001, '김민준', 2, '2023-01-15');
INSERT INTO orders VALUES(NULL, 1002, '이서연', 1, '2023-01-18');
INSERT INTO orders VALUES(NULL, 1003, '박지훈', 1, '2023-02-01');
INSERT INTO orders VALUES(NULL, 1004, '김민준', 3, '2023-02-05');
INSERT INTO orders VALUES(NULL, 1005, '최수아', 1, '2023-02-11');
INSERT INTO orders VALUES(NULL, 1001, '박지훈', 1, '2023-02-12');
INSERT INTO orders VALUES(NULL, 1008, '이서연', 2, '2023-03-02');
INSERT INTO orders VALUES(NULL, 1009, '정현우', 5, '2023-03-05');
INSERT INTO orders VALUES(NULL, 1002, '김민준', 2, '2023-03-10');
INSERT INTO orders VALUES(NULL, 1006, '최수아', 1, '2023-04-01');
INSERT INTO orders VALUES(NULL, 1003, '박지훈', 3, '2023-04-02');
INSERT INTO orders VALUES(NULL, 1001, '이서연', 1, '2023-04-08');
INSERT INTO orders VALUES(NULL, 1005, '김민준', 2, '2023-04-15');
INSERT INTO orders VALUES(NULL, 1004, '정현우', 1, '2023-04-20');
INSERT INTO orders VALUES(NULL, 1008, '최수아', 1, '2023-05-01');
INSERT INTO orders VALUES(NULL, 1010, '박지훈', 2, '2023-05-05');
INSERT INTO orders VALUES(NULL, 1002, '최수아', 1, '2023-05-12');
INSERT INTO orders VALUES(NULL, 1006, '이서연', 2, '2023-05-20');
INSERT INTO orders VALUES(NULL, 1009, '김민준', 1, '2023-06-01');
INSERT INTO orders VALUES(NULL, 1001, '정현우', 3, '2023-06-07');
INSERT INTO orders VALUES(NULL, 1003, '이서연', 2, '2023-06-15');
INSERT INTO orders VALUES(NULL, 1005, '박지훈', 1, '2023-07-01');
INSERT INTO orders VALUES(NULL, 1010, '김민준', 1, '2023-07-03');
INSERT INTO orders VALUES(NULL, 1004, '최수아', 2, '2023-07-10');
-- =======================================================================
-- [문제 1] orders 테이블에 기록된 총 주문 건수는 몇 개인지 조회하세요.
-- order_id의 max값을 찾으면 됨 ㅋㅋ
select max( order_id) from orders;

-- [문제 2] books 테이블에 있는 모든 도서의 평균 가격(price)을 '평균단가' 라는 별칭으로 조회하세요.
-- avg함수 쓰고, as로 평균단가 먹이기
select avg( price ) as 평균단가 from books;

-- [문제 3] orders 테이블에서 '김민준' 고객이 주문한 총 주문 수량(order_qty의 합계)을 조회하세요.
-- from orders에서  김민준 조회(where customer like '김민준')하고 총주문수량 sum( order_qty ) , 조회할 것은 총 주문 수량X(합계만 조회해라).
select sum(order_qty) from orders where customer = '김민준';

-- [문제 4] books 테이블에서 각 장르(genre)별로 도서가 총 몇 권씩 있는지 조회하세요.
-- from books , 장르 별로 묶어주고(group by genre), 조회할 것은 stock.
-- select stock from books group by genre; 실행안됨. 오답
-- select genre from books group by genre; 이건 실행되지만 오답. 장르만 나옴.
-- 다수 속성명 조회 시 하나의 그룹으로 불가능 , 집계 함수 써야함
select genre, sum( stock ) from books group by genre;

-- [문제 5] orders 테이블에서 각 도서번호(book_id)별로 총 몇 권이 주문되었는지 조회하세요.
-- from orders , book_id로 묶어줌 (group by book_id) , 주문량(order_qty) sum 함수 쓰기.
select book_id , sum(order_qty) from orders group by book_id;

-- [문제 6] '김민준'과 '이서연' 고객에 대해, 각 고객별 총 주문 수량(order_qty의 합계)을 조회하세요. 단, 총 주문 수량이 4권 이상인 고객만 조회하세요.
-- 테이블 세팅 : from orders , 고객 이름 찾기 : where customer like between ('김민준' , '이서연' ) 조건절 : where order_qty >= 4; 조회할 것 : customer 별 sum(order_qty)
-- select order_qty from orders where customer like '김민준' , '이서연'; 안됨
-- 비트윈 아님. in으로 해볼까?
-- select customer , sum(order_qty) from orders  where customer in ('김민준' , '이서연') having sum(order_qty) >= 4; 안됨
-- 아 order_qty 그룹바이를 해야함. 그러면 where 못쓰는데?
select customer , sum(order_qty) from orders group by customer; -- 일단 여기까지는 됨
select customer , sum(order_qty) from orders group by customer having customer in ('김민준' , '이서연') and sum(order_qty) >= 4; -- 일단 그룹바이 구매자로 밀어넣은 후, 해빙에 조건절 다 때려박기 
select customer , sum(order_qty) as 총주문수량 from orders where customer in ('김민준' , '이서연') group by customer having 총주문수량 >= 4; -- 강사님 풀이

-- [문제 7] books 테이블에서 재고(stock)가 5권 미만인 도서들의 평균 가격을 조회하세요.
-- 테이블 세팅 : from books , 조건 : stock < 5 and , 계산할 거 : avg(price),
-- 그룹화 안하고 풀기
select avg(price) from books where stock < 5;	-- 이건 됨
-- 그룹화 하고 풀기
-- 테이블 세팅 : from books , 조건(웨어) : stock < 5 and , 계산할 거 : avg(price), 그룹화할 거 price 
select avg(price) from books where stock < 5 group by price;	-- 왜 값이 2개 나오지?
select avg(price) as 평균가격 from books where stock < 5;	-- 강사님풀이

-- [문제 8] orders 테이블에서 3번 이상 주문된 도서의 book_id와 주문 횟수를 조회하세요.
-- 조건 : order_qty >= 3 조회할 것 : book_id , order_qty , 그룹화할 것 : book_id
select book_id , order_qty from orders where order_qty >= 3; -- 어제 배운 걸로 간단하게 품. 아 도서 그룹화도 해야함
select book_id , count(order_qty) as 주문횟수 from orders group by book_id having 주문횟수 >= 3;

-- [문제 9] orders 테이블에서 총 주문 수량이 5권을 초과하는 고객의 customer와 총 주문 수량을 조회하세요.
-- 테이블 : orders , 조건 : order_qty > 5 , 그룹화할 것 : customer , 조회할 것 : customer , sum(order_qty)
select customer , sum(order_qty) as 총주문수량 from orders group by customer having 총주문수량 >5;

-- [문제 10] books 테이블에서 각 저자(author)별로 출판한 도서가 2권 이상인 저자의 이름과 출판 도서 수를 조회하세요.
-- 테이블 : books , 그룹화 : author , 조건 : count(author) >= 2 , 찾을거 : author , count(author) , 별칭 : count(author) as 출판도서수
select author , count(author) as 출판도서수 from books group by author having 출판도서수 >=2;

-- [문제 11] books 테이블의 '컴퓨터' 장르 도서 중 가장 비싼 도서의 가격을 조회하세요.
-- 테이블 : books , 그룹화 : genre , 조건(where or having) : genre = '컴퓨터' , 조회할 것 : max(price)
select max(price) as 최고가 from books group by genre having genre = '컴퓨터';

-- [문제 12] books 테이블의 '소설' 장르 도서들의 총 재고 수량을 조회하세요.
-- 테이블 : books , 조건 : genre = '소설' , 조회할 것 : sum( stock )
select sum( stock ) as 소설재고수량 from books where genre = '소설';

-- [문제 13] orders 테이블에서 주문을 한 고객이 총 몇 명인지 조회하세요. (DISTINCT 사용) 찾을 거를 중복 합쳐버리기
-- 테이블 : orders , 고객 중복 합치기 : distinct customer , 조회할 거 : count (distinct customer)
select count(distinct customer) as 고객수 from orders;

-- [문제 14] orders 테이블에서 고객별로 첫 주문일과 마지막 주문일을 조회하세요.
-- 테이블 : orders , 그룹화 : customer 조회할 거 고객별, 주문일 : order_date , 첫 주문일 : asc limit 1 , 마지막 주문일 desc limit 1 
-- select customer, order_date from orders order by order_date asc limit 2;
-- select customer, order_date from orders order by order_date desc limit 2;
-- min max로 대체하고 그룹바이 커스토머로 마무리
select customer, min(order_date), max(order_date) from orders group by customer;

-- [문제 15] orders 테이블에서 도서별 평균 주문 수량을 조회하세요.
-- 테이블 : orders , 조회할 거 : avg( order_qty)
select avg(order_qty) from orders;

-- [문제 16] books 테이블에서 장르별 평균 가격이 18000원을 초과하는 장르와 그 평균 가격을 조회하세요.
-- 테이블 : books , 조회할 거 : genre , avg(price) , 조건 : price > 18000 , 그룹화해서 조건절 해빙
select genre , avg(price) from books group by genre having avg(price) > 18000;

-- [문제 17] orders 테이블에서 2023년 1분기(1월~3월)에 발생한 총 주문 수량을 조회하세요. (BETWEEN 사용)
-- 테이블 : orders 조건절 : order_date between 2023-01-01 to 2023-03-31 조회할 것 : sum( order_qty )
select sum(order_qty) from orders where order_date between '2023-01-01' and '2023-03-31';

-- [문제 18] orders 테이블에서 가장 다양한 종류의 책을 주문한 고객의 이름과 그 종류의 수를 조회하세요.
-- 테이블 orders , 조건 : count(book_id) 찾을 거 : customer , count(book_id) , 그룹 커스토머 , 리미트 1로 한 명 출력
select customer , count(book_id) from orders group by customer having count(book_id) limit 1;

-- [문제 19] books 테이블에서 각 장르별로 가장 저렴한 도서의 가격을 조회하세요.
-- 테이블 books , 찾을 거 : genre , min(price) 그룹 : genre
select genre , min(price) as 저렴이 from books group by genre;

-- [문제 20] orders 테이블에서 주문을 단 한 번만 한 고객을 조회하세요. (조회결과: 0개 레코드)
-- 테이블 : orders , 조건 : order_id = 1 , 찾을 거 : customer
select customer , count(order_id) from orders group by customer having count(order_id) = 1;
