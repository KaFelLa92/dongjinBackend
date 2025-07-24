-- [SQL] 실습5 : JOIN 실습 문제
-- [ 문제 ] 아래 SQL JOIN 관련 문제를 해결하시오.
-- [ 제출방법 ] 각 문제의 요구사항에 맞는 SQL 코드를 작성하여 제출하시오.
-- [사전 준비] 실습용 데이터베이스 및 테이블, 데이터 생성
-- 아래 SQL 코드를 전체 복사하여 MySQL Workbench에서 실행(Ctrl+Shift+Enter)한 후 문제를 풀어주세요.
-- ==================== 실습 환경 구축 ====================
DROP DATABASE IF EXISTS exam5;
CREATE DATABASE exam5;
USE exam5;
-- 1. 카테고리 테이블
CREATE TABLE pcategory(
    카테고리번호_pk INT UNSIGNED AUTO_INCREMENT,
    카테고리명 VARCHAR(10) NOT NULL,
    PRIMARY KEY(카테고리번호_pk)
);
-- 2. 제품 테이블
CREATE TABLE product(
    제품번호_pk INT UNSIGNED AUTO_INCREMENT,
    제품명 VARCHAR(100) NOT NULL,
    제품가격 INT UNSIGNED NOT NULL,
    카테고리번호_fk INT UNSIGNED,
    PRIMARY KEY(제품번호_pk),
    FOREIGN KEY(카테고리번호_fk) REFERENCES pcategory(카테고리번호_pk)
);
-- 3. 재고 테이블
CREATE TABLE stock(
    재고번호_pk INT UNSIGNED AUTO_INCREMENT,
    재고수량 INT,
    재고등록날짜 DATETIME DEFAULT NOW(),
    제품번호_fk INT UNSIGNED,
    PRIMARY KEY(재고번호_pk),
    FOREIGN KEY(제품번호_fk) REFERENCES product(제품번호_pk)
);

-- 샘플 데이터 삽입
INSERT INTO pcategory(카테고리명) VALUES('노트북'), ('스마트폰'), ('의류'), ('도서');
INSERT INTO product(제품명, 제품가격, 카테고리번호_fk) VALUES
('그램 15인치', 1500000, 1), ('맥북 프로 16인치', 3000000, 1),
('갤럭시 S23', 1200000, 2), ('아이폰 14 Pro', 1550000, 2),
('반팔 티셔츠', 30000, 3), ('청바지', 80000, 3),
('혼공 SQL', 22000, 4);
INSERT INTO stock(재고수량, 제품번호_fk) VALUES (10, 1), (5, 2), (20, 3), (15, 4), (100, 5), (50, 6),(5, 1), (2, 3);

-- ========================================================
-- [문제 1] 모든 제품의 제품명과 해당 제품의 카테고리명을 함께 조회하세요. (조회결과: 7개 레코드)
-- 제품이 table1, 카테고리명이 table2 , pr 카테고리번호 fk와 pc 카테고리번호 pk로 함께 조회 조회할 것 : 제품명과 카테고리명.
select pr.제품명 , pc.카테고리명 from product pr join pcategory pc on pr.카테고리번호_fk = pc.카테고리번호_pk;

-- [문제 2] '노트북' 카테고리에 속하는 모든 제품의 제품명과 제품가격을 조회하세요. (조회결과: 2개 레코드)
-- 조회할 것 : 제품명과 제품 가격 , 조건 : 카테고리명이 '노트북'일 것. 교집합
select pr.제품명 , pr.제품가격 from product pr join pcategory pc on pr.카테고리번호_fk = pc.카테고리번호_pk where 카테고리명 = ('노트북');

-- [문제 3] 모든 제품의 제품명과 등록된 재고수량을 함께 조회하세요. (조회결과: 8개 레코드)
-- 조회할 것 : 제품명(product 제품명)과 재고수량(stock 재고수량) , product의 제품번호_pk와 stock의 제품번호_fk 속성명 대응. 
# 공통된 값을 기준으로 하는 교집합 
select pr.제품명 , st.재고수량 from product pr join stock st on pr.제품번호_pk = st.제품번호_fk;

-- [문제 4] '그램 15인치' 제품의 모든 재고등록날짜와 재고수량을 조회하세요. (조회결과: 2개 레코드)
-- 조회할 것 : stock 재고등록날짜, stock 재고수량 , 조건 : product 제품명이 '그램 15인치'여야함. product 제품번호_pk와 stock 제품번호_fk 비교. 교집합
select st.재고등록날짜 , st.재고수량 from product pr join stock st on pr.제품번호_pk = st.제품번호_fk where 제품명 = ('그램 15인치');

-- [문제 5] 모든 제품의 제품명, 카테고리명, 재고수량을 한 번에 조회하세요. (3개 테이블 조인) (조회결과: 8개 레코드)
-- 조회할 것 : product pr의 제품명, pcategory pc의 카테고리명 , stock st의 재고수량 , pc.카테고리번호_pk가 pr.카테고리번호_fk와 비교하고, pr.제품번호_pk가 st.제품번호_fk와 비교 교집합 실패
-- select pr.제품명 , pc.카테고리명 , st.재고수량 from product pr join pcategory pc join stock st on pc.카테고리번호_pk = pr.카테고리번호_fk = pr.제품번호_pk = st.제품번호_fk;
-- 유니온으로 풀기, pk fk 묶인 것끼리 식 만들고, union으로 묶어주기
-- select pc.카테고리명 , pr.제품명 from pcategory pc left join product pr on pc.카테고리번호_pk = pr.카테고리번호_fk union
-- select pr.제품명 , st.재고수량 from product pr left join stock st on pr.제품번호_pk = st.제품번호_fk;
-- 3테이블 조인으로 다시 도전 select from join on join on
select pc.카테고리명 , pr.제품명 , st.재고수량 from product pr join pcategory pc on pc.카테고리번호_pk = pr.카테고리번호_fk join stock st on pr.제품번호_pk = st.제품번호_fk; 

-- [문제 6] 모든 카테고리의 카테고리명과 해당 카테고리에 속한 제품명을 조회하세요. 만약 카테고리에 속한 제품이 없더라도 카테고리명은 모두 표시되도록 하세요. (조회결과: 7개 레코드)
-- 조회할 것 : 카테고리명 , 제품명  pcategory를 left join으로 하여 카테고리명 모두 표시되게 하기, 교집합으로 pc.카테고리번호_pk = pr.카테고리번호_fk.
select pc.카테고리명 , pr.제품명 from pcategory pc left join product pr on pc.카테고리번호_pk = pr.카테고리번호_fk; 

-- [문제 7] 재고가 한 번도 등록되지 않은 제품의 제품명을 조회하세요. (조회결과: 1개 레코드)
-- 조회할 것 : 제품명 , 조건 : st.재고번호_pk = 0 , 교집합 : pr.제품번호_pk = st.제품번호_fk;
-- 왼쪽 테이블에서 오른쪽 테이블을 빼줘야 재고가 없는(is null) 레코드가 남을 수 있다.
select pr.제품명 from product pr left outer join stock st on pr.제품번호_pk = st.제품번호_fk where st.재고번호_pk is null;

-- [문제 8] 각 카테고리별로 총 재고 수량의 합계를 카테고리명과 함께 조회하세요. (조회결과: 3개 레코드)
-- 조회할 것 : 카테고리명 , 총 재고 수량의 합계 sum( st.재고수량 )  테이블 : 카테고리 pcategory  교집합 : 카테고리 , 재고 (제품으로 한번 더 이어줘야함)
-- sum 안먹힘. 그룹 바이로 처리할 것
-- 프롬을 제품으로 해줘야 join 두 번 써서 이어줄 수 있다. 카테고리로 해도 되네?
select pc.카테고리명 , sum(st.재고수량) as 재고총합 from pcategory pc 
inner join product pr on pr.카테고리번호_fk = pc.카테고리번호_pk 
inner join stock st on pr.제품번호_pk = st.제품번호_fk
group by pc.카테고리명;

-- [문제 9] 각 제품별로 총 재고 수량을 조회하고, 총 재고 수량이 많은 순서대로 정렬하여 제품명과 총재고수량을 표시하세요. (조회결과: 6개 레코드)
-- 조회할 것 : product 제품명 , stock 총재고수량 sum(st.재고수량) (많은 순으로 정렬 desc) 교집합 : product pr.제품번호_pk stock st.제품번호_fk 
select pr.제품명 , sum(st.재고수량) as 총재고수량 
from product pr join stock st on pr.제품번호_pk = st.제품번호_fk 
group by pr.제품명
order by 총재고수량 desc;	-- asc : 오름차순 , desc : 내림차순
