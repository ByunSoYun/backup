-- D:\class\server\EtcTest\db.sql

create table tblMovie (
    seq number primary key,                 --번호(PK)
    title varchar2(200) not null,           --제목
    outline varchar2(200) not null,         --개요
    time number not null,                   --상영시간
    rdate varchar2(10) not null,            --개봉일
    director varchar2(100) not null,        --감독
    actor varchar2(200) not null,           --배우
    poster varchar2(300) not null           --포스터
);

create sequence seqMovie;


select * from tblMovie;



insert into tblMovie (seq, title, outline, time, rdate, director, actor, poster)  values (seqMovie.nextVal, ?, ?, ?, ?, ?, ?, ?)














