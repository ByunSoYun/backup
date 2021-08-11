-- C:\class\server\JSPTeest\db.sql

drop table tblAddress;
drop sequence seqAddress;

create table tblAddress (
    seq number primary key,                                 --PK
    name varchar2(30) not null,                             --이름
    age number(2) not null,                                 --나이
    gender char(1) not null check (gender in('m', 'f')),    --성별
    address varchar2(500) not null
);

create sequence seqAddress;

insert into tbladdress (seq, name, age, gender, address) values (seqAddress.nextVal, '홍길동', 20, 'm', '서울시 강남구 역삼동');

select * from tbladdress;


select * from tblTodo;


commit;

create table tblCard(
    seq number primary key,
    korname varchar2(50) not null,
    engname varchar2(50) not null,
    tel varchar2(15) not null,
    email varchar2(50) not null,
    company varchar2(50) not null,
    position varchar2(50) not null
);


create sequence seqCard;

insert into tblCard(seq, korname, engname, tel, email, company, position)
values (seqCard.nextVal, '홍길동', 'Hong gil dong' , '010-1234-5678', 'hong@gmail.com','쌍용 OO솔루션', '제 1개발팀 팀장');

select* from tblCard;
commit;