drop database if exists mydb0723;
create database mydb0723;
use mydb0723;

create table user(
	uno int auto_increment , -- 회원번호 , int(정수) , auto_increment(자동번호부여)
    uname varchar(30) not null, -- 회원명 , varchar(문자열) , not null(공백 비허용)
    uage int default 10 , -- 회원나이 , int(정수) , default 10(insert 생략시 초기값)
    constraint primary key ( uno ) -- 위에서 선언된 회원번호 속성을 기본키(PK) 설정
);

# 1. day18 -> userDao에서 사용할 sql 샘플
insert into user( uname , uage ) values ( '유재석' , 40 );

select * from user;

# 2. JDBC 매개변수 활용 -- 자바에서 실행
insert into user( uname , uage ) values ( ? , ? ); -- 워크벤치에서는 실행 불가능




