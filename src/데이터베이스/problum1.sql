drop database if exists libraryDB;
create database libraryDB;
use libraryDB;
create table user(
	uno int auto_increment,
    uid varchar(30) not null unique,
    upwd varchar(30) not null,
    uname varchar(10) not null,
    uphone char(13) not null,
    constraint primary key(uno)
);

create table bookAdd(
	bno int auto_increment, 
	constraint primary key(bno),
    bname varchar(20) not null ,
    bwriter varchar(20) not null 
);

create table bookBorrow(
	lno int auto_increment,
    constraint primary key(lno),
	bno int, 
    constraint foreign key(bno) references bookAdd(bno) , 
    uno int,
    constraint foreign key(uno) references user(uno),
    bstart date not null,
    bend date not null,
    breturn date not null
);

select * from user;
select * from bookAdd;
select * from bookBorrow;

show tables;