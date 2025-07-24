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
 constraint foreign key (pno) references product (pno),
 ino int auto_increment,
 constraint primary key (ino),
 icontext longtext not null,
 idate datetime default now(),
 iaka varchar(10) not null default "뚝딱이",
 ipwd varchar(30) not null
);

select * from product;
select * from inquiry;