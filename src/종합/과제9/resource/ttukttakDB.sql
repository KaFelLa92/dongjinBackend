drop database if exists usedMarket;
create database usedMarket;
use usedMarket;

create table product(
 pno int auto_increment,
 constraint primary key (pno) ,
 pname varchar(30) not null,
 pcontent longtext not null,
 pprice int unsigned,
 pboolean bool,
 pdate datetime default now(),
 paka varchar(10) not null,
 ppwd varchar(30) not null
);

create table inquiry(
 pno int,
 constraint foreign key (pno) references product (pno) on delete cascade, -- 온 딜리트 캐스케이드 안하면 삭제 함수 안됨
 ino int auto_increment,
 constraint primary key (ino),
 icontent longtext not null,
 idate datetime default now(),
 iaka varchar(10) not null default "뚝딱이",
 ipwd varchar(30) not null
);

INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('고려청자', '원나라 때 수장되었었던 도자기 팝니다.', 1500000, true, '2025-07-24 16:33:00', '오관석', 'pinemokpo');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('게임기', 'PS5 풀박스 팝니다. 미개봉', 620000, true, '2025-07-23 12:00:00', '정지원', 'playpass');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('에어프라이어', '2번 사용한 거의 새거입니다.', 45000, false, '2025-07-21 09:30:00', '한은미', 'cookcook');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('스마트폰', '갤럭시 S22 울트라, 256GB', 850000, true, '2025-07-20 15:12:00', '박재홍', 'galaxywin');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('캠핑텐트', '4인용 텐트, 방수처리 완벽', 130000, true, '2025-07-19 10:05:00', '최은지', 'tentlove');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('기타', '야마하 어쿠스틱 기타 팝니다.', 200000, false, '2025-07-18 20:20:00', '김우진', 'yamaha123');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('책상', '높이 조절 가능, 원목 책상입니다.', 70000, true, '2025-07-17 08:00:00', '정성민', 'study777');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('의자', '사무용 의자, 허리받침 편함', 35000, true, '2025-07-16 17:30:00', '김소영', 'sitwell');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('공기청정기', '미세먼지 필터 교체 완료', 120000, false, '2025-07-15 19:00:00', '이현우', 'cleanlife');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('노트북', '맥북 에어 M1, 실사용 1년', 980000, true, '2025-07-14 13:10:00', '홍길동', 'macisgood');

INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('가습기', '초음파식 가습기, 겨울 필수템', 27000, true, '2025-07-13 11:45:00', '윤지아', 'humid99');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('자전거', '알루미늄 하이브리드 자전거', 170000, false, '2025-07-12 08:22:00', '장민석', 'pedal2025');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('청소기', '무선 진공청소기, 흡입력 좋음', 145000, true, '2025-07-11 15:00:00', '유지연', 'cleanyes');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('프린터기', '잉크젯 프린터, 거의 새상품', 40000, true, '2025-07-10 17:40:00', '김민재', 'printit');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('선풍기', '탁상용 선풍기, 조용함', 19000, true, '2025-07-09 14:30:00', '정하은', 'coolfan');

INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('노트', '문고판 무지 노트 10권', 9000, true, '2025-07-08 09:10:00', '오지훈', 'study99');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('헤드셋', '게임용 7.1 헤드셋입니다.', 75000, false, '2025-07-07 19:20:00', '서민정', 'sound888');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('카메라', '캐논 DSLR 중고, 상태 A급', 380000, true, '2025-07-06 13:40:00', '한지호', 'captureit');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('라디오', '빈티지 감성 라디오 팝니다.', 29000, true, '2025-07-05 10:00:00', '조영숙', 'radio77');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('전기장판', '1인용 전기장판, 온도조절기 포함', 36000, true, '2025-07-04 18:10:00', '이승환', 'warm123');

INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('모니터', '24인치 FHD 모니터 팝니다.', 120000, true, '2025-07-03 12:55:00', '박수현', 'display77');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('빔프로젝터', 'HD 해상도, 스크린 포함', 210000, true, '2025-07-02 15:30:00', '류지성', 'projectme');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('와인냉장고', '소형 와인셀러, 8병 보관', 99000, false, '2025-07-01 20:00:00', '최지혜', 'winecool');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('미니냉장고', '1인용 미니 냉장고 팝니다.', 150000, true, '2025-06-30 11:20:00', '고윤성', 'coldcold');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('안마기', '목 어깨 겸용 안마기', 55000, true, '2025-06-29 17:00:00', '이소영', 'relaxit');

INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('쌀포대', '20kg 남은 쌀 팝니다.', 32000, true, '2025-06-28 13:33:00', '조우진', 'grain12');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('의류건조기', '5kg 소형 건조기 팝니다.', 180000, false, '2025-06-27 08:45:00', '배진아', 'drymeup');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('텀블러', '스타벅스 한정판', 27000, true, '2025-06-26 10:15:00', '김주환', 'coffeeluv');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('커피머신', '캡슐 머신 팝니다', 120000, true, '2025-06-25 16:25:00', '전소영', 'espresso');
INSERT INTO product(pname, pcontent, pprice, pboolean, pdate, paka, ppwd) VALUES ('식기세트', '도자기 접시 10p 세트', 45000, true, '2025-06-24 14:00:00', '이정우', 'dishking');

INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('이거 진짜에요?', '2025-07-24 16:35:23', '양만식', 'hogu1234', 1);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('배송비 포함인가요?', '2025-07-24 17:02:10', '이나영', 'askme11', 2);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('사진 추가 부탁드려요.', '2025-07-24 17:10:45', '류진우', 'pw12345', 3);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('직거래 가능한가요?', '2025-07-24 18:00:00', '김하늘', 'sky12', 4);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('사용감 어떤가요?', '2025-07-24 18:30:12', '박선우', 'abc321', 5);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('에눌 되나요?', '2025-07-24 18:45:55', '정소라', 'negotime', 6);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('어디서 직거래 하나요?', '2025-07-24 19:10:22', '이해준', 'placeplz', 7);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('몇 년 사용하셨어요?', '2025-07-24 19:40:40', '오서진', 'years?', 8);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('사고싶은데 연락처 알려주세요', '2025-07-24 20:00:00', '유가은', 'callme12', 9);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('상태 설명 좀 더 해주세요', '2025-07-24 20:25:00', '한지우', 'moreinfo', 10);

INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('실사용 횟수 궁금해요', '2025-07-24 20:50:12', '남기현', 'numtimes', 11);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('왜 파시는 거예요?', '2025-07-24 21:05:33', '송은비', 'reason4sale', 12);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('택배비 별도인가요?', '2025-07-24 21:20:00', '홍시우', 'deliveryok', 13);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('지금도 판매 중인가요?', '2025-07-24 21:45:22', '고지훈', 'stillon?', 14);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('사진 속 내용물 모두 포함인가요?', '2025-07-24 22:00:00', '차민서', 'whatinside', 15);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('소리 잘 나나요?', '2025-07-24 22:15:10', '양지민', 'checksound', 16);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('크기 정보 알 수 있을까요?', '2025-07-24 22:30:40', '임현우', 'sizeplz', 17);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('사용 설명서 있나요?', '2025-07-24 22:45:33', '정하린', 'manualyes', 18);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('환불 가능한가요?', '2025-07-24 23:00:00', '백시현', 'refundme', 19);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('시연도 가능할까요?', '2025-07-24 23:15:55', '문서진', 'showme', 20);

INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('지역이 어디신가요?', '2025-07-24 23:30:00', '김도연', 'location?', 21);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('정품 맞나요?', '2025-07-24 23:45:45', '이하영', 'originalok', 22);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('얼마까지 가능하세요?', '2025-07-25 00:00:00', '강지후', 'finalprice', 23);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('충전기 포함인가요?', '2025-07-25 00:10:33', '이연서', 'charger?', 24);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('내일 거래 가능할까요?', '2025-07-25 00:25:20', '최태현', 'tomorrowok', 25);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('다른 색상도 있나요?', '2025-07-25 00:40:50', '배예린', 'coloroption', 26);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('직접 보고 결정해도 되나요?', '2025-07-25 00:55:00', '유지안', 'canisee', 27);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('몇 년식 모델인가요?', '2025-07-25 01:10:00', '박하준', 'modelyear', 28);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('택배 보내주실 수 있나요?', '2025-07-25 01:25:15', '정다은', 'postplz', 29);
INSERT INTO inquiry(icontent, idate, iaka, ipwd, pno) VALUES ('A/S 가능한가요?', '2025-07-25 01:40:40', '노예준', 'serviceok', 30);

select * from product;
select * from inquiry;