--ex15_insert.sql

-- insert 문
-- DML
-- 데이터를 테이블에 추가하는 명령어(행추가,레코드 추가)
-- insert into 테이블명(칼럼리스트) values (값릳스트);

drop table tblMemo;

create table tblMemo(
    seq number primary key,
    name varchar2(30) default '익명' not null,
    memo varchar2(1000) not null,
    regdate date default sysdate null -- default 때문에 암시적으로 하면 디폴트 동작 / 명시적은 null나옴
);

create sequence seqMemo;

--1. 표준 : 원본 테이블에 정의된 컬럼 순서대로 컬럼리스트와 값리스트를 구성하는 방법
insert into tblMemo(seq,name,memo,regdate) values(seqMemo.nextVal,'홍길동','메모입니다.',sysdate);


--2. 컬럼리스트의 순서와 값리스트의 순서는 반드시 일치해야한다.
insert into tblMemo(name,memo,regdate,seq) values(seqMemo.nextVal,'홍길동','메모입니다.',sysdate);


--3. 원본 테이블의 컬럼순서와 insert 컬럼 순서는 무관하다.
insert into tblMemo(name,memo,regdate,seq) values('홍길동','메모입니다.',sysdate,seqMemo.nextVal);


--4.00947. 00000 -  "not enough values"
insert into tblMemo(seq,name,memo,regdate) values(seqMemo.nextVal,'홍길동',sysdate);

--5.00913. 00000 -  "too many values"
insert into tblMemo(seq,name,regdate) values(seqMemo.nextVal,'홍길동','메모입니다.',sysdate);


--6. null 허용 칼럼 조작 
insert into tblMemo(seq,name,memo) values(seqMemo.nextVal,'홍길동','메모입니다.'); -- 암시적방법(해당 컬럼이 명시 X)
insert into tblMemo(seq,name,memo,regdate) values(seqMemo.nextVal,'홍길동','메모입니다.',null); -- 명시적 방법 (null 상수)

7. default 칼럼 조작 
insert into tblMemo(seq,memo) values(seqMemo.nextVal,'메모입니다.'); --암시적  null 대입 -> default 동작
insert into tblMemo(seq,name,memo,regdate) values(seqMemo.nextVal,null,'메모입니다.',null); -- 명시적 null 대입
insert into tblMemo(seq,memo,regdate) values(seqMemo.nextVal,'홍길동','메모입니다.',null); -- 이름(암시적), 날짜(명시적)

--default 상수(null 대입을 통해서 default값을 호출하는 방법보다 훨씬 직관적이고 편한 방법)
insert into tblMemo (seq,name,memo,regdate) values (seqMemo.nextVal,default,'메모입니다.',default);

-- 8. 컬럼 리스트 생략 표현
Insert into tblMemo values (seqMemo.nextVal,'홍길동','메모입니다.',sysdate);
Insert into tblMemo values (seqMemo.nextVal,'홍길동','메모입니다.');
Insert into tblMemo values ('홍길동','메모입니다.',sysdate,seqMemo.nextVal);

-- 9. 서브 쿼리 

create table tblMemoCopy(
    seq number primary key,
    name varchar2(30) default '익명' not null,
    memo varchar2(1000) not null,
    regdate date default sysdate null 
);

insert into tblMemoCopy select * from tblMemo;


CREATE TABLE tblComedianMale
(
   first varchar2(20) not null,
   last varchar2(20) not null,
   gender varchar2(1) check(gender in ('m', 'f')) not null,
   height number not null,
   weight number not null,
   nick varchar2(50) not null
);

-- tblComedian 테이블에서 남자만 추출해서 따로 테이블을 만들어 주세요..
insert into tblComedianMale
    select * from tblComedian where gender = 'm';




-- 테이블 만들기 + 데이터 추가하기 
-- 테이블 생성시 제약사항이 복사가 안된다 (********************) -> 유효하지 않은 데이터가 들어가도 어쩔수가없음.. > 실제 사용하는 용도의 테이블(X) > 개발자 임시 테이블 사용 (o) -> 더미용
create table tblComedianFemale
as 
    select * from tblComedian where gender = 'f';
select * from tblComedianFemale;



select * from tblMemoCopy;
select * from tblMemo;