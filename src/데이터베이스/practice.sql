
drop database if exists youNotBePrepared;
create database youNotBePrepared;
use youNotBePrepared;

create table tableName(
	props1 int not null,
    props2 int not null
);


# [1] Insert
# (1) 특정 속성에 레코드 추가
insert into tableName(props1 , props2) values(1 , 2);
# (2) 속성 아구가 딱 맞을때
insert into tableName values(1 , 2);
# (3) 여러 레코드 추가
insert into tableName values (1 , 2) , (1 , 2), (1 , 2);
insert into tableName(props1, props2) values(1 , 2) , (1 , 2) , (1 , 2);

# [2] Select
# (1) 전체 테이블 조회
select * from tableName;
# (2) 특정 props 레코드 조회
select props1 , props2 from tableName;
# (3) 특정 props 조건에 따른 레코드 조회
select * from tableName where props1 = 1;

# [3] Update
-- safe 모드 해제
set SQL_SAFE_UPDATES = 0;
# (1) 전체 레코드 속성값 수정
update tableName set props1 = 3;
# (2) 특정 속성 조건에 따른 레코드 속성값 수정
update tableName set props2 = 3 where props1 = 3;

# [4] Delete
# (1) 전체 레코드 삭제
delete from tableName;
# (2) 특정 속성 조건에 따른 레코드 삭제
delete from tableName where props2 = 3;