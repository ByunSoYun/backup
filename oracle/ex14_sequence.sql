--ex14_sequence.sql

/*
시퀀스, Sequence
- 데이터베이스 객체 중 하나 
- 식별자를 만드는데 주로 사용 > PK 컬럼에서 잘 사용 
- 일련번호를 만들어서 제공하는 객체(중복되지 않은 번호)
- 오라클 전용 

시퀀스 객체 만들기 
- create sequence 시퀀명;

시퀀스 객체 삭제하기 
-drop sequence 시퀀스명;

시퀀스 객체 사용하기 
- 시퀀스명.nextVal 함수(***)
- 시퀀스명.currVal 함수 

*/

drop  sequence seqNum;
create sequence seqNum;

select seqNum.nextVal from dual; -- 계수기 

select 'A' || seqNum.nextVal from dual; -- 상품번호, 주문번호 

select 'A' || trim(to_char(seqNum.nextVal,'000')) from dual; -- A001,A002 ...

--
select seqNum.currVal from dual; --15(자바 Queue.peek())


/*
시퀀스 상세 설정 
- create sequence 시퀀스명 ;

- create sequence 시퀀스명
    increment by n -- 증감치(양수,음수)
    start with n  -- 시작값(seed)
    maxvalue n --최댓값 (넘어가면 에러)
    minvalue n -- 최솟값 (넘어가면 에러)
    cycle -- 순환구조(PK 써먹기에 곤란함;;)
    cache n; 
    
*/

drop sequence seqTest;

create sequence seqTest
    increment by 1
    start with 1
    maxvalue 10
    cycle
    cache 5;

select seqTest.nextVal from dual;
create sequence seqA

    maxvalue 10
    cycle 
    cache 5;
    
    -- 제대로 저장되면 데이터의 값이 하드디스크로  제대로 저장 
    -- 제대로 저장안되면 데이터의 값이 하드디스크로 제soyu대로 저장 
create sequence seqB
    maxvalue 5 
    cycle 
    cache 3;
    


select 'ABC' || trim(to_char(seqA.nextVal,'00')) || trim(to_char(seqB.nextVal,'00')) from dual;
--ABC0101
--ABC0202


drop sequence seqNum;


create sequence seqNum;

select seqNum.nextVal from dual;

select seqNum.currVal from dual;

select seqNum.next

/*
오라클 서버를 중지하는 방법 
1.Win +R > sevices.msc> OracleServiceXE
2. 메뉴 > Stop Database
3. cmd > net stop OracleServiceXE


오라클 서버를 시작하는 방법 
1. Win + R > sevices.msc > OracleServiceXE 시작 
2. 메뉴 > Start Database 
3.cmd < net start OracleServiceXE


*/

--메모번호 :seqMemo.nextVal
--  중복이 되면 안되는 번호 (******)
-- 1, 2, 3, 4, 5... 21, 22, 23, 24..
-- 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23...



drop sequence seqNum;

create sequence seqNum;

create sequence seqNum start with 125;

select seqNum.nextVal  from dual;



/*
들여쓰기나 대소문자에 관해 표준이 되는 coding convention이 정해져 있는지 도 궁금합니다..그냥 일하는 회사에 맞춰서 사용하면 될까요?
- 프로젝트 단위

실제 상용하
*/





/*
PL/SQL
- select -> 결과셋 -> PL/SQL 변수 

1. select into 절 사용 
- 결과셋의 레코드가 1개일때만 사용 가능(***)
- 결과셋의 컬럼은 1개 이상~



declare 
    변수 선언;
begin 
    select 컬럼 into 변수 from 테이블;
end;


2. cursor 사용 
- 결과셋의 레코드가 0개 이상일때 사용 가능(N개)
- 컬럼셋의 컬럼은 1개 이상 
- 일반적으로 결과셋의 레코드가 2개 이상일때 궍장 
- 자바의 Iterator 구조와 유사 



declare 
    커서 선언;
being
    커서 열기;
        loop
            레코드 접근 -> 커서 사용
        end loop;
    커서 닫기;
end;

*/

set serveroutput on;

declare 
    vname tblInsa.name%type;
begin
    select name vname from tblInsa;-- where num = 10001;
    dbms_output.put_line(vname);
end;


declare 
    vname tblInsa.name%type;
    
    --커서 선언
    cursor vcursor is select name from tblInsa;
begin
    
    -- 커서 열기: 커서가 가지고 있는 select 문이 실행된다.>결과셋>커서가 참조
    open vcursor;
        --커서 조작 -> 결과셋 탐색
        --loop:결과셋의 레코드들을 탐색 루프
        loop
            -- 커서를 전진한다. + 커서 가르키는 레코드의 컬럼 접근
            fetch vcursor into vname;  -- select name into vname 유사
            
            -- 탈출 -> 더이상 읽어올 레코드가 없을때
            
            exit when vcursor%notfound; -- 커서 프로퍼티 
            
            dbms_output.put_line(vname);
        end loop;
    close vcursor;
end;


--create view vwTest
--as 
--select name 

select * from tblCountry;

declare 
    cursor vcursor 
        is select name,  capital, population from tblCountry order by name asc;
    vname tblCountry.name%type;
    vcapital tblCountry.capital%type;
    vpopulation tblCountry.population%type;
begin
    open vcursor;
        loop
            --select name , captial, population into vname, vcapital, vpopulation
            fetch vcursor into vname, vcapital, vpopulation;
            exit when vcursor%notfound;
            
            dbms_output.put_line(vname || '-' || vcapital || '-' || vpopulation);
            
        end loop;
    close vcursor;
end;


select * from tblBonus;

-- 개발부 직원 -> 모두 보너스 지금 
declare 
    cursor vcursor is select num,basicpay from tblInsa where buseo = '개발부''
    vnum tblInsa.num%type;
    vbasicpay tblInsa.basicpay%type;
begin 
    open vcursor;
        loop
    
    
            fetch vcursor into vnum, vbasicpay;
            exit when vcursor%notfound;
    
            --여기부터 업무에 따라 고민
        
            insert into tblBonus (seq,pnum,bonus,regdate)
                values (seqBonus.nextVal, vnum, vbasicpay *0.7,default);
            
        end loop;
    
    
    close vcursor;
    
    
end;

-- 기본버전 

-- tblInsa. 개발부 직원 + 모든 컬럼
declare 
    
    cursor vcursor is select * from tblInsa where buseo = '개발부';
    vrow tblInsa%rowtype; -- 레코드 참조 변수 (컬럼 10개짜리)
    
begin 
    open vcursor;
        loop
            fetch vcursor into vrow; --컬럼 10개 -> 변수 10개 복사 
            exit when vcursor%notfound;
            
            dbms_output.put_line(vrow.name);
            dbms_output.put_line(vrow.buseo);
            dbms_output.put_line('---');

        end loop;
    close vcursor;
end;

-- 간단 버전 
declare 
    
    cursor vcursor is select * from tblInsa where buseo = '개발부';
   -- vrow tblInsa%rowtype;  생략 -> 아래에서 만든다
    
begin 
    --open vcursor;
       for vrow in vcursor loop
       
           -- fetch vcursor into vrow; --컬럼 10개 -> 변수 10개 복사 
           -- exit when vcursor%notfound;
            
            dbms_output.put_line(vrow.name);
            dbms_output.put_line(vrow.buseo);
            dbms_output.put_line('---');

        end loop;
        
    --close vcursor;
end;


 
declare 
    
    cursor vcursor is select * from tblInsa where buseo = '개발부';
    
begin 
       for vrow in vcursor loop -- vrow + loop + fetch + exit when
       
            dbms_output.put_line(vrow.name);
            dbms_output.put_line(vrow.buseo);
            dbms_output.put_line('---');

        end loop;
        
end;


-- 권장 X-- 인라인 커서 -> 가독성 안좋음
create view vwDev
as 
select * from tblInsa  where buseo = '개발부';

select* from vwDev;
select * from (select *from tblInsa where buseo = '개발부'); -- 인라인뷰 



-- 인라인 커서 -> 가독성 안좋음
-- 단순한 쿼리에 사용 
begin 
       for vrow in (select * from tblInsa where buseo = '개발부') loop
       
            dbms_output.put_line(vrow.name);
            dbms_output.put_line(vrow.buseo);
            dbms_output.put_line('---');

        end loop;
        
end;


/*
프로시저 
- PL/SQL 블럭 (declare , begin, exception, end)
1. 익명 프로시저 
    - 1회용 (DB에 저장이 안됨, HDD에 *.sql로 저장)
    - 객체 x 
    - 속도 느림
    - 테스트용 , 임시 개발용 
    
2. 실명 프로시저 
    - 저장용(DB에 저장이 됨)
    - 객체o
    - 재사용 가능 , 타 유저에게 공유
    - 속도 빠름 
    
실명 프로시저 > 저장 프로시저(Stored Procedure)
1. 저장 프로시저(Stored Procedure)
    -매개변수 구성 or 반환값 구성 -> 자유
    
2. 저장 함수 (Stored Function)
    -매개변수 필수 , 반환값 필수 -> 고정 


익명 프로시저 선언 
[declare
    변수 선언;
    커서 선언;]
begin
    구현부;
[exception
    예외처리;]
end;

저장 프로시저 선언 
create [or replace] procedure 프로시저명 
is(as)
    [변수 선언;
    커서 선언;]
begin
    구현부;
[exception
    예외처리;]
end [프로시저명];
*/


declare
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
    
end;

create or replace procedure procTest 
is 
    vnum number; 
begin 
    vnum := 100;
    dbms_output.put_line(vnum);
end;